package be.luckuless.code.springboothibernate.repository;

import be.luckuless.code.springboothibernate.entity.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WheelRepository extends JpaRepository<Wheel, String> {
}
