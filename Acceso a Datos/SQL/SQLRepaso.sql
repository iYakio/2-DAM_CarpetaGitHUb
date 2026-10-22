drop database if exists informatica;

create database informatica;

use informatica;

create table Cliente ( 
	id_cliente int auto_increment primary key,
    nombre varchar(30) not null,
    direccion varchar(30) not null,
    ciudad varchar(30) not null,
    email varchar(100),
    telefono varchar(9),
    dni varchar(9)


);

create table Producto ( 
	id_producto int auto_increment primary key,
	nombre varchar(30) not null,
    categoria varchar(30),
    marca varchar(30) not null,
    precio decimal (8,2) not null,
    stock int default 0
);

create table Proveedor ( 
	id_proveedor int auto_increment primary key,
    nombre varchar(60) not null,
    ciudad varchar(60) not null,
    telefono varchar(9)

);

create table Compra ( 
	id_compra int auto_increment primary key,
    id_proveedor int not null,
    id_producto int not null,
    fecha date not null,
    cantidad int not null,
    coste decimal(8,2) not null,


	foreign key (id_proveedor) references Proveedor(id_proveedor),
    foreign key (id_producto) references Producto(id_producto)



);

create table Venta (
	id_venta int auto_increment primary key,
    id_cliente int not null,
    id_producto int not null,
    fecha date not null,
    cantidad int not null,
    
    foreign key (id_cliente) references Cliente(id_cliente),
    foreign key (id_producto) references Producto(id_producto)


);

/* Comprobación que se ha creado*/
show tables;
describe cliente;


/*Modificar la estructura ALTER TABLE*/
alter table Cliente add column telefono varchar(9);
alter table Cliente rename column telefono to movil;
alter table Cliente modify column movil varchar(15);

alter table Cliente drop movil;

/*Insertar datos*/
insert into Cliente(nombre, direccion, ciudad, email)
values ('Juan Lopez', 'C/Andalucia', 'Málaga', 'juan.lopez@davante.org');

select * from Cliente;

insert into Proveedor(nombre, ciudad, telefono)
values ('HP', 'Madrid', '915000001'),
('Lenovo', 'Barcelona', '934000002'),
('Logitech', 'Valencia', '963000003'),
('TechMayorista', 'Málaga', '95200004');

insert into Producto (nombre, categoria, marca, precio, stock) values
('Portatil HP 15', 'Portátiles', 'HP', 549.00, '15'),
('Portátil Lenovo IdeaPad', 'Portátiles', 'Lenovo', 479.00, 20);

insert into Venta(id_cliente, id_producto, fecha, cantidad) values
(1,1,'2026-09-01',1),
(1,2,'2026-09-01',1);

INSERT INTO Cliente (nombre, direccion, ciudad, email) VALUES
 ('Pepe Tejada',      'Avda. de Sevilla 12',  'Sevilla',   'pepe.tejada@davante.org'),
 ('Victor Fernandez', 'C/Mayor 5',            'Jaen',      NULL),
 ('Jose Assensio',    'C/Huesca 8',           'Huesca',    'jose.assensio@davante.org'),
 ('Leo Perez',        'Plaza Mayor 1',        'Orense',    NULL),
 ('Patricia Aranda',  'Paseo de Gracia 20',   'Barcelona', 'patricia.aranda@davante.org'),
 ('David Lopez',      'Gran Via 45',          'Madrid',    'david.lopez@davante.org'),
 ('Enrique Ferreras', 'C/Larios 3',           'Malaga',    'enrique.ferreras@davante.org'),
 ('Luis Guzman',    'C/Colon 18',           'Valencia',  NULL);
 

select * from Cliente;

INSERT INTO Producto (nombre, categoria, marca, precio, stock) VALUES
 ('Monitor Samsung 24',    'Monitores',      'Samsung',  139.90,  30),
 ('Raton Logitech M185',   'Perifericos',    'Logitech',  14.90, 100),
 ('Teclado Logitech K120', 'Perifericos',    'Logitech',  12.50,  80),
 ('Impresora HP DeskJet',  'Impresoras',     'HP',        69.00,  25),
 ('Disco SSD 1TB',         'Almacenamiento', 'Kingston',  74.90,  45),
 ('Pendrive 64GB',         'Almacenamiento', 'Kingston',   8.90, 150);

select * from Producto;
INSERT INTO Venta (id_cliente, id_producto, fecha, cantidad) VALUES
 (2, 3, '2026-09-01', 2),
 (2, 5, '2026-09-01', 1),
 (1, 7, '2026-09-15', 1),
 (1, 6, '2026-09-15', 1),
 (5, 2, '2026-09-20', 1),
 (5, 4, '2026-09-20', 1),
 (5, 5, '2026-09-20', 1),
 (7, 6, '2026-10-01', 2),
 (7, 8, '2026-10-01', 3),
 (2, 4, '2026-10-05', 2),
 (2, 7, '2026-10-05', 1);

SELECT COUNT(*) AS ventas FROM venta;

INSERT INTO Compra (id_proveedor, id_producto, fecha, cantidad, coste) VALUES
 (1, 1, '2026-08-25',  20, 430.00),
 (1, 6, '2026-08-25',  30,  48.00),
 (2, 2, '2026-08-26',  25, 380.00),
 (3, 4, '2026-08-27', 120,   9.50),
 (3, 5, '2026-08-27', 100,   7.80),
 (4, 3, '2026-08-28',  40, 105.00),
 (4, 4, '2026-08-28',  50,  10.20),
 (4, 7, '2026-08-29',  60,  58.00),
 (4, 8, '2026-08-29', 200,   5.20);


SELECT COUNT(*) AS compras FROM compra;

-- PASO 6

INSERT INTO cliente (nombre, direccion, ciudad, email)
VALUES ('Ana Ruiz', 'C/Sol 7', 'Malaga', 'ana.ruiz@davante.org');

INSERT INTO cliente (nombre, direccion, ciudad, email)
VALUES ('Luis Soto', 'C/Luna 9', 'Granada', 'luis.soto@davante.org');

SELECT id_cliente, nombre, ciudad FROM cliente WHERE id_cliente > 8;

-- PASO 7 
UPDATE cliente SET ciudad = 'Cordoba' WHERE id_cliente = 3;

SELECT id_cliente, nombre, ciudad FROM cliente WHERE id_cliente = 3;

UPDATE producto SET stock = stock + 5, precio = 529.00 WHERE id_producto = 1;

UPDATE producto SET precio = precio * 1.10 WHERE id_producto = 4;

SELECT id_producto, nombre, precio, stock FROM producto WHERE id_producto IN (1, 4);