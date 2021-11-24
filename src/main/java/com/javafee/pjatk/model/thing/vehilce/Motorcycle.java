package com.javafee.pjatk.model.thing.vehilce;

import com.javafee.pjatk.utils.enums.PowerTrainType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Motorcycle extends Vehicle {
    private int maxSpeed;
    private PowerTrainType powerTrainType;

    @Builder
    public Motorcycle(int id, String name, double surface, int maxSpeed, PowerTrainType powerTrainType) {
        super(id, name, surface);
        this.maxSpeed = maxSpeed;
        this.powerTrainType = powerTrainType;
    }
}
