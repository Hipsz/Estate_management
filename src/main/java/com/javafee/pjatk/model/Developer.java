package com.javafee.pjatk.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class Developer {
    private List<Estate> estates = new ArrayList<>();
}
