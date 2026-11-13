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


-- 4.- INSERTAR DATOS
-- 1 -- Inserta tu fila en socio con id_socio = 1, tu nombre, la ciudad Malaga y tu email.
INSERT INTO socio (nombre, ciudad, email) VALUES (
'Adrián Cuevas Martínez', 'Málaga', 'adricuevas.martinez@gmail.com'
);
-- 2 -- Comprueba con un SELECT * FROM socio que tu fila está.
select * from socio;

-- 3 -- Abre el fichero datos_gimnasio.sql en Workbench (File → Open SQL Script…) y ejecútalo entero (rayo). 
-- Inserta los monitores, el resto de socios, las actividades y las inscripciones. --

-- ============================================================
-- DATOS DEL GIMNASIO (importar DESPUES de insertar tu socio 1)
-- En Workbench: File > Open SQL Script... > elegir este fichero > rayo
-- ===========================================================

INSERT INTO monitor (id_monitor, nombre, telefono) VALUES
 (1, 'Laura Vidal',  '611111111'),
 (2, 'Pablo Ortega', '622222222'),
 (3, 'Marta Rey',    '633333333');
 
 select * from monitor;

INSERT INTO socio (id_socio, nombre, ciudad, email) VALUES
 (2, 'Berto Ruiz',   'Sevilla',  'berto@mail.com'),
 (3, 'Carla Gil',    'Malaga',   NULL),
 (4, 'David Sanz',   'Granada',  'david@mail.com'),
 (5, 'Elena Mora',   'Sevilla',  'elena@mail.com'),
 (6, 'Alberto Vega', 'Cordoba',  NULL);
 
 select * from socio;

INSERT INTO actividad (id_actividad, nombre, precio, plazas, id_monitor) VALUES
 (1, 'Yoga',     15.00, 12, 1),
 (2, 'Spinning', 20.00, 15, 2),
 (3, 'Pilates',  18.50, 10, 1),
 (4, 'Boxeo',    25.00,  8, 2);

select * from actividad;

INSERT INTO inscripcion (id_socio, id_actividad, fecha) VALUES
 (1, 1, '2026-09-01'),
 (1, 2, '2026-09-05'),
 (2, 2, '2026-09-02'),
 (3, 1, '2026-09-03'),
 (3, 3, '2026-09-10'),
 (4, 4, '2026-09-12'),
 (5, 2, '2026-09-15'),
 (1, 3, '2026-09-20');

select * from inscripcion;

-- 5.- Consultas sencillas
-- 5.1 -- Todos los datos de todos los socios
select * from socio;
-- 5.2 -- Nombre y email de los socios de Málaga
select nombre, ciudad, email from socio where ciudad = 'Malaga';
-- 5.3 -- Nombre y precio de las actividades de menos de 20 €, ordenadas por precio
select nombre, precio from actividad where precio < 20 order by precio;
-- 5.4 -- Nombre de los socios cuyo nombre empieza por «A»
select nombre as 'Nombres que empiezan por A' from socio where nombre LIKE 'A%';
-- 5.5 -- Nombre de los socios que no tienen email
select nombre as 'Nombres que no tienen email', email from socio where email IS NULL;
-- 5.6 -- Las ciudades de los socios, sin repetir ninguna
select distinct ciudad from socio;
-- 5.7 -- Las actividades con precio entre 15 y 20 € (BETWEEN)
select * from actividad where precio between 15 and 20;
-- 5.8 -- Las actividades que cuesten menos de 20 € y tengan 10 plazas o más
select * from actividad where precio < 20 and plazas >= 10;



-- 6.- Modificar datos
-- 1 -- Carla Gil (socio 3) se ha mudado a Córdoba
UPDATE socio set ciudad = 'Córdoba' where id_socio = 3;
select * from socio;
-- 2 -- Sube un 10 % el precio de Yoga (actividad 1).
UPDATE actividad set precio = precio * 1.10 where nombre = 'Yoga';
-- 3 -- Quita una plaza a Boxeo (actividad 4).
UPDATE actividad set plazas = plazas - 1 where nombre = 'Boxeo';

-- 7.- Consultas con JOIN
-- 7.1 -- Nombre del socio, nombre de la actividad y fecha de todas las inscripciones
select s.nombre as 'Nombre del socio', a.nombre as 'Actividad', i.fecha as 'Fecha de la inscripción' from
socio s join inscripcion i on (s.id_socio = i.id_socio) join actividad a on (a.id_actividad = i.id_actividad);
-- 7.2 --  Las actividades a las que estás apuntado tú (socio 1)
select s.nombre as 'Nombre', a.nombre as 'Actividades' from socio s join inscripcion i on (s.id_socio = i.id_socio)
join actividad a on (a.id_actividad = i.id_actividad) where s.id_socio = 1;
-- 7.3 -- Cuántos inscritos tiene cada actividad
select a.nombre as 'Actividad', count(*) as 'Conteo' from actividad a join inscripcion i on (a.id_actividad = i.id_actividad) group by a.nombre;
-- 7.4 -- Los socios que no están apuntados a ninguna actividad
select s.nombre as 'Nombre de los socios', a.nombre as 'Actividad' from socio s left join inscripcion i on (s.id_socio = i.id_socio) 
left join actividad a on (a.id_actividad = i.id_actividad) where a.nombre IS NULL;
-- 7.5 -- El nombre de cada actividad con el nombre de su monitor
select a.nombre as 'Actividad', m.nombre as 'Nombre del monitor' from actividad a join monitor m on (a.id_monitor = m.id_monitor);
-- 7.6 -- Cuántas actividades imparte cada monitor, incluidos los que no imparten ninguna
select m.nombre as 'Nombre del monitor', count(*) as 'Número de actividades' from monitor m left join actividad a on (m.id_monitor = a.id_monitor) group by m.nombre;

-- 8.- Borrar datos
-- 1 -- Borra la inscripción número 8.
DELETE FROM inscripcion where id_inscripcion = 8;
-- 2 -- Intenta borrar al socio 1 (tú). Debe dar error 1451. Explica con tus palabras por qué.
DELETE FROM socio where id_socio = 1;
-- NO SE PUEDE BORRAR PORQUE ESTE ID TIENE FOREIGN KEY CON OTRAS TABLAS QUE DEPENDEN DE ELLA
-- 3 -- Borra al socio 6 (Alberto Vega). Debe funcionar. ¿Por qué este sí?
DELETE FROM socio where id_socio = 6;
-- Este sí funciona porque no tiene ninguna foreign key que dependa de ella, de hecho se calificaba como "null"
-- 4 -- Intenta borrar al monitor 1 (Laura Vidal): error 1451. Borra al monitor 3 (Marta Rey): funciona. Explica la diferencia.
DELETE FROM monitor where id_monitor = 1;
DELETE FROM monitor where id_monitor = 3;
-- Sí permite borrar el numero 3 y no el numero 1, porque una vez más, el id_monitor 3 no tenía ninguan foreign key que dependiese de ella
Truncate table inscripcion;



