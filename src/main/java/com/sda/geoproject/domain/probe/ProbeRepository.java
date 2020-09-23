package com.sda.geoproject.domain.probe;

import java.util.List;
import java.util.Optional;

public interface ProbeRepository {
    void createP(Probe probe);
    void deleteP(int id);
    void updateP(Probe probe);

    Optional<Probe> getOne(int id);

    List<Probe> getAll();
}
