package com.sda.geoproject.external.probe;

import com.sda.geoproject.domain.probe.Probe;
import com.sda.geoproject.external.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "probes")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProbeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Integer depth;
    private LocalDate probeDate;
    private String location;

    void updateFromDomain(Probe probe) {
        this.location = probe.getLocation();
        this.probeDate = probe.getProbeDate();
        this.depth = probe.getDepth();
    }
}
