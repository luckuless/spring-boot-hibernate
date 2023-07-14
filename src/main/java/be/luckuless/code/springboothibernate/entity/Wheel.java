package be.luckuless.code.springboothibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Wheel {

    @Id
    private String ref;
    private String model;
    private String type;
    private Double size;
    private int price;

    @OneToMany(mappedBy = "wheel")
    Set<CarWheel> cars;
}
