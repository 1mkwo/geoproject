package com.sda.geoproject.domain.borehole;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BoreholeService {
    private final BoreholeRepository boreholeRepository;

    public void createB(Borehole borehole){
        boreholeRepository.createB(borehole);
    }

    public void deleteB(int id){
        boreholeRepository.deleteB(id);
    }

    public void updateB(Borehole  borehole){
        boreholeRepository.getOne(borehole.getId()).filter(bor-> !bor.getId().equals(borehole.getId()))
                .ifPresent(bro -> {throw new IllegalStateException("Borehole with same Id already exists");});
        boreholeRepository.updateB(borehole);
    }

    public List<Borehole> getAll(){
        return boreholeRepository.getAll();
    }

    public Borehole getOne(Integer id){
        return boreholeRepository.getOne(id)
                .orElseThrow(()-> new IllegalArgumentException("Borehole with given id not exist"));
    }
}
