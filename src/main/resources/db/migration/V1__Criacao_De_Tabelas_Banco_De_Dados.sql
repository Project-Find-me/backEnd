CREATE TABLE TB_USUARIO (
  id_usuario int NOT NULL AUTO_INCREMENT,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  nome_completo VARCHAR(255) NOT NULL,
  imagem MEDIUMTEXT NULL,
  PRIMARY KEY (id_usuario));

CREATE TABLE TB_ENDERECO (
  id_endereco INT NOT NULL AUTO_INCREMENT,
  cep INT NOT NULL,
  cidade VARCHAR(60) NOT NULL,
  uf CHAR(2) NOT NULL,
  rua VARCHAR(255) NOT NULL,
  bairro VARCHAR(60) NOT NULL,
  numero INT NULL,
  id_usuario INT NOT NULL,
  PRIMARY KEY (id_endereco),
  CONSTRAINT fk_endereco_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES TB_USUARIO (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE TB_SERVICO (
  id_servico INT NOT NULL AUTO_INCREMENT,
  nome_servico VARCHAR(255) NOT NULL,
  preco DOUBLE NOT NULL,
  PRIMARY KEY (id_servico));


CREATE TABLE IF NOT EXISTS TB_PRESTADOR (
  id_prestador INT NOT NULL AUTO_INCREMENT,
  telefone BIGINT NOT NULL,
  rg VARCHAR(20) NOT NULL,
  cnpj VARCHAR(14) NULL,
  cpf VARCHAR(11) NULL,
  id_usuario INT NOT NULL,
  id_servico INT NOT NULL,
  PRIMARY KEY (id_prestador),
  CONSTRAINT fk_PRESTADOR_USUARIO1
    FOREIGN KEY (id_usuario)
    REFERENCES TB_USUARIO (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_PRESTADOR_SERVICO1
    FOREIGN KEY (id_servico)
    REFERENCES TB_SERVICO (id_servico)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS TB_FORMA_DE_PAGAMENTO (
  id_forma_pagamento INT NOT NULL,
  cartao_de_credito TINYINT NOT NULL,
  boleto TINYINT NOT NULL,
  PRIMARY KEY (id_forma_pagamento));


CREATE TABLE IF NOT EXISTS TB_AGENDAMENTO_DO_SERVICO (
  id_agendamento INT NOT NULL AUTO_INCREMENT,
  data_início DATETIME NOT NULL,
  data_fim DATETIME NOT NULL,
  PRIMARY KEY (id_agendamento));


CREATE TABLE IF NOT EXISTS TB_CARTAO_DE_CREDITO (
  id_cartao_de_credito INT NOT NULL AUTO_INCREMENT,
  nome_do_titular VARCHAR(255) NOT NULL,
  numero_do_cartao CHAR(16) NOT NULL,
  validade_do_cartao VARCHAR(6) NOT NULL,
  id_forma_pagamento INT NOT NULL,
  PRIMARY KEY (id_cartao_de_credito),
  CONSTRAINT fk_CARTAO_DE_CREDITO_FORMA_DE_PAGAMENTO1
    FOREIGN KEY (id_forma_pagamento)
    REFERENCES TB_FORMA_DE_PAGAMENTO (id_forma_pagamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS TB_SERVICO_CONTRATADO (
  id_servico_contratado INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  id_prestador INT NOT NULL,
  id_agendamento INT NOT NULL,
  id_forma_pagamento INT NOT NULL,
  PRIMARY KEY (id_servico_contratado),
  CONSTRAINT fk_TB_SERVICO_CONTRATADO_AGENDAMENTO_DO_SERVICO1
    FOREIGN KEY (id_agendamento)
    REFERENCES TB_AGENDAMENTO_DO_SERVICO (id_agendamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_TB_SERVICO_CONTRATADO_FORMA_DE_PAGAMENTO1
    FOREIGN KEY (id_forma_pagamento)
    REFERENCES TB_FORMA_DE_PAGAMENTO (id_forma_pagamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_TB_SERVICO_CONTRATADO_USUARIO1
    FOREIGN KEY (id_usuario)
    REFERENCES TB_USUARIO (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_TB_SERVICO_CONTRATADO_PRESTADOR1
    FOREIGN KEY (id_prestador)
    REFERENCES TB_PRESTADOR (id_prestador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);