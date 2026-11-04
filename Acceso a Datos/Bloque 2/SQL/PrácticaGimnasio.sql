DROP DATABASE IF EXISTS gimnasio;
Create database gimnasio;
use gimnasio;

create table monitor (
	id_monitor int auto_increment primary key,
    nombre varchar(50) not null,
    telefono varchar(9)
    

);

create table socio (
	id_socio int auto_increment primary key,
    nombre varchar(50) not null,
    ciudad varchar(40),
    email varchar(80)


);

create table actividad (
	id_actividad int auto_increment primary key,
    nombre varchar(40) not null,
    precio decimal(6, 2),
    plazas int,
    id_monitor int not null,
    
    foreign key (id_monitor) references monitor (id_monitor)
);


create table inscripcion (
	id_inscripcion int auto_increment primary key,
    id_socio int not null,
    id_actividad int not null,
    fecha date not null,
    
    foreign key (id_socio) references socio (id_socio),
	foreign key (id_actividad) references actividad (id_actividad)
);

-- 3.- MODIFICAR LA ESTRUCTURA (ALTER TABLE)
-- 1 -- Añade una columna telefono de tipo varchar (9)
alter table socio add column telefono varchar(9);
-- 2 -- Cambia el tipo de telefono a varchar(15)
alter table socio modify column telefono varchar(15);
-- 3 -- Elimina la columna telefono
alter table socio drop telefono;




