drop database if exists Supermercado;
create database Supermercado;
use Supermercado;

create table Trabajadores (
	CodigoEmpleado smallint not null,
    Usuario varchar (40) not null,
    Contraseña varchar (100) not null,
    Nombre varchar (40),
    DNI varchar (9)
);

create table Facturas (
    CodigoFactura varchar(5),
    CodigoCaja smallint not null,
    FechaHora varchar (1000),
    PrecioTotal float,
    DineroPagado float
);

create table TipoIvas (
	Porcentaje float not null,
	Tipo enum ('superreducido','reducido','general')
);

create table Productos (
	CodigoProducto smallint not null,
    Nombre varchar (50) not null,
    PrecioUnidad float not null,
    TipoIva float,
    Stock smallint 
);

create table DetallesFacturas (
	CodigoFactura varchar(5),
    CodigoProducto smallint not null,
	Cantidad smallint not null,
    Precio float
);

ALTER TABLE Facturas ADD PRIMARY KEY (CodigoFactura);
ALTER TABLE Trabajadores ADD PRIMARY KEY (CodigoEmpleado);
ALTER TABLE Productos ADD PRIMARY KEY (CodigoProducto);
ALTER TABLE TipoIvas ADD PRIMARY KEY (Porcentaje);

ALTER TABLE Productos ADD FOREIGN KEY (TipoIva) REFERENCES TipoIvas (Porcentaje);
ALTER TABLE DetallesFacturas ADD FOREIGN KEY (CodigoFactura) REFERENCES Facturas (CodigoFactura) ON DELETE CASCADE;
ALTER TABLE DetallesFacturas ADD FOREIGN KEY (CodigoProducto) REFERENCES Productos (CodigoProducto);



INSERT INTO TipoIvas VALUES (4.00,'superreducido');
INSERT INTO TipoIvas VALUES (10.00,'reducido');
INSERT INTO TipoIvas VALUES (21.00,'general');

INSERT INTO Trabajadores VALUES (01,'Administrador','bc7a844476607e1a59d8eb1b1f311830','raul','28945094H');
INSERT INTO Trabajadores VALUES (02,'empleado02','81dc9bdb52d04dc20036dbd8313ed055','Agustin','37691758P');

INSERT INTO Productos VALUES (001,'Oreo',1.89,10.00,10);
INSERT INTO Productos VALUES (002,'Huevos',2.21,4.00,35);
INSERT INTO Productos VALUES (003,'Arroz',1.32,4.00,23);
INSERT INTO Productos VALUES (004,'Ron barcelo',14.23,21.00,9);
INSERT INTO Productos VALUES (005,'Aceite de oliva',3.89,10.00,40);
INSERT INTO Productos VALUES (006,'Agua',0.19,10.00,70);
INSERT INTO Productos VALUES (007,'Cerveza',2.99,21.00,43);
INSERT INTO Productos VALUES (008,'Sal',0.69,4.00,31);
INSERT INTO Productos VALUES (009,'Vino',11.99,21.00,16);
INSERT INTO Productos VALUES (010,'Doritos',1.69,10.00,57);
INSERT INTO Productos VALUES (011,'Harina',0.35,4.00,101);

select * from Productos;
UPDATE Productos SET Stock = '10' WHERE CodigoProducto = '1';
UPDATE Productos SET Stock = '35' WHERE CodigoProducto = '2';
UPDATE Productos SET Stock = '23' WHERE CodigoProducto = '3';
UPDATE Productos SET Stock = '9' WHERE CodigoProducto = '4';
UPDATE Productos SET Stock = '40' WHERE CodigoProducto = '5';
SELECT * FROM Facturas;
select * from DetallesFacturas;
select * FROM Trabajadores where usuario = 'Administrador';
delete from Facturas where CodigoFactura in ("T1","T2","T3","T4","T5","T6","T7","T8","T9");

-- INSERT INTO Facturas VALUES ("T1",1,1,1);
-- INSERT INTO DetallesFacturas VALUES ("T1",1,1,1);
