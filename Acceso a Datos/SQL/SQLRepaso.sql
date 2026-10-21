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