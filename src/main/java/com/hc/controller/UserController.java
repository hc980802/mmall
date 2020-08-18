package com.hc.controller;


import com.hc.entity.User;
import com.hc.enums.ResultEnum;
import com.hc.exception.MallException;
import com.hc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 张三
 * @since 2020-07-25
 */
@Controller
@RequestMapping("//user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(User user, HttpSession session) {
        User result = this.userService.login(user);
        String url = "";
        if (result == null) {
            url = "login";
        } else {
            session.setAttribute("user", result);
            url = "redirect:/";
        }
        return url;
    }

    @PostMapping("/register")
    public String register(User user) {
        boolean save = this.userService.save(user);
        if (save) {
            return "login";
        } else {
            throw new MallException(ResultEnum.REGISTER_ERROR);
        }
    }

}

