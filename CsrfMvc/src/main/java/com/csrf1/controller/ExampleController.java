package com.csrf1.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class ExampleController {
    Logger logger = Logger.getLogger(ExampleController.class.getName());

    @RequestMapping("/")
    public String home() {
        return "Home";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("hello") String hello) {
        logger.info("Hello====>" + hello);
        return "hello";
    }
    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }
    @RequestMapping("/header")
    public String header() {
        return "header";
    }
}
