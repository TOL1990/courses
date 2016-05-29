package com.courses.spalah.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap model)
    {
        model.addAttribute( "message", "Hello Nakach!!!");
        return "hello";
    }
}
