package com.mypack.controller;

import com.mypack.model.RequestsCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    private RequestsCounter requestsCounter;

    @RequestMapping(method = RequestMethod.GET)
    public String redirectToSimple() {
        return "redirect:/simple";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String incrementRequestsCount() {
        requestsCounter.getRequestsCount().increment();

        return "post";
    }
}
