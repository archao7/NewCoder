package com.example.nowcoder.controller;

import com.example.nowcoder.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    //
    @Autowired
    DiscussPostService discussPostService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(Model model){

        return "/index";
    }

}
