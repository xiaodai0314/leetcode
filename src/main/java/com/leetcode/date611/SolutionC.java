package com.leetcode.date611;

public class SolutionC {
    public String longestCommonPrefix(String[] strs) {
            String flag = strs[0];
            for(int i=1;i<strs.length;i++) {
                while (strs[i].indexOf(flag) != 0) {
                    flag = flag.substring(0,flag.length()-1);
                    if(flag.isEmpty()) {
                        return "";
                    }
                }
            }
            return flag;
    }
    public static void main(String[] args) {
        String result = new SolutionC().longestCommonPrefix(new String[] {"leetcode","leet","leetest","lees"});
        System.out.println(result);
    }
}
