INSERT INTO sebo_virtual.Usuario (email, senha, habilitado, autoridade)
VALUES 
("juliana@gmail.com", "$2a$10$SDkaAdM62IwQ28ELm8AUQOsomkO1h8apJrXFG5/plC2XujQofW1Iu", "1", "USUARIO"),
("vanderson@gmail.com", "$2a$10$SDkaAdM62IwQ28ELm8AUQOsomkO1h8apJrXFG5/plC2XujQofW1Iu", "1", "USUARIO"),
("guilherme@gmail.com", "$2a$10$SDkaAdM62IwQ28ELm8AUQOsomkO1h8apJrXFG5/plC2XujQofW1Iu", "1", "USUARIO");

INSERT INTO sebo_virtual.Pessoa_Fisica (id, nome, sobrenome, data_nascimento, cpf, sexo)
VALUES 
((SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), "Juliana", "Aquino", "1981-06-01", "532.533.684-32", "F"),
((SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), "Vanderson", "Sander", "1982-10-08", "913.646.577-16", "M"),
((SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), "Guilherme", "Nunes", "1985-12-15", "313.514.618-93", "M");

INSERT INTO sebo_virtual.Status (nome)
VALUES 
("Ativo"),
("Editado"),
("Excluido");

INSERT INTO sebo_virtual.Tipo_Metodo_Pagamento (nome)
VALUES 
("Paypal"),
("Pagseguro");

INSERT INTO sebo_virtual.Historico_Metodo_Pagamento (id_metodo_pagamento, email, 
data_modificacao, fk_id_tipo_metodo_pag, fk_id_status, fk_id_usuario)
VALUES 
("1", "juliana@gmail.com", now(), "1", "1", "1"),
("2", "juliana@gmail.com", now(), "1", "1", "1");

INSERT INTO sebo_virtual.Historico_Endereco (id_endereco, nome_destinatario, 
cep, logradouro, numero, complemento, bairro, cidade, estado, apelido,
data_modificacao, fk_id_status, fk_id_usuario)
VALUES 
("1", "Juliana Aquino", "22431-004", "Avenida Bartolomeu Mitre", "990",
"Apto 410", "Leblon", "Rio de Janeiro", "RJ", "Apartamento", now(), "1", "1");

INSERT INTO sebo_virtual.Telefone (ddi, ddd, numero, tipo, fk_id_usuario)
VALUES ("55", "21", "980228740", "celular", "1"),
	   ("55", "21", "39888740", "contato", "1"),
       ("55", "11", "945418250", "celular", "2"),
       ("55", "11", "967305807", "celular", "2");

INSERT INTO sebo_virtual.Marca (nome)
VALUES ("Sony"),
("Wii"),
("Super Nitendo"),
("Atari");

INSERT INTO sebo_virtual.Subcategoria (nome)
VALUES ("Vitrola"),
("Console"),
("Cartucho"),
("Toca-disco");

INSERT INTO sebo_virtual.Formato_Midia (nome)
VALUES ("CD"),
("DVD"),
("Disco de Vinil");

INSERT INTO sebo_virtual.Gravadora (nome)
VALUES ("Sony Music"),
("Universal Music"),
("AB Records"),
("Arsenal Music"),
("Warner Music");

INSERT INTO sebo_virtual.Genero (nome)
VALUES ("Musical"),
("Terror"),
("Romance"),
("Documentário"),
("Suspense");

INSERT INTO sebo_virtual.Legenda (nome)
VALUES ("Português"),
("Inglês"),
("Francês"),
("Espanhol"),
("Alemão");

INSERT INTO sebo_virtual.Idioma (nome)
VALUES ("Português"),
("Inglês"),
("Francês"),
("Espanhol"),
("Alemão");

INSERT INTO sebo_virtual.Condicao (descricao)
VALUES ("Usado"),
("Seminovo"),
("Novo");

INSERT INTO `sebo_virtual`.`Produto` (`titulo`) VALUES 
('A Festa'),
('Flores');

INSERT INTO `sebo_virtual`.`Midia` (`id`,`quantidade_midias`, `ano`, `quantidade_faixas`, `tempo_execucao`, `artista`, `fk_id_gravadora`, `fk_id_formato_midia`, `fk_id_idioma`, `fk_id_genero`) 
VALUES 
((SELECT id from sebo_virtual.Produto WHERE titulo='A Festa'),'1', '2019-01-01', '12', '00:01:30', 'Ivete Sangalo', '1', '1', '1', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Flores'),'1', '2020-01-01', '10', '00:01:25', 'Ivete Sangalo', '1', '1', '1', '1');

INSERT INTO `sebo_virtual`.`Midia_tem_Legenda` (`fk_id_produto`, `fk_id_legenda`) 
VALUES 
('1', '1'),
('1', '2'),
('2', '1'),
('2', '2');

INSERT INTO `sebo_virtual`.`Historico_Anuncio` (`id_anuncio`, `estoque`, `titulo`, 
`descricao`, `preco`, `data_modificacao`, `fk_id_usuario`, `fk_id_condicao`, 
`fk_id_produto`, `fk_id_status`) 
VALUES 
('1', '10', 'Promoção Imperdível! CD A Festa da Ivete!!!', 
'1 cd da Ivete Sangalo, A Festa, por R$ 24', '24', '2020-11-04 02:38:35', '1', '1', 
'1', '1'),
('2', '5', 'CD Flores da Ivete!!!', 
'1 cd da Ivete Sangalopor R$ 28', '28', '2020-11-04 02:38:35', '1', '1', 
'1', '1');

INSERT INTO `sebo_virtual`.`Motivo_Devolucao` (`descricao`)
VALUES
('Chegou depois do prazo'),
('Comprado por engano'),
('Diferente do que foi pedido'),
('Diferente da descrição do site'),
('Está com defeito ou não funciona'),
('Não é mais necessário'),
('Não desejo informar o motivo'),
('Produto danificado');
