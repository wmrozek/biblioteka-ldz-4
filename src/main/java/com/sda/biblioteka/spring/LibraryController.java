package com.sda.biblioteka.spring;

import com.sda.biblioteka.spring.db.BookContext;
import com.sda.biblioteka.spring.db.UserContext;
import com.sda.biblioteka.spring.db.model.Book;
import com.sda.biblioteka.spring.db.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LibraryController {

    @RequestMapping(value = "/home")
    public ModelAndView libraryHomePage(HttpServletRequest request){
        checkLoggedCookie(request);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksCount", BookContext.getInstance().getBooksCount());
        modelAndView.addObject("usersCount", UserContext.getInstance().getUsersCount());
        modelAndView.addObject("isLoggedUser", UserContext.getInstance().isLogged());
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Potop"));
        modelAndView.addObject("emptyList", books);
        modelAndView.addObject("books", BookContext.getInstance().getBooks());
        modelAndView.setViewName("libraryMain.jsp");
        return modelAndView;
    }

    private void checkLoggedCookie(HttpServletRequest request) {
        boolean isCookie = false;
        for (Cookie cookie : request.getCookies()){
            if (cookie.getName().equalsIgnoreCase("logged")){
                isCookie = true;
                break;
            }
        }
        if (!isCookie){
            UserContext.getInstance().setLoggedUser(false);
            request.getSession().invalidate();
        }
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksCount", BookContext.getInstance().getBooksCount());
        modelAndView.addObject("usersCount", UserContext.getInstance().getUsersCount());
        modelAndView.addObject("isAnonymous", Boolean.FALSE);
        modelAndView.addObject("isLoggedUser", Boolean.TRUE);
        modelAndView.setViewName("register.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksCount", BookContext.getInstance().getBooksCount());
        modelAndView.addObject("usersCount", UserContext.getInstance().getUsersCount());
        modelAndView.addObject("isAnonymous", Boolean.TRUE);
        modelAndView.addObject("isLoggedUser", Boolean.FALSE);
        modelAndView.setViewName("login.jsp");
        return modelAndView;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(@ModelAttribute(value = "regForm") User user){
        //WALIDACJA
        UserContext.getInstance().addUser(user);
        return "redirect:/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value="login") String login,
                        @RequestParam(value="password") String password,
                        HttpServletRequest request,
                        HttpServletResponse response){
        //TODO implementation
        UserContext.getInstance().setLoggedUser(true);
        //Tworzenie "ciasteczka"
        Cookie cookie = new Cookie("logged", "true");
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        //SESJA użytkownika
        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        return "redirect:/home";
    }

//    @RequestMapping(value="/register", method = RequestMethod.POST)
//    public String register(@ModelAttribute(value = "regForm") User user,
//                           @RequestParam(value = "login") String login){
//        System.out.println(login);
//        return "redirect:/home";
//    }

}
