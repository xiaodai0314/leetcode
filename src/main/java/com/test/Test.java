package com.test;

import java.net.URLDecoder;

public class Test {
    public static void main(String[] args) throws Exception{
        String result = URLDecoder.decode("%2B","GBK");
        System.out.println(result);
        System.out.println(URLDecoder.decode(";","ASCII"));
    }
}
