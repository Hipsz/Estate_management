package com.javafee.pjatk.model;

import com.javafee.pjatk.model.thing.Thing;
import com.javafee.pjatk.utils.IdGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@ToString
public class Parking {
    private int id;
    private double capacity;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private List<Thing> things = new ArrayList<>();
}
