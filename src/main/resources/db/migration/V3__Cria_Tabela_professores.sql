CREATE TABLE IF NOT EXISTS `professores` (
  `id` varchar(255) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_de_atualizacao` datetime(6) DEFAULT NULL,
  `data_de_cadastro` datetime(6) DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `genero` enum('FEMININO','MASCULINO') DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  `sobrenome` varchar(100) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK95q8xsh7pkn7fbdo3cyst74o7` (`cpf`)
);
