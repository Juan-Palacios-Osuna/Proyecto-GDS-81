/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.8-MariaDB : Database - predictor
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`predictor` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `predictor`;

/*Table structure for table `barras` */

DROP TABLE IF EXISTS `barras`;

CREATE TABLE `barras` (
  `id_barra` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(64) NOT NULL,
  `registro_disponible` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_barra`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `barras` */

insert  into `barras`(`id_barra`,`nombre`,`registro_disponible`) values 
(1,'Refrescos',1),
(2,'Nacional',1),
(3,'Internacional',1);

/*Table structure for table `bebidas` */

DROP TABLE IF EXISTS `bebidas`;

CREATE TABLE `bebidas` (
  `id_bebida` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(64) NOT NULL,
  `denominacion` enum('0','1','2','3','4') NOT NULL,
  `registro_disponible` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_bebida`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `bebidas` */

insert  into `bebidas`(`id_bebida`,`nombre`,`denominacion`,`registro_disponible`) values 
(1,'Refresco de toronja','2',1),
(2,'Refresco de limon','2',1),
(3,'Refresco de cola','2',1),
(4,'Agua mineral','3',1),
(5,'Cerveza','3',1),
(6,'Vodka','3',1),
(7,'Ron','3',1),
(8,'Ginebra','3',1),
(9,'Brandy','2',1),
(10,'Whiskey','1',1),
(11,'Vino tinto','2',1),
(12,'Vino blanco','2',1),
(13,'Jugo de naranja','4',1),
(14,'Boing de uva','3',1),
(15,'Cacacola','0',1);

/*Table structure for table `bebidas_de_barra` */

DROP TABLE IF EXISTS `bebidas_de_barra`;

CREATE TABLE `bebidas_de_barra` (
  `id_bebida_barra` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_barra` int(10) unsigned NOT NULL,
  `id_bebida` int(10) unsigned NOT NULL,
  `registro_disponible` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_bebida_barra`),
  KEY `id_barra` (`id_barra`),
  KEY `id_bebida` (`id_bebida`),
  CONSTRAINT `bebidas_de_barra_ibfk_1` FOREIGN KEY (`id_barra`) REFERENCES `barras` (`id_barra`),
  CONSTRAINT `bebidas_de_barra_ibfk_2` FOREIGN KEY (`id_bebida`) REFERENCES `bebidas` (`id_bebida`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `bebidas_de_barra` */

insert  into `bebidas_de_barra`(`id_bebida_barra`,`id_barra`,`id_bebida`,`registro_disponible`) values 
(1,1,1,1),
(2,1,2,1),
(3,1,3,1),
(4,1,4,1),
(5,2,5,1),
(6,2,6,1),
(7,2,7,1),
(8,2,8,1),
(10,3,9,1),
(11,3,10,1),
(12,2,11,1);

/*Table structure for table `eventos` */

DROP TABLE IF EXISTS `eventos`;

CREATE TABLE `eventos` (
  `id_evento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(64) NOT NULL,
  `registro_disponible` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_evento`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `eventos` */

insert  into `eventos`(`id_evento`,`nombre`,`registro_disponible`) values 
(1,'Boda',1),
(2,'Bautizo',1),
(3,'Buffet',1),
(4,'Cumpleaños',1),
(5,'Graduacion',0),
(6,'Prueba de evento',1),
(7,'Prueba 2',1);

/*Table structure for table `historial_consumo` */

DROP TABLE IF EXISTS `historial_consumo`;

CREATE TABLE `historial_consumo` (
  `id_consumo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_evento` int(10) unsigned NOT NULL,
  `id_bebida` int(10) unsigned NOT NULL,
  `registro_disponible` tinyint(1) NOT NULL DEFAULT 1,
  `mililitros` float NOT NULL,
  PRIMARY KEY (`id_consumo`),
  KEY `id_evento` (`id_evento`),
  KEY `id_bebida` (`id_bebida`),
  CONSTRAINT `historial_consumo_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_evento`),
  CONSTRAINT `historial_consumo_ibfk_2` FOREIGN KEY (`id_bebida`) REFERENCES `bebidas` (`id_bebida`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `historial_consumo` */

insert  into `historial_consumo`(`id_consumo`,`id_evento`,`id_bebida`,`registro_disponible`,`mililitros`) values 
(1,1,1,1,500),
(3,6,2,1,1000),
(4,6,3,1,2000),
(5,6,4,1,3000),
(6,3,4,1,1000),
(7,3,3,1,2000),
(8,3,2,1,3000),
(9,6,5,1,1),
(10,6,6,1,2),
(11,6,7,1,3),
(12,1,1,1,100),
(13,1,2,1,200),
(14,1,3,1,300),
(15,1,5,1,400);

/*Table structure for table `movimientos` */

DROP TABLE IF EXISTS `movimientos`;

CREATE TABLE `movimientos` (
  `id_movimiento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tipo` varchar(64) NOT NULL,
  `tabla` varchar(64) NOT NULL,
  `id` int(11) NOT NULL,
  `nombre` varchar(64) NOT NULL,
  `fecha` date NOT NULL,
  `registro_disponible` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_movimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `movimientos` */

/* Procedure structure for procedure `agregar_bebida` */

/*!50003 DROP PROCEDURE IF EXISTS  `agregar_bebida` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`::1` PROCEDURE `agregar_bebida`(
	in nnombre varchar(64),
	in ndenominacion int
    )
BEGIN
		IF NOT EXISTS (SELECT id_bebida FROM bebidas WHERE nombre=nnombre) THEN
			INSERT INTO `predictor`.`bebidas` (nombre, denominacion)
			VALUES (nnombre, ndenominacion);
		ELSE
			SELECT "Bebida ya está registrada." AS ERROR;
		END IF;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `agregar_evento` */

/*!50003 DROP PROCEDURE IF EXISTS  `agregar_evento` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`::1` PROCEDURE `agregar_evento`(
	IN nnombre VARCHAR(64)
    )
BEGIN
		IF NOT EXISTS (SELECT id_evento FROM eventos WHERE nombre=nnombre) THEN
			INSERT INTO `predictor`.`eventos` (nombre)
			VALUES (nnombre);
		ELSE
			SELECT "Evento ya está registrado." AS ERROR;
		END IF;
	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
