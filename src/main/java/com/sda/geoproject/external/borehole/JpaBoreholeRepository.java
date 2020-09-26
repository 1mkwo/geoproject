package com.sda.geoproject.external.borehole;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaBoreholeRepository extends JpaRepository<BoreholeEntity, Integer> {
    Optional<BoreholeEntity> findByLocation(String location);
}
