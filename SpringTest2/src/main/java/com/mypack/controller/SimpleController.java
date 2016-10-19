package com.mypack.controller;

import com.mypack.model.RequestsCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.LongAdder;

@Controller
@RequestMapping("/simple")
public class SimpleController {

    @Autowired
    private RequestsCounter requestsCounter;

    @RequestMapping(method = RequestMethod.GET)
    public String displayRequestsCount(
            @RequestParam(value="name", defaultValue="Anonymous") String username,
            Model model) {
        requestsCounter.increment();

        long localRequestsCount = requestsCounter.getValue();

        model.addAttribute("username", username);
        model.addAttribute("requestsCount", localRequestsCount);

        return "main";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String incrementRequestsCount() {
        requestsCounter.increment();

        return "post";
    }
}
