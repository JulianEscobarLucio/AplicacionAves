
CREATE DATABASE administradoraves;
USE administradoraves;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";



--
-- Base de datos: `administradoraves`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ave`
--

CREATE TABLE `ave` (
  `id_ave` bigint(20) NOT NULL,
  `id_pais` bigint(20) NOT NULL,
  `nombre_cientifico` varchar(100) DEFAULT NULL,
  `nombre_comun` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ave`
--

INSERT INTO `ave` (`id_ave`, `id_pais`, `nombre_cientifico`, `nombre_comun`) VALUES
(18, 1, 'Vultur gryphus', 'Condor'),
(22, 3, 'Larus dominicanus ', 'Gaviota'),
(25, 2, 'Pava Andina', 'Penelope montagnii');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id_pais` bigint(20) NOT NULL,
  `nombre_pais` varchar(100) DEFAULT NULL,
  `id_zona` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id_pais`, `nombre_pais`, `id_zona`) VALUES
(1, 'Colombia', 1),
(2, 'Bolivia', 1),
(3, 'Argentina', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais_aves`
--

CREATE TABLE `pais_aves` (
  `id_pais` bigint(20) NOT NULL,
  `id_ave` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pais_aves`
--

INSERT INTO `pais_aves` (`id_pais`, `id_ave`) VALUES
(1, 18),
(2, 25),
(3, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zona`
--

CREATE TABLE `zona` (
  `id_zona` bigint(20) NOT NULL,
  `nombre_zona` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `zona`
--

INSERT INTO `zona` (`id_zona`, `nombre_zona`) VALUES
(1, 'Suramerica');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ave`
--
ALTER TABLE `ave`
  ADD PRIMARY KEY (`id_ave`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id_pais`),
  ADD KEY `FKIdZona` (`id_zona`);

--
-- Indices de la tabla `pais_aves`
--
ALTER TABLE `pais_aves`
  ADD PRIMARY KEY (`id_pais`,`id_ave`),
  ADD KEY `FKIdAve` (`id_ave`);

--
-- Indices de la tabla `zona`
--
ALTER TABLE `zona`
  ADD PRIMARY KEY (`id_zona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ave`
--
ALTER TABLE `ave`
  MODIFY `id_ave` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pais`
--
ALTER TABLE `pais`
  ADD CONSTRAINT `FKIdZona` FOREIGN KEY (`id_zona`) REFERENCES `zona` (`id_zona`);

--
-- Filtros para la tabla `pais_aves`
--
ALTER TABLE `pais_aves`
  ADD CONSTRAINT `FKIdPais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`),
  ADD CONSTRAINT `FKIdAve` FOREIGN KEY (`id_ave`) REFERENCES `ave` (`id_ave`);
COMMIT;

