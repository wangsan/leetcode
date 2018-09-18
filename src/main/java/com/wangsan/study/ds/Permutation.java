package com.wangsan.study.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 不放回抽样=全排列
 */
public class Permutation {
    public static void main(String[] args) {
        List<String> abcd = new ArrayList<>();
        abcd.add("a");
        abcd.add("b");
        abcd.add("c");
        abcd.add("d");

        List<List<String>> result = permutation(abcd);
        result.forEach(item -> System.out.println(item.stream().collect(Collectors.joining())));
    }

    public static <T> List<List<T>> permutation(List<T> itemList) {
        List<List<T>> result = new ArrayList<>();
        if (itemList.size() == 1) {
            result.add(itemList);
            return result;
        }

        for (int i = 0; i < itemList.size(); i++) {
            List<T> otherList = new ArrayList<>(itemList);
            T first = otherList.remove(i);

            // 递归公式 p(n)=Σ(0->n) p1(i)__p(n-i) 其中p(n)返回list<list>  p1(i)为返回单元素 __为单元素和list<list>取的逐项拼接逻辑
            List<List<T>> otherPermutationResult = permutation(otherList);
            for (List<T> otherPermutation : otherPermutationResult) {
                List<T> firstList = new ArrayList<>();
                firstList.add(first);
                firstList.addAll(otherPermutation);

                result.add(firstList);
            }
        }

        return result;
    }

    public static <T extends Comparable<? super T>> List<List<T>> permutationAb(List<T> itemList) {
        List<List<T>> result = new ArrayList<>();
        Collections.sort(itemList);

        while (nextPermutation(itemList)) {
            result.add(new ArrayList<>(itemList));
        }

        return result;
    }

    public static <T extends Comparable<? super T>> boolean nextPermutation(List<T> itemList) {
        int swap1 = itemList.size() - 1;
        int swap2 = itemList.size() - 1;
        while (swap1 > 0 && itemList.get(swap1).compareTo(itemList.get(swap1 - 1)) > 0) {

        }

        return false;
    }

}
