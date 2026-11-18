Create database tienda_cuevas character set utf8mb4;

use tienda_cuevas;



SELECT USER(), @@hostname, NOW();
SELECT * FROM categoria;
SELECT * FROM cliente;
select * from compra;
SELECT p.nombre, p.precio, c.nombre AS categoria
FROM producto p JOIN categoria c ON p.id_categoria = c.id;

DELETE FROM categoria WHERE id = 1; 