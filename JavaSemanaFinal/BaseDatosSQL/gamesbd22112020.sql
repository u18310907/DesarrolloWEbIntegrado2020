-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2020 a las 04:55:44
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
-- Base de datos: `gamesbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`codigo`, `nombre`) VALUES
(1, 'Aventura'),
(2, 'Accion'),
(3, 'Peleas'),
(4, 'Carreras');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `codigo` int(11) NOT NULL,
  `coduser` int(11) NOT NULL,
  `codjuego` int(11) NOT NULL,
  `comentario` varchar(200) NOT NULL,
  `fecha` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`codigo`, `coduser`, `codjuego`, `comentario`, `fecha`) VALUES
(30, 2, 1, 'alexpalli', '2020-11-20'),
(31, 2, 1, 'Administrador', '2020-11-20'),
(32, 2, 1, 'usuiario', '2020-11-20'),
(33, 17, 1, 'Luana', '2020-11-20'),
(34, 2, 1, 'Alex Palli Administrador', '2020-11-22'),
(35, 19, 1, 'example Admin', '2020-11-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `galeria`
--

CREATE TABLE `galeria` (
  `codigo` int(11) NOT NULL,
  `codjue` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  `vista` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `galeria`
--

INSERT INTO `galeria` (`codigo`, `codjue`, `estado`, `vista`) VALUES
(1, 1, 1, 'Admin'),
(2, 63, 1, 'Home'),
(3, 5, 1, 'Games'),
(4, 3, 1, 'Blog'),
(5, 2, 1, 'Foro'),
(6, 62, 1, 'Conctact');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos`
--

CREATE TABLE `juegos` (
  `codigo` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `observacion` varchar(200) NOT NULL,
  `ImagenName` varchar(200) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `juegos`
--

INSERT INTO `juegos` (`codigo`, `titulo`, `descripcion`, `categoria_id`, `observacion`, `ImagenName`, `precio`) VALUES
(1, 'Default', 'Default', 2, 'Default', 'webImg.jpg', 0),
(2, 'Dragon Dutty', 'Busca al rey de los dragones', 1, 'Este juego contiene escena violentas, ademas requiere alto consumo de la tarjeta grafica', '2.jpg', 15.99),
(3, 'Demoic Ltd', 'Obten recompensas y convierte a los demonios en tus aliados', 1, 'Recomendado para personas mayores de edad, contiene seres mitologicos', '3.jpg', 4.99),
(4, 'Viaje al Infierno', 'Escapa de las criaturas que buscan apoderarse de ti', 1, 'Contiene escenas violentas, no apto para personas religiosas ', '4.jpg', 30.99),
(5, 'Gran Turismo', 'Demuestra que eres el mas rapido dentro de la ciudad', 4, 'Apto para publico en general', '5.jpg', 15.99),
(6, 'Batle Field', 'Demuestra tus estrategias siendo el ultimo sobreviviente', 2, 'Juego no apto para menores, uso de armas y excesiva violencia', '6.jpg', 50.99),
(7, 'Comandos', 'Reune a tu equipo y comienza una aventura', 1, 'Forma grupos colaborativos, organizados con un objetivo', '7.jpg', 4.99),
(9, 'Detroit', 'Crea una alianza y unete al campo de batalla', 2, 'Este es un juego de peleas creado desde la base de datos', '1.jpg', 17.99),
(62, 'Spiderman 3', 'Diviertete paseando por las calles de New York', 2, 'Juego de un hombre que obtiene superpoderes pertenece a Marvel', 'spiderma.jpg', 99.99),
(63, 'Thanos', 'Defiende a Thanos de los SuperHeroes de Marvel', 3, 'Perfecto para simpatizantes de Marvel, incluye escenas de  Infinity War', 'Thanos.jpg', 15.99),
(64, 'Dota 2', 'Juego MOBA evolucion del dota 1 WC3', 3, 'Juego para equipos de 5, requiere alta tarjeta grafica, Conexion a Internet estable', 'dota2.jpg', 15.39);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listadeseos`
--

CREATE TABLE `listadeseos` (
  `codigo` int(11) NOT NULL,
  `codjue` int(11) NOT NULL,
  `codusu` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  `fecha` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `listadeseos`
--

INSERT INTO `listadeseos` (`codigo`, `codjue`, `codusu`, `estado`, `fecha`) VALUES
(21, 62, 2, 0, '2020-11-22'),
(22, 9, 2, 0, '2020-11-22'),
(23, 4, 2, 0, '2020-11-22'),
(24, 63, 19, 0, '2020-11-22'),
(25, 64, 2, 0, '2020-11-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `promocion`
--

CREATE TABLE `promocion` (
  `codigo` int(11) NOT NULL,
  `codjue` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `descuento` double NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `promocion`
--

INSERT INTO `promocion` (`codigo`, `codjue`, `descripcion`, `descuento`, `estado`) VALUES
(1, 3, 'test', 2, 0),
(2, 5, 'Oferta especial por evento', 10, 0),
(3, 7, 'Usa estrategias para ganar oferta especial por equipo', 30, 1),
(4, 3, 'otro', 9.99, 0),
(5, 5, 'Vuela como el viente con un descuento de ', 9.99, 1),
(6, 62, 'Spidemanr retorna con una oferta', 20, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `codigo` int(11) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `ImagenName` varchar(200) DEFAULT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codigo`, `usuario`, `password`, `ImagenName`, `correo`) VALUES
(1, 'Default', 'Default', '1.jpg', 'default@gmail,com'),
(2, 'Admin', 'Admin', '2.jpg', 'kyscompani@gmail.com'),
(3, 'Alex', 'Alex', '3.jpg', 'kyscompani@gmail.com'),
(14, 'Other', 'Other', '2.jpg', 'Other'),
(15, 'Administrador', 'Administrador', '1.jpg', 'Administrador'),
(17, 'Luana', 'Luana', '8.jpg', 'Luana@gmail.com'),
(19, 'example', 'example', '8.jpg', 'example@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `codigo` int(11) NOT NULL,
  `codjue` int(11) NOT NULL,
  `codusu` int(11) NOT NULL,
  `precio` double NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`codigo`, `codjue`, `codusu`, `precio`, `fecha`, `estado`) VALUES
