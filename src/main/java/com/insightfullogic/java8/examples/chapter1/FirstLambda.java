package com.insightfullogic.java8.examples.chapter1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

/**
 */
public class FirstLambda {

    // 使用匿名内部类将行为和按钮单击进行关联
    public void anonymousInnerClass() {
        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
            }
        });
    }


    // 使用Lambda表达式将行为和按钮单击进行关联
    public void lambda() {
        Button button = new Button();
        button.addActionListener(event -> System.out.println("button clicked"));
    }


    private class MyButton {
        public void addActionListener(MyEventListener l) {

        }
    }

    private interface MyEventListener extends EventListener {
        void actionPerformed(ActionEvent event);

        void beforePerformed(ActionEvent event, String message);
    }


    /*public void lambda2() {
        MyButton button = new MyButton();
        button.addActionListener(event -> {

        },event, message -> {

        });
    }*/
}
