package com.sda.geoproject.mvc;

import com.sda.geoproject.domain.user.User;
import com.sda.geoproject.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/register")
public class UserController {
    private final UserService userService;

    @GetMapping
    ModelAndView registerPage(){
        ModelAndView mav= new ModelAndView("register.html");
        mav.addObject("user", new User());
        return mav;
    }
    @PostMapping
    String registerUser(@ModelAttribute User user){
        userService.registerUser(user);

        return "redirect:/";
    }
}
