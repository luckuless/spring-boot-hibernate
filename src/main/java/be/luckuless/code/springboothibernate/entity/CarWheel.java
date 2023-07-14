package be.luckuless.code.springboothibernate.entity;

import javax.persistence.*;

@Entity
public class CarWheel {

    @EmbeddedId
    private CarWheelKey id;

    @ManyToOne
    @MapsId("carRef")
    @JoinColumn(name = "car_ref")
    private Car car;

    @ManyToOne
    @MapsId("wheelRef")
    @JoinColumn(name = "wheel_ref")
    private Wheel wheel;

    private int amount;

}
