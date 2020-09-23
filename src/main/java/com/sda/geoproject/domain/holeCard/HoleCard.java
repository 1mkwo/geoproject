package com.sda.geoproject.domain.holeCard;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class HoleCard {
    private Integer id;
    @NotEmpty(message = "Point number must be given")
    private String pointNumber;
    @NotEmpty(message = "Point number must be given")
    private String layerDepth;
    @NotEmpty(message = "Point number must be given")
    private String landType;
    private String description;
    private String plasticityState;
    @NotEmpty(message = "Point number must be given")
    private String wetness;
    private boolean sample;
    private String waterDrilled;
    private String waterStabilized;
}
