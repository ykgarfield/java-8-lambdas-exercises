package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Track;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * 常用的流操作
 */
public class CommonStreamOperate {

    public void collect() {
        List<String> collected = Stream.of("a", "b", "c")
                                        .collect(Collectors.toList());

    }


    /**
     * 如果有一个函数可以将一种类型的值转换成另外一种类型，map 操作就可以
     * 使用该函数，将一个流中的值转换成一个新的流。
     */
    public void useForConvertString2UpperCase() {
        List<String> collected = new ArrayList<>();
        for (String string : asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }
    }


    /**
     * 使用 map 操作将字符串转换为大写形式
     */
    public void mapConvertString2UpperCase() {
        List<String> collected = Stream.of("a", "b", "hello")
                                    .map(string -> string.toUpperCase())
                                    .collect(Collectors.toList());

        List<Integer> collected2 = Stream.of("1", "2", "30")
                .map(string -> Integer.parseInt(string))
                .collect(Collectors.toList());
    }


    /**
     * 使用循环遍历列表，使用条件语句做判断
     */
    public void useForTraverseListAndUseIf() {
        List<String> beginningWithNumbers = new ArrayList<>();
        for(String value : asList("a", "1abc", "abc1")) {
            if (isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }
    }


    public void map() {
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                                                    .filter(value -> isDigit(value.codePointAt(0)))
                                                    .collect(Collectors.toList());
    }


    public void flatMap() {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                                        .flatMap(numbers -> numbers.stream())
                                        .collect(Collectors.toList());
    }


    public void maxMin() {
        List<Track> tracks = asList(new Track("Bakai", 524),
                                    new Track("Violets for Your Furs", 378),
                                    new Track("Time Was", 451));

        Track shortestTrack = tracks.stream()
                        .min(Comparator.comparing(track -> track.getLength()))
                        .get();
    }


    // 使用 reduce 求和
    public void reduce_sum() {
        int count = Stream.of(1, 2, 3)
                            .reduce(0, (acc, element) -> acc + element);

        assertEquals(6, count);
    }


    // 展开 reduce 操作
    public void reduce() {
        BinaryOperator<Integer> accumlator = (acc, element) -> acc + element;

        int count = accumlator.apply(
                accumlator.apply(
                        accumlator.apply(0, 1),
                2),
            3);
    }


    // 使用命令式编程方式求和
    public void sum_commond() {
        int acc = 0;
        for (Integer element : asList(1, 2, 3)) {
            acc += element;
        }

        assertEquals(6, acc);
    }
}
