INSERT INTO sebo_virtual.Usuario (email, senha, habilitado, autoridade)
VALUES 
("juliana@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO"),
("vanderson@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO"),
("guilherme@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO");

INSERT INTO sebo_virtual.Pessoa_Fisica (id, nome, sobrenome, data_nascimento, cpf, sexo)
VALUES 
((SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), "Juliana", "Aquino", "1981-06-01", "532.533.684-32", "F"),
((SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), "Vanderson", "Sander", "1982-10-08", "913.646.577-16", "M"),
((SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), "Guilherme", "Nunes", "1985-12-15", "313.514.618-93", "M");

INSERT INTO sebo_virtual.Status (nome)
VALUES 
("ativo"),
("editado"),
("excluido");

INSERT INTO sebo_virtual.Tipo_Metodo_Pagamento (nome)
VALUES 
("Paypal"),
("Pagseguro");

INSERT INTO sebo_virtual.Historico_Metodo_Pagamento (id_metodo_pagamento, email, 
data_modificacao, fk_id_tipo_metodo_pag, fk_id_status, fk_id_usuario)
VALUES 
("1", "juliana@gmail.com", now(), "1", "1", "1"),
("2", "juliana@gmail.com", now(), "1", "1", "1"),
("1", "vanderson@gmail.com", now(), "1", "1", "2"),
("2", "vanderson@gmail.com", now(), "1", "1", "2"),
("1", "guilherme@gmail.com", now(), "1", "1", "3"),
("2", "guilherme@gmail.com", now(), "1", "1", "3");

INSERT INTO sebo_virtual.Historico_Endereco (id_endereco, nome_destinatario, 
cep, logradouro, numero, complemento, bairro, cidade, estado, apelido,
data_modificacao, fk_id_status, fk_id_usuario, principal)
VALUES 
("1", "Juliana Aquino", "22431-004", "Avenida Bartolomeu Mitre", "990",
"Apto 410", "Leblon", "Rio de Janeiro", "RJ", "Apartamento", now(), "1", "1", 1),
("1", "Efigênia Aquino", "60532-620", "Rua 1004", "146",
"4a etapa", "Conjunto Ceará", "Fortaleza", "CE", "Casa da Mãe", now(), "1", "1", 0),
("1", "Francisca Viana", "60710-570", "Rua Dinamarca", "450",
"", "Parangaba", "Fortaleza", "CE", "Casa da Sogra", now(), "1", "1", 0);

INSERT INTO sebo_virtual.Telefone (ddi, ddd, numero, tipo, fk_id_usuario)
VALUES ("55", "21", "980228740", "celular", "1"),
	   ("55", "21", "39888740", "contato", "1"),
       ("55", "11", "945418250", "contato", "2"),
       ("55", "11", "945418250", "celular", "2");

INSERT INTO sebo_virtual.Marca (nome)
VALUES ("Sony"),
("Wii"),
("Super Nintendo"),
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
("Suspense"),
("Ficção");

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

#Cadastro de Produtos
INSERT INTO `sebo_virtual`.`Produto` (`titulo`, `categoria`) VALUES 
#CD's
('A Festa', 'cd'),
('Flores', 'cd'),
#Livros
('A Mão e a Luva', 'livro'),
('A Metamorfose', 'livro'),
('As Armas da Persuassão', 'livro'),
('Clean Code', 'livro'),
('Contos da Meia Noite', 'livro'),
('Dom Casmurro', 'livro'),
('Esaú e Jacó', 'livro'),
('Helena', 'livro'),
('Histórias da Meia Noite', 'livro'),
('Laranja Mecânica', 'livro'),
('Marley e Eu', 'livro'),
('Memorial de Aires', 'livro'),
('Memórias Póstumas de Brás Cubas', 'livro'),
('Do Mil ao Milhão', 'livro'),
('Mindset', 'livro'),
('Quem Mexeu no Meu Queijo', 'livro'),
('Quincas Borba', 'livro'),
('Senhora', 'livro'),
('Vidas Secas', 'livro'),
#Eletrônicos
('Super Nintendo', 'eletronico'),
#Discos
('Tim Maia', 'disco'),
('Trash in Texas', 'disco'),
('Elvis Presley', 'disco'),
('Evil Empire', 'disco'),
('Hillbilly Rawhide', 'disco'),
('Isso é Amor', 'disco'),
('Kiss', 'disco'),
('Mickey', 'disco'),
('Red Hot Mothers Milk', 'disco'),
('Some People Have Real Problems', 'disco'),
('Twist Uptown The Crystals', 'disco');

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

#Editoras
INSERT INTO `editora`
(`nome`)
VALUES
('Virtude Livros'),
('Nova Aguilar'),
('Record'),
('HarperCollins Bis');

#Formato Publicação
INSERT INTO `formato_publicacao`
(`nome`)
VALUES
('livro'),
('quadrinho');

