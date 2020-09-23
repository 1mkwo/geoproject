package com.sda.geoproject.domain.borehole;

import com.sda.geoproject.domain.probe.Probe;

import java.util.List;
import java.util.Optional;

public interface BoreholeRepository {
    void createB(Borehole borehole);
    void deleteB(int id);
    void updateB(Borehole borehole);

    Optional<Borehole> getOne(int id);

    List<Borehole> getAll();
}
