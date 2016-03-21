package com.insightfullogic.java8.examples.chapter2;

import java.util.HashMap;
import java.util.Map;

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
}
