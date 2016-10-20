package com.mypack.controller;

import com.mypack.model.ExtendedResponse;
import com.mypack.model.RequestStatus;
import com.mypack.model.RequestsCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/secured/simple", produces = MediaType.APPLICATION_JSON_VALUE)
public class SecuredSimpleController {
    @Autowired
    private RequestsCounter requestsCounter;

    @RequestMapping(method = RequestMethod.GET)
    public ExtendedResponse displayRequestsCount(
            @RequestParam(value = "name", defaultValue = "Anonymous") String name) {
        requestsCounter.increment();

        long localRequestsCount = requestsCounter.getValue();

        return new ExtendedResponse(new RequestStatus("GET_OK_SECURED"), name, localRequestsCount);
    }
}
