package com.wangsan.study.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str = "";
        ListNode temp = this;
        while (temp != null) {
            str += temp.val;
            temp = temp.next;
            if (temp != null) {
                str += "->";
            }
        }

        return str;
    }
}