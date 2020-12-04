INSERT INTO sebo_virtual.Usuario (email, senha, habilitado, autoridade)
VALUES 
("juliana@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO"),
("vanderson@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO"),
("guilherme@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO"),
("jeanne@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO"),
("henrique@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO"),
("tudoderock@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO"),
("soquadrinhos@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO"),
("aquitemquadrinhos@gmail.com", "$2a$10$/neADC8gHtRb39wNtVV/de/2dBjpusdCbMkDv8hESnxvR5T2DeFva", "1", "USUARIO");

INSERT INTO sebo_virtual.Pessoa_Fisica (id, nome, sobrenome, data_nascimento, cpf, sexo)
VALUES 
((SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), "Juliana", "Aquino", "1981-06-01", "532.533.684-32", "F"),
((SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), "Vanderson", "Sander", "1982-10-08", "913.646.577-16", "M"),
((SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), "Guilherme", "Nunes", "1985-12-15", "313.514.618-93", "M"),
((SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com"), "Jeanne", "Aquino", "1982-10-08", "913.032.600-18", "F"),
((SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com"), "Henrique", "Viana", "1981-06-14", "572.625.100-88", "M");

INSERT INTO sebo_virtual.Pessoa_Juridica (id, nome_fantasia, cnpj, razao_social)
VALUES 
((SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), "Tudo de Rock", "31.718.516/0001-08", "Tudo de Rock S.A."),
((SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com"), "Só Quadrinhos", "13.473.210/0001-49", "Só Quadrinhos S.A."),
((SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com"), "Aqui tem Quadrinhos", "23.232.892/0001-51", "Só Quadrinhos S.A.");

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
data_modificacao, fk_id_status, fk_id_usuario, principal, principal_envio)
VALUES 
#Juliana
("1", "Juliana Aquino", "22431-004", "Avenida Bartolomeu Mitre", "990",
"Apto 410", "Leblon", "Rio de Janeiro", "RJ", "Apartamento", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1, 1),
("2", "Efigênia Aquino", "60532-620", "Rua 1004", "999",
"4a etapa", "Conjunto Ceará", "Fortaleza", "CE", "Casa da Mãe", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 0, 0),
("3", "Francisca Viana", "60710-570", "Rua Dinamarca", "1000",
"", "Parangaba", "Fortaleza", "CE", "Sogra", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 0, 0),
#Vanderson
("1", "Vanderson Sander", "04116-040", "Rua Domingos Soto", "1000",
"", "Jardim Vila Mariana", "São Paulo", "SP", "Casa", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), 1, 1),
("2", "Vanderson Sander", "05409-010", "Rua Oscar Freire", "1291",
"", "Pinheiros", "São Paulo", "SP", "Casa dos Avós", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), 0, 0),
#Guilherme
("1", "Guilherme Nunes", "01310-932", "Avenida Paulista", "2202",
"", "Bela Vista", "São Paulo", "SP", "Casa dos Avós", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), 1, 1),
#Jeanne
("1", "Jeanne Aquino", "60532-620", "Rua 1004", "999",
"4a etapa", "Conjunto Ceará", "Fortaleza", "CE", "Casa", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com"), 1, 1),
#Henrique
("1", "Francisca Viana", "60710-570", "Rua Dinamarca", "1000",
"", "Parangaba", "Fortaleza", "CE", "Casa", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com"), 1, 1),
#PJ
("1", "Tudo de Rock", "01310-932", "Avenida Paulista", "1000",
"", "Bela Vista", "São Paulo", "SP", "Matriz", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), 1, 1),
("1", "Só Quadrinhos", "01310-932", "Avenida Paulista", "1000",
"Sala 201", "Bela Vista", "São Paulo", "SP", "Matriz", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com"), 1, 1),
("1", "Aqui tem Quadrinhos", "01310-932", "Avenida Paulista", "3000",
"Sala 902", "Bela Vista", "São Paulo", "SP", "Matriz", now(), "1", (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com"), 1, 1);

INSERT INTO sebo_virtual.Telefone (ddi, ddd, numero, tipo, fk_id_usuario)
VALUES ("55", "21", "980228740", "celular", "1"),
	   ("55", "21", "39888740", "contato", "1"),
       ("55", "11", "945418250", "contato", "2"),
       ("55", "11", "945418250", "celular", "2"),
       ("55", "11", "945418250", "celular", "4"),
       ("55", "11", "945418250", "contato", "4");

INSERT INTO sebo_virtual.Marca (nome)
VALUES 
("Atari"),
("CTX"),
("Oldway"),
("Playstation"),
("Raveo"),
("Sony"),
("Super Nintendo"),
("Wii"),
("Xbox");

INSERT INTO sebo_virtual.Subcategoria (nome)
VALUES 
("Cartucho"),
("Console"),
("Jogo"),
("Toca-disco"),
("Vitrola");

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
#Quadrinhos
('Hulk #094', 'quadrinho'),
('Hulk Anual #1', 'quadrinho'),
('Universo Marvel - 4ª Série #08', 'quadrinho'),
('Liga da Justiça - 3ª Série #04', 'quadrinho'),
('Liga da Justiça - 3ª Série #03', 'quadrinho'),
('Savanna Game - Segunda Temporada #04', 'quadrinho'),
('Savanna Game #2', 'quadrinho'),
('Fairy Tail Zero', 'quadrinho'),
('Yu Yu Hakusho - 2ª Edição #12', 'quadrinho'),
('Ultraman # 01','quadrinho'),
#CDs
('O carnaval', 'cd'),
('The Wonder Of You', 'cd'),
('Badlands (Deluxe)', 'cd'),
('Greatest Hits', 'cd'),
('Painkiller', 'cd'),
('All the Best', 'cd'),
('Standard', 'cd'),
('Thank U Next', 'cd'),
#DVDs
('Aladdin', 'dvd'),
('Moana', 'dvd'),
('O Rei Leão', 'dvd'),
('Vingadores: Ultimato', 'dvd'),
('Vingadores: Guerra Infinita', 'dvd'),
('Vingadores: Era de Ultron', 'dvd'),
#Discos
('Tim Maia', 'disco'),
('Trash in Texas', 'disco'),
('Sun Singles', 'disco'),
('Evil Empire', 'disco'),
('My Name is Rattlesnake', 'disco'),
('Isso é Amor', 'disco'),
('Kiss', 'disco'),
('Stoned', 'disco'),
('Mothers Milk', 'disco'),
('Some People Have Real Problems', 'disco'),
('Twist Uptown', 'disco'),
#Eletrônicos
('Super Nintendo', 'eletronico');

INSERT INTO `sebo_virtual`.`Midia` (`id`,`quantidade_midias`, `ano`, `quantidade_faixas`, `tempo_execucao`, `artista`, `fk_id_gravadora`, `fk_id_formato_midia`, `fk_id_idioma`, `fk_id_genero`) 
VALUES 
#cds
((SELECT id from sebo_virtual.Produto WHERE titulo='O Carnaval'),'1', '2019-01-01', '12', '00:01:30', 'Ivete Sangalo', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='The Wonder Of You'),'1', '2020-01-01', '10', '00:01:25', 'Elvis Presley', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Badlands (Deluxe)'),'1', '2020-01-01', '10', '00:00:55', 'Halsey', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Greatest Hits'),'1', '2020-01-01', '10', '00:01:04', 'Foo Fighters', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Painkiller'),'1', '2020-01-01', '10', '00:46:00', 'Judas Priest', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='All the Best'),'1', '1995-01-01', '10', '00:01:30', 'Tina Turner', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Standard'),'1', '2002-01-01', '10', '00:48:00', 'Taylor Swift ', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Thank U Next'),'1', '2018-01-01', '10', '00:41:00', 'Ariana Grande', '1', '1', '5', '1');

INSERT INTO `sebo_virtual`.`Midia` (`id`,`quantidade_midias`, `ano`, `quantidade_faixas`, `tempo_execucao`, `artista`, `fk_id_gravadora`, `fk_id_formato_midia`, `fk_id_idioma`, `fk_id_genero`) 
VALUES 
#dvds
((SELECT id from sebo_virtual.Produto WHERE titulo='Aladdin'),'1', '2019-09-11', '10', '00:02:08', 'Will Smith', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Moana'),'1', '2017-04-19', '10', '00:01:47', 'Dwayne Johnson ', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='O Rei Leão'),'1', '2011-09-28', '10', '00:01:28', 'Matthew Broderick', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Vingadores: Ultimato'),'1', '2019-08-014', '10', '00:03:01', 'Robert Downey Jr', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Vingadores: Guerra Infinita'),'1', '2018-08-22', '10', '00:02:29', 'Robert Downey Jr', '1', '1', '5', '1'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Vingadores: Era de Ultron'),'1', '2015-09-16', '10', '00:02:22', 'Robert Downey Jr', '1', '1', '5', '1');

INSERT INTO `sebo_virtual`.`Midia` (`id`,`quantidade_midias`, `ano`, `quantidade_faixas`, `tempo_execucao`, `artista`, `fk_id_gravadora`, `fk_id_formato_midia`, `fk_id_idioma`, `fk_id_genero`) 
VALUES 
#discos
((SELECT id from sebo_virtual.Produto WHERE titulo='Trash in Texas'), '2', '1987-01-01', '10', '00:01:25', 'Anthrax', '1', '3', '4', '3'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Sun Singles'), '1', '1955-01-01', '10', '00:01:30', 'Elvis Presley', '1', '3', '4', '3'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Evil Empire'), '1', '2000-01-01', '10', '00:01:45', 'Rage Against the Machine', '1', '3', '4', '3'),
((SELECT id from sebo_virtual.Produto WHERE titulo='My Name is Rattlesnake'), '2', '1980-01-01', '10', '00:02:30', 'Hillbilly Rawhide', '1', '3', '4', '3'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Isso é Amor'), '2', '2019-01-01', '12', '00:01:35', 'Ira', '1', '3', '5', '3'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Kiss'), '1', '1985-01-01', '12', '00:01:35', 'Kiss', '1', '3', '5', '3'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Stoned'), '2', '1991-01-01', '12', '00:01:30', 'Mickey Junkies', '1', '3', '4', '3'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Mothers Milk'), '1', '1995-01-01', '10', '00:01:30', 'Rage Against the Machine', '1', '3', '4', '3'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Some People Have Real Problems'), '1', '2000-01-01', '10', '00:01:30', 'Sia', '1', '3', '4', '3'),
((SELECT id from sebo_virtual.Produto WHERE titulo='Twist Uptown'), '1', '1975-01-01', '10', '00:01:30', 'The Crystals', '1', '3', '4', '3');

INSERT INTO `sebo_virtual`.`Midia_tem_Legenda` (`fk_id_produto`, `fk_id_legenda`) 
VALUES 
((SELECT id from Produto WHERE titulo='Aladdin'), '1'),
((SELECT id from Produto WHERE titulo='Aladdin'), '2'),
((SELECT id from Produto WHERE titulo='Moana'), '1'),
((SELECT id from Produto WHERE titulo='Moana'), '2');

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
#livros
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
  '1938', 117, 'comum', '', '', 2, 1, 5, 6),
#quadrinhos
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Hulk #094'),
  '1991', 84, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Hulk Anual #1'),
  '1994', 132, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Universo Marvel - 4ª Série #08'),
  '2017', 148, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Liga da Justiça - 3ª Série #04'),
  '2017', 52, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Liga da Justiça - 3ª Série #03'),
  '2017', 52, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Savanna Game - Segunda Temporada #04'),
  '2016', 184, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Savanna Game #2'),
  '2015', 184, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Fairy Tail Zero'),
  '2017', 272, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Yu Yu Hakusho - 2ª Edição #12'),
  '2015', 192, 'comum', '', '', 1, 1, 5, 2),
