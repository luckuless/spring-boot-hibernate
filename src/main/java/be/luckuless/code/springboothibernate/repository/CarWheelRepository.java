package be.luckuless.code.springboothibernate.repository;

import be.luckuless.code.springboothibernate.entity.CarWheel;
import be.luckuless.code.springboothibernate.entity.CarWheelKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarWheelRepository extends JpaRepository<CarWheel, CarWheelKey> {
}