CREATE SCHEMA filtro;

USE filtro;

CREATE TABLE IF NOT EXISTS tienda(
id_tienda int auto_increment Primary KEY,
nombre_tienda varchar(120),
ubicacion varchar(255)
);

CREATE TABLE IF NOT EXISTS producto(
id_producto int auto_increment Primary KEY,
nombre_producto varchar(255),
precio decimal(10,2),
id_tienda int,
stock int,
constraint FK_idtienda FOREIGN KEY(id_tienda) REFERENCES tienda(id_tienda)
);

CREATE TABLE IF NOT EXISTS cliente(
id_cliente int auto_increment Primary KEY,
nombre varchar(100),
apellido varchar(100),
email varchar(100)
);

CREATE TABLE IF NOT EXISTS compra(
id_compra int auto_increment Primary KEY,
id_cliente int,
id_producto int,
fecha_compra DATE,
cantidad int,
constraint FK_idproducto FOREIGN KEY(id_producto) REFERENCES producto(id_producto),
constraint FK_idcliente FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente) ON delete cascade
);

INSERT INTO tienda (nombre_tienda, ubicacion) VALUES ( "Tienda1", "DeMODAOUTLET"),  ( "Tienda2", "Medellin ");

