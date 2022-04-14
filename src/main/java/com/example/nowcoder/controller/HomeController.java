package com.example.nowcoder.controller;

import com.example.nowcoder.entity.DiscussPost;
import com.example.nowcoder.entity.Page;
import com.example.nowcoder.entity.User;
import com.example.nowcoder.service.DiscussPostService;
import com.example.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getHomePage(Model model, Page page){
        //spring会自动实例化model和page，也会自动装到model里
        //所以thymeleaf可以直接访问page对象中的数据

        //查总行数
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        //查前十个数据
        List<DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();

        //装到列表里，给前端页面使用
        if(list != null){
            for(DiscussPost discussPost: list){
                Map<String, Object> map = new HashMap<>();
                map.put("post", discussPost);
                User user = userService.findUserById(discussPost.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }

}
