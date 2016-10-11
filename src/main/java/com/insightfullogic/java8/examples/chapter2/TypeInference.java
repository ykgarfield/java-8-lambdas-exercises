package com.insightfullogic.java8.examples.chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * 类型推断
 */
public class TypeInference {

    public void typeInference() {
        // Java7 无法通过
        useHashMap(new HashMap<>());
    }

    private void useHashMap(Map<String, String> values) {
    }


    public void typeInference2() {
        // Predicate 用来判断真假的函数接口
        Predicate<Integer> atLeast5 = x -> x > 5;

        // 略显复杂的类型推断
        BinaryOperator<Long> add = (x, y) -> x + y;


        // 没有泛型, 编译错误:  cannot be applied to java.lang.Object, java.lang.Object.
//        BinaryOperator add2 = (x, y) -> x + y;

        // 显式声明参数类型
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

        // 一个参数声明类型, 一个不声明, 编译报错
//        BinaryOperator<Long> addExplicit2 = (Long x, y) -> x + y;
    }
}
