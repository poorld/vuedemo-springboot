package com.teenydas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Administrator
 * @Date 2018-08-22.
 * @Email teenyda@gmail.com
 */

@RestController
public class IndexController {

    @GetMapping(value = "/index")
    public String index() {
        return "hello";
    }
}
