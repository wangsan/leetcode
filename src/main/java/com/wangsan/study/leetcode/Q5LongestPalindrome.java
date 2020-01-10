package com.wangsan.study.leetcode;

public class Q5LongestPalindrome {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("babad").equals("bab"));
        System.out.println(solution.longestPalindrome("cbbd").equals("bb"));
        System.out.println(solution.longestPalindrome("abc").equals("a"));
        System.out.println(solution.longestPalindrome("").equals(""));

        System.out.println(solution.longestPalindrome("bb").equals("bb"));

        long start = System.nanoTime();
        System.out.println(solution.longestPalindrome("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg").equals("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
        System.out.println(System.nanoTime() - start);
    }

    public static class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 0) {
                return s;
            }

            int start = 0;
            int end = 0;
            char[] chars = s.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (isPalindrome(chars, i, j) && j - i > end - start) {
                        start = i;
                        end = j;
                    }
                }
            }

            return s.substring(start, end + 1);
        }

        public boolean isPalindrome(char[] chars, int start, int end) {
            for (int i = start, j = end; i < j; i++, j--) {
                if (chars[i] != chars[j]) {
                    return false;
                }
            }

            return true;
        }
        

        public boolean isPalindrome2(char[] chars) {
            for (int i = 0; i < chars.length / 2; i++) {
                if (chars[i] != chars[chars.length - 1 - i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
