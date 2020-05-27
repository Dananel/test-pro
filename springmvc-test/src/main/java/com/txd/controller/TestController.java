package com.txd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 处理器测试:
 * @RequestMapping: 既可以用在class上也可以用在method上
 *      参数：1：value：资源url，method：请求方法
 * @PathVariable: 接收请求url上的参数，占位符的名字和PathVariable参数名一样
 *
 * @RequestParam 映射请求参数
 *
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

    //http://localhost:8080/springmvc/test/test
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test() {
        return "success";
    }

    // http://localhost:8080/springmvc/test/testPathParam/12
    @RequestMapping("/testPathParam/{id}")
    public String testPathParam(@PathVariable("id") String id ) {
        System.out.println("test @PathVariable:"+id);
        return "success";
    }

    @RequestMapping("/testParam")
    public void testParam(@RequestParam("id")String id) {

    }
}
