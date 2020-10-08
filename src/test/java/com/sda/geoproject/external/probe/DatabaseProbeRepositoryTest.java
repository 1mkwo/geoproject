package com.sda.geoproject.external.probe;

import com.sda.geoproject.domain.probe.Probe;
import com.sda.geoproject.domain.user.User;
import com.sda.geoproject.external.user.DatabaseUserRepository;
import com.sda.geoproject.external.user.JpaUserRepository;
import com.sda.geoproject.external.user.UserEntity;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDate;

public class DatabaseProbeRepositoryTest {

    private JpaProbeRepository jpaProbeRepository = Mockito.mock(JpaProbeRepository.class);
    private JpaUserRepository jpaUserRepository = Mockito.mock(JpaUserRepository.class);
    private DatabaseProbeRepository probeRepository = new DatabaseProbeRepository(jpaProbeRepository, jpaUserRepository);
    private DatabaseUserRepository userRepository = new DatabaseUserRepository(jpaUserRepository);

    private ArgumentCaptor<ProbeEntity> probeEntityCaptor = ArgumentCaptor.forClass(ProbeEntity.class);
    private ArgumentCaptor<UserEntity> userEntityCaptor = ArgumentCaptor.forClass(UserEntity.class);

    @Test
    public void shouldPersistNewProbe() {
        //given
        User user = new User(1,"Robert", "password", "admin");
        Probe probe = new Probe(1, "Robert", LocalDate.of(2000, 10, 10), 130, "Lublin");
        //when
        userRepository.create(user);
        probeRepository.createP(probe);
        //then
        Mockito.verify(jpaProbeRepository).save(probeEntityCaptor.capture());
        Mockito.verify(jpaUserRepository).save(userEntityCaptor.capture());

        ProbeEntity entity = probeEntityCaptor.getValue();
        Assertions.assertEquals("Robert", entity.getUser());
        Assertions.assertEquals(130, entity.getDepth());
        Assertions.assertEquals("Lublin", entity.getLocation());
        Assertions.assertEquals(LocalDate.of(2000, 10, 10), entity.getProbeDate());
    }

}