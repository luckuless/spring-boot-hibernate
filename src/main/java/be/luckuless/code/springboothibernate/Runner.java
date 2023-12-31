package be.luckuless.code.springboothibernate;

import be.luckuless.code.springboothibernate.entity.Car;
import be.luckuless.code.springboothibernate.entity.CarWheel;
import be.luckuless.code.springboothibernate.entity.Driver;
import be.luckuless.code.springboothibernate.entity.Wheel;
import be.luckuless.code.springboothibernate.repository.CarRepository;
import be.luckuless.code.springboothibernate.repository.CarWheelRepository;
import be.luckuless.code.springboothibernate.repository.DriverRepository;
import be.luckuless.code.springboothibernate.repository.WheelRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Profile("jpa")
public class Runner implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(Runner.class);

    private CarRepository carRepository;

    private DriverRepository driverRepository;

    private WheelRepository wheelRepository;

    private CarWheelRepository carWheelRepository;

    public Runner(CarRepository carRepository, DriverRepository driverRepository, WheelRepository wheelRepository, CarWheelRepository carWheelRepository) {
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
        this.wheelRepository = wheelRepository;
        this.carWheelRepository = carWheelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        basicRepository();
        complexRepository();

        criteriaBuilder();
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

    private void complexRepository() {
        findWheelsUsedByCarRef("4x4NissanNavara1");
        findTotalWheelPriceByCarRef("4x4NissanNavara1");
        findCarsByFuelTypeAndDriverSunroofPreference("Diesel", true);
    }

    private Optional<Car> findCarsByRef(String ref) {
        return carRepository.findCarsByRef(ref);

    }



    private void findWheelsUsedByCarRef(String ref) {
        Optional<Car> car = findCarsByRef(ref);
        if(car.isPresent()) {
            List<CarWheel> wheelsByCar = carWheelRepository.findCarWheelsByCar(car.get());
            logger.info("number of different wheels used by "+ref+": " + wheelsByCar.size());
            wheelsByCar.forEach(z -> logger.info("Wheel:" +z.getWheel().getRef() + " - Price: "+ z.getWheel().getPrice() + " - Number of wheels used: " + z.getAmount()));
        }
    }

    private void findTotalWheelPriceByCarRef(String ref) {
        Optional<Car> car = findCarsByRef(ref);
        if(car.isPresent()) {
            List<CarWheel> wheelsByCar = carWheelRepository.findCarWheelsByCar(car.get());

            Integer totalPrice = wheelsByCar.stream()
                    .map(wheelByCar -> wheelByCar.getWheel().getPrice() * wheelByCar.getAmount())
                            .reduce(0, Integer::sum);

            logger.info("Total Wheel Price for car "+ref+": " + totalPrice);
        }

    }

    private void findCarsByFuelTypeAndDriverSunroofPreference(String fuelType, boolean sunroof) {
        List<Car> cars = carRepository.findMyCarsByFulTypeAndDriverSunroof(fuelType, sunroof);
        logger.info("findCarsByFuelTypeAndDriverSunroofPreference "+cars.size()+" found - fuel:" + fuelType +", sunroof: "+ sunroof);
        cars.forEach(c -> logger.info(cars.toString()));
    }

    private void criteriaBuilder() {



    }



}
