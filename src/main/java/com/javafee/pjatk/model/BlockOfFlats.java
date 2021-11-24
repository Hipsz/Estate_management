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
public class BlockOfFlats {
    private String name;
    private List<Flat> flats = new ArrayList<>();
}
