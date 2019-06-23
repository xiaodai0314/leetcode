package com.leetcode.second;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取字符串中连续不重复字符串的最大长度
 *
 * 滑动窗口
 * 字节码
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static int lengthOfLongestSubstring1(String s) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (char c : chars ) {
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            }
            map.put(c,1);
        }
        sum = map.size();
        return sum;

    }
}
