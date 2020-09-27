package com.sda.geoproject.domain.probe;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProbeService {
    //@Autowired
    private final ProbeRepository probeRepository;

    public void createP(Probe probe){
        probeRepository.getOne(probe.getId())
                .ifPresent(pro-> {throw new IllegalStateException("Probe with given ID already exists");});

        probeRepository.createP(probe);
    }
    public void deleteP(int id){
        probeRepository.deleteP(id);
    }
    public void updateP(Probe probe){
        probeRepository.getOne(probe.getId()).filter(pro-> !pro.getId().equals(pro.getId()))
                .ifPresent(pro -> {throw new IllegalStateException("Probe with same Id already exists");});
        probeRepository.updateP(probe);
    }
    public List<Probe> getAll(){
      return probeRepository.getAll();
    }

}
