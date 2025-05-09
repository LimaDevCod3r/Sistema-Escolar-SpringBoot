CREATE TABLE IF NOT EXISTS alunos (
  id varchar(255) NOT NULL,
  cep varchar(9) DEFAULT NULL,
  cidade varchar(100) DEFAULT NULL,
  cpf varchar(11) NOT NULL,
  data_de_atualizacao datetime(6) DEFAULT NULL,
  data_de_cadastro datetime(6) DEFAULT NULL,
  data_nascimento date NOT NULL,
  email varchar(100) DEFAULT NULL,
  estado varchar(2) DEFAULT NULL,
  genero enum('FEMININO','MASCULINO') DEFAULT NULL,
  nome varchar(100) NOT NULL,
  nome_da_mae varchar(100) DEFAULT NULL,
  nome_do_pai varchar(100) DEFAULT NULL,
  sobrenome varchar(100) DEFAULT NULL,
  telefone varchar(15) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK2t1qqj9okv59i9gcj7hjirhju (cpf)
);
