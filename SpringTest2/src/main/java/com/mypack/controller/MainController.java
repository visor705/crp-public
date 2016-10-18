package com.mypack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/simple")
public class MainController {

    private final Object REQUESTS_COUNT_MONITOR = new Object();
    private int requestsCount = 0;

    @RequestMapping(method = RequestMethod.GET)
    public String printMain(
            @RequestParam(value="name", defaultValue="Anonymous") String username,
            Model model) {
        int localRequestsCount = 0;

        synchronized (REQUESTS_COUNT_MONITOR) {
            requestsCount++;
            localRequestsCount = requestsCount;
        }

        model.addAttribute("username", username);
        model.addAttribute("requestsCount", localRequestsCount);

        return "main";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost() {
        synchronized (REQUESTS_COUNT_MONITOR) {
            requestsCount++;
        }

        return "post";
    }
}
