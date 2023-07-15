package be.luckuless.code.springboothibernate.repository;

import be.luckuless.code.springboothibernate.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, String> {
    Optional<Car> findCarsByRef(String ref);
}
