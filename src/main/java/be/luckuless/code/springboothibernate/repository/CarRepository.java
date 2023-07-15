package be.luckuless.code.springboothibernate.repository;

import be.luckuless.code.springboothibernate.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
