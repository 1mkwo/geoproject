package com.sda.geoproject.mvc;

import com.sda.geoproject.domain.borehole.Borehole;
import com.sda.geoproject.domain.borehole.BoreholeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/borehole")
@RequiredArgsConstructor

public class BoreholeController {

    private final BoreholeService boreholeService;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    @PreAuthorize("isAuthenticated()")
    ModelAndView allBoreholePage() {
        ModelAndView mav = new ModelAndView("borehole.html");
        mav.addObject("borehole", boreholeService.getAll());
        return mav;
    }

    @GetMapping("/addOrUpdate")
    @PreAuthorize("hasRole('WORKER')")
    ModelAndView addBoreholePage(@RequestParam(name = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView("addBorehole.html");
        if (id != null) {
            mav.addObject("borehole", boreholeService.getOne(id));
        } else {
            mav.addObject("patient", new Borehole());
        }
        return mav;
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('WORKER')")
    String deleteBorehole(@RequestParam Integer id) {
        boreholeService.deleteB(id);

        return "redirect:/borehole";
    }

    @PostMapping("/addOrUpdate")
    @PreAuthorize("hasRole('WORKER')")
    String addOrUpdateBorehole(@ModelAttribute @Valid Borehole borehole, BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "addBorehole.html";
        }

        if (borehole.getId() == null) {
            boreholeService.createB(borehole);
        } else {
            boreholeService.updateB(borehole);
        }
        return "redirect:/borehole";
    }

}
