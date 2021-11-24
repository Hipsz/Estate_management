package com.javafee.pjatk.model.thing.item;

import com.javafee.pjatk.model.thing.Thing;

import lombok.Builder;

public class Item extends Thing {
    @Builder
    public Item(int id, String name, double surface) {
        super(id, name, surface);
    }
}