#Publicações
INSERT INTO `publicacao`
(`id`, `ano`, `quantidade_paginas`, `tipo_capa`, `isbn10`, `isbn13`,
`fk_id_editora`, `fk_id_formato_publicacao`, `fk_id_idioma`, `fk_id_genero`)
VALUES
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'A Mão e a Luva'),
  '1874-01-01', 145, 'comum', '', '', 1, 1, 1, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'A Metamorfose'),
  '1915-01-01', 44, 'comum', '', '', 1, 1, 1, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'As Armas da Persuassão'),
  '2012-01-01', 304, 'comum', '', '', 1, 1, 1, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Clean Code'),
  '2008-01-01', 464, 'comum', '', '', 1, 1, 2, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Contos da Meia Noite'),
  '2020-01-01', 85, 'comum', '', '', 4, 1, 1, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Dom Casmurro'),
  '1873-01-01', 223, 'comum', '', '', 2, 1, 1, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Esaú e Jacó'),
  '1904-01-01', 296, 'comum', '', '', 2, 1, 1, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Helena'),
  '1876-01-01', 219, 'comum', '', '', 2, 1, 1, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Histórias da Meia Noite'),
  '1873-01-01', 325, 'comum', '', '', 2, 1, 1, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Laranja Mecânica'),
  '1970-01-01', 288, 'dura', '', '', 3, 1, 1, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Marley e Eu'),
  '2005-01-01', 317, 'dura', '', '', 3, 1, 1, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Memorial de Aires'),
  '1908-01-01', 245, 'comum', '', '', 3, 1, 1, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Memórias Póstumas de Brás Cubas'),
  '1881-01-01', 215, 'comum', '', '', 3, 1, 1, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Do Mil ao Milhão'),
  '2018-01-01', 192, 'comum', '', '', 4, 1, 1, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Mindset'),
  '2017-01-01', 312, 'comum', '', '', 4, 1, 1, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Quem Mexeu no Meu Queijo'),
  '2017-01-01', 112, 'comum', '', '', 4, 1, 1, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Quincas Borba'), 
  '1886-01-01', 256, 'comum', '', '', 4, 1, 1, 6),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Senhora'),
  '1875-01-01', 132, 'comum', '', '', 3, 1, 1, 6),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Vidas Secas'),
  '1938-01-01', 117, 'comum', '', '', 2, 1, 1, 6);

INSERT INTO `sebo_virtual`.`Historico_Anuncio` (`id_anuncio`, `estoque`, `titulo`, 
`descricao`, `preco`, `data_modificacao`, `fk_id_usuario`, `fk_id_condicao`, 
`fk_id_produto`, `fk_id_status`) 
VALUES 
('1', '10', 'Promoção Imperdível! CD A Festa da Ivete!!!', 
'1 cd da Ivete Sangalo, A Festa, por R$ 24', '24', '2020-11-04 02:38:35', '1', '1', 
'1', '1'),
('2', '5', 'CD Flores da Ivete!!!', 
'1 cd da Ivete Sangalopor R$ 28', '28', '2020-11-04 02:38:35', '1', '1', 
'1', '1'),
#Livros
(3, 12, 'A Mão e a Luva', 'Bom estado de conservação', 20.8,
  '2020-11-9', 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'A Mão e a Luva'), 1),
(4, 14, 'A Metamorfose', 'descricao', 12.8,
  '2020-11-9', 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'A Metamorfose'), 1),
(5, 16, 'As Armas da Persuassão', 'descricao', 23.5,
  '2020-11-9', 1, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'As Armas da Persuassão'), 1),
