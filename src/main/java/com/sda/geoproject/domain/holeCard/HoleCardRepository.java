package com.sda.geoproject.domain.holeCard;

import com.sda.geoproject.domain.borehole.Borehole;

import java.util.List;
import java.util.Optional;

public interface HoleCardRepository {
    void createHC(HoleCard holeCard);
    void deleteHC(int id);
    void updateHC(HoleCard holeCard);

    Optional<HoleCard> getOne(int id);

    List<HoleCard> getAll();

}
