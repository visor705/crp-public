package com.mypack.model;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.LongAdder;

@Component
public class RequestsCounter {
    private LongAdder requestsCount = new LongAdder();

    public LongAdder getRequestsCount() {
        return requestsCount;
    }
}
