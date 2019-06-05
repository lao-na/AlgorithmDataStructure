package com.lao.na.data.structure.array;

/**
 * 使用jdk中的数组 实现自定义的数据操作
 */
public class Array1 {

    // jdk 中的数组
    private int[] data;
    // 维护数组的数量 size属性
    private int size;

    /**
     * 定义Array构造函数
     */
    public Array1(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    /**
     * 初始化一个长度为10的数组
     */
    public Array1() {
        this(10);
    }

    /**
     * 获取数据的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组的末尾添加元素
     */
    public boolean add(int element) {

        // 数组满的情况下需要扩容 (此方法暂不考虑扩容)
        if (data.length == size) {
            throw new IllegalArgumentException("数组已满,暂无法添加元素");
        }
        data[size] = element;
        size++;
        return true;
    }

    /**
     * 在数组的指定位置添加一个元素
     */
    public boolean add(int index, int element) {

        if (data.length == size) {
            throw new IllegalArgumentException("数组已满,暂无法添加元素");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index >= 0 && index <= size");
        }

        // 将元素插入到指定位置,将元素覆盖
//        for (int i = size - 1; i >= index; i--) {
//                data[index] = element;
//        }
//        size++;

        // 将元素插入到指定位置,不能将元素覆盖 (此时并不考虑扩容的问题)
        for (int i = size - 1; i >= index; i--) {
            // 将index之后的元素向后挪一位
            data[i + 1] = data[i];
        }
        size++;
        data[index] = element;
        return true;
    }

    public static void main(String[] args) {

        Array1 array = new Array1();
        for (int i = 0; i < 9; i++) {
            array.add(i);
        }

        array.add(8, 10);

        for (int i = 0; i < 8; i++) {
            System.out.println(array.data[i]);
        }
        System.out.println("size: " + array.size);

    }
}
