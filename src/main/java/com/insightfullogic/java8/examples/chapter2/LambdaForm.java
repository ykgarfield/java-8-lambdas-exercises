package com.insightfullogic.java8.examples.chapter2;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class LambdaForm {

    /**
     * Lambda 表达式的形式
     */
    public void lambdaForm() {
        // 无参数
        // () 表示没有参数
        Runnable noArgs = () -> System.out.println("Hello World");

        // 一个参数, 可省略括号
        ActionListener oneArg = event -> System.out.println("Button clicked");

        // 多条语句
        Runnable multiStatement = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };

        // 多个参数
        BinaryOperator<Long> add = (x, y) -> x + y;

        // 编译错误:  cannot be applied to java.lang.Object, java.lang.Object.
//        BinaryOperator add2 = (x, y) -> x + y;

        // 显式声明参数类型
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
    }
}
