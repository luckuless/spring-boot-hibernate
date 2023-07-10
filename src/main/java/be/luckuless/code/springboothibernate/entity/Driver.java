package be.luckuless.code.springboothibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
}
