package be.luckuless.code.springboothibernate.repository;

import be.luckuless.code.springboothibernate.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, String> {
    
}
