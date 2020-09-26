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
    @NotNull(message = "Evaluator can not be null")
    private String evaluator;
    @PastOrPresent(message = "You cannot start research in the future")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate bhDate;
    @NotEmpty(message = "Location of research is needed")
    private String location;
    private String depth;
    @NotEmpty(message = "If u want payment, give me difficulty status")
    private int difficulty;

}