(19, 3, 2, 4.99, '2020-11-20', '0'),
(20, 4, 2, 12.99, '2020-11-20', '0'),
(21, 3, 2, 4.99, '2020-11-22', '0'),
(22, 5, 2, 15.99, '2020-11-22', '0'),
(23, 4, 2, 30.99, '2020-11-22', '1'),
(24, 64, 2, 15.39, '2020-11-22', '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_comentarios` (`codjuego`),
  ADD KEY `fk_usuario` (`coduser`);

--
-- Indices de la tabla `galeria`
--
ALTER TABLE `galeria`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_galeria` (`codjue`);

--
-- Indices de la tabla `juegos`
--
ALTER TABLE `juegos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_categoria` (`categoria_id`);

--
-- Indices de la tabla `listadeseos`
--
ALTER TABLE `listadeseos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_listaUsu` (`codusu`),
  ADD KEY `fk_listaJuego` (`codjue`);

--
-- Indices de la tabla `promocion`
--
ALTER TABLE `promocion`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_juegos` (`codjue`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_Venta` (`codjue`),
  ADD KEY `fk_Venta_Usuario` (`codusu`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `galeria`
--
ALTER TABLE `galeria`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT de la tabla `juegos`
--
ALTER TABLE `juegos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT de la tabla `listadeseos`
--
ALTER TABLE `listadeseos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `promocion`
--
ALTER TABLE `promocion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `fk_comentarios` FOREIGN KEY (`codjuego`) REFERENCES `juegos` (`codigo`),
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`coduser`) REFERENCES `usuario` (`codigo`);

--
-- Filtros para la tabla `galeria`
--
ALTER TABLE `galeria`
  ADD CONSTRAINT `fk_galeria` FOREIGN KEY (`codjue`) REFERENCES `juegos` (`codigo`);

--
-- Filtros para la tabla `juegos`
--
ALTER TABLE `juegos`
  ADD CONSTRAINT `fk_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`codigo`);

--
-- Filtros para la tabla `listadeseos`
--
ALTER TABLE `listadeseos`
  ADD CONSTRAINT `fk_listaJuego` FOREIGN KEY (`codjue`) REFERENCES `juegos` (`codigo`),
  ADD CONSTRAINT `fk_listaUsu` FOREIGN KEY (`codusu`) REFERENCES `usuario` (`codigo`);

--
-- Filtros para la tabla `promocion`
--
ALTER TABLE `promocion`
  ADD CONSTRAINT `fk_juegos` FOREIGN KEY (`codjue`) REFERENCES `juegos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_Venta` FOREIGN KEY (`codjue`) REFERENCES `juegos` (`codigo`),
  ADD CONSTRAINT `fk_Venta_Usuario` FOREIGN KEY (`codusu`) REFERENCES `usuario` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
