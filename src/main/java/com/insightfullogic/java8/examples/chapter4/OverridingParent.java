package com.insightfullogic.java8.examples.chapter4;

// BEGIN body
public class OverridingParent extends ParentImpl {

    // 具体方法
    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }

}
// END body