((SELECT id FROM `sebo_virtual`.Produto WHERE `titulo` = 'Ultraman # 01'),
  '2015', 192, 'comum', '', '', 1, 1, 5, 2);

INSERT INTO `publicacao`
(`id`, `ano`, `quantidade_paginas`, `tipo_capa`, `isbn10`, `isbn13`,
`fk_id_editora`, `fk_id_formato_publicacao`, `fk_id_idioma`, `fk_id_genero`, `resumo`)
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
#Livros
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) FROM Historico_Anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 
  12, 'A Mão e a Luva', 'Bom estado de conservação', 20.8, 
  ('2020-11-03' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1, 
  (SELECT id FROM `Produto` WHERE titulo = 'A Mão e a Luva'), 1),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 14, 'A Metamorfose', 'descricao', 12.8, 
  ('2020-11-04' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'A Metamorfose'), 1),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 16, 'As Armas da Persuassão', 'descricao', 23.5,
  ('2020-11-05' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 2,
  (SELECT id FROM `Produto` WHERE titulo = 'As Armas da Persuassão'), 1), #%
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 18, 'Clean Code', 'descricao', 88.2,
  ('2020-11-06' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Clean Code'), 1), #6
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 20, 'Contos da Meia Noite', 'descricao', 11.9, 
  ('2020-11-07' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Contos da Meia Noite'), 1), #7
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 25, 'Dom Casmurro', 'descricao', 11.9,
  ('2020-11-08' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Dom Casmurro'), 1), #8
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 30, 'Esaú e Jacó', 'descricao', 11.9,
  ('2020-11-09' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Esaú e Jacó'), 1), #9
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com")), 27, 'Helena', 'descricao', 13.5,
  ('2020-11-10' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Helena'), 1), #10
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com")), 23, 'Histórias da Meia Noite', 'Seminovo, lacrado!', 21.3,
  ('2020-11-11' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Histórias da Meia Noite'), 1), #11
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com")), 23, 'Laranja Mecânica', 'descricao', 33.4,
  ('2020-11-12' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), 3,
  (SELECT id FROM `Produto` WHERE titulo = 'Laranja Mecânica'), 1), #12
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com")), 23, 'Marley e Eu', 'descricao', 40.2,
  ('2020-11-13' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), 3,
  (SELECT id FROM `Produto` WHERE titulo = 'Marley e Eu'), 1), #13
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com")), 33, 'Memorial de Aires', 'descricao', 12.5,
  ('2020-11-14' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Memorial de Aires'), 1), #14
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com")), 35, 'Memórias Póstumas de Brás Cubas', 'descricao', 9.5,
  ('2020-11-15' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="vanderson@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Memórias Póstumas de Brás Cubas'), 1), #15
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com")), 10, 'Do Mil ao Milhão - Sem cortar o cafezinho', 'descricao', 18.5,
  ('2020-11-16' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Do Mil ao Milhão'), 1), #16
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com")), 28, 'Mindset', 'descricao', 40.2,
  ('2020-11-17' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Mindset'), 1), #17
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com")), 26, 'Quem Mexeu no Meu Queijo', 'descricao', 23.4,
  ('2020-11-18' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Quem Mexeu no Meu Queijo'), 1), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com")), 29, 'Quincas Borba', 'Livro possui algumas dobras e amassados', 4.3,
  ('2020-11-19' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Quincas Borba'), 1), #19
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com")), 9, 'Senhora', 'Em ótimo estado de conservação', 10.5,
  ('2020-11-20' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Senhora'), 1), #20
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com")), 25, 'Vidas Secas', 'Edição especial autografada, para colecionadores', 152.5,
  ('2020-11-21' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), 2,
  (SELECT id FROM `Produto` WHERE titulo = 'Vidas Secas'), 1), #21,
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 10, 'Iracema', 'Edição especial autografada, para colecionadores', 22.9,
  ('2020-11-22' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Iracema'), 1), #22
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 11, 'O Guarani', 'Edição especial autografada, para colecionadores', 15.9,
  ('2020-11-23' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'O Guarani'), 1), #23
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 5, 'O Quinze', 'Edição especial autografada, para colecionadores', 21.9,
  ('2020-11-24' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'O Quinze'), 1), #24
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), 2, 'Promoção Til', 'Edição especial autografada, para colecionadores', 21.9,
  ('2020-11-25' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), 1,
  (SELECT id FROM `Produto` WHERE titulo = 'Til'), 1); #25

INSERT INTO `sebo_virtual`.`Historico_Anuncio` (`id_anuncio`, `estoque`, `titulo`, 
`descricao`, `preco`, `data_modificacao`, `fk_id_usuario`, `fk_id_condicao`, 
`fk_id_produto`, `fk_id_status`) 
VALUES 
# Discos
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Promoção Anthrax! ', 'Disco importado', '168', 
  ('2020-11-26' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'Trash in Texas'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Promoção Elvis! ', 'Disco importado', '170', 
  ('2020-11-27' + INTERVAL 2 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'Sun Singles'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Promoção Evil Empire! ', 'Disco importado', '170', 
  ('2020-11-28' + INTERVAL 3 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'Evil Empire'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Promoção My Name is Rattlesnake! ', 'Disco importado', '94.9', 
  ('2020-11-29' + INTERVAL 4 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'My Name is Rattlesnake'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Promoção Disco do Ira! ', 'Disco nacional', '129.9', 
  ('2020-11-30' + INTERVAL 5 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'Isso é Amor'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Kiss Importado! ', 'Disco importado em ótimas condições', '262.9', 
  ('2020-11-30' + INTERVAL 6 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'Kiss'), '1'),  
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Mickey Junkies Importado! ', 'Disco importado em ótimas condições', '94.9', 
  ('2020-11-30' + INTERVAL 7 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'Stoned'), '1'),    
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Mothers Milk Importado! ', 'Disco importado em ótimas condições', '94.9', 
  ('2020-11-30' + INTERVAL 8 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'Mothers Milk'), '1'),  
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Some People Have Real Problems Importado! ', 'Disco importado em ótimas condições', '94.9', 
  ('2020-11-30' + INTERVAL 9 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'Some People Have Real Problems'), '1'),    
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com")), '2', 'Raridade Twist Uptown!', 'Disco importado em ótimas condições', '123.9', 
  ('2020-11-30' + INTERVAL 10 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="tudoderock@gmail.com"), '3', 
  (SELECT id FROM `Produto` WHERE titulo = 'Twist Uptown'), '1');
  
INSERT INTO `sebo_virtual`.`Historico_Anuncio` (`id_anuncio`, `estoque`, `titulo`, 
 `preco`, `data_modificacao`, `fk_id_usuario`, `fk_id_condicao`, 
`fk_id_produto`, `fk_id_status`) 
VALUES 
#Quadrinhos
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com")), '2', 'Promoção Hulk #094', '4.99', 
  ('2020-12-01' + INTERVAL 1 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Hulk #094'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com")), '2', 'Promoção Hulk Anual #1', '5.90', 
  ('2020-12-01' + INTERVAL 2 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Hulk Anual #1'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com")), '2', 'Promoção Universo Marvel - 4ª Série #08', '3.99', 
  ('2020-12-01' + INTERVAL 3 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Universo Marvel - 4ª Série #08'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com")), '2', 'Promoção Liga da Justiça - 3ª Série #04', '4.50', 
  ('2020-12-01' + INTERVAL 4 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Liga da Justiça - 3ª Série #04'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com")), '2', 'Promoção Liga da Justiça - 3ª Série #03', '4.90', 
  ('2020-12-01' + INTERVAL 5 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="soquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Liga da Justiça - 3ª Série #03'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com")), '2', 'Promoção Savanna Game - Segunda Temporada #04 ', '4.50', 
  ('2020-12-01' + INTERVAL 6 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Savanna Game - Segunda Temporada #04'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com")), '2', 'Promoção Savanna Game #2 ', '4.80', 
  ('2020-12-02' + INTERVAL 7 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Savanna Game #2'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com")), '2', 'Promoção Fairy Tail Zero ', '4.70', 
  ('2020-12-02' + INTERVAL 8 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Fairy Tail Zero'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com")), '2', 'Promoção Yu Yu Hakusho - 2ª Edição #12', '4.90', 
  ('2020-12-02' + INTERVAL 9 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Yu Yu Hakusho - 2ª Edição #12'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com")), '2', 'Promoção Ultraman # 01 - 2ª Edição #12', '3.00', 
  ('2020-12-02' + INTERVAL 10 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="aquitemquadrinhos@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Ultraman # 01'), '1');

INSERT INTO `sebo_virtual`.`Historico_Anuncio` (`id_anuncio`, `estoque`, `titulo`, 
 `preco`, `data_modificacao`, `fk_id_usuario`, `fk_id_condicao`, 
`fk_id_produto`, `fk_id_status`) 
VALUES 
#CDs
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com")), '10', 'Promoção! CD O Carnaval de Ivete!!!', '24', 
  ('2020-12-03' + INTERVAL 11 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'O Carnaval'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com")), '5', 'CD The Wonder Of You', '28', 
  ('2020-12-03' + INTERVAL 12 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="guilherme@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'The Wonder Of You'), '1'), 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com")), '2', 'Promoção Badlands (Deluxe)', '24.90', 
  ('2020-12-03' + INTERVAL 13 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Badlands (Deluxe)'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com")), '2', 'Promoção Greatest Hits', '33.99', 
  ('2020-12-03' + INTERVAL 14 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Greatest Hits'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com")), '2', 'Promoção Painkiller', '25.50', 
  ('2020-12-03' + INTERVAL 15 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Painkiller'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com")), '2', 'Promoção All the Best', '22.90', 
  ('2020-12-03' + INTERVAL 16 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'All the Best'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com")), '2', 'Promoção Standard ', '29.99', 
  ('2020-12-03' + INTERVAL 17 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Standard'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com")), '2', 'Promoção Thank U Next', '34.90', 
  ('2020-12-03' + INTERVAL 18 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Thank U Next'), '1'),
#DVDs
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com")), '2', 'Promoção Aladdin ', '25.00', 
  ('2020-12-03' + INTERVAL 19 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Aladdin'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com")), '2', 'Promoção Moana ', '20.00', 
  ('2020-12-03' + INTERVAL 20 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Moana'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com")), '2', 'Promoção O Rei Leão ', '15.00', 
  ('2020-12-03' + INTERVAL 21 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="jeanne@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'O Rei Leão'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com")), '2', 'Promoção Vingadores: Ultimato ', '22.00', 
  ('2020-12-03' + INTERVAL 22 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Vingadores: Ultimato'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com")), '2', 'Promoção Vingadores: Guerra Infinita', '18.50', 
  ('2020-12-03' + INTERVAL 23 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Vingadores: Guerra Infinita'), '1'),
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com")), '2', 'Promoção Vingadores: Era de Ultron', '19.99', 
  ('2020-12-03' + INTERVAL 24 DAY_MINUTE), (SELECT id from sebo_virtual.Usuario WHERE email="henrique@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Vingadores: Era de Ultron'), '1');
  
INSERT INTO `sebo_virtual`.`Imagem` (`url`, `fk_id_anuncio`) 
VALUES
#Juliana
('1A0k3KYSoTSS9w3+7ce0PEPNQA==.jpg', #O Carnaval
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'O Carnaval')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'guilherme@gmail.com'))), 
('NZlrNA4NQISXqTbw+QK2kf6IFg==.jpg', #The Wonder Of You
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'The Wonder Of You')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'guilherme@gmail.com'))), 
('eQ6wA92kZxK0mDcJl8VtGSzbzow=.jpg', #A Mão e a Luva
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'A Mão e a Luva')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #A Mão e a Luva
('KFbug0vDdtXk9xlu0qiH7mjpag==.png', #A Metamorfose
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'A Metamorfose')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #A Metamorfose
('3T4f2ngJkJMYrqJkkT7byp14yg==.jpg', #As Armas da Persuassão
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'As Armas da Persuassão')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #As Armas da Persuassão
('Yk2oOY8XkkQ7m8tRR2LoNzrVfg==.png', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Clean Code')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #Clean Code
('4CJPGbQdL9JDTpScp0W4nV0=.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Contos da Meia Noite')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #Contos da Meia Noite
('9mBIY3J44AbZMJvACiIDqQZsOBg=.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Dom Casmurro')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #Dom Casmurro
('5Uz3tu0W14sMaKWBxa5iRsD0oKk=.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Esaú e Jacó')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))),# Esaú e Jacó
('XbhLBgyy098tWRidCTukgUqrhw==.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Iracema')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #Iracema
('blwnE85rFLBGD0lC5Dirku4FJdY=.jpg', #O Guarani
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'O Guarani')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #O Guarani
('wwutZup0AsfrQ3ysoWWSjvYPYg==.jpg', #O Quinze
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'O Quinze')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #O Quinze
('3bKHi21970dnHLoXkcrWLW9PnoA=.jpg',
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Til')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'juliana@gmail.com'))), #Til    
#Vanderson    
('TKSKv91J9bsjkmRfJeAilc4=.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Helena')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'vanderson@gmail.com'))), #Helena
('vkCvHV2D1W93aht6C0TMKS47hUk=.jpg',
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Histórias da Meia Noite')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'vanderson@gmail.com'))), #Histórias da Meia Noite
('7KYhUCt3JKMtQKi3BWn0CyYG6A==.png',
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Laranja Mecânica')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'vanderson@gmail.com'))), #Laranja Mecânica
('OjGu7i6fiPWWWcewUx0gGM4HmLg=.png', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Marley e Eu')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'vanderson@gmail.com'))), #Marley e Eu
('y1NsS7lq43JFEMaX6qXL8bvnSQ==.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Memorial de Aires')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'vanderson@gmail.com'))), #Memorial de Aires
('y1NsS7lq43JFEMaX6qXL8bvnSQ2==.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Memórias Póstumas de Brás Cubas')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'vanderson@gmail.com'))), #Memórias Póstumas de Brás Cubas
#Guilherme
('09rtHgZ7Vs9HWfcY5iBkWyH01g==.png',
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Do Mil ao Milhão')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'guilherme@gmail.com'))), #Do Mil ao Milhão
('dqtvleT4Nq3ahly4NHZ8SMhlCg==.png', #Mindset
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Mindset')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'guilherme@gmail.com'))), #Mindset
('4z9bAoUUltVUfAwtbj98wxVG.png', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Quem Mexeu no Meu Queijo')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'guilherme@gmail.com'))), #Quem Mexeu no Meu Queijo?
('RwzBvGQaqQ7Bhz0H5xMeSDGl0Q==.jpg',
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Quincas Borba')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'guilherme@gmail.com'))), #Quincas Borba 
('dqOb5ol7Wdtk+frTtc6tLsG91bM=.png', #Senhora
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Senhora')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'guilherme@gmail.com'))), #Senhora
('mfwsqbCBMNuUbNg2vUf0j8gz0g==.png',
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Vidas Secas')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'guilherme@gmail.com'))), #Vidas Secas
#Discos
('vinyl_disc_antrax.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Trash in Texas')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))),
('vinyl_disc_elvis_presley.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Sun Singles')
	AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))), 
('vinyl_disc_evil_empire.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Evil Empire')
	AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))), 
('vinyl_disc_hill.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'My Name is Rattlesnake')
	AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))), 
('vinyl_disc_ira.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Isso é amor')
	AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))), 
('vinyl_disc_kiss.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Kiss')
	AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))),
('vinyl_disc_mickey.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Stoned')
	AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))), 
