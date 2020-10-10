package com.sda.geoproject.domain.borehole;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

public class BoreholeServiceTest {

    private BoreholeRepository boreholeRepository =
            Mockito.mock(BoreholeRepository.class);

    private BoreholeService boreholeService = new BoreholeService(boreholeRepository);

    @Test
    public void shouldCreateNewBorehole() {
        Borehole borehole = new Borehole(null, "Robert", LocalDate.of(2000, 10, 10), 130,5, "Lublin");
        //when
        boreholeService.createB(borehole);
        //then
        Mockito.verify(boreholeRepository).createB(borehole);
    }

    @Test
    public void shouldReturnBoreholeById() {
        //given
        Borehole borehole = new Borehole(null, "Robert", LocalDate.of(2000, 10, 10), 130, 5, "Lublin");
        Mockito.when(boreholeRepository.getOne(1)).thenReturn(Optional.of(borehole));
        //when
        Borehole returnedBorehole = boreholeService.getOne(1);
        //then
        Assertions.assertEquals("Robert", returnedBorehole.getOperator());
        Assertions.assertEquals(130, returnedBorehole.getDepth());
        Assertions.assertEquals(5, returnedBorehole.getDifficulty());
        Assertions.assertEquals("Lublin", returnedBorehole.getLocation());
        Assertions.assertEquals(LocalDate.of(2000, 10, 10), returnedBorehole.getBhDate());
    }
}
