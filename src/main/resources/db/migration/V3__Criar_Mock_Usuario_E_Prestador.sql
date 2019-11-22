INSERT INTO TB_USUARIO(id_usuario, email, senha, nome_completo, imagem) VALUES (1, 'victor@victor.com', '12345678', 'Victor Victor Vitão', null);
INSERT INTO TB_ENDERECO(id_endereco,cep,cidade,uf,rua,bairro,numero,id_usuario) VALUES (1, 73803045, 'Formosa', 'GO', 'Avenida Circular', 'Abreu', 28, 1);
INSERT INTO TB_PRESTADOR(id_prestador,telefone,rg,cnpj,cpf,id_usuario,id_servico) VALUES (1, 61996232697, 5909277, null, 06016692158,1,1);

INSERT INTO TB_USUARIO(id_usuario, email, senha, nome_completo, imagem) VALUES (2, 'victor2@victor.com', '
', 'Victor Victor Vitão', null);
INSERT INTO TB_ENDERECO(id_endereco,cep,cidade,uf,rua,bairro,numero,id_usuario) VALUES (2, 73803045, 'Formosa', 'GO', 'Avenida Circular', 'Abreu', 28, 2);