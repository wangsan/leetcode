package com.wangsan.study.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class Q3LongestSubstring {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.err.println(solution.lengthOfLongestSubstring("abcabcbb") == 3);
        System.err.println(solution.lengthOfLongestSubstring("bbbbb") == 1);
        System.err.println(solution.lengthOfLongestSubstring("pwwkew") == 3);
        System.err.println(solution.lengthOfLongestSubstring("abcadcbb") == 4);
        System.err.println(solution.lengthOfLongestSubstring("abcbacdcbb") == 4);
        System.err.println(solution.lengthOfLongestSubstring("abcde") == 5);
        System.err.println(solution.lengthOfLongestSubstring("c") == 1);
        System.err.println(solution.lengthOfLongestSubstring("cdd") == 2);
        System.err.println(solution.lengthOfLongestSubstring("jbpnbwwd") == 4);
        System.err.println(solution.lengthOfLongestSubstring("hkcpmprxxxqw") == 5);

    }

    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            LinkedHashSet<Character> maxSub = new LinkedHashSet<Character>();
            LinkedHashSet<Character> sub = new LinkedHashSet<Character>();

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Character c = chars[i];
                boolean contains = sub.contains(c);
                if (!contains) {
                    sub.add(c);
                }

                if (i == chars.length - 1) {
                    if (sub.size() >= maxSub.size()) {
                        maxSub.clear();
                        maxSub.addAll(sub);
                    }
                    break;
                }

                if (contains) {
                    if (sub.size() >= maxSub.size()) {
                        maxSub.clear();
                        maxSub.addAll(sub);
                    }

                    // remove chars before c
                    Iterator<Character> iterator = sub.iterator();
                    while (iterator.hasNext()) {
                        Character sc = iterator.next();
                        iterator.remove();

                        if (sc.equals(c)) {
                            break;
                        }
                    }
                    // add c to the tail
                    sub.add(c);
                }
            }

            return maxSub.size();
        }
    }

    public static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }
    }
}
