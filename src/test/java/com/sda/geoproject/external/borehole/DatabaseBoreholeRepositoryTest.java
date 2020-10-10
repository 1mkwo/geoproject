package com.sda.geoproject.external.borehole;

import com.sda.geoproject.domain.borehole.Borehole;
import com.sda.geoproject.domain.probe.Probe;
import com.sda.geoproject.external.probe.DatabaseProbeRepository;
import com.sda.geoproject.external.probe.JpaProbeRepository;
import com.sda.geoproject.external.probe.ProbeEntity;
import com.sda.geoproject.external.user.JpaUserRepository;
import com.sda.geoproject.external.user.UserEntity;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

public class DatabaseBoreholeRepositoryTest {


    private JpaBoreholeRepository jpaBoreholeRepository = Mockito.mock(JpaBoreholeRepository.class);
    private JpaUserRepository jpaUserRepository = Mockito.mock(JpaUserRepository.class);
    private DatabaseBoreholeRepository boreholeRepository = new DatabaseBoreholeRepository(jpaBoreholeRepository, jpaUserRepository);

    private ArgumentCaptor<BoreholeEntity> boreholeEntityCaptor = ArgumentCaptor.forClass(BoreholeEntity.class);

    @Test
    public void shouldPersistNewBorehole() {
        //given
        UserEntity user = new UserEntity(1, "Robert", "password", "admin");
        Borehole borehole = new Borehole(1, "Robert", LocalDate.of(2000, 10, 10), 130, 5, "Lublin");
        Mockito.when(jpaUserRepository.findByUsername("Robert")).thenReturn(Optional.of(user));
        //when
        boreholeRepository.createB(borehole);
        //then
        Mockito.verify(jpaBoreholeRepository).save(boreholeEntityCaptor.capture());
        BoreholeEntity entity = boreholeEntityCaptor.getValue();
        Assertions.assertEquals("Robert", entity.getUser().getUsername());
        Assertions.assertEquals(130, entity.getDepth());
        Assertions.assertEquals(5, entity.getDifficulty());
        Assertions.assertEquals("Lublin", entity.getLocation());
        Assertions.assertEquals(LocalDate.of(2000, 10, 10), entity.getBhDate());
    }
}
