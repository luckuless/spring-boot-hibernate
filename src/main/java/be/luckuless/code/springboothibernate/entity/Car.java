package be.luckuless.code.springboothibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Car {

    @Id
    private String ref;
    private int vin;
    private String type;
    private String model;
    private String trim;
    private String fuelType;

    @ManyToOne
    @JoinColumn(name = "driver", referencedColumnName = "passportNo", nullable = true)
    private Driver driver;

    @OneToMany(mappedBy = "car")
    Set<CarWheel> wheels;

}
