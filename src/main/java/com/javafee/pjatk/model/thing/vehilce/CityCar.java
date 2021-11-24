package com.javafee.pjatk.model.thing.vehilce;

import com.javafee.pjatk.utils.enums.PowerTrainType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CityCar extends Vehicle {
    private int doorAmount;
    private PowerTrainType powerTrainType;

    @Builder
    public CityCar(int id, String name, double surface, int doorAmount, PowerTrainType powerTrainType) {
        super(id, name, surface);
        this.doorAmount = doorAmount;
        this.powerTrainType = powerTrainType;
    }
}
