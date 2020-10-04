package com.sda.geoproject.domain.borehole;

import lombok.*;
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
public class Borehole {

    private Integer id;
    @NotNull(message = "Operator can not be null")
    private String operator;
    @PastOrPresent(message = "You cannot start research in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bhDate;
    @NotEmpty(message = "Please enter the depth of research")
    private Integer depth;
    @NotEmpty(message = "Difficulty level")
    private Integer difficulty;
    @NotEmpty(message = "Location of research is needed")
    private String location;
}
