package com.klef.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.service.UserManager;

@Controller
public class ViewController {
	
	@Autowired
	 UserManager UM;

    @GetMapping("/")
    public ModelAndView showLoginPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");  
        return mv;
    }
}