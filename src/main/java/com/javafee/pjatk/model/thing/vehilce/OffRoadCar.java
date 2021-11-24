package com.javafee.pjatk.model.thing.vehilce;

import com.javafee.pjatk.utils.enums.PowerTrainType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OffRoadCar extends Vehicle {
    private int torque;
    private PowerTrainType powerTrainType;

    @Builder
    public OffRoadCar(int id, String name, double surface, int torque, PowerTrainType powerTrainType) {
        super(id, name, surface);
        this.torque = torque;
        this.powerTrainType = powerTrainType;
    }
}
