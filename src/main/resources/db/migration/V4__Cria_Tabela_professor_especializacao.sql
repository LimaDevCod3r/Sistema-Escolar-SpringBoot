CREATE TABLE IF NOT EXISTS `professor_especializacao` (
  `professor_id` varchar(255) NOT NULL,
  `especializacao_id` varchar(255) NOT NULL,
  KEY `FKelvc36rodqyweph8bo3h3da7o` (`especializacao_id`),
  KEY `FKkme2v1er9y7v6rfhgg04p6lr` (`professor_id`),
  CONSTRAINT `FKelvc36rodqyweph8bo3h3da7o` FOREIGN KEY (`especializacao_id`) REFERENCES `especializacoes` (`id`),
  CONSTRAINT `FKkme2v1er9y7v6rfhgg04p6lr` FOREIGN KEY (`professor_id`) REFERENCES `professores` (`id`)
);
