-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-06-2023 a las 20:14:36
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `escuela`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE IF NOT EXISTS `estudiante` (
  `id_estudiante` bigint(20) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `zona_horaria` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_estudiante`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`id_estudiante`, `ciudad`, `edad`, `nombre`, `zona_horaria`) VALUES
(12, 'taxco', 1, 'Alexis', 'mexico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examen`
--

CREATE TABLE IF NOT EXISTS `examen` (
  `id_examen` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_examen`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `examen`
--

INSERT INTO `examen` (`id_examen`, `nombre`) VALUES
(1, 'Java v2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(29);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opcion`
--

CREATE TABLE IF NOT EXISTS `opcion` (
  `id_opcion` bigint(20) NOT NULL,
  `correcta` bit(1) NOT NULL,
  `opcion` varchar(255) DEFAULT NULL,
  `pregunta` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_opcion`),
  KEY `FK36va5vive815r63xvre09jish` (`pregunta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `opcion`
--

INSERT INTO `opcion` (`id_opcion`, `correcta`, `opcion`, `pregunta`) VALUES
(3, b'0', 'comida', 2),
(4, b'0', 'animal', 2),
(5, b'0', 'peinado', 2),
(6, b'1', 'tipo de dato', 2),
(8, b'0', 'comida', 7),
(9, b'0', 'animal', 7),
(10, b'0', 'peinado', 7),
(11, b'1', 'tipo de dato', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE IF NOT EXISTS `pregunta` (
  `id_pregunta` bigint(20) NOT NULL,
  `enunciado` varchar(255) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  `examen` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_pregunta`),
  KEY `FK294gvnwb285qixrodrnhyn7qh` (`examen`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`id_pregunta`, `enunciado`, `puntos`, `examen`) VALUES
(2, '¿que es int en java?', 50, 1),
(7, '¿que es double en java?', 50, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE IF NOT EXISTS `respuesta` (
  `id_respuesta` bigint(20) NOT NULL,
  `estudiante` bigint(20) DEFAULT NULL,
  `examen` bigint(20) DEFAULT NULL,
  `opcion` bigint(20) DEFAULT NULL,
  `pregunta` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_respuesta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`id_respuesta`, `estudiante`, `examen`, `opcion`, `pregunta`) VALUES
(28, 12, 1, 11, 7),
(27, 12, 1, 6, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta_estudiante`
--

CREATE TABLE IF NOT EXISTS `respuesta_estudiante` (
  `respuesta_id_respuesta` bigint(20) NOT NULL,
  `estudiante_id_estudiante` bigint(20) NOT NULL,
  PRIMARY KEY (`respuesta_id_respuesta`,`estudiante_id_estudiante`),
  KEY `FKkwv9lbfkqmxx9pyjmlmac2se1` (`estudiante_id_estudiante`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta_examen`
--

CREATE TABLE IF NOT EXISTS `respuesta_examen` (
  `respuesta_id_respuesta` bigint(20) NOT NULL,
  `examen_id_examen` bigint(20) NOT NULL,
  PRIMARY KEY (`respuesta_id_respuesta`,`examen_id_examen`),
  KEY `FKl77pboiuo9tag98cp6bqui7ex` (`examen_id_examen`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta_opcion`
--

CREATE TABLE IF NOT EXISTS `respuesta_opcion` (
  `respuesta_id_respuesta` bigint(20) NOT NULL,
  `opcion_id_opcion` bigint(20) NOT NULL,
  PRIMARY KEY (`respuesta_id_respuesta`,`opcion_id_opcion`),
  KEY `FK4bopdrx7jlxcearauidws0hwn` (`opcion_id_opcion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta_pregunta`
--

CREATE TABLE IF NOT EXISTS `respuesta_pregunta` (
  `respuesta_id_respuesta` bigint(20) NOT NULL,
  `pregunta_id_pregunta` bigint(20) NOT NULL,
  PRIMARY KEY (`respuesta_id_respuesta`,`pregunta_id_pregunta`),
  KEY `FKj3eovqi753vj6hrsln4jp1bhi` (`pregunta_id_pregunta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
