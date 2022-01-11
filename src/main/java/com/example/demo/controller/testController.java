package com.example.demo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author laogao
 * @date 2022/1/7 11:03
 */

@Controller
public class testController {

    @ApolloConfig
    private Config apolloStaticConfig;


    @PostMapping(value = "/world", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateUserAddress() {
        System.out.println("hh");
        String a = apolloStaticConfig.getProperty("test","");
        System.out.println(a);
        return a;
    }

    @RequestMapping("/index")
    public String updateUserAddress2() {
        System.out.println("hh");

        return "";
    }

}
