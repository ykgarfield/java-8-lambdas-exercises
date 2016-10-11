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
    }
}
