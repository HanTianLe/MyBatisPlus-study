package com.htl.generator.controller;

import com.htl.generator.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hantianle
 * @since 2020-12-22
 */
@Controller
@RequestMapping("/generator/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list",accountService.list());
        return modelAndView;
    }

}