('vinyl_disc_redhot.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Mothers Milk')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))), 
('vinyl_disc_sia.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Some People Have Real Problems')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))),
('vinyl_disc_thecrystals.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM `Produto` WHERE titulo = 'Twist Uptown')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'tudoderock@gmail.com'))),
#Quadrinhos
('quadrinhos_hulk094.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Hulk #094')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'soquadrinhos@gmail.com'))),
('quadrinhos_hulkanual1.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Hulk Anual #1')
	AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'soquadrinhos@gmail.com'))),
('quadrinhos_universomarvel_4_serie_panini_8.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Universo Marvel - 4ª Série #08')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'soquadrinhos@gmail.com'))),
('quadrinhos_liga_da_justica-3_serie_panini_4.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Liga da Justiça - 3ª Série #04')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'soquadrinhos@gmail.com'))),
('quadrinhos_liga_da_justica_3_serie_panini_3.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Liga da Justiça - 3ª Série #03')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'soquadrinhos@gmail.com'))),
('quadrinho_savanna_game_04.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Savanna Game - Segunda Temporada #04')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'aquitemquadrinhos@gmail.com'))),
('quadrinho_savanna_game_2.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Savanna Game #2')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'aquitemquadrinhos@gmail.com'))),
('quadrinho_fairy_tail_zero.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Fairy Tail Zero')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'aquitemquadrinhos@gmail.com'))),
('quadrinho_yu-yu-hakusho-2-edicao-12.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Yu Yu Hakusho - 2ª Edição #12')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'aquitemquadrinhos@gmail.com'))),
('quadrinho_yu-yu-hakusho-2-edicao-12.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Yu Yu Hakusho - 2ª Edição #12')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'aquitemquadrinhos@gmail.com'))),
('quadrinho_ultraman-01.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Ultraman # 01')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'aquitemquadrinhos@gmail.com'))),
#CDs
('cd_badlands_deluxe_halsey.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Badlands (Deluxe)')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'jeanne@gmail.com'))),
('cd_greatest_hits.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Greatest Hits')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'jeanne@gmail.com'))),
('cd_Painkiller.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Painkiller')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'jeanne@gmail.com'))),
('cd_tinaturnerallthebest.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'All the Best')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'henrique@gmail.com'))),
('cd_taylor_swift_standard.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Standard')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'henrique@gmail.com'))),
('cd_ariana grande_thank u next.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Thank U Next')
    AND
    fk_id_usuario IN
	(SELECT id FROM `Usuario` WHERE email = 'henrique@gmail.com'))),
