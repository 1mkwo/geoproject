package com.sda.geoproject.domain.probe;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

public class ProbeServiceTest {

    private ProbeRepository probeRepository =
            Mockito.mock(ProbeRepository.class);

    private ProbeService probeService = new ProbeService(probeRepository);

    @Test
    public void shouldCreateNewProbe() {
        //given
        Probe probe = new Probe(null, "Robert", LocalDate.of(2000, 10, 10), 130, "Lublin");
        //when
        probeService.createP(probe);
        //then
        Mockito.verify(probeRepository).createP(probe);
    }

    @Test
    public void shouldReturnProbeById() {
        //given
        Probe probe = new Probe(null, "Robert", LocalDate.of(2000, 10, 10), 130, "Lublin");
        Mockito.when(probeRepository.getOne(1)).thenReturn(Optional.of(probe));
        //when
        Probe returnedProbe = probeService.getOne(1);
        //then
        Assertions.assertEquals("Robert", returnedProbe.getOperator());
        Assertions.assertEquals(130, returnedProbe.getDepth());
        Assertions.assertEquals("Lublin", returnedProbe.getLocation());
        Assertions.assertEquals(LocalDate.of(2000, 10, 10), returnedProbe.getProbeDate());

    }
}