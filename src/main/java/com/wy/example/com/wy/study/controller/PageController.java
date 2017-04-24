package com.wy.example.com.wy.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WY on 2017/4/23.
 */
@Controller
public class PageController {

    @RequestMapping("/hello")
    public String helloPage() {
        return "hello";
    }
}
