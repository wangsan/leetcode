package com.wangsan.study.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangsan
 * @date 2018/09/17
 */
public class Sample {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("b");
        data.add("c");

        sample(data, 3).forEach(i -> System.out.println(i.stream().collect(Collectors.joining())));

        System.out.println("----");
        sample(data, 2).forEach(i -> System.out.println(i.stream().collect(Collectors.joining())));
    }

    public static <T> List<List<T>> sample(List<T> data, int size) {
        List<List<T>> result = new ArrayList<>();
        if (size == 1) {
            data.forEach(i -> {
                List<T> item = new ArrayList<>(1);
                item.add(i);
                result.add(item);
            });
            return result;
        }

        List<List<T>> smallResult = sample(data, size - 1);
        data.forEach(i -> {
            smallResult.forEach(s -> {
                List<T> item = new ArrayList<>();
                item.add(i);
                item.addAll(s);
                result.add(item);
            });
        });

        return result;
    }
}
