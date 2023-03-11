/*Roles*/
INSERT INTO `rol`(`nombre`) VALUES ('Administrador');
INSERT INTO `rol`(`nombre`) VALUES ('Vendedor');
INSERT INTO `rol`(`nombre`) VALUES ('Jefe de produccion');
INSERT INTO `rol`(`nombre`) VALUES ('Cliente');


/*Productos*/
INSERT INTO `Productos`(`Nombre_producto`, `Precio`) VALUES ('Alcoba','3000000');
INSERT INTO `Productos`(`Nombre_producto`, `Precio`) VALUES ('Comedor','2500000');
INSERT INTO `Productos`(`Nombre_producto`, `Precio`) VALUES ('Puerta','800000');
INSERT INTO `Productos`(`Nombre_producto`, `Precio`) VALUES ('Sala en L','2000000');

/*Telas*/
INSERT INTO `Telas`(`Nombre_tela`, `Valor`) VALUES ('Lino','100000');
INSERT INTO `Telas`(`Nombre_tela`, `Valor`) VALUES ('Prana','225000');
INSERT INTO `Telas`(`Nombre_tela`, `Valor`) VALUES ('Cuero','100000');
INSERT INTO `Telas`(`Nombre_tela`, `Valor`) VALUES ('Cuerina','150000');

/*Maderas*/
INSERT INTO `Maderas`(`Nombre_madera`, `Precio`) VALUES ('Cedro','175000');
INSERT INTO `Maderas`(`Nombre_madera`, `Precio`) VALUES ('Flor morado','200000');
INSERT INTO `Maderas`(`Nombre_madera`, `Precio`) VALUES ('Nogal','150000');

/*Categorias*/
INSERT INTO `Categorias_productos`(`Nombre_categoria`) VALUES ('Salas');
INSERT INTO `Categorias_productos`(`Nombre_categoria`) VALUES ('Comedores');
INSERT INTO `Categorias_productos`(`Nombre_categoria`) VALUES ('Alcobas');
INSERT INTO `Categorias_productos`(`Nombre_categoria`) VALUES ('Puertas');

/*Diseno*/
INSERT INTO `Disenos`(`Nombre_d`) VALUES ('Clásico');
INSERT INTO `Disenos`(`Nombre_d`) VALUES ('Moderno');
INSERT INTO `Disenos`(`Nombre_d`) VALUES ('Deko');
INSERT INTO `Disenos`(`Nombre_d`) VALUES ('Rustico');

/*Categoria Insumos*/
INSERT INTO `categoria_insumos`(`nombre_categoria_insumos`) VALUES ('Herramienta');
INSERT INTO `categoria_insumos`(`nombre_categoria_insumos`) VALUES ('Insumo');

/*Insumos*/
INSERT INTO `insumos`(`tel_distribuidor`,`distribuidor`,`nombre`,`precio`,`stock`,`unidad_de_medida`,`id_categoria_insumo_fk`) VALUES ('3123138632','Andres Santiago Pineda','Puntillas','5000','500','pulgadas','2');
INSERT INTO `insumos`(`tel_distribuidor`,`distribuidor`,`nombre`,`precio`,`stock`,`unidad_de_medida`,`id_categoria_insumo_fk`) VALUES ('3203113386','Jose Uldarico Yañez','Tornillos','6000','500','pulgadas','2');
INSERT INTO `insumos`(`tel_distribuidor`,`distribuidor`,`nombre`,`precio`,`stock`,`unidad_de_medida`,`id_categoria_insumo_fk`) VALUES ('3123138632','Andres Santiago Pineda','Martillos','35000','10','centimetros','1');
















