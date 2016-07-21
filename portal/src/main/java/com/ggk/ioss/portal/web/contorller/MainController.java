package com.ggk.ioss.portal.web.contorller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController{
	
	@RequestMapping(value = "/ioss")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView result = new ModelAndView("/html/login.html");
        return result;
    }
	
}