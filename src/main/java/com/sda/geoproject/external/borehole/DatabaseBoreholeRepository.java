package com.sda.geoproject.external.borehole;

import com.sda.geoproject.domain.borehole.Borehole;
import com.sda.geoproject.domain.borehole.BoreholeRepository;
import com.sda.geoproject.domain.probe.Probe;
import com.sda.geoproject.external.probe.ProbeEntity;
import com.sda.geoproject.external.user.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class DatabaseBoreholeRepository implements BoreholeRepository {

    private final JpaBoreholeRepository boreholeRepository;
    private final JpaUserRepository userRepository;

    @Override
    public void createB(Borehole borehole) {
        BoreholeEntity entity = BoreholeEntity.builder().user(userRepository.findByUsername(borehole.getOperator())
            .orElseThrow(() -> new IllegalStateException("User does not exiists.")))
                .bhDate(borehole.getBhDate())
                .location(borehole.getLocation())
                .depth(borehole.getDepth())
                .difficulty(borehole.getDifficulty())
                .build();

        boreholeRepository.save(entity);
    }

    @Override
    public void deleteB(int id) {
        boreholeRepository.deleteById(id);
    }

    @Override
    public void updateB(Borehole borehole) {
        boreholeRepository.findById(borehole.getId())
                .ifPresent(ent -> {
                    ent.updateFromDomain(borehole);
                    boreholeRepository.save(ent);
                });
    }

    @Override
    public Optional<Borehole> getOne(int id) {
        return boreholeRepository.findById(id).map(mapToDomain());
    }

    @Override
    public List<Borehole> getAll() {
        return boreholeRepository.findAll()
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    private Function<BoreholeEntity, Borehole> mapToDomain() {
        return ent -> Borehole.builder()
                .id(ent.getId())
                .operator(ent.getUser().getUsername())
                .bhDate(ent.getBhDate())
                .location(ent.getLocation())
                .depth(ent.getDepth())
                .difficulty(ent.getDifficulty())
                .build();
    }
}