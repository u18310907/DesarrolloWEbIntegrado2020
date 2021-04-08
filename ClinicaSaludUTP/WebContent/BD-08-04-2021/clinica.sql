-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-04-2021 a las 08:41:56
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clinica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `cod_Cita` int(11) NOT NULL,
  `num_cita` varchar(15) NOT NULL,
  `hora_cita` varchar(15) NOT NULL,
  `cod_Pac` int(11) NOT NULL,
  `cod_Per` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historiaclinica`
--

CREATE TABLE `historiaclinica` (
  `cod_HisC` int(11) NOT NULL,
  `num_HisC` int(11) NOT NULL,
  `codPac_HisC` int(11) NOT NULL,
  `codTra_HisC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `cod_Pac` int(11) NOT NULL,
  `nom_Pac` varchar(50) NOT NULL,
  `apellPac_Pac` varchar(50) NOT NULL,
  `apeMat_Pac` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `cod_Per` int(11) NOT NULL,
  `cod_Rol` int(11) NOT NULL,
  `nom_Per` varchar(50) NOT NULL,
  `apePat_Per` varchar(50) NOT NULL,
  `apeMat_Per` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`cod_Per`, `cod_Rol`, `nom_Per`, `apePat_Per`, `apeMat_Per`) VALUES
(1, 1, 'Juan ', 'Torres', 'Diaz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `cod_Rol` int(11) NOT NULL,
  `nom_Rol` varchar(50) NOT NULL,
  `descr_Rol` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`cod_Rol`, `nom_Rol`, `descr_Rol`) VALUES
(1, 'Medico Externo', 'Persona encargada de consultorios Externos'),
(2, 'Informatica', 'Encargado de las TI'),
(3, 'Limpieza', 'Encargados de la Limpieza de la Clinica'),
(18, 'Planillas', 'Encargado de los pagos del Personal de todas las Areas');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`cod_Cita`),
  ADD KEY `fk_Pac_Cit` (`cod_Pac`),
  ADD KEY `fk_Per_Cit` (`cod_Per`);

--
-- Indices de la tabla `historiaclinica`
--
ALTER TABLE `historiaclinica`
  ADD PRIMARY KEY (`cod_HisC`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`cod_Pac`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`cod_Per`),
  ADD KEY `fk_Rol_Per` (`cod_Rol`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`cod_Rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `cod_Cita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `historiaclinica`
--
ALTER TABLE `historiaclinica`
  MODIFY `cod_HisC` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `cod_Pac` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `cod_Per` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `cod_Rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `fk_Pac_Cit` FOREIGN KEY (`cod_Pac`) REFERENCES `paciente` (`cod_Pac`),
  ADD CONSTRAINT `fk_Per_Cit` FOREIGN KEY (`cod_Per`) REFERENCES `personal` (`cod_Per`);

--
-- Filtros para la tabla `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `fk_Rol_Per` FOREIGN KEY (`cod_Rol`) REFERENCES `rol` (`cod_Rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
