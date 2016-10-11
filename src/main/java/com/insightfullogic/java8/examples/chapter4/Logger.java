package com.insightfullogic.java8.examples.chapter4;

import java.util.function.Supplier;

public class Logger {

    private boolean debug = true;

    public boolean isDebugEnabled() {
        return debug;
    }

    public void debug(String message) {
        if (isDebugEnabled()) {
            System.out.println(message);
        }
    }


    // 使用 isDebugEnabled 方法降低日志性能开销
    public void example() {
        // BEGIN debug_optimised
        Logger logger = new Logger();
        if (logger.isDebugEnabled()) {
            // 即使直接调用 debug 方法能省去记录文本信息，也仍然需要调用 expensiveOperation 方法，并且需要将执行结果和已有字符串连接起来
            logger.debug("Look at this: " + expensiveOperation());
        }
        // END debug_optimised
    }

    // 假设为昂贵的操作
    private String expensiveOperation() {
        return "";
    }

    // 启用 Lambda 表达式实现的日志记录器
    // BEGIN debug_lambda
    public void debug(Supplier<String> message) {
        if (isDebugEnabled()) {
            debug(message.get());
        }
    }
    // END debug_lambda

    // 使用 Lambda 表达式简化日志代码
    public void exampleWithLambda() {
        // BEGIN debug_optimised_lambda
        Logger logger = new Logger();
        logger.debug(() -> "Look at this: " + expensiveOperation());
        // END debug_optimised_lambda
    }

}
