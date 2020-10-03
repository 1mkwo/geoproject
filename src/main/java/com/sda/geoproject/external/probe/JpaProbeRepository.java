package com.sda.geoproject.external.probe;

import com.sda.geoproject.external.borehole.BoreholeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaProbeRepository extends JpaRepository<ProbeEntity, Integer> {
    Optional<ProbeEntity> findByLocation(String location);
}
