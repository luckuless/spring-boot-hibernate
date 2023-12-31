CREATE TABLE IF NOT EXISTS Driver (
    passport_no VARCHAR(50) UNIQUE,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    primary key (passport_no)
);

CREATE TABLE IF NOT EXISTS Driver_Profile (
    id INT AUTO_INCREMENT NOT NULL,
    passport_no VARCHAR(50) UNIQUE NOT NULL,
    sunroof BOOLEAN NOT NULL,
    gearbox_manual BOOLEAN NOT NULL,
    foreign key (passport_no) references Driver (passport_no),
    primary key (id)
);


CREATE TABLE IF NOT EXISTS Car (
    ref VARCHAR(50),
    vin INT UNIQUE NOT NULL,
    type VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    trim VARCHAR(100) NOT NULL,
    fuel_type VARCHAR(25) NOT NULL,
    driver VARCHAR(50),
    foreign key (driver) references Driver (passport_no),
    primary key (ref)
);

CREATE TABLE If NOT EXISTS Wheel (
    ref VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    size DOUBLE NOT NULL,
    price INT NOT NULL,
    primary key (ref)
);

CREATE TABLE IF NOT EXISTS Car_Wheel (
    car_ref VARCHAR(50) NOT NULL,
    wheel_ref VARCHAR(50) NOT NULL,
    amount INT NOT NULL,
    foreign key (car_ref) references Car(ref),
    foreign key (wheel_ref) references Wheel(ref)
);

