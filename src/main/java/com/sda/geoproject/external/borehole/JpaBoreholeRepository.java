package com.sda.geoproject.external.borehole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface JpaBoreholeRepository extends JpaRepository<BoreholeEntity, Integer> {
    Optional<BoreholeEntity> findByLocation(String location);
}
