package com.wangsan.study.dynamicprograming;

public class Fibonacci {

    static long m = 0;

    public static int fib(int n) {
        m++;

        if (n <= 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static long l = 0;

    public static int fibDp(int n) {
        int fn_2 = 0;
        int fn_1 = 1;
        int fn = 2;

        for (int i = 1; i <= n; i++) {
            l++;

            if (i > 2) {
                fn_2 = fn_1;
                fn_1 = fn;
                fn = fn_1 + fn_2;
            }
        }

        return fn;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fib(45));
        System.out.println("use ms: " + (System.currentTimeMillis() - start));
        System.out.println("run fib times: " + m);

        long start2 = System.currentTimeMillis();
        System.out.println(fibDp(45));
        System.out.println("use ms: " + (System.currentTimeMillis() - start2));
        System.out.println("run fibDp times: " + l);
    }
}
