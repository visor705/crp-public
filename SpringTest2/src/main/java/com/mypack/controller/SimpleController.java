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
    public RequestStatus incrementRequestsCount() {
        requestsCounter.increment();

        return  new RequestStatus("POST_OK");
    }
}
