CREATE TABLE IF NOT EXISTS `alunos` (
  `id` VARCHAR(36) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `sobrenome` VARCHAR(100) DEFAULT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `data_nascimento` DATETIME(6) NOT NULL,
  `telefone` VARCHAR(15) DEFAULT NULL,
  `genero` ENUM('FEMININO', 'MASCULINO') DEFAULT NULL,
  `email` VARCHAR(100) DEFAULT NULL,
  `nome_da_mae` VARCHAR(100) DEFAULT NULL,
  `nome_do_pai` VARCHAR(100) DEFAULT NULL,
  `cep` VARCHAR(8) DEFAULT NULL,
  `cidade` VARCHAR(100) DEFAULT NULL,
  `estado` CHAR(2) DEFAULT NULL,
  `data_de_cadastro` DATETIME(6) DEFAULT NULL,
  `data_de_atualizacao` DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_cpf` (`cpf`)
);
