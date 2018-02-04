package com.sda.biblioteka.spring;

import com.sda.biblioteka.spring.db.BookContext;
import com.sda.biblioteka.spring.db.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
