package com.sda.geoproject.external.probe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProbeRepository extends JpaRepository<ProbeEntity, Integer> {
}
