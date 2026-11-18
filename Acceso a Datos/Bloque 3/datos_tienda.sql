Create database tienda_cuevas character set utf8mb4;

use tienda_cuevas;

desc categoria;
desc producto;
desc cliente;
desc compra;

SELECT USER(), @@hostname, NOW();
SELECT * FROM categoria;
SELECT * FROM cliente;
select * from compra;
select * from producto;
SELECT p.nombre, p.precio, c.nombre AS categoria
FROM producto p JOIN categoria c ON p.id_categoria = c.id;

DELETE FROM categoria WHERE id = 1; 

INSERT INTO categoria (nombre) VALUES
  ('Electrónica'),
  ('Hogar'),
  ('Deportes');

INSERT INTO producto (nombre, precio, stock, id_categoria) VALUES
  ('Auriculares Bluetooth',       39.90, 25, (SELECT id FROM categoria WHERE nombre = 'Electrónica' LIMIT 1)),
  ('Cargador USB-C 65W',          24.50, 40, (SELECT id FROM categoria WHERE nombre = 'Electrónica' LIMIT 1)),
  ('Teclado Cuevas',              49.99, 15, (SELECT id FROM categoria WHERE nombre = 'Electrónica' LIMIT 1)),
  ('Lámpara de escritorio LED',   18.75, 30, (SELECT id FROM categoria WHERE nombre = 'Hogar' LIMIT 1)),
  ('Juego de sábanas',            29.95, 20, (SELECT id FROM categoria WHERE nombre = 'Hogar' LIMIT 1)),
  ('Cafetera de goteo',           34.00, 12, (SELECT id FROM categoria WHERE nombre = 'Hogar' LIMIT 1)),
  ('Balón de baloncesto',         21.90, 35, (SELECT id FROM categoria WHERE nombre = 'Deportes' LIMIT 1)),
  ('Esterilla de yoga',           15.60, 50, (SELECT id FROM categoria WHERE nombre = 'Deportes' LIMIT 1));
  
  INSERT INTO cliente (nombre) VALUES
  ('Lucía Fernández'),
  ('Marcos Ortega'),
  ('Elena Ruiz');
  
  INSERT INTO compra (id_cliente, id_producto) VALUES
  ((SELECT id FROM cliente WHERE nombre = 'Lucía Fernández' LIMIT 1), (SELECT id FROM producto WHERE nombre = 'Auriculares Bluetooth' LIMIT 1)),
  ((SELECT id FROM cliente WHERE nombre = 'Lucía Fernández' LIMIT 1), (SELECT id FROM producto WHERE nombre = 'Esterilla de yoga' LIMIT 1)),
  ((SELECT id FROM cliente WHERE nombre = 'Lucía Fernández' LIMIT 1), (SELECT id FROM producto WHERE nombre = 'Lámpara de escritorio LED' LIMIT 1)),
  
  ((SELECT id FROM cliente WHERE nombre = 'Marcos Ortega' LIMIT 1),   (SELECT id FROM producto WHERE nombre = 'Teclado Cuevas' LIMIT 1)),
  ((SELECT id FROM cliente WHERE nombre = 'Marcos Ortega' LIMIT 1),   (SELECT id FROM producto WHERE nombre = 'Cargador USB-C 65W' LIMIT 1)),
  ((SELECT id FROM cliente WHERE nombre = 'Marcos Ortega' LIMIT 1),   (SELECT id FROM producto WHERE nombre = 'Balón de baloncesto' LIMIT 1)),
  -- Elena Ruiz
  ((SELECT id FROM cliente WHERE nombre = 'Elena Ruiz' LIMIT 1),      (SELECT id FROM producto WHERE nombre = 'Juego de sábanas' LIMIT 1)),
  ((SELECT id FROM cliente WHERE nombre = 'Elena Ruiz' LIMIT 1),      (SELECT id FROM producto WHERE nombre = 'Cafetera de goteo' LIMIT 1)),
  ((SELECT id FROM cliente WHERE nombre = 'Elena Ruiz' LIMIT 1),      (SELECT id FROM producto WHERE nombre = 'Esterilla de yoga' LIMIT 1));
  