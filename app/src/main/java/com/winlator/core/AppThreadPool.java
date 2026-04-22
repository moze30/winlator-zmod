package com.winlator.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

// 测试用

public abstract class AppThreadPool {
    private static ExecutorService executorService;
    private static ScheduledExecutorService scheduledExecutorService;

    public static synchronized ExecutorService getExecutorService() {
        if (executorService == null || executorService.isShutdown()) {
            executorService = Executors.newCachedThreadPool();
        }
        return executorService;
    }

    public static synchronized ScheduledExecutorService getScheduledExecutorService() {
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            scheduledExecutorService = Executors.newScheduledThreadPool(4);
        }
        return scheduledExecutorService;
    }
    
    public static void shutdown() {
        if (executorService != null) {
            executorService.shutdownNow();
            executorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            scheduledExecutorService = null;
        }
    }
}
