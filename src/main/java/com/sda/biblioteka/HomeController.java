package com.sda.biblioteka;

import com.sda.biblioteka.tools.RandomNumberGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/helloSpring")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lottoNumbers", RandomNumberGenerator.drawLottoNumber());
        modelAndView.setViewName("home.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/index")
    public ModelAndView indexPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lottoNumbers", RandomNumberGenerator.drawLottoNumber());
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }
}
