CREATE TABLE tb_usuario (
  id int NOT NULL AUTO_INCREMENT,
  nome_completo varchar(100) NOT NULL,
  email varchar(50) NOT NULL,
  senha varchar(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;