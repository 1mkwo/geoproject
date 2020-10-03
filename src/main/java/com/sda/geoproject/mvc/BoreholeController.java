package com.sda.geoproject.mvc;

import com.sda.geoproject.domain.borehole.Borehole;
import com.sda.geoproject.domain.borehole.BoreholeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/borehole")
@RequiredArgsConstructor
public class BoreholeController {

    private final BoreholeService boreholeService;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    ModelAndView allBoreholePage() {
        ModelAndView mav = new ModelAndView("boreholes.html");
        mav.addObject("boreholes", boreholeService.getAll());
        return mav;
    }

    @GetMapping("/addOrUpdate")
    ModelAndView addBoreholePage(@RequestParam(name = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView("addBorehole.html");
        if (id != null) {
            mav.addObject("borehole", boreholeService.getOne(id));
        } else {
            mav.addObject("borehole", new Borehole());
        }
        return mav;
    }

    @GetMapping("/delete")
    String deleteBorehole(@RequestParam Integer id) {
        boreholeService.deleteB(id);

        return "redirect:/borehole";
    }

    @PostMapping("/addOrUpdate")
    String addOrUpdateBorehole(@ModelAttribute Borehole borehole) {

        if (borehole.getId() == null) {
            boreholeService.createB(borehole);
        } else {
            boreholeService.updateB(borehole);;
        }
        return "redirect:/patient";
    }
}
