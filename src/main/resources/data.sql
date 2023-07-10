insert into Driver values
    ('muPass01', 'John', 'Doe', 'p.louis'),
    ('muPass02', 'Jane', 'Doe', 'moka'),
    ('bePass03', 'jean', 'claude', 'ixelles');

insert into Driver_Profile values
    (1, true, true, 'muPass01'),
    (2, false, false, 'muPass02'),
    (3, true, true, 'bePass03');

insert into Car values
    ( 'suvBmwX51', 123450, 'SUV', 'BMW', 'X5', 'Diesel/Electric', 'muPass01'),
    ( 'sedanToyotaCorolla1', 123451, 'SEDAN', 'Toyota', 'Corolla', 'Petrol', 'muPass01'),
    ( 'sedanHondaCivic1', 123452, 'Sedan', 'Honda', 'Civic', 'Petrol/Electric', 'muPass02'),
    ( 'crossVolkTiguan1', 123453, 'CROSSOVER', 'Volkswagen', 'Tiguan', 'Diesel', 'bePass03'),
    ( 'sedanHondaCivic2', 123454, 'Sedan', 'Honda', 'Civic', 'Petrol/Electric', NULL),
    ( 'crossVolkTiguan2', 123455, 'CROSSOVER', 'Volkswagen', 'Tiguan', 'Diesel', NULL),
    ( '4x4NissanNavara1', 123456, '4X4', 'Nissan', 'Navara', 'Diesel', NULL);

insert into Wheel values
    ( 'bmTubeless16', 'BM', 'tubeless', 16, 500 ),
    ( 'bmTubeless17', 'BM', 'tubeless', 17, 600 ),
    ( 'toyoThreaded18', 'Toyo', 'threaded', 18, 500 ),
    ( 'michelinRacing19', 'Michelin', 'racing', 19, 2500 ),
    ( 'contiGT17', 'Continental', 'gt', 17, 800 ),
    ( 'contiThreaded18', 'Continental', 'threaded', 18, 1200 );

insert into Car_Wheel values
    ('suvBmwX51', 'bmTubeless17', 4),
    ('sedanToyotaCorolla1', 'bmTubeless17', 2),
    ('sedanToyotaCorolla1', 'contiGT17', 2),
    ('sedanHondaCivic1', 'toyoThreaded18', 4),
    ('crossVolkTiguan1', 'michelinRacing19', 4),
    ('sedanHondaCivic2', 'michelinRacing19', 4),
    ('crossVolkTiguan2', 'toyoThreaded18', 4),
    ('4x4NissanNavara1', 'toyoThreaded18', 4),
    ('4x4NissanNavara1', 'contiThreaded18', 3);
