package com.example1.yudn.web;

import com.example1.yudn.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2017/4/27.
 */

@RestController
public class HelloController {
/*    @Value("${cpuSize}")
    private String cpuSize;
    @Value("${age}")
    private int age;
    @Value("${content}")
    private String content;*/
@Autowired
private GirlProperties girlProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET )
    public String hello() {
        return girlProperties.getCpuSize();

    }
    @RequestMapping(value="/1/")
    public String index1() {
        return "Greetings from Spring Boot! 333333333"  +"SSSSSSSSSSS"+ girlProperties.getAge();
    }
    @RequestMapping(value = "/home/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/home/{id}")
    public String say(@PathVariable(value = "id") Integer id) {
        return "id:" + id;
    }

}
