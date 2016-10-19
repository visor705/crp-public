package com.mypack.controller;

import com.mypack.model.RequestStatus;
import com.mypack.model.RequestsCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class RootController {

    @Autowired
    private RequestsCounter requestsCounter;

    @RequestMapping(method = RequestMethod.GET)
    public RequestStatus redirectToSimple() {
        //TODO:redirect?
        return new RequestStatus("Redirect failed");
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public RequestStatus incrementRequestsCount() {
        requestsCounter.increment();

        return new RequestStatus("POST_OK");
    }
}
