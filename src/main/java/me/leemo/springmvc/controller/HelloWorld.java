package me.leemo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leemo on 15-12-22
 */
@Controller
@RequestMapping("/hello")
public class HelloWorld {
    @RequestMapping("hello.page")
    public ModelAndView page(
            @RequestParam(defaultValue = "null") String value
    ){
        ModelAndView mv = new ModelAndView("hello.html");
        mv.addObject("value", value);
        return mv;
    }

    @RequestMapping("hello.json")
    @ResponseBody
    public ControllerModel json(
            @RequestParam(defaultValue = "null") String value
    ){
        ControllerModel model = new ControllerModel();
        model.put("value", value);
        return model;
    }

    @RequestMapping("error.page")
    public ModelAndView errorPage(){
        throw new RuntimeException();
    }

    @RequestMapping("error.json")
    @ResponseBody
    public ModelAndView errorJson(){
        throw new RuntimeException();
    }
}
