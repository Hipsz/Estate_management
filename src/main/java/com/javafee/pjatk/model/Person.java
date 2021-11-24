package com.javafee.pjatk.model;

import com.javafee.pjatk.utils.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class Person {
    private Role role;
    private int id;
    private String name, surname, pesel, address;
    private LocalDate dateOfBirth;
    private boolean isCheckedIn;
    private List<File> files;
}
