package com.sort;

import java.util.Arrays;

public class BubbleSort1 {
    public static void sort(int[] ints)  throws Exception{

        int sortBorder = ints.length - 1;
        int lastIndex = 0;
        for (int i=0; i<ints.length; i++) {
            boolean flag = true;
            for (int j=0; j < sortBorder; j++) {
                if ((ints[j]>ints[j+1])) {
                    swep(ints, j, j+1);
                    flag = false;
                    lastIndex = j;
                }
            }
            sortBorder = lastIndex;
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int[] ints = new int[]{3,4,5,2,1,3,5,6,7,8,9,7,8,5,8,9,6,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        sort(ints);
        long start = System.nanoTime();
        System.out.println(String.valueOf(start));
        System.out.println(Arrays.toString(ints));
        long end = System.nanoTime();
        System.out.println(String.valueOf(end));
        System.out.println("用时: " + String.valueOf(end - start));
    }
    private static void swep(int[] ints,int i1, int i2){
        int temp = 0;
        temp = ints[i1];
        ints[i1] = ints[i2];
        ints[i2] = temp;
    }
}
