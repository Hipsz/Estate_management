package com.javafee.pjatk.model.thing.vehilce;

import com.javafee.pjatk.utils.enums.PowerTrainType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Boat extends Vehicle {
    private double dipping;
    private PowerTrainType powerTrainType;

    @Builder
    public Boat(int id, String name, double surface, double dipping, PowerTrainType powerTrainType) {
        super(id, name, surface);
        this.dipping = dipping;
        this.powerTrainType = powerTrainType;
    }
}
