package com.sda.geoproject.domain.probe;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Probe {
    private Integer id;
    @NotNull(message = "Operator name cannot be null")
    private String operator;
    @NotEmpty(message = "Please enter the depth of research")
    private String depth;
    @PastOrPresent(message = "You cannot start research in the future")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate probeDate;
    @NotEmpty(message = "Location of research is needed")
    private String location;




}