#DVDs
('dvd_alladin.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Aladdin'))),
('dvd_moana.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Moana'))),
('dvd_o rei leão.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'O Rei Leão'))),
('dvd_vingadores_ultimato.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Vingadores: Ultimato'))),
('dvd_vingadores_guerra infinita.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Vingadores: Guerra Infinita'))),
('dvd_vingadores_ era de ultron.jpg', 
	(SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
	fk_id_produto IN 
	(SELECT id FROM Produto WHERE titulo = 'Vingadores: Era de Ultron')));

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
('Rachel', 'de Queiroz');

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
  (SELECT id FROM `Autor` WHERE nome = 'José' and sobrenome = 'de Alencar')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Iracema'),
  (SELECT id FROM `Autor` WHERE nome = 'José' and sobrenome = 'de Alencar')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'O Quinze'),
  (SELECT id FROM `Autor` WHERE nome = 'Rachel' and sobrenome = 'de Queiroz')
),
(
  (SELECT id FROM `Produto` WHERE titulo = 'Til'),
  (SELECT id FROM `Autor` WHERE nome = 'José' and sobrenome = 'de Alencar')
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

#Cadastro de Produtos
INSERT INTO `sebo_virtual`.`Produto` (`titulo`, `categoria`) VALUES 
#Eletrônicos
('Console Super Nintendo', 'eletronico'),
('Console Playstation 4 Slim 1TB', 'eletronico'),
('Console Playstation 4 Pro', 'eletronico'),
('Console Xbox One fat 500gb', 'eletronico'),
('Jogo Fifa 15 - PS4', 'eletronico'), 
('Jogo Madden NFL 20 - PS4', 'eletronico'),
('Jogo Batman Arkham Knight - PS4', 'eletronico'),
('Vitrola Vintage Dvd/mp3/usb Bivolt','eletronico'), 
('Vitrola CTX Classic','eletronico'), 
('Vitrola Toca Discos Raveo','eletronico');

INSERT INTO `sebo_virtual`.`Eletronico` (`id`,`fk_id_marca`, `fk_id_subcategoria`) 
VALUES 
((SELECT id from sebo_virtual.Produto WHERE titulo='Console Super Nintendo'), 
	(SELECT id from sebo_virtual.Marca WHERE nome='Super Nintendo'), 
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Console')),
((SELECT id from sebo_virtual.Produto WHERE titulo='Console Playstation 4 Slim 1TB'), 
	(SELECT id from sebo_virtual.Marca WHERE nome='Playstation') ,
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Console')),
((SELECT id from sebo_virtual.Produto WHERE titulo='Console Playstation 4 Pro'),
	(SELECT id from sebo_virtual.Marca WHERE nome='Playstation') , 
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Console')),
((SELECT id from sebo_virtual.Produto WHERE titulo='Console Xbox One fat 500gb'),
	(SELECT id from sebo_virtual.Marca WHERE nome='Xbox') , 
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Console')),
((SELECT id from sebo_virtual.Produto WHERE titulo='Jogo Fifa 15 - PS4'),
	(SELECT id from sebo_virtual.Marca WHERE nome='Playstation') ,
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Jogo')),
((SELECT id from sebo_virtual.Produto WHERE titulo='Jogo Madden NFL 20 - PS4'),
	(SELECT id from sebo_virtual.Marca WHERE nome='Playstation') , 
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Jogo')),
((SELECT id from sebo_virtual.Produto WHERE titulo='Jogo Batman Arkham Knight - PS4'), 
	(SELECT id from sebo_virtual.Marca WHERE nome='Playstation') ,
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Jogo')),
((SELECT id from sebo_virtual.Produto WHERE titulo='Vitrola Vintage Dvd/mp3/usb Bivolt'), 
	(SELECT id from sebo_virtual.Marca WHERE nome='Oldway') ,
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Vitrola')),
((SELECT id from sebo_virtual.Produto WHERE titulo='Vitrola CTX Classic'), 
	(SELECT id from sebo_virtual.Marca WHERE nome='CTX') , 
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Vitrola')),
((SELECT id from sebo_virtual.Produto WHERE titulo='Vitrola Toca Discos Raveo'),
	(SELECT id from sebo_virtual.Marca WHERE nome='Raveo') ,
	(SELECT id from sebo_virtual.Subcategoria WHERE nome='Vitrola'));
    
INSERT INTO `sebo_virtual`.`Historico_Anuncio` (`id_anuncio`, `estoque`, `titulo`, 
 `preco`, `data_modificacao`, `fk_id_usuario`, `fk_id_condicao`, 
`fk_id_produto`, `fk_id_status`) 
VALUES 
((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Super Nintendo', '890', 
  ('2020-11-03' + INTERVAL 30 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo = 'Console Super Nintendo'), '1'), 

((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Console Playstation 4 Slim 1TB ', '1500', 
  ('2020-11-03' + INTERVAL 31 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo ='Console Playstation 4 Slim 1TB'), '1'), 

((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Console Playstation 4 Pro ', '1400', 
  ('2020-11-03' + INTERVAL 32 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo ='Console Playstation 4 Pro'), '1'),

((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Console Xbox One fat 500gb', '1699', 
  ('2020-11-03' + INTERVAL 33 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo ='Console Xbox One fat 500gb'), '1'), 

((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Jogo Fifa 15 - PS4', '1699', 
  ('2020-11-03' + INTERVAL 34 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo ='Jogo Fifa 15 - PS4'), '1'),

((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Jogo Madden NFL 20 - PS4', '39.99', 
  ('2020-11-03' + INTERVAL 35 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo ='Jogo Madden NFL 20 - PS4'), '1'),

((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Jogo Batman Arkham Knight', '99.99', 
  ('2020-11-03' + INTERVAL 36 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo ='Jogo Batman Arkham Knight - PS4'), '1'),

((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Vitrola Vintage', '2000', 
  ('2020-11-03' + INTERVAL 37 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo ='Vitrola Vintage Dvd/mp3/usb Bivolt'), '1'), #1

((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Vitrola CTX Classic', '1700', 
  ('2020-11-03' + INTERVAL 38 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo ='Vitrola CTX Classic'), '1'), #1

((SELECT (IFNULL(MAX(a.id_anuncio), 0) + 1) AS next_id FROM historico_anuncio a
  WHERE a.fk_id_usuario = (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com")), '2', 'Promoção Vitrola Toca Discos Raveo', '1800', 
  ('2020-11-03' + INTERVAL 39 DAY_MINUTE), 
  (SELECT id from sebo_virtual.Usuario WHERE email="juliana@gmail.com"), '1', 
  (SELECT id FROM `Produto` WHERE titulo ='Vitrola Toca Discos Raveo'), '1');

INSERT INTO `sebo_virtual`.`Imagem` (`url`, `fk_id_anuncio`) 
VALUES 
('eletronico_console_super_nitendo.jpg', 
 (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Console Super Nintendo')
    AND
    fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com'))),

('eletronico_console_playstation4slim_1TB.jpg', 
 (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Console Playstation 4 Slim 1TB')
    AND
    fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com'))),
 
('eletronico_console_playstation4pro.jpg', 
  (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 	
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Console Playstation 4 Pro')
    AND
 fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com'))),

('eletronico_console_xboxonefat500gb.jpg', 
 (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Console Xbox One fat 500gb')
    AND
	fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com'))),

('eletronico_jogo_fifa15_ps4.jpg', 
 (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Jogo Fifa 15 - PS4')
    AND
    fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com'))),

('eletronico_jogo_madden_nfl20ps4.jpg', 
 (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Jogo Madden NFL 20 - PS4')
    AND
    fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com'))),

('eletronico_jogo_batmanarkhamknight_ ps4.jpg', 
 (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Jogo Batman Arkham Knight - PS4')
    AND
    fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com'))),

('eletronico_vitrola_vintage.jpg', 
 (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Vitrola Vintage Dvd/mp3/usb Bivolt')
    AND
    fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com'))),

('eletronico_vitrolactxclassic.jpg', 
 (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Vitrola CTX Classic')
    AND
    fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com'))),

('eletronico_vitrolaraveo.jpg', 
 (SELECT id FROM sebo_virtual.Historico_Anuncio WHERE 
 fk_id_produto IN 
 (SELECT id FROM Produto WHERE titulo = 'Vitrola Toca Discos Raveo')
    AND
    fk_id_usuario IN
 (SELECT id FROM Usuario WHERE email = 'juliana@gmail.com')));