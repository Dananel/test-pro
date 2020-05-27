package com.txd.servletexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理器
 */
@Controller
public class HelloController {

    @RequestMapping("/test")
    public String test() {
        return "hello";
    }
}
