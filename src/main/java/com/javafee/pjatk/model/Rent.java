package com.javafee.pjatk.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class Rent {
    private int id;
    private Person tenant;
    private List<Flat> flats;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
}
