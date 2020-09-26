package com.sda.geoproject.external.borehole;

import com.sda.geoproject.domain.borehole.Borehole;
import com.sda.geoproject.domain.borehole.BoreholeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DatabaseBoreholeRepository implements BoreholeRepository {
    private JpaBoreholeRepository boreholeRepository;

    @Override
    public void createB(Borehole borehole) {

    }

    @Override
    public void deleteB(int id) {

    }

    @Override
    public void updateB(Borehole borehole) {

    }

    @Override
    public Optional<Borehole> getOne(int id) {
        return Optional.empty();
    }

    @Override
    public List<Borehole> getAll() {
        return null;
    }
}
