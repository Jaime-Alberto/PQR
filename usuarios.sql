-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 02, 2021 at 01:29 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `usuarios`
--

-- --------------------------------------------------------

--
-- Table structure for table `pqr`
--

DROP TABLE IF EXISTS `pqr`;
CREATE TABLE IF NOT EXISTS `pqr` (
  `asunto_pqr` varchar(100) NOT NULL,
  `fecha_creacion` timestamp NULL DEFAULT current_timestamp(),
  `fecha_limite` timestamp NULL DEFAULT current_timestamp(),
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_pqr` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

--
-- Triggers `pqr`
--
DROP TRIGGER IF EXISTS `pqr_AI`;
DELIMITER $$
CREATE TRIGGER `pqr_AI` AFTER INSERT ON `pqr` FOR EACH ROW INSERT INTO reg_pqr(asunto_pqr, tipo_pqr, estado, usuario) VALUES(NEW.asunto_pqr,NEW.tipo_pqr, NEW.estado, NEW.usuario, NOW())
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `reg_pqr`
--

DROP TABLE IF EXISTS `reg_pqr`;
CREATE TABLE IF NOT EXISTS `reg_pqr` (
  `asunto_pqr` varchar(100) NOT NULL,
  `fecha_creacion` timestamp NULL DEFAULT current_timestamp(),
  `fecha_limite` timestamp NULL DEFAULT current_timestamp(),
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_pqr` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id`, `nombre`) VALUES
(1, 'Administrador'),
(2, 'Usuario');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id_tipo` int(11) DEFAULT NULL,
  `last_session` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `password`, `id_tipo`, `last_session`, `nombre`, `correo`) VALUES
(11, 'admin', 'admin', 1, '0000-00-00 00:00:00', 'jaime', 'jaime@gmail.com'),
(13, 'mariaCoronel', 'edcac06643020979563080b8345520a27e9fa3bc', 1, '0000-00-00 00:00:00', 'maria', 'maria@gmail.com');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
