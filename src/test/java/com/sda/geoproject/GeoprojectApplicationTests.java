package com.sda.geoproject;

import com.sda.geoproject.config.FacilityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@EnableConfigurationProperties(FacilityConfiguration.class)
@SpringBootTest
class GeoprojectApplicationTests {

    @Test
    void contextLoads() {
    }

}
