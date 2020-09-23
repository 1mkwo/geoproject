package com.sda.geoproject.domain.holeCard;

import com.sda.geoproject.domain.probe.Probe;
import com.sda.geoproject.domain.probe.ProbeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@RequiredArgsConstructor
public class HoleCardService {
    @Autowired
    private final HoleCardRepository holeCardRepository;

    public void createHC(HoleCard holeCard){
        holeCardRepository.getOne(holeCard.getId())
                .ifPresent(pro-> {throw new IllegalStateException("HoleCard with given ID already exists");});

        holeCardRepository.createHC(holeCard);
    }
    public void deleteP(int id){
        holeCardRepository.deleteHC(id);
    }
    public void updateP(HoleCard holeCard){
        holeCardRepository.getOne(holeCard.getId()).filter(pro-> !pro.getId().equals(pro.getId()))
                .ifPresent(pro -> {throw new IllegalStateException("HoleCard with same Id already exists");});
        holeCardRepository.updateHC(holeCard);
    }
    public List<HoleCard> getAll(){
        return holeCardRepository.getAll();
    }

}
