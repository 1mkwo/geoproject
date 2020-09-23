package com.sda.geoproject.mvc;

import com.sda.geoproject.config.FacilityConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class MainPageController {
    private final FacilityConfiguration facilityConfiguration;

    @GetMapping
    ModelAndView mainPage() {
        ModelAndView mav = new ModelAndView("main.html");
        mav.addObject("date", LocalDate.now().toString());
        mav.addObject("config", facilityConfiguration);
        return mav;
    }
}
