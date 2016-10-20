package com.mypack.controller;

import com.mypack.model.ExtendedResponse;
import com.mypack.model.RequestStatus;
import com.mypack.model.RequestsCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.LongAdder;

@RestController
@RequestMapping(value = "/simple", produces = MediaType.APPLICATION_JSON_VALUE)
public class SimpleController {

    @Autowired
    private RequestsCounter requestsCounter;

    @RequestMapping(method = RequestMethod.GET)
    public ExtendedResponse displayRequestsCount(
            @RequestParam(value="name", defaultValue="Anonymous") String name) {
        requestsCounter.increment();

        long localRequestsCount = requestsCounter.getValue();

        return new ExtendedResponse(new RequestStatus("GET_OK"), name, localRequestsCount);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ExtendedResponse incrementRequestsCount(@RequestBody String name) {
        requestsCounter.increment();

        long localRequestsCount = requestsCounter.getValue();

        if (name.isEmpty()) {
            name = "Anonymous";
        }

        return new ExtendedResponse(new RequestStatus("POST_OK"), name, localRequestsCount);
    }
}
