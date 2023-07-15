package be.luckuless.code.springboothibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    private String passportNo;
    private String fname;
    private String lname;
    private String address;

    @OneToOne(mappedBy = "driver")
    private DriverProfile driverProfile;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "driver", cascade = CascadeType.ALL)
    private Set<Car> cars;

    @Override
    public String toString() {
        return "Driver{" +
                "passportNo='" + passportNo + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", address='" + address + '\'' +
                ", driverProfile=" + driverProfile +
                ", cars" + carsToString(cars) +
                '}';
    }

    private String carsToString(Set<Car> cars) {

        List<String> carsList = cars.stream().map(car -> car.toStringExcludeDriver()).collect(Collectors.toList());

        return carsList.toString();
    }

}
