package com.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] array) {
        for (int i=0 ; i<array.length ; i++) {
            for (int j=i ; j<array.length ; j++) {
                if(array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * @param array
     */
    public static void sort1(int[] array) {
        for (int i=0 ; i<array.length -1; i++) {
            for (int j=0 ; j<array.length -i -1; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序优化 1,如果已经排序了 结束循环
     * @param array
     */
    public static void sort2(int[] array) {
        for (int i=0 ; i<array.length -1 ; i++) {
            boolean isSorted = true;
            for (int j = 0 ; j<array.length -i -1 ; j++) {
                int tmp = 0;
                if(array[j] > array [j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = false;
                }
            }
            if(isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序优化 2增加flag 如果未比较提前结束里层循环,记录最后一次交换的位置
     * @param array
     */
    public static void sort3(int[] array) {
        int lastExchangeIndex = 0;
        int sortBorder = array.length -1;
        for(int i=0 ; i<array.length -1 ; i++) {
            boolean isSorted = true;
            for(int j = 0 ; j<sortBorder ; j++) {
                int tmp = 0;
                if(array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序变种 鸡尾酒排序
     * @param array
     */
    public void sort4(int[] array) {
        int tmp = 0;
        for (int i=0 ; i<array.length/2 ; i++) {
            boolean isSorted = true;

            for(int j=i; j<array.length-i-1 ; i++) {
                if(array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = false;
                }
            }
            if(isSorted) {
                break;
            }

            //偶数轮
            isSorted = true;
            for(int j = array.length -i -1 ; j>i ; j--) {
                if(array[j] < array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = false;
                }
            }
            if(isSorted) {
                break;
            }
        }
    }

    public static void  main(String[] args) {
        int[] array = new int[] {5,8,6,3,3,3,9,2,1,7};
        sort1(array);
        System.out.println(Arrays.toString(array));
    }
}
