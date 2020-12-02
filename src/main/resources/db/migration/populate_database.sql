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
("2", "Efigênia Aquino", "60532-620", "Rua 1004", "999",
"4a etapa", "Conjunto Ceará", "Fortaleza", "CE", "Casa da Mãe", now(), "1", "1", 0),
("3", "Francisca Viana", "60710-570", "Rua Dinamarca", "1000",
"", "Parangaba", "Fortaleza", "CE", "Sogra", now(), "1", "1", 0),
("1", "Vanderson Sander", "04116-040", "Rua Domingos Soto", "1000",
"", "Jardim Vila Mariana", "São Paulo", "SP", "Casa", now(), "1", "2", 1),
("2", "Vanderson Sander", "05409-010", "Rua Oscar Freire", "1291",
"", "Pinheiros", "São Paulo", "SP", "Casa dos Avós", now(), "1", "2", 0),
("1", "Guilherme Nunes", "01310-932", "Avenida Paulista", "2202",
"", "Bela Vista", "São Paulo", "SP", "Casa dos Avós", now(), "1", "3", 1);

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
VALUES 
("Administração"),
("Autoajuda"),
("Heróis"),
("Literatura"),
("Policial"),
("Romance"),
("Suspense"),
("Ficção"),
("Outro");

INSERT INTO sebo_virtual.Legenda (nome)
VALUES ("Português"),
("Inglês"),
("Francês"),
("Espanhol"),
("Alemão");

INSERT INTO sebo_virtual.Idioma (nome)
VALUES 
("Alemão"),
("Espanhol"),
("Francês"),
("Inglês"),
("Português"),
("Outro");

INSERT INTO sebo_virtual.Condicao (descricao)
VALUES 
("Novo"),
("Seminovo"),
("Usado");

#Cadastro de Produtos
INSERT INTO `sebo_virtual`.`Produto` (`titulo`, `categoria`) VALUES 
#CD's
('O carnaval', 'cd'),
('The Wonder Of You', 'cd'),
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
('O Guarani', 'livro'),
('Iracema', 'livro'),
('O Quinze', 'livro'),
('Til', 'livro'),
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
((SELECT id from sebo_virtual.Produto WHERE titulo='O Carnaval'),'1', '2019-01-01', '12', '00:01:30', 'Ivete Sangalo', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='The Wonder Of You'),'1', '2020-01-01', '10', '00:01:25', 'Elvis Presley', '1', '1', '5', '1');

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
('HarperCollins Bis'),
('Panda Books'),
('Martin Claret'),
('José Olympio');

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
  '1874', 145, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'A Metamorfose'),
  '1915', 44, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'As Armas da Persuassão'),
  '2012', 304, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Clean Code'),
  '2008', 464, 'comum', '', '', 1, 1, 4, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Contos da Meia Noite'),
  '2020', 85, 'comum', '', '', 4, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Dom Casmurro'),
  '1873', 223, 'comum', '', '', 2, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Esaú e Jacó'),
  '1904', 296, 'comum', '', '', 2, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Helena'),
  '1876', 219, 'comum', '', '', 2, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Histórias da Meia Noite'),
  '1873', 325, 'comum', '', '', 2, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Laranja Mecânica'),
  '1970', 288, 'dura', '', '', 3, 1, 5, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Marley e Eu'),
  '2005', 317, 'dura', '', '', 3, 1, 5, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Memorial de Aires'),
  '1908', 245, 'comum', '', '', 3, 1, 5, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Memórias Póstumas de Brás Cubas'),
  '1881', 215, 'comum', '', '', 3, 1, 5, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Do Mil ao Milhão'),
  '2018', 192, 'comum', '', '', 4, 1, 5, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Mindset'),
  '2017', 312, 'comum', '', '', 4, 1, 5, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Quem Mexeu no Meu Queijo'),
  '2017', 112, 'comum', '', '', 4, 1, 5, 5),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Quincas Borba'), 
  '1886', 256, 'comum', '', '', 4, 1, 5, 6),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Senhora'),
  '1875', 132, 'comum', '', '', 3, 1, 5, 6),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Vidas Secas'),
  '1938', 117, 'comum', '', '', 2, 1, 5, 6);
  
