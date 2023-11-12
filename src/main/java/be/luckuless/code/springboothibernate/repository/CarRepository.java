package be.luckuless.code.springboothibernate.repository;

import be.luckuless.code.springboothibernate.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, String> {
    Optional<Car> findCarsByRef(String ref);

    @Query("select c from Car c where c.ref=:ref ")
    Optional<Car> findMyCarByRef(@Param("ref") String ref);

    @Query("select c from Car c inner join Driver d on c.driver=d.passportNo inner join DriverProfile dp on d.passportNo=dp.driver where c.fuelType=:fuel and dp.sunroof=:sunroof")
    List<Car> findMyCarsByFulTypeAndDriverSunroof(@Param("fuel") String fuelName, @Param("sunroof") Boolean sunroof);

}
