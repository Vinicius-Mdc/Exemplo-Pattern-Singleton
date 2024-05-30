package com.viniciusmdc.ExemploPatternSingleton.Enum;

import com.viniciusmdc.ExemploPatternSingleton.Thread.BaseThread;
import com.viniciusmdc.ExemploPatternSingleton.Thread.ThreadExample;
import com.viniciusmdc.ExemploPatternSingleton.Thread.ThreadExample2;
import com.viniciusmdc.ExemploPatternSingleton.Thread.ThreadManager;

public enum ThreadEnum {

    threadExample(ThreadExample.class),
    threadExample2(ThreadExample2.class);

    private final Class<? extends BaseThread> threadClass;

    ThreadEnum(Class<? extends BaseThread> threadExampleClass) {
        this.threadClass = threadExampleClass;
    }

    public static ThreadEnum fromId(String id) {
        for (ThreadEnum threadEnum : values()) {
            if (threadEnum.name().equalsIgnoreCase(id)) {
                return threadEnum;
            }
        }
        throw new IllegalArgumentException("Nenhuma thread encontrada para o parâmetro " + id);
    }

    public BaseThread getBaseThread() {
        return ThreadManager.getInstance().getThread(threadClass);
    }
}
