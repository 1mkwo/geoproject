package com.sda.geoproject.domain.probe;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProbeService {
    @Autowired
    private final ProbeRepository probeRepository;

    public void createP(Probe probe){
        probeRepository.createP(probe);
    }

    public void deleteP(int id){
        probeRepository.deleteP(id);
    }

    public void updateP(Probe probe){
        probeRepository.getOne(probe.getId()).filter(pro-> !pro.getId().equals(probe.getId()))
                .ifPresent(pro -> {throw new IllegalStateException("Probe with same Id already exists");});
        probeRepository.updateP(probe);
    }
    public List<Probe> getAll(){
      return probeRepository.getAll();
    }

    public Probe getOne(int id) {
        return probeRepository.getOne(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient with given id not exists"));
    }
}
