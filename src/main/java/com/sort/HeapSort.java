package com.sort;

import java.util.Arrays;

public class HeapSort {
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int tmp = array[parentIndex];
        int childIndex = 2*parentIndex + 1;

        while (childIndex < length) {
            //如果有右孩子且右孩子大于左孩子的值,则定位右孩子
            if(childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值 跳出
            if(tmp > array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = tmp;
    }
    public static void sort(int[] arr) {
        for (int i = (arr.length-2)/2; i>=0 ; i--) {
            downAdjust(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));
        for(int i=arr.length - 1; i>0; i--) {
            int tem = arr[i];
            arr[i] = arr[0];
            arr[0] = tem;

            downAdjust(arr,0,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
