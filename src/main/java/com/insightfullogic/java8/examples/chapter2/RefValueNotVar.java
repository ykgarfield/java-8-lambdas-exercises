package com.insightfullogic.java8.examples.chapter2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 引用值, 而不是变量
 */
public class RefValueNotVar {


    /**
     * age 变量是既成事实的 final 变量, 虽然不用 final 修饰, 但是在内部类
     * 或 lambda 中仍然是无法修改的.
     */
    public void innerClassUseFinalVar() {
        final String name = "Tom";
        int age = 24;

        // 无法修改, 编译报错
//        age = this.changeAge(age);

        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hi: " + name);
                // 可以使用非 final 变量, Java8 放松了这一限制
                System.out.println("Are you " + age + " ?");

                // 无法修改, 编译报错
//                age = 22;
            }
        });
    }


    public void lambdaUseFinalVar() {
        final String name = "Tom";
        int age = 24;

        // 无法修改, 编译报错
//        age = this.changeAge(age);

        Button button = new Button();
        button.addActionListener(event -> {
            System.out.println("Hi: " + name);
            // lamdba 内可以使用非 final 变量
            System.out.println("Are you " + age + " ?");

            // 无法修改, 编译报错
//            age = 22;
        });
    }

    private int changeAge(int age) {
        return age + 1;
    }
}
