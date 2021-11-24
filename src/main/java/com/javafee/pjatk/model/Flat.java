package com.javafee.pjatk.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class Flat {
    private int id;
    private List<Person> people;
    private Parking parking;
    private Person tenant;
    private double capacity;
}