(6, 18, 'Clean Code', 'descricao', 88.2,
  '2020-11-9', 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Clean Code'), 1),
(7, 20, 'Contos da Meia Noite', 'descricao', 11.9, 
  '2020-11-9', 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Contos da Meia Noite'), 1),
(8, 25, 'Dom Casmurro', 'descricao', 11.9,
  '2020-11-9', 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Dom Casmurro'), 1),
(9, 30, 'Esaú e Jacó', 'descricao', 11.9,
  '2020-11-9', 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Esaú e Jacó'), 1),
(10, 27, 'Helena', 'descricao', 13.5,
  '2020-11-9', 2, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Helena'), 1),
(11, 23, 'Histórias da Meia Noite', 'Seminovo, lacrado!', 21.3,
  '2020-11-9', 2, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Histórias da Meia Noite'), 1),
(12, 23, 'Laranja Mecânica', 'descricao', 33.4,
  '2020-11-9', 2, 3,
  (SELECT id FROM `Produto` WHERE titulo = 'Laranja Mecânica'), 1),
(13, 23, 'Marley e Eu', 'descricao', 40.2,
  '2020-11-9', 2, 3,
  (SELECT id FROM `Produto` WHERE titulo = 'Marley e Eu'), 1),
(14, 33, 'Memorial de Aires', 'descricao', 12.5,
  '2020-11-9', 2, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Memorial de Aires'), 1),
(15, 35, 'Memórias Póstumas de Brás Cubas', 'descricao', 9.5,
  '2020-11-9', 2, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Memórias Póstumas de Brás Cubas'), 1),
(16, 10, 'Do Mil ao Milhão - Sem cortar o cafezinho', 'descricao', 18.5,
  '2020-11-9', 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Do Mil ao Milhão'), 1),
(17, 28, 'Mindset', 'descricao', 40.2,
  '2020-11-9', 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Mindset'), 1),
(18, 26, 'Quem Mexeu no Meu Queijo', 'descricao', 23.4,
  '2020-11-9', 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Quem Mexeu no Meu Queijo'), 1),
(19, 29, 'Quincas Borba', 'Livro possui algumas dobras e amassados', 4.3,
  '2020-11-9', 3, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Quincas Borba'), 1),
(20, 9, 'Senhora', 'Em ótimo estado de conservação', 10.5,
  '2020-11-9', 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Senhora'), 1),
(21, 25, 'Vidas Secas', 'Edição especial autografada, para colecionadores', 152.5,
  '2020-11-9', 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Vidas Secas'), 1);
  
#Autores
INSERT INTO `Autor`
(`nome`, `sobrenome`)
VALUE
('Machado', 'de Assis'),
('Graciliano', 'Ramos'),
('José', 'de Alencar'),
('Thiago', 'Nigro'),
('Spencer', 'Johnson'),
('Carol', 'Dweck'),
('John', 'Grogan'),
('Anthony', 'Burgess'),
('Samuel', 'Marcos Miranda'),
('Robert', 'C. Martin'),
('Robert', 'B. Cialdini'),
('Franz', 'Kafka');

#Autores e Publicações
INSERT INTO `Publicacao_Tem_Autor`
(`fk_id_produto`, `fk_id_autor`)
VALUES
(
  (SELECT id FROM `Produto` WHERE titulo = 'A Mão e a Luva'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'A Metamorfose'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Histórias da Meia Noite'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Dom Casmurro'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Esaú e Jacó'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Helena'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Memorial de Aires'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Memórias Póstumas de Brás Cubas'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Quincas Borba'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Senhora'),
  (SELECT id FROM `Autor` WHERE nome = 'Machado' and sobrenome = 'de Assis')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Do Mil ao Milhão'),
  (SELECT id FROM `Autor` WHERE nome = 'Thiago' and sobrenome = 'Nigro')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Quem Mexeu no Meu Queijo'),
  (SELECT id FROM `Autor` WHERE nome = 'Spencer' and sobrenome = 'Johnson')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Mindset'),
  (SELECT id FROM `Autor` WHERE nome = 'Carol' and sobrenome = 'Dweck')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Marley e Eu'),
  (SELECT id FROM `Autor` WHERE nome = 'John' and sobrenome = 'Grogan')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Laranja Mecânica'),
  (SELECT id FROM `Autor` WHERE nome = 'Anthony' and sobrenome = 'Burgess')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Contos da Meia Noite'),
  (SELECT id FROM `Autor` WHERE nome = 'Samuel' and sobrenome = 'Marcos Miranda')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Clean Code'),
  (SELECT id FROM `Autor` WHERE nome = 'Robert' and sobrenome = 'C. Martin')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'As Armas da Persuassão'),
  (SELECT id FROM `Autor` WHERE nome = 'Robert' and sobrenome = 'B. Cialdini')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Vidas Secas'),
  (SELECT id FROM `Autor` WHERE nome = 'Graciliano' and sobrenome = 'Ramos')
);

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

INSERT INTO `sebo_virtual`.`Avaliacao` (`nota_descricao`, `nota_rapidez_envio`, `nota_embalagem`, `comentarios`, `anonimo`, `fk_id_usuario`)
VALUES 	
('6', '10', '8', 'Muito boa a entrega', '1', '1'),
('2', '5', '4', 'Péssima entrega', '1', '2'),
('5', '7', '6', 'Entrega razoável', '1', '3');

INSERT INTO `sebo_virtual`.`Fale_Conosco` (`nome`, `email`, `fk_id_usuario`, `fk_id_telefone`)
VALUES 	
('Juliana', 'juliana@gmail.com', 1, 1),
('Vanderson', 'vanderson@gmail.com', 1, 1),
('Guilherme', 'guilherme@gmail.com', 1, 1);

INSERT INTO `sebo_virtual`.`Pedido` (`data`, `valor_total`, `status`, `id_avaliacao`, `fk_id_usuario`, `fk_id_metodo_de_pagamento`, `fk_id_endereco`)
VALUES
(now(), '500.0', 'Enviado', 1, 1, 1, 1),
(now(), '100.0', 'Cancelado', 2, 2, 2, 1),
(now(), '1200.0', 'Pendente', 3, 3, 2, 1);