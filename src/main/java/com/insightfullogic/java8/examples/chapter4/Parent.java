package com.insightfullogic.java8.examples.chapter4;

// BEGIN body
public interface Parent {

    public void message(String body);

    // 默认方法
    public default void welcome() {
        message("Parent: Hi!");
    }

    public String getLastMessage();

}
// END body
