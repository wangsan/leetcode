package com.wangsan.study.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.wangsan.study.ds.Permutation;
import com.wangsan.study.ds.Sample;

/**
 * @author wangsan
 * @date 2018/09/17
 */
public class Point24 {

    public static void main(String[] args) {
        calculate(Lists.newArrayList(6, 6, 6, 6)).forEach(System.out::println);
        System.out.println();

        calculate(Lists.newArrayList(1, 2, 1, 7)).forEach(System.out::println);
        System.out.println();

        calculate(Lists.newArrayList(3, 3, 7, 7)).forEach(System.out::println);
        System.out.println();

        calculate(Lists.newArrayList(3, 3, 8, 8)).forEach(System.out::println);
        System.out.println();

        calculate(Lists.newArrayList(1, 5, 5, 5)).forEach(System.out::println);
    }

    public static Set<String> calculate(List<Integer> numbers) {
        List<String> opList = new ArrayList<>();
        opList.add("+");
        opList.add("-");
        opList.add("*");
        opList.add("/");

        List<List<Integer>> numberPerm = Permutation.permutation(numbers);
        List<List<String>> opSample = Sample.sample(opList, 3);
        return crossJoin(numberPerm, opSample);
    }

    public static Set<String> crossJoin(List<List<Integer>> a, List<List<String>> b) {
        Set<String> expression = new HashSet<>();
        a.forEach(ai -> {
            b.forEach(bi -> {
                List<String> result = cal(ai, bi);
                if (result != null) {
                    expression.addAll(result);
                }
            });
        });

        return expression;
    }

    private static List<String> cal(List<Integer> numbers, List<String> ops) {
        try {
            List<Exp> exps = numbers.stream().map(i -> new Exp(i.doubleValue())).collect(Collectors.toList());
            List<Integer> opIndex = Lists.newArrayList(0, 1, 2);
            List<List<Integer>> permutation = Permutation.permutation(opIndex);
            return permutation.stream().map(oi -> {
                Integer first = oi.get(0);
                Integer second = oi.get(1);
                Integer third = oi.get(2);

                Exp op1 = new Exp(ops.get(first), exps.get(first), exps.get(first + 1));
                Exp op2;
                Exp op3 = new Exp(0.0);
                if (second - first == 1) {
                    op2 = new Exp(ops.get(second), op1, exps.get(second + 1));

                    if (third > second) {
                        op3 = new Exp(ops.get(third), op2, exps.get(third + 1));
                    } else {
                        op3 = new Exp(ops.get(third), exps.get(third), op2);
                    }
                } else if (second - first == -1) {
                    op2 = new Exp(ops.get(second), exps.get(second), op1);
                    if (third > second) {
                        op3 = new Exp(ops.get(third), op2, exps.get(third + 1));
                    } else {
                        op3 = new Exp(ops.get(third), exps.get(third), op2);
                    }
                } else if (second - first == 2) {
                    op2 = new Exp(ops.get(second), exps.get(second), exps.get(second + 1));
                    op3 = new Exp(ops.get(third), op1, op2);
                } else if (second - first == -2) {
                    op2 = new Exp(ops.get(second), exps.get(second), exps.get(second + 1));
                    op3 = new Exp(ops.get(third), op2, op1);
                }

                if (Math.abs(op3.value - 24) < 1e-5) {
                    return op3.simpleString();
                }

                return null;
            }).filter(Objects::nonNull).collect(Collectors.toList());

        } catch (Exception e) {
        }

        return null;
    }

    private static class Exp {
        private double value;
        private String exp;

        public Exp(double value) {
            this.value = value;
            this.exp = String.valueOf((int) value);
        }

        public Exp(String op, Exp a, Exp b) {
            value = op(op, a.value, b.value);
            exp = "(" + a.exp + op + b.exp + ")";
        }

        @Override
        public String toString() {
            return exp;
        }

        public String simpleString() {
            if (exp.startsWith("(") && exp.endsWith(")")) {
                return exp.substring(1, exp.length() - 1);
            } else {
                return exp;
            }
        }
    }

    private static double op(String op, Double a, Double b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new RuntimeException("error op");
        }
    }

}
