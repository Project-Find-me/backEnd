CREATE TABLE TB_USUÁRIO (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  nome_completo VARCHAR(255) NOT NULL,
  imagem MEDIUMTEXT NULL,
  PRIMARY KEY (id_usuario));

CREATE TABLE TB_ENDEREÇO (
  id_endereco INT NOT NULL AUTO_INCREMENT,
  cep INT NOT NULL,
  cidade VARCHAR(60) NOT NULL,
  uf CHAR(2) NOT NULL,
  rua VARCHAR(255) NOT NULL,
  bairro VARCHAR(60) NOT NULL,
  numero INT NULL,
  id_usuario INT NOT NULL,
  PRIMARY KEY (id_endereco),
  INDEX fk_ENDEREÇO_USUÁRIO (id_usuario ASC),
  CONSTRAINT fk_ENDEREÇO_USUÁRIO
    FOREIGN KEY (id_usuario)
    REFERENCES TB_USUÁRIO (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE TB_SERVICO (
  id_servico INT NOT NULL AUTO_INCREMENT,
  nome_servico VARCHAR(255) NOT NULL,
  preco DOUBLE NOT NULL,
  PRIMARY KEY (id_servico));


CREATE TABLE IF NOT EXISTS TB_PRESTADOR (
  id_prestador INT NOT NULL AUTO_INCREMENT,
  telefone INT NOT NULL,
  rg VARCHAR(20) NOT NULL,
  cnpj CHAR(11) NULL,
  cpf CHAR(11) NULL,
  id_usuario INT NOT NULL,
  id_servico INT NOT NULL,
  PRIMARY KEY (id_prestador),
  INDEX fk_PRESTADOR_USUÁRIO1 (id_usuario ASC),
  INDEX fk_PRESTADOR_SERVICO1 (id_servico ASC),
  CONSTRAINT fk_PRESTADOR_USUÁRIO1
    FOREIGN KEY (id_usuario)
    REFERENCES TB_USUÁRIO (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_PRESTADOR_SERVICO1
    FOREIGN KEY (id_servico)
    REFERENCES TB_SERVICO (id_servico)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS TB_FORMA_DE_PAGAMENTO (
  id_forma_pagamento INT NOT NULL,
  cartao_de_crédito TINYINT NOT NULL,
  boleto TINYINT NOT NULL,
  PRIMARY KEY (id_forma_pagamento));


CREATE TABLE IF NOT EXISTS TB_AGENDAMENTO_DO_SERVIÇO (
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
  INDEX fk_CARTAO_DE_CREDITO_FORMA_DE_PAGAMENTO1 (id_forma_pagamento ASC),
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
  INDEX fk_TB_SERVICO_CONTRATADO_AGENDAMENTO_DO_SERVIÇO1_idx (id_agendamento ASC),
  INDEX fk_TB_SERVICO_CONTRATADO_FORMA_DE_PAGAMENTO1_idx (id_forma_pagamento ASC),
  INDEX fk_TB_SERVICO_CONTRATADO_USUÁRIO1_idx (id_usuario ASC),
  INDEX fk_TB_SERVICO_CONTRATADO_PRESTADOR1_idx (id_prestador ASC),
  CONSTRAINT fk_TB_SERVICO_CONTRATADO_AGENDAMENTO_DO_SERVIÇO1
    FOREIGN KEY (id_agendamento)
    REFERENCES TB_AGENDAMENTO_DO_SERVIÇO (id_agendamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_TB_SERVICO_CONTRATADO_FORMA_DE_PAGAMENTO1
    FOREIGN KEY (id_forma_pagamento)
    REFERENCES TB_FORMA_DE_PAGAMENTO (id_forma_pagamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_TB_SERVICO_CONTRATADO_USUÁRIO1
    FOREIGN KEY (id_usuario)
    REFERENCES TB_USUÁRIO (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_TB_SERVICO_CONTRATADO_PRESTADOR1
    FOREIGN KEY (id_prestador)
    REFERENCES TB_PRESTADOR (id_prestador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);