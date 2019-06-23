package com.algorithm;

public class MyBitMap {
    private long[] words;

    private int size;

    public MyBitMap(int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size - 1) + 1)];
    }

    /**
     * 判断Bitmap某一位的状态
     * @param bitIndex
     * @return
     */
    public boolean getBit(int bitIndex) {
        if(bitIndex<0 | bitIndex > size-1) {
            throw new IndexOutOfBoundsException("超过Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1l << bitIndex)) != 0;
    }

    /**
     * 把Bitmap某一位设置为true
     * @param bitIndex
     */
    public void setBit(int bitIndex) {
        if(bitIndex<0 | bitIndex > size-1) {
            throw new IndexOutOfBoundsException("超过Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    /**
     * 定位Bitmap某一位所对应的word
     * @param bitIndex
     * @return
     */
    private int getWordIndex(int bitIndex) {
        return  bitIndex >> 6;
    }

    public static void main(String[] args) {
        MyBitMap bitMap = new MyBitMap(128);
        bitMap.setBit(126);
        bitMap.setBit(75);
        System.out.println(bitMap.getBit(126));
        System.out.println(bitMap.getBit(78));
    }
}
