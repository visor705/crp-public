package com.mypack.controller;

import com.mypack.model.RequestStatus;
import com.mypack.model.RequestsCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.LongAdder;

@RestController
@RequestMapping(value = "/simple", produces = MediaType.APPLICATION_JSON_VALUE)
public class SimpleController {

    @Autowired
    private RequestsCounter requestsCounter;

    @RequestMapping(method = RequestMethod.GET)
    public RequestStatus displayRequestsCount(
            @RequestParam(value="name", defaultValue="Anonymous") String username,
            Model model) {
        requestsCounter.increment();

        long localRequestsCount = requestsCounter.getValue();

        //TODO:use REST request/response body

        model.addAttribute("username", username);
        model.addAttribute("requestsCount", localRequestsCount);

        return new RequestStatus("GET_OK");
    }

    @RequestMapping(method = RequestMethod.POST)
    public RequestStatus incrementRequestsCount() {
        requestsCounter.increment();

        return  new RequestStatus("POST_OK");
    }
}
