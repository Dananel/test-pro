package com.txd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * hello-world入门：controller
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
         return "hello world";
    }
}
