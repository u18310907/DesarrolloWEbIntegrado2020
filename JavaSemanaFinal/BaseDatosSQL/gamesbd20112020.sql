-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2020 a las 23:44:14
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
(33, 17, 1, 'Luana', '2020-11-20');

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
(5, 4, 1, 'Home'),
(6, 2, 1, 'Games'),
(7, 4, 1, 'Blog'),
(8, 5, 1, 'Foro'),
(9, 4, 1, 'Conctact'),
(10, 1, 1, 'Admin');

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
(1, 'Default', 'Default', 1, 'Default', 'webImg.jpg', 0),
(2, 'Soladado Game', 'Juego de guerra peleas de andoriddes', 1, 'Este es un juego de accion creado desde la base de datos', '2.jpg', 12.99),
(3, 'Aventure Game', 'Juego de aventuras', 1, 'Este es un juego de peleas creado desde la base de datos', '3.jpg', 4.99),
(4, 'Demonic Game', 'Juego de estrategia', 1, 'Este es un juego de peleas creado desde la base de datos', '4.jpg', 12.99),
(5, 'Medusa', 'Juego de aventura y estrategia griega', 1, 'Este es un juego de peleas creado desde la base de datos', '5.jpg', 15.99),
(6, 'Speed', 'Juego de carreras', 1, 'Este es un juego de carreras creado desde la base de datos', '6.jpg', 3.99),
(7, 'Free Fire', 'Juego de estrategia de guerra', 1, 'Este es un juego de peleas creado desde la base de datos', '7.jpg', 4.99),
(9, 'BlankGame', 'Juego de peleas con androides', 1, 'Este es un juego de peleas creado desde la base de datos', '1.jpg', 7.99);

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
(1, 4, 2, 0, '2020-11-20'),
(2, 3, 2, 0, '2020-11-20'),
(3, 2, 3, 0, '2020-11-20'),
(4, 6, 2, 0, '2020-11-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `promocion`
--

CREATE TABLE `promocion` (
  `codigo` int(11) NOT NULL,
  `codjue` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `descuento` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `promocion`
--

INSERT INTO `promocion` (`codigo`, `codjue`, `descripcion`, `descuento`) VALUES
(1, 3, 'Oferta especial por inaguracion', 10),
(2, 5, 'Oferta especial por evento', 10),
(3, 7, 'Usa estrategias para ganar oferta especial por equipo', 30);

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
(17, 'Luana', 'Luana', '8.jpg', 'Luana@gmail.com');

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
(20, 4, 2, 12.99, '2020-11-20', '0');

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
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de la tabla `galeria`
--
ALTER TABLE `galeria`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `juegos`
--
ALTER TABLE `juegos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT de la tabla `listadeseos`
--
ALTER TABLE `listadeseos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `promocion`
--
ALTER TABLE `promocion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

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