INSERT INTO `publicacao`
(`id`, `ano`, `quantidade_paginas`, `tipo_capa`, `isbn10`, `isbn13`,
`fk_id_editora`, `fk_id_formato_publicacao`, `fk_id_idioma`, `fk_id_genero`, resumo)
VALUES
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'O Guarani'),
  '2012', 380, 'comum', '8572323384', '9788572323383', 
  (SELECT id FROM Editora WHERE nome='Panda Books'), 1, 5, 6,
  'Publicado em 1865, Iracema é um dos textos fundamentais da cultura brasileira. Parte da trilogia indianista de José de Alencar (O guarani e Ubirajara são os outros livros), o romance guarda a multiplicidade dos clássicos: sua prosa é poética, seu tratamento da matéria é mítico, seu ar é de epopeia. Livro que durante muitos anos resumiu o éthos brasileiro nas letras, ainda hoje oferece muitos caminhos de interpretação na crítica literária, na historiografia, nos estudos culturais e de gênero. A história do amor de Iracema, a “virgem dos lábios de mel”, com Martim é a metáfora romântica do encontro entre a civilização e a cultura autóctone. Valorizando a paisagem brasileira e construindo um passado idealizado, José de Alencar criou um mito que perdura até hoje.'),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Iracema'),
  '2015', 168, 'comum', '8578885252', '9788578885250', 
  (SELECT id FROM Editora WHERE nome='Martin Claret'), 1, 5, 6,
  'O guarani – um dos romances mais importantes de José de Alencar – foi uma das primeiras obras criadas com o objetivo de fundar uma literatura brasileira autônoma em relação à tradição portuguesa. Foi inicialmente publicada em forma de folhetim, em meados de 1857, concedendo grande popularidade a Alencar. Quando, no final do mesmo ano, foi transformado em livro, sofreu pequenas modificações. Em meio à história de amor entre o índio Peri e a moça branca Ceci, José de Alencar cria uma narrativa épica, cheia de amor, aventura, traição, lutas e vingança, prendendo a atenção do leitor a cada nova página. O romance proclama a brasilidade, focando importantes aspectos da realidade brasileira do século XVII: o índio e o branco; a cidade e o campo; o sertão e o litoral.'),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'O Quinze'),
  '2012', 208, 'comum', '8503012928', '9788503012928', 
  (SELECT id FROM Editora WHERE nome='Panda Books'), 1, 5, 6,
  'Lançado originalmente em 1930, em edição financiada pela própria autora, O Quinze é o romance de estreia da aclamada escritora cearense Rachel de Queiroz. Gerou grande impacto na época não apenas por sua força narrativa, mas também pelo fato de ter sido escrito por uma mulher de apenas 20 anos de idade.  Ao narrar as histórias de Conceição, Vicente e a saga do vaqueiro Chico Bento e sua família, Rachel de Queiroz, imortal da Academia Brasileira de Letras,  expõe de maneira única e original o drama causado pela histórica seca de 1915, que assolou o Nordeste brasileiro.  O Quinze expressa uma questão atual: o duelo entre o homem e a terra. A história da seca nordestina, as expectativas e as angústias que ela provocou são aqui retratadas com simplicidade e força.'),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Til'),
  '2012', 264, 'comum', '8572328432', '9788572328432', 
  (SELECT id FROM Editora WHERE nome='Martin Claret'), 1, 5, 6,
  'Publicada pela primeira vez em 1872, Til pertence, ao lado de O gaúcho, O sertanejo e O tronco do Ipê, ao regionalismo de José de Alencar e retrata o interior paulista. Nesse romance, a idealização da natureza, a narrativa leve e o subjetivismo da linguagem criam uma atmosfera suave, em que a inocência dos personagens centrais contrasta com a trama emaranhada e sanguinolenta. A beleza da natureza, tão valorizada e enaltecida pelos contemporâneos de Alencar, divide lugar com a brutalidade da realidade regional. Til é o apelido de Berta, moça “pequena, esbelta, ligeira, buliçosa” que se envolve nas mais intricadas tramas, sempre buscando ajudar os que precisam. Trata-se do ideal de heroína: doce, meiga, caridosa, mas também de coragem e impetuosidade únicas na literatura brasileira. Capaz de enfrentar jagunços, Berta não mede esforços ao buscar a realização de seus intentos. Violências, mistérios e triângulos amorosos constituem esta complicada e bela história.');

