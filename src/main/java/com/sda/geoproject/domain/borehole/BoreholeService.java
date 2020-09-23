package com.sda.geoproject.domain.borehole;

import com.sda.geoproject.domain.probe.Probe;
import com.sda.geoproject.domain.probe.ProbeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
@RequiredArgsConstructor
public class BoreholeService {
    @Autowired
    private final BoreholeRepository boreholeRepository;

    public void createB(Borehole borehole){
        boreholeRepository.getOne(borehole.getId())
                .ifPresent(bor-> {throw new IllegalStateException("Borehole with given ID already exists");});

        boreholeRepository.createB(borehole);
    }
    public void deleteB(int id){
        boreholeRepository.deleteB(id);
    }
    public void updateB(Borehole  borehole){
        boreholeRepository.getOne(borehole.getId()).filter(bor-> !bor.getId().equals(bor.getId()))
                .ifPresent(pro -> {throw new IllegalStateException("Borehole with same Id already exists");});
        boreholeRepository.updateB(borehole);
    }
    public List<Borehole> getAll(){
        return boreholeRepository.getAll();
    }
}
