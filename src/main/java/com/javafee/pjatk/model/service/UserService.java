package com.javafee.pjatk.model.service;

import com.javafee.pjatk.model.Person;
import com.javafee.pjatk.utils.DataProvider;
import com.javafee.pjatk.utils.exceptions.NoSuchUserException;

public class UserService {
    public Person findById(int id) throws NoSuchUserException {
        return DataProvider.PEOPLE.stream().filter(e -> e.getId() == id).findFirst()
                .orElseThrow(() -> new NoSuchUserException("Brak użytkownika o wskazanym ID = " + id));
    }
}
