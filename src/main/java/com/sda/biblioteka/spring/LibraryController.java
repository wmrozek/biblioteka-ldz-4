package com.sda.biblioteka.spring;

import com.sda.biblioteka.spring.db.BookContext;
import com.sda.biblioteka.spring.db.UserContext;
import com.sda.biblioteka.spring.db.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LibraryController {

    @RequestMapping(value = "/home")
    public ModelAndView libraryHomePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksCount", BookContext.getInstance().getBooksCount());
        modelAndView.addObject("usersCount", UserContext.getInstance().getUsersCount());
        modelAndView.setViewName("libraryMain.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksCount", BookContext.getInstance().getBooksCount());
        modelAndView.addObject("usersCount", UserContext.getInstance().getUsersCount());
        modelAndView.setViewName("register.jsp");
        return modelAndView;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(@ModelAttribute(value = "regForm") User user){
        //WALIDACJA
        UserContext.getInstance().addUser(user);
        return "redirect:/home";
    }

//    @RequestMapping(value="/register", method = RequestMethod.POST)
//    public String register(@ModelAttribute(value = "regForm") User user,
//                           @RequestParam(value = "login") String login){
//        System.out.println(login);
//        return "redirect:/home";
//    }

}
