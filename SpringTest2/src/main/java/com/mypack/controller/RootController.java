package com.mypack.controller;

import com.mypack.model.RequestStatus;
import com.mypack.model.RequestsCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController {

    @Autowired
    private RequestsCounter requestsCounter;

    @RequestMapping(method = RequestMethod.GET)
    public RedirectView redirectToSimple() {
        return new RedirectView("/simple");
    }

    @RequestMapping(method = RequestMethod.POST)
    public RequestStatus incrementRequestsCount() {
        requestsCounter.increment();

        return new RequestStatus("POST_OK");
    }
}
