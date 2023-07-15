package be.luckuless.code.springboothibernate;

import be.luckuless.code.springboothibernate.entity.Car;
import be.luckuless.code.springboothibernate.entity.Driver;
import be.luckuless.code.springboothibernate.entity.Wheel;
import be.luckuless.code.springboothibernate.repository.CarRepository;
import be.luckuless.code.springboothibernate.repository.DriverRepository;
import be.luckuless.code.springboothibernate.repository.WheelRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(Runner.class);

    private CarRepository carRepository;

    private DriverRepository driverRepository;

    private WheelRepository wheelRepository;

    public Runner(CarRepository carRepository, DriverRepository driverRepository, WheelRepository wheelRepository) {
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
        this.wheelRepository = wheelRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        basicRepository();
    }

    private void basicRepository() {

        logger.info("Cars List");
        List<Car> cars = carRepository.findAll();
        cars.forEach(car -> logger.info(car.toString()));
        logger.info("Number of Cars: "+String.valueOf(cars.size()));

        logger.info("Drivers List");
        List<Driver> drivers = driverRepository.findAll();
        drivers.forEach(driver -> logger.info(driver.toString()));
        logger.info("Number of Drivers: "+String.valueOf(drivers.size()));


        logger.info("Wheels List");
        List<Wheel> wheels = wheelRepository.findAll();
        wheels.forEach(wheel -> logger.info(wheel.toString()));
        logger.info("Number of different Wheels: "+String.valueOf(wheels.size()));

    }
}
