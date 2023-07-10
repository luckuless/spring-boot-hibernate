package be.luckuless.code.springboothibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class DriverProfile {
    @Id
    @GeneratedValue
    private Long id;

    private boolean sunroof;
    private boolean gearboxManual;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_passport_number", referencedColumnName = "passportNo")
    private Driver driver;
}
