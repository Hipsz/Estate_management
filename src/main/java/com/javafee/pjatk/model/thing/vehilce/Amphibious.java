package com.javafee.pjatk.model.thing.vehilce;

import com.javafee.pjatk.utils.enums.PowerTrainType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Amphibious extends Vehicle {
    private double mass;
    private PowerTrainType powerTrainType;

    @Builder
    public Amphibious(int id, String name, double surface, double mass, PowerTrainType powerTrainType) {
        super(id, name, surface);
        this.mass = mass;
        this.powerTrainType = powerTrainType;
    }
}
