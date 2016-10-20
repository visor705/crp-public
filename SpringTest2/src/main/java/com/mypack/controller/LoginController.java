package com.mypack.controller;

import com.mypack.model.RequestStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/login_check")
public class LoginController {
    @RequestMapping(method = RequestMethod.POST)
    public RedirectView checkCredentials() {
        return new RedirectView("/simple");
    }
}
