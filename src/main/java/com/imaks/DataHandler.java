package com.imaks;

import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

    private final String[] fruits;

    public DataHandler(String[] fruits) {
        this.fruits = fruits;
    }

    public void getOutput() {
        // критичний блок коду
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append(Thread.currentThread().getName()).append(": ");
            AtomicInteger count = new AtomicInteger(1);
            for (String fruit : fruits) {
                sb.append(String.format("(%d) %s ",
                        count.getAndIncrement(), fruit));
            }
            System.out.println(sb);
        }
    }
}