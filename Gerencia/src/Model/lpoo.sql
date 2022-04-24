CREATE DATABASE lpoo;

USE lpoo;

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cliente_id` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `sobrenome` varchar(150) NOT NULL,
  `rg` varchar(12) NOT NULL,
  `cpf` bigint(12) NOT NULL,
  `endereco` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`cliente_id`, `nome`, `sobrenome`, `rg`, `cpf`, `endereco`) VALUES
(1, 'Ernesto', 'Montero', '012345678', 20783856547, 'Rua Dos Alfeneiros, n 4'),
(2, 'Janaina', 'Ercole', '92351130', 48906735553, 'Montanha da Perdicao, Mordor, n 7'),
(3, 'Raul', 'Salinas', '91131130', 95362078500, 'Hogwarts, Salão Comunal da Corvinal, quarto 1'),
(54, 'Martin', 'Mosquera', '1312441', 80058267964, 'Rua dos locos'),
(57, 'Ana', 'Paola', '312315', 32124930206, 'Rua dos outros'),
(58, 'Carminida', 'flores', '237123', 39136977640, 'Rua do Macarrom'),
(59, 'Andres', 'Ardila', '012345678', 20783856547, 'Rua Dos Alfeneiros, n 4'),
(60, 'Carolina', 'Strangber', '92351130', 48906735553, 'Montanha da Perdicao, Mordor, n 7'),
(61, 'Nicolle', 'Costa', '91131130', 95362078500, 'Hogwarts, Salão Comunal da Corvinal, quarto 1'),
(62, 'Rafael', 'Prestes', '81332130', 51281923508, 'Minas Thirith, Casa do lado do portao');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conta`
--

CREATE TABLE `conta` (
  `num_conta` int(20) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `dep_inicial` double NOT NULL,
  `limite` double DEFAULT NULL,
  `montante_min` double DEFAULT NULL,
  `deposito_min` double DEFAULT NULL,
  `cliente_id` int(11) NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `conta`
--

INSERT INTO `conta` (`num_conta`, `tipo`, `dep_inicial`, `limite`, `montante_min`, `deposito_min`, `cliente_id`, `saldo`) VALUES
(199, 'Conta Corrente', 100, 100, NULL, NULL, 54, 109.35759041570921),
(201, 'Conta Investimento', 100, NULL, 200, 100, 57, 119.5092568622311);

-- --------------------------------------------------------

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`cliente_id`);

--
-- Indices de la tabla `conta`
--
ALTER TABLE `conta`
  ADD PRIMARY KEY (`num_conta`),
  ADD UNIQUE KEY `cliente_id` (`cliente_id`);



--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `cliente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT de la tabla `conta`
--
ALTER TABLE `conta`
  MODIFY `num_conta` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=203;


--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `conta`
--
ALTER TABLE `conta`
  ADD CONSTRAINT `fk_conta` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`cliente_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
