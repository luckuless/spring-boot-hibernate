package be.luckuless.code.springboothibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CarWheelKey implements Serializable {

    @Column(name = "ref")
    private String carRef;

    @Column(name = "ref")
    private String wheelRef;
}
