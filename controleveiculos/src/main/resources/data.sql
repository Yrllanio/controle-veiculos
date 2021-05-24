INSERT INTO tb_usuario(nome,email,cpf,data_nascimento) VALUES ('José da Silva','jose@gmail.com','12345678901',TIMESTAMP WITH TIME ZONE '1987-07-13T20:50:07.12345Z');
INSERT INTO tb_usuario(nome,email,cpf,data_nascimento) VALUES ('Antonio Ferreira','antonio@gmail.com','14521478965',TIMESTAMP WITH TIME ZONE '1988-05-13T20:50:07.12345Z');
INSERT INTO tb_usuario(nome,email,cpf,data_nascimento) VALUES ('Ayrton Cavalcanti','ayrton@gmail.com','54874521478',TIMESTAMP WITH TIME ZONE '1977-06-13T20:50:07.12345Z');
INSERT INTO tb_usuario(nome,email,cpf,data_nascimento) VALUES ('Maria do Bairro','maria@gmail.com','88454785548',TIMESTAMP WITH TIME ZONE '1978-02-13T20:50:07.12345Z');
INSERT INTO tb_usuario(nome,email,cpf,data_nascimento) VALUES ('Jailson Fernandes','jailson@gmail.com','84579512348',TIMESTAMP WITH TIME ZONE '1967-04-13T20:50:07.12345Z');
INSERT INTO tb_usuario(nome,email,cpf,data_nascimento) VALUES ('Antonio Freitas','antoniofreitas@gmail.com','06547894521',TIMESTAMP WITH TIME ZONE '1982-01-13T20:50:07.12345Z');
INSERT INTO tb_usuario(nome,email,cpf,data_nascimento) VALUES ('Juliano Cabral','juliano@gmail.com','25124587932',TIMESTAMP WITH TIME ZONE '1957-12-13T20:50:07.12345Z');

INSERT INTO tb_veiculo(marca,modelo_do_veiculo,ano) VALUES ('Ford','New Fiesta','2016');
INSERT INTO tb_veiculo(marca,modelo_do_veiculo,ano) VALUES ('Fiat','Palio','2020');
INSERT INTO tb_veiculo(marca,modelo_do_veiculo,ano) VALUES ('Volkswagen','Gol','2019');
INSERT INTO tb_veiculo(marca,modelo_do_veiculo,ano) VALUES ('Renault','Logan','2014');
INSERT INTO tb_veiculo(marca,modelo_do_veiculo,ano) VALUES ('Ford','Eco Sport','2010');
INSERT INTO tb_veiculo(marca,modelo_do_veiculo,ano) VALUES ('Chevrolet','Camaro','2013');
INSERT INTO tb_veiculo(marca,modelo_do_veiculo,ano) VALUES ('Nissan','Versa','2015');

INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (1, 1);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (2, 2);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (3, 3);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (3, 4);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (1, 5);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (2, 7);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (6, 7);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (7, 6);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (1, 6);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (4, 3);
INSERT INTO tb_usuario_veiculo (usuario_id, veiculo_id) VALUES (5, 5);

