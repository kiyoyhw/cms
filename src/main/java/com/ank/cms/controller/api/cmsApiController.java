package com.ank.cms.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class cmsApiController {
    /**
     * api请求接口
     *
     * @return 跳转地址
     */
    @RequestMapping("/api")
    public String redisApiHome() {
        return "redirect:swagger-ui.html";
    }
}
