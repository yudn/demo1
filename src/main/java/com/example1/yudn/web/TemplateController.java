package com.example1.yudn.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/2.
 */
@Controller
public class TemplateController {
    @RequestMapping("/")
    public String helloHtml(Map<String,Object> map){

        map.put("hello","from TemplateController.helloHtml");
        return"/helloHtml";
    }
}
