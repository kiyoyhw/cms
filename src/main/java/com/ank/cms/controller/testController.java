package com.ank.cms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("test")
@ApiIgnore
public class testController {

    @RequestMapping("hello")
    public String test() {
        return "hello";
    }

}
