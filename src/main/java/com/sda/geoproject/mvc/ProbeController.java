package com.sda.geoproject.mvc;

import com.sda.geoproject.domain.probe.Probe;
import com.sda.geoproject.domain.probe.ProbeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/probe")
@RequiredArgsConstructor
public class ProbeController {

    private final ProbeService probeService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    ModelAndView allProbesPage() {
        ModelAndView mav = new ModelAndView("probes.html");
        mav.addObject("probes", probeService.getAll());
        return mav;
    }

    @GetMapping("/addOrUpdate")
    ModelAndView addProbePage(@RequestParam(name = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView("addProbe.html");
        if (id != null) {
            mav.addObject("probe", probeService.getOne(id));
        } else {
            mav.addObject("probe", new Probe());
        }
        return mav;
    }

    @GetMapping("/delete")
    String deleteProbe(@RequestParam Integer id) {
        probeService.delete(id);

        return "redirect:/probe";
    }

    @PostMapping("/addOrUpdate")
    String addOrUpdateProbe(@ModelAttribute Probe probe) {
        if (probe.getId() == null) {
            probeService.createP(probe);
        } else {
            probeService.updateP(probe);
        }
        return "redirect:/probe";
    }
}
