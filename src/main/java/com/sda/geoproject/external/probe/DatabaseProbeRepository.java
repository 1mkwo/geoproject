package com.sda.geoproject.external.probe;

import com.sda.geoproject.domain.probe.Probe;
import com.sda.geoproject.domain.probe.ProbeRepository;
import com.sda.geoproject.external.user.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatabaseProbeRepository implements ProbeRepository {

    private final JpaProbeRepository probeRepository;
    private final JpaUserRepository userRepository;

    @Override
    public void createP(Probe probe) {
        ProbeEntity entity = ProbeEntity.builder()
                .user(userRepository.findByUsername(probe.getOperator()).orElseThrow(() -> new IllegalStateException("User does not exists.")))
                .depth(probe.getDepth())
                .location(probe.getLocation())
                .probeDate(probe.getProbeDate())
                .build();

        probeRepository.save(entity);
    }

    @Override
    public void deleteP(int id) {
        probeRepository.deleteById(id);
    }

    @Override
    public void updateP(Probe probe) {
        probeRepository.findById(probe.getId())
                .ifPresent(ent -> {
                    ent.updateFromDomain(probe);
                    probeRepository.save(ent);
                });
    }

    @Override
    public Optional<Probe> getOne(int id) {
        return probeRepository.findById(id).map(mapToDomain());
    }

    @Override
    public List<Probe> getAll() {
        return probeRepository.findAll()
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    private Function<ProbeEntity, Probe> mapToDomain() {
        return ent -> Probe.builder()
                .id(ent.getId())
                .depth(ent.getDepth())
                .location(ent.getLocation())
                .operator(ent.getUser().getUsername())
                .probeDate(ent.getProbeDate())
                .build();
    }
}
