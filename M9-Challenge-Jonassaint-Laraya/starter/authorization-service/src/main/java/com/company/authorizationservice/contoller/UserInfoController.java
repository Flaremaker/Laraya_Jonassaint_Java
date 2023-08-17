package com.company.authorizationservice.contoller;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public HttpTrace.Principal getUserInfo(HttpTrace.Principal principal) {
        System.out.println("CALLED userinfo");
        return principal;
    }
}