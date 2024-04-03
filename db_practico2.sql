-- Crear base de datos
CREATE DATABASE  IF NOT EXISTS `db_practico2`;

-- Crear tabla Empresa
CREATE TABLE `empresa`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `denominacion` VARCHAR(128),
    `telefono` VARCHAR(50),
    `horario_atencion` VARCHAR(256),
    `quienes_somos` VARCHAR(1024),
    `latitud` DECIMAL(10, 8),
    `longitud` DECIMAL(11, 8),
    `domicilio` VARCHAR(256),
    `email` VARCHAR(75),
    PRIMARY KEY (`id`)
);

-- Crear tabla Noticia
CREATE TABLE `noticia` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo_noticia` VARCHAR(128),
    `resumen_noticia` VARCHAR(1024),
    `imagen_noticia` VARCHAR(256),
    `contenido_html` VARCHAR(20480),
	`publicada` CHAR(1),
    `fecha_publicacion` DATE,
    `id_empresa` INT,
     PRIMARY KEY (`id`),
    FOREIGN KEY (`id_empresa`) REFERENCES `empresa`(`id`)
);