INSERT INTO `sebo_virtual`.`Historico_Anuncio` (`id_anuncio`, `estoque`, `titulo`, 
`descricao`, `preco`, `data_modificacao`, `fk_id_usuario`, `fk_id_condicao`, 
`fk_id_produto`, `fk_id_status`) 
VALUES 
('1', '10', 'Promoção! CD O Carnaval de Ivete!!!', '1 cd da Ivete Sangalo', '24', 
  ('2020-11-01' + INTERVAL 1 DAY_MINUTE), '1', '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'O Carnaval'), '1'), #1
('1', '5', 'CD The Wonder Of You', '1 cd do Elvis Presley - The Wonder Of You', '28', 
  ('2020-11-02' + INTERVAL 1 DAY_MINUTE), '1', '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'The Wonder Of You'), '1'), #2
#Livros
(3, 12, 'A Mão e a Luva', 'Bom estado de conservação', 20.8, 
  ('2020-11-03' + INTERVAL 1 DAY_MINUTE), 1, 1, 
  (SELECT id FROM `Produto` WHERE titulo = 'A Mão e a Luva'), 1), #3
(4, 14, 'A Metamorfose', 'descricao', 12.8, 
  ('2020-11-04' + INTERVAL 1 DAY_MINUTE), 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'A Metamorfose'), 1), #4
(5, 16, 'As Armas da Persuassão', 'descricao', 23.5,
  ('2020-11-05' + INTERVAL 1 DAY_MINUTE), 1, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'As Armas da Persuassão'), 1), #%
