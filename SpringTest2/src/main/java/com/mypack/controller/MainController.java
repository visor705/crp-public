package com.mypack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.LongAdder;

@Controller
@RequestMapping("/simple")
public class MainController {

    private LongAdder requestsCount = new LongAdder();

    @RequestMapping(method = RequestMethod.GET)
    public String printMain(
            @RequestParam(value="name", defaultValue="Anonymous") String username,
            Model model) {
        requestsCount.increment();

        long localRequestsCount = requestsCount.longValue();

        model.addAttribute("username", username);
        model.addAttribute("requestsCount", localRequestsCount);

        return "main";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost() {
        requestsCount.increment();

        return "post";
    }
}
