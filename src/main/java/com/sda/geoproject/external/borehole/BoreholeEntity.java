package com.sda.geoproject.external.borehole;

import com.sda.geoproject.domain.borehole.Borehole;
import com.sda.geoproject.domain.probe.Probe;
import com.sda.geoproject.external.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "borehole")
public class BoreholeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private LocalDate bhDate;
    private String location;
    private Integer depth;
    private Integer difficulty;

    void updateFromDomain(Borehole borehole) {
        this.bhDate = borehole.getBhDate();
        this.location = borehole.getLocation();
        this.depth = borehole.getDepth();
        this.difficulty = borehole.getDifficulty();

    }
}
