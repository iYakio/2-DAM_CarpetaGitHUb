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

-- Paso 6

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

UPDATE cliente SET ciudad = 'Cordoba' WHERE ciudad = 'Jaen';

UPDATE cliente SET ciudad = 'Jaen' WHERE id_cliente = 3;

SELECT id_cliente, nombre, ciudad FROM cliente WHERE id_cliente = 3;

-- Paso 9
REPLACE INTO producto (id_producto, nombre, categoria, marca, precio, stock)
VALUES (9, 'Alfombrilla raton', 'Perifericos', 'Logitech', 4.90, 60);

SELECT * FROM producto WHERE id_producto = 9;

REPLACE INTO producto (id_producto, nombre, categoria, marca, precio)
VALUES (9, 'Alfombrilla raton XL', 'Perifericos', 'Logitech', 9.90);

SELECT * FROM producto WHERE id_producto = 9;

DELETE FROM cliente WHERE id_cliente IN (10, 11);

DELETE FROM cliente WHERE id_cliente = 1;

DELETE FROM producto WHERE id_producto = 9;

SELECT COUNT(*) AS productos FROM producto;

-- Paso 10 
SELECT * FROM cliente;
SELECT nombre, ciudad FROM cliente;
SELECT nombre AS Producto, precio AS Precio FROM producto;

SELECT marca FROM producto;
SELECT DISTINCT marca FROM producto;
SELECT DISTINCT categoria FROM producto;

-- Paso 11

SELECT nombre, precio FROM producto WHERE precio > 100;
SELECT nombre, precio FROM producto WHERE precio >= 74.90;
SELECT nombre, precio FROM producto WHERE precio < 15;
SELECT nombre, marca FROM producto WHERE marca = 'HP';
SELECT nombre, marca FROM producto WHERE marca <> 'HP';


SELECT id_cliente, nombre, email FROM cliente WHERE email IS NULL;
SELECT id_cliente, nombre, email FROM cliente WHERE email = NULL;
SELECT id_cliente, nombre, email FROM cliente WHERE email IS NOT NULL;

-- Paso 12

SELECT nombre FROM cliente WHERE nombre LIKE 'P%';       -- empieza por P
SELECT nombre FROM cliente WHERE nombre LIKE '%Lopez';   -- termina en Lopez
SELECT nombre FROM cliente WHERE nombre LIKE '%er%';     -- contiene "er"
SELECT nombre FROM cliente WHERE nombre LIKE '_e%';      -- segunda letra: e
SELECT nombre, email FROM cliente WHERE email LIKE '%@davante.org';

SELECT nombre, precio FROM producto WHERE nombre LIKE 'Portatil%';
SELECT nombre, marca FROM producto WHERE nombre LIKE '%Logitech%';
SELECT nombre, precio FROM producto WHERE precio BETWEEN 10 AND 100;
SELECT nombre, marca FROM producto WHERE marca IN ('HP', 'Kingston');
SELECT nombre, categoria FROM producto WHERE categoria IN ('Monitores', 'Impresoras');

-- Paso 13

SELECT nombre, precio FROM producto WHERE precio > 20 AND precio < 150;
SELECT nombre, marca FROM producto WHERE marca = 'HP' OR marca = 'Lenovo';
SELECT nombre, categoria FROM producto WHERE NOT categoria = 'Portatiles';

-- Sin paréntesis: AND se evalúa antes que OR
SELECT nombre, marca, precio FROM producto
WHERE marca = 'HP' OR marca = 'Logitech' AND precio < 20;

-- Con paréntesis: primero el OR
SELECT nombre, marca, precio FROM producto
WHERE (marca = 'HP' OR marca = 'Logitech') AND precio < 20;

-- Paso 14
SELECT nombre, precio FROM producto ORDER BY precio;
SELECT nombre, precio FROM producto ORDER BY precio DESC;

-- Paso 5
SELECT *
FROM producto
WHERE precio > 100
ORDER BY nombre ASC;

SELECT nombre, marca, precio
FROM producto
WHERE precio BETWEEN 10 AND 150
ORDER BY nombre DESC;

-- Paso 16
SELECT v.id_venta, v.fecha, c.nombre AS cliente, p.nombre AS producto,
       v.cantidad, v.cantidad * p.precio AS importe
FROM venta v
JOIN cliente c  ON v.id_cliente  = c.id_cliente
JOIN producto p ON v.id_producto = p.id_producto
ORDER BY v.id_venta;

SELECT v.fecha, p.nombre AS producto, v.cantidad
FROM venta v
JOIN producto p ON v.id_producto = p.id_producto
WHERE v.id_cliente = 1
ORDER BY v.fecha;

SELECT c.nombre, SUM(v.cantidad * p.precio) AS total_gastado
FROM venta v
JOIN cliente c  ON v.id_cliente  = c.id_cliente
JOIN producto p ON v.id_producto = p.id_producto
GROUP BY c.id_cliente, c.nombre
ORDER BY total_gastado DESC;

SELECT p.nombre AS producto, pr.nombre AS proveedor
FROM compra c
JOIN producto p   ON c.id_producto  = p.id_producto
JOIN proveedor pr ON c.id_proveedor = pr.id_proveedor
ORDER BY p.nombre, pr.nombre;

