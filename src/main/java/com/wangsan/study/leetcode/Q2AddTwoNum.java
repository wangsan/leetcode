package com.wangsan.study.leetcode;

public class Q2AddTwoNum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        System.out.println(l3);

        ListNode l4 = new ListNode(1);
        l4.next = new ListNode(8);
        ListNode l5 = new ListNode(0);
        ListNode l6 = solution.addTwoNumbers(l4, l5);
        System.out.println(l6);

        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(5);
        ListNode l9 = solution.addTwoNumbers(l7, l8);
        System.out.println(l9);
    }

    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode l1cur = l1, l2cur = l2, cur = dummyHead;
            int acc = 0;
            while (l1cur != null || l2cur != null || acc != 0) {
                int l1i = l1cur != null ? l1cur.val : 0;
                int l2i = l2cur != null ? l2cur.val : 0;

                int mod = (l1i + l2i + acc) % 10;
                acc = (l1i + l2i + acc) / 10;

                ListNode l3i = new ListNode(mod);
                cur.next = l3i;
                cur = l3i;

                l1cur = l1cur != null ? l1cur.next : null;
                l2cur = l2cur != null ? l2cur.next : null;
            }


            return dummyHead.next;
        }
    }
}




