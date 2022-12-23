package com.example.simplespringboottest.prac.first.designPattern;

public class SingletonPattern {
    // 单例模式
    // 单例模式的实现方式有很多，但是最常见的是懒汉式，线程不安全的，线程安全的可以使用双重检查锁，或者使用volatile关键字保证线程安全。
    // 懒汉式：类加载时不创建单例对象，第一次调用getInstance()方法时创建单例对象。
    // 线程不安全：在多线程环境下，可能会出现多个线程同时调用getInstance()方法，导致多个线程同时创建单例对象。
    // 线程安全：在多线程环境下，可以使用双重检查锁，保证线程安全。
    // volatile关键字：保证线程安全。
    // 双重检查锁：保证线程安全。

    private static volatile SingletonPattern instance = null;
    private SingletonPattern() {
    }
    public SingletonPattern getInstance() {
        if (instance == null) {
            synchronized (SingletonPattern.class) {
                if (instance == null) {
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }
    // 快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        //  取第一个数作为基准数
        //  将数组分为两部分，一部分比基准数小，一部分比基准数大
        //  从两部分中选择一部分作为新的基准数，重复这个过程，直到基准数所在的位置。
        //  将基准数放在基准数所在的位置。
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        return i;
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    // 选择排序
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    // 插入排序
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

   // 希尔排序
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j] < arr[j - gap]) {
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j -= gap;
                }
            }
            gap /= 2;
        }
    }
    // 归并排序
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }
    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }
    public static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int m = left; m <= right; m++) {
            arr[m] = temp[m];
        }
    }
    // 快速排序
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            heapAdjust(arr, 0, j);
        }
    }

    private static void heapAdjust(int[] arr, int i, int length) {
        // 将arr[i]调整到合适的位置
        int temp = arr[i];
        // 先取出左右孩子的值
        int left = 2 * i + 1;
        // 如果左右孩子的值都存在，则取左右孩子的较大值
        if (left < length && arr[left] > arr[left + 1]) {
            left++;
        }
        //  如果左右孩子的值都存在，则取左右孩子的较大值
        int right = left + 1;
        if (right < length && arr[right] > arr[left]) {
            right++;
        }
    }

}