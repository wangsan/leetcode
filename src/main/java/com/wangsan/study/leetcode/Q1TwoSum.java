package com.wangsan.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] twoSum = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(twoSum));

        twoSum = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(twoSum));
    }

    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }

            return null;
        }
    }
}