(6, 18, 'Clean Code', 'descricao', 88.2,
  ('2020-11-06' + INTERVAL 1 DAY_MINUTE), 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Clean Code'), 1), #6
(7, 20, 'Contos da Meia Noite', 'descricao', 11.9, 
  ('2020-11-07' + INTERVAL 1 DAY_MINUTE), 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Contos da Meia Noite'), 1), #7
(8, 25, 'Dom Casmurro', 'descricao', 11.9,
  ('2020-11-08' + INTERVAL 1 DAY_MINUTE), 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Dom Casmurro'), 1), #8
(9, 30, 'Esaú e Jacó', 'descricao', 11.9,
  ('2020-11-09' + INTERVAL 1 DAY_MINUTE), 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Esaú e Jacó'), 1), #9
(10, 27, 'Helena', 'descricao', 13.5,
  ('2020-11-10' + INTERVAL 1 DAY_MINUTE), 2, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Helena'), 1), #10
(11, 23, 'Histórias da Meia Noite', 'Seminovo, lacrado!', 21.3,
  ('2020-11-11' + INTERVAL 1 DAY_MINUTE), 2, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Histórias da Meia Noite'), 1), #11
(12, 23, 'Laranja Mecânica', 'descricao', 33.4,
  ('2020-11-12' + INTERVAL 1 DAY_MINUTE), 2, 3,
  (SELECT id FROM `Produto` WHERE titulo = 'Laranja Mecânica'), 1), #12
(13, 23, 'Marley e Eu', 'descricao', 40.2,
  ('2020-11-13' + INTERVAL 1 DAY_MINUTE), 2, 3,
  (SELECT id FROM `Produto` WHERE titulo = 'Marley e Eu'), 1), #13
(14, 33, 'Memorial de Aires', 'descricao', 12.5,
  ('2020-11-14' + INTERVAL 1 DAY_MINUTE), 2, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Memorial de Aires'), 1), #14
(15, 35, 'Memórias Póstumas de Brás Cubas', 'descricao', 9.5,
  ('2020-11-15' + INTERVAL 1 DAY_MINUTE), 2, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Memórias Póstumas de Brás Cubas'), 1), #15
(16, 10, 'Do Mil ao Milhão - Sem cortar o cafezinho', 'descricao', 18.5,
  ('2020-11-16' + INTERVAL 1 DAY_MINUTE), 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Do Mil ao Milhão'), 1), #16
(17, 28, 'Mindset', 'descricao', 40.2,
  ('2020-11-17' + INTERVAL 1 DAY_MINUTE), 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Mindset'), 1), #17
(18, 26, 'Quem Mexeu no Meu Queijo', 'descricao', 23.4,
  ('2020-11-18' + INTERVAL 1 DAY_MINUTE), 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Quem Mexeu no Meu Queijo'), 1), #18
(19, 29, 'Quincas Borba', 'Livro possui algumas dobras e amassados', 4.3,
  ('2020-11-19' + INTERVAL 1 DAY_MINUTE), 3, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Quincas Borba'), 1), #19
(20, 9, 'Senhora', 'Em ótimo estado de conservação', 10.5,
  ('2020-11-20' + INTERVAL 1 DAY_MINUTE), 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Senhora'), 1), #20
(21, 25, 'Vidas Secas', 'Edição especial autografada, para colecionadores', 152.5,
  ('2020-11-21' + INTERVAL 1 DAY_MINUTE), 3, 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Vidas Secas'), 1), #21,
(22, 10, 'Iracema', 'Edição especial autografada, para colecionadores', 22.9,
  ('2020-11-22' + INTERVAL 1 DAY_MINUTE), 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Iracema'), 1), #22
(23, 11, 'O Guarani', 'Edição especial autografada, para colecionadores', 15.9,
  ('2020-11-23' + INTERVAL 1 DAY_MINUTE), 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'O Guarani'), 1), #23
(24, 5, 'O Quinze', 'Edição especial autografada, para colecionadores', 21.9,
  ('2020-11-24' + INTERVAL 1 DAY_MINUTE), 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'O Quinze'), 1), #24
(25, 2, 'Promoção Til', 'Edição especial autografada, para colecionadores', 21.9,
  ('2020-11-25' + INTERVAL 1 DAY_MINUTE), 1, 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Til'), 1); #25
  
INSERT INTO `sebo_virtual`.`Imagem` (`url`, `fk_id_anuncio`) 
VALUES 
('1A0k3KYSoTSS9w3+7ce0PEPNQA==.jpg', '1'), #A Festa
('NZlrNA4NQISXqTbw+QK2kf6IFg==.jpg', '2'), #Flores
('eQ6wA92kZxK0mDcJl8VtGSzbzow=.jpg', '3'), #A Mão e a Luva
('KFbug0vDdtXk9xlu0qiH7mjpag==.png', '4'), #A Metamorfose
('3T4f2ngJkJMYrqJkkT7byp14yg==.jpg', '5'), #As Armas da Persuassão
('Yk2oOY8XkkQ7m8tRR2LoNzrVfg==.png', '6'), #Clean Code
('4CJPGbQdL9JDTpScp0W4nV0=.jpg', '7'), #Contos da Meia Noite
('9mBIY3J44AbZMJvACiIDqQZsOBg=.jpg', '8'), #Dom Casmurro
('5Uz3tu0W14sMaKWBxa5iRsD0oKk=.jpg', '9'), #Esaú e Jacob - ok
('TKSKv91J9bsjkmRfJeAilc4=.jpg', '10'), #Helena
('vkCvHV2D1W93aht6C0TMKS47hUk=.jpg', '11'), #História da Meia Noite
('7KYhUCt3JKMtQKi3BWn0CyYG6A==.png', '12'), #Laranja Mecânica
('OjGu7i6fiPWWWcewUx0gGM4HmLg=.png', '13'), #Marley & Eu
('y1NsS7lq43JFEMaX6qXL8bvnSQ==.jpg', '14'), #Memorial de Aires
('y1NsS7lq43JFEMaX6qXL8bvnSQ2==.jpg', '15'), #Memórias Póstumas de Brás Cubas
('09rtHgZ7Vs9HWfcY5iBkWyH01g==.png', '16'), #Do Mil ao Milhão
('dqtvleT4Nq3ahly4NHZ8SMhlCg==.png', '17'), #Mindset
('4z9bAoUUltVUfAwtbj98wxVG.png', '18'), #Quem Mexeu no Meu Queijo?
('RwzBvGQaqQ7Bhz0H5xMeSDGl0Q==.jpg', '19'), #Quincas Borba
('dqOb5ol7Wdtk+frTtc6tLsG91bM=.png', '20'), #Senhora
('mfwsqbCBMNuUbNg2vUf0j8gz0g==.png', '21'), #Vidas Secas
('XbhLBgyy098tWRidCTukgUqrhw==.jpg', '22'), #Iracema
('blwnE85rFLBGD0lC5Dirku4FJdY=.jpg', '23'), #O Guarani
('wwutZup0AsfrQ3ysoWWSjvYPYg==.jpg', '24'), #O Quinze
('3bKHi21970dnHLoXkcrWLW9PnoA=.jpg', '25'); #Til

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
('de Alencar', 'José'),
('de Queiroz', 'Rachel');

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
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'O Guarani'),
  (SELECT id FROM `Autor` WHERE nome = 'de Alencar' and sobrenome = 'José')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Iracema'),
  (SELECT id FROM `Autor` WHERE nome = 'de Alencar' and sobrenome = 'José')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'O Quinze'),
  (SELECT id FROM `Autor` WHERE nome = 'de Queiroz' and sobrenome = 'Rachel')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Til'),
  (SELECT id FROM `Autor` WHERE nome = 'de Alencar' and sobrenome = 'José')
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

INSERT INTO `sebo_virtual`.`Pedido` (`data`, `valor_total`, `status`, `data_status`, `id_avaliacao`, `fk_id_usuario`, `fk_id_metodo_de_pagamento`, `fk_id_endereco`)
VALUES
# Pedido que o usuário 1 fez
('2020-01-01', '23.5', 'Entregue', '2020-01-05', 1, 1, 1, 1),     #R$ 13.5 + 10 (frete)
('2020-05-02', '31.3', 'Entregue', '2020-05-05', null, 1, 1, 2),  # R$ 21.3 + 10 (frete)
('2020-06-07', '33.4', 'Cancelado', '2020-06-07', null, 1, 2, 3), #frete grátis
('2020-08-27', '52.7', 'Entregue', '2020-08-31', null, 1, 2, 1),  #frete grátis
('2020-11-01', '19.5', 'Cancelado', '2020-11-01', null, 1, 1, 2),               #R$ 9.5 + 10 (frete)
(now(), '98.9', 'Confirmado', now(), null, 1, 1, 3),              #frete grátis
# Pedido que o usuário 2 fez
('2019-12-05', '33.6', 'Cancelado', '2019-12-07', 2, 2, 3, 4),    # 7 - frete grátis
('2019-12-10', '23.5', 'Entregue', '2019-12-19', 3, 3, 3, 4),     # 8 - 23.5
('2020-01-01', '88.2', 'Entregue', '2020-01-05', null, 2, 4, 4),  # 9 - 88.20
('2020-02-02', '21.9', 'Entregue', '2020-02-12', null, 2, 4, 4),  # 10 - 11.90 + 10
('2020-09-01', '23.8', 'Cancelado', '2020-09-01', null, 2, 3, 5), # 11 - 23.8
('2020-11-23', '24.3', 'Entregue', '2019-12-28', null, 2, 3, 5),  # 12 - 4.3 + 10
(now(), '163', 'Confirmado', now(), null, 2, 4, 5);               # 13 - 11.90 + 10

INSERT INTO `sebo_virtual`.`Pedido_tem_Anuncio` (`id_pedido`, `id_anuncio`, `quantidade`)
VALUES
#Pedidos do usuário 1
('1', '10', 1),
('2', '11', 1),
('3', '12', 1),
('4', '13', 1),
('4', '14', 1),
('5', '15', 1),
('6', '16', 1),
('6', '17', 2),
#Pedidos do usuário 2
('7', '3', 1),
('7', '4', 1),
('8', '5', 1),
('9', '6', 1),
('10', '7', 1),
('11', '8', 1),
('11', '9', 1),
('12', '18', 1),
('12', '19', 1),
('13', '20', 1),
('13', '21', 1);