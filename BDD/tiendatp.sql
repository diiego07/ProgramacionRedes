DROP DATABASE IF EXISTS tiendatrabajo;
CREATE DATABASE tiendatrabajo;
USE tiendatrabajo;

DROP TABLE IF EXISTS stock;
CREATE TABLE stock(
	id int primary KEY auto_increment,
	nombre varchar(100),
	descripcion varchar(255),
	precio_compra float,
	precio_venta float,
	cant int,
	discontinuado boolean
);

INSERT INTO stock(nombre, descripcion, precio_compra, precio_venta, cant, discontinuado) VALUES('Alfombra', 'Verde', 20.00, 30.00, 10, false);