package com.sda.geoproject.web.borehole;

import com.sda.geoproject.domain.borehole.Borehole;
import com.sda.geoproject.domain.borehole.BoreholeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/borehole")
@RequiredArgsConstructor
public class BoreholeEndpoint {

    private final BoreholeService boreholeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createPatient(@RequestBody @Valid Borehole borehole) {
        boreholeService.createB(borehole);
    }

    @PutMapping
    void updatePatient(@RequestBody Borehole borehole) {
        boreholeService.updateB(borehole);
    }

    @GetMapping
    List<Borehole> getAll() {
        return boreholeService.getAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteB(@RequestParam int id) {
        boreholeService.deleteB(id);
    }

    @GetMapping("/{id}")
    Borehole getById(@PathVariable int id) {
        return boreholeService.getOne(id);
    }
}