-- Paso 17
SELECT id_producto, nombre, stock FROM producto WHERE id_producto IN (1, 4);
SELECT COUNT(*) AS ventas FROM venta;

START TRANSACTION;

INSERT INTO venta (id_cliente, id_producto, fecha, cantidad) VALUES (3, 1, '2026-10-10', 1);
INSERT INTO venta (id_cliente, id_producto, fecha, cantidad) VALUES (3, 4, '2026-10-10', 2);
UPDATE producto SET stock = stock - 1 WHERE id_producto = 1;
UPDATE producto SET stock = stock - 2 WHERE id_producto = 4;

-- Dentro de la transacción vemos los cambios:
SELECT id_producto, nombre, stock FROM producto WHERE id_producto IN (1, 4);
SELECT COUNT(*) AS ventas FROM venta;

ROLLBACK;

-- Tras el ROLLBACK todo ha vuelto atrás:
SELECT id_producto, nombre, stock FROM producto WHERE id_producto IN (1, 4);
SELECT COUNT(*) AS ventas FROM venta;

START TRANSACTION;

INSERT INTO venta (id_cliente, id_producto, fecha, cantidad) VALUES (3, 1, '2026-10-10', 1);
INSERT INTO venta (id_cliente, id_producto, fecha, cantidad) VALUES (3, 4, '2026-10-10', 2);
UPDATE producto SET stock = stock - 1 WHERE id_producto = 1;
UPDATE producto SET stock = stock - 2 WHERE id_producto = 4;

COMMIT;

SELECT id_producto, nombre, stock FROM producto WHERE id_producto IN (1, 4);
SELECT id_venta, id_cliente, id_producto, fecha, cantidad FROM venta ORDER BY id_venta DESC LIMIT 2;

START TRANSACTION;

UPDATE producto SET precio = 519.00 WHERE id_producto = 1;   -- Portatil HP
SAVEPOINT despues_del_portatil;
UPDATE producto SET precio = 149.90 WHERE id_producto = 4;   -- Raton (error de tecleo)

SELECT id_producto, nombre, precio FROM producto WHERE id_producto IN (1, 4);

ROLLBACK TO despues_del_portatil;                            -- deshace solo lo posterior al savepoint

SELECT id_producto, nombre, precio FROM producto WHERE id_producto IN (1, 4);

COMMIT;       												 -- guardamos lo que queda (el precio del portatil)

-- Paso 18                   

CREATE TABLE producto_caro LIKE producto;
INSERT INTO producto_caro SELECT * FROM producto WHERE precio > 100;
SELECT * FROM producto_caro;

RENAME TABLE producto_caro TO productos_destacados;
SHOW TABLES;

DELETE FROM productos_destacados WHERE id_producto > 0;
INSERT INTO productos_destacados (nombre, marca, precio) VALUES ('Prueba 1', 'HP', 5.00);
SELECT id_producto, nombre FROM productos_destacados;

TRUNCATE TABLE productos_destacados;
INSERT INTO productos_destacados (nombre, marca, precio) VALUES ('Prueba 2', 'HP', 5.00);
SELECT id_producto, nombre FROM productos_destacados;

DROP TABLE productos_destacados;
DROP TABLE productos_destacados;
DROP TABLE IF EXISTS productos_destacados;
SHOW TABLES;

-- 1.- Muestra el nombre y el stock de los productos con menos de 30 unidades, ordenados de menos a más stock.
SELECT nombre, stock FROM producto WHERE stock < 30 ORDER BY stock;
-- 2 Muestra los clientes cuya ciudad empiece por M
SELECT * FROM cliente WHERE ciudad LIKE 'M%';
-- 3 Muestra los clientes sin email, ordenados por nombre
SELECT * FROM cliente WHERE email IS NULL ORDER BY nombre;
-- 4 Muestra los productos de la marca Logitech que cuesten menos de 14 euros
SELECT nombre, marca, precio FROM producto WHERE marca = 'Logitech' AND precio < 14;
-- 5 Sube un 10 % el precio del teclado y del pendrive (ids 5 y 8) y comprueba el resultado.
UPDATE producto SET precio = precio * 1.10 WHERE id_producto IN (5, 8);
SELECT id_producto, nombre, precio FROM producto WHERE id_producto IN (5, 8);
-- 6 Inserta un nuevo proveedor ('Kingston', 'Sevilla', '954000005') y una compra de 100 pendrives (id 8) a ese proveedor, a 5.00 de coste, con fecha '2026-10-12'. (Pista: LAST_INSERT_ID() devuelve el último id generado con AUTO_INCREMENT; así reutilizas el id del proveedor recién creado.)
INSERT INTO proveedor (nombre, ciudad, telefono) VALUES ('Kingston', 'Sevilla', '954000005');
INSERT INTO compra (id_proveedor, id_producto, fecha, cantidad, coste)
VALUES (LAST_INSERT_ID(), 8, '2026-10-12', 100, 5.00);
SELECT * FROM compra WHERE fecha = '2026-10-12';
-- 7 Muestra, para cada proveedor, el dinero total gastado en compras (cantidad * coste), de mayor a menor.
SELECT pr.nombre AS proveedor, SUM(c.cantidad * c.coste) AS total_gastado
FROM compra c
JOIN proveedor pr ON c.id_proveedor = pr.id_proveedor
GROUP BY pr.nombre
ORDER BY total_gastado DESC;