-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sebo_virtual
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sebo_virtual
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sebo_virtual` DEFAULT CHARACTER SET utf8 ;
USE `sebo_virtual` ;

-- -----------------------------------------------------
-- Table `sebo_virtual`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Editora` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Formato_Publicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Formato_Publicacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Idioma` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Genero` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Publicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Publicacao` (
  `id` INT NOT NULL,
  `ano` YEAR(4) NULL,
  `quantidade_paginas` INT NULL,
  `tipo_capa` VARCHAR(45) NULL,
  `isbn10` VARCHAR(10) NULL,
  `isbn13` VARCHAR(13) NULL,
  `idioma` VARCHAR(45) NOT NULL,
  `fk_id_editora` INT NULL,
  `fk_id_formato_publicacao` INT NOT NULL,
  `fk_id_idioma` INT NOT NULL,
  `fk_id_genero` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Publicacao_Editora1_idx` (`fk_id_editora` ASC) VISIBLE,
  INDEX `fk_Publicacao_FormatoPublicacao1_idx` (`fk_id_formato_publicacao` ASC) VISIBLE,
  INDEX `fk_Publicacao_Idioma1_idx` (`fk_id_idioma` ASC) VISIBLE,
  INDEX `fk_Publicacao_Genero1_idx` (`fk_id_genero` ASC) VISIBLE,
  CONSTRAINT `fk_Livro_Produto`
    FOREIGN KEY (`id`)
    REFERENCES `sebo_virtual`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Publicacao_Editora1`
    FOREIGN KEY (`fk_id_editora`)
    REFERENCES `sebo_virtual`.`Editora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Publicacao_FormatoPublicacao1`
    FOREIGN KEY (`fk_id_formato_publicacao`)
    REFERENCES `sebo_virtual`.`Formato_Publicacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Publicacao_Idioma1`
    FOREIGN KEY (`fk_id_idioma`)
    REFERENCES `sebo_virtual`.`Idioma` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Publicacao_Genero1`
    FOREIGN KEY (`fk_id_genero`)
    REFERENCES `sebo_virtual`.`Genero` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Formato_Midia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Formato_Midia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Gravadora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Gravadora` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Midia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Midia` (
  `id` INT NOT NULL,
  `quantidade_midias` INT NOT NULL DEFAULT 1 COMMENT 'Quantidade de mídias do produto. Exemplo: 2 cds em um mesmo produto. ',
  `ano` DATE NULL COMMENT 'Ano de lançamento',
  `quantidade_faixas` INT NULL COMMENT 'Quantidade de faixas',
  `tempo_execucao` TIME NULL,
  `artista` VARCHAR(45) NULL,
  `fk_id_gravadora` INT NULL,
  `fk_id_formato_midia` INT NOT NULL,
  `fk_id_idioma` INT NOT NULL,
  `fk_id_genero` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Midia_FormatoMidia1_idx` (`fk_id_formato_midia` ASC) VISIBLE,
  INDEX `fk_Midia_Gravadora1_idx` (`fk_id_gravadora` ASC) VISIBLE,
  INDEX `fk_Midia_Idioma1_idx` (`fk_id_idioma` ASC) VISIBLE,
  INDEX `fk_Midia_Genero1_idx` (`fk_id_genero` ASC) VISIBLE,
  CONSTRAINT `fk_Produto_Produto1`
    FOREIGN KEY (`id`)
    REFERENCES `sebo_virtual`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Midia_FormatoMidia1`
    FOREIGN KEY (`fk_id_formato_midia`)
    REFERENCES `sebo_virtual`.`Formato_Midia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Midia_Gravadora1`
    FOREIGN KEY (`fk_id_gravadora`)
    REFERENCES `sebo_virtual`.`Gravadora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Midia_Idioma1`
    FOREIGN KEY (`fk_id_idioma`)
    REFERENCES `sebo_virtual`.`Idioma` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Midia_Genero1`
    FOREIGN KEY (`fk_id_genero`)
    REFERENCES `sebo_virtual`.`Genero` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Marca` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Subcategoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Subcategoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Eletronico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Eletronico` (
  `id` INT NOT NULL,
  `fk_id_marca` INT NOT NULL,
  `fk_id_subcategoria` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Eletrônico_Marca1_idx` (`fk_id_marca` ASC) VISIBLE,
  INDEX `fk_Eletrônico_Subcategoria1_idx` (`fk_id_subcategoria` ASC) VISIBLE,
  CONSTRAINT `fk_Eletrônico_Produto1`
    FOREIGN KEY (`id`)
    REFERENCES `sebo_virtual`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Eletrônico_Marca1`
    FOREIGN KEY (`fk_id_marca`)
    REFERENCES `sebo_virtual`.`Marca` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Eletrônico_Subcategoria1`
    FOREIGN KEY (`fk_id_subcategoria`)
    REFERENCES `sebo_virtual`.`Subcategoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `senha` VARCHAR(64) NOT NULL,
  `habilitado` TINYINT NOT NULL DEFAULT 1,
  `autoridade` VARCHAR(20) NOT NULL DEFAULT 'USUARIO',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Pessoa_Fisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Pessoa_Fisica` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `data_nascimento` DATE NULL,
  `sexo` VARCHAR(1) NULL,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  INDEX `fk_Pessoa_Fisica_Usuario1_idx` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Pessoa_Fisica_Usuario1`
    FOREIGN KEY (`id`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Pessoa_Juridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Pessoa_Juridica` (
  `id` INT NOT NULL,
  `nome_fantasia` VARCHAR(100) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `razao_social` VARCHAR(100) NULL,
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC) VISIBLE,
  INDEX `fk_Pessoa_Juridica_Usuario1_idx` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Pessoa_Juridica_Usuario1`
    FOREIGN KEY (`id`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Tipo_Metodo_Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Tipo_Metodo_Pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Id do tipo de método de pagamento. Se é PayPal ou Pagseguro.',
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL DEFAULT 'ATIVO' COMMENT 'Ativo, Inativo ou Excluído',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Historico_Metodo_Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Historico_Metodo_Pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_metodo_pagamento` INT NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `data_modificacao` DATETIME NOT NULL,
  `fk_id_tipo_metodo_pag` INT NOT NULL,
  `fk_id_status` INT NOT NULL,
  `fk_id_usuario` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_MétodoPagamento_Usuario1_idx` (`fk_id_usuario` ASC) VISIBLE,
  INDEX `fk_HistoricoMetodoPagamento_TipoMetodoPagamento1_idx` (`fk_id_tipo_metodo_pag` ASC) VISIBLE,
  INDEX `fk_HistoricoMetodoPagamento_Status1_idx` (`fk_id_status` ASC) VISIBLE,
  CONSTRAINT `fk_MetodoPagamento_Usuario`
    FOREIGN KEY (`fk_id_usuario`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HistoricoMetodoPagamento_TipoMetodoPagamento1`
    FOREIGN KEY (`fk_id_tipo_metodo_pag`)
    REFERENCES `sebo_virtual`.`Tipo_Metodo_Pagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HistoricoMetodoPagamento_Status1`
    FOREIGN KEY (`fk_id_status`)
    REFERENCES `sebo_virtual`.`Status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Historico_Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Historico_Endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_endereco` INT NOT NULL COMMENT 'Esse id identifica um endereço. Pode haver mais linhas com esse mesmo id, indicando que o endereço foi editado. A linha com a data mais recente significa a ultima alteração deste endereço.',
  `nome_destinatario` VARCHAR(45) NOT NULL COMMENT 'Nome do destinatário do endereço.',
  `cep` VARCHAR(9) NOT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(8) NOT NULL,
  `complemento` VARCHAR(20) NULL,
  `ponto_referencia` VARCHAR(45) NULL COMMENT 'Ponto de referência do endereço.',
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(2) NOT NULL,
  `apelido` VARCHAR(20) NOT NULL COMMENT 'Apelido para o endereço. Exemplos: minha casa, casa da minha mãe.',
  `data_modificacao` DATETIME NOT NULL COMMENT 'Indica a data de criação/modificação do endereço.',
  `fk_id_status` INT NOT NULL,
  `fk_id_usuario` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Endereco_Usuario1_idx` (`fk_id_usuario` ASC) VISIBLE,
  INDEX `fk_HistoricoEndereco_Status1_idx` (`fk_id_status` ASC) VISIBLE,
  CONSTRAINT `fk_Endereco_Usuario`
    FOREIGN KEY (`fk_id_usuario`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HistoricoEndereco_Status1`
    FOREIGN KEY (`fk_id_status`)
    REFERENCES `sebo_virtual`.`Status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Avaliacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nota_descricao` INT NULL COMMENT 'Nota sobre a descrição do produto.',
  `nota_rapidez_envio` INT NULL COMMENT 'Nota sobre a rapidez do envio.',
  `nota_embalagem` INT NULL COMMENT 'Nota sobre a embalagem do produto. Se o produto foi bem embalado.',
  `comentarios` VARCHAR(200) NULL COMMENT 'Comentários da avaliação.',
  `anonimo` TINYINT NULL COMMENT 'Se o comentário foi feito anonimamente ou não.',
  `fk_id_usuario` INT NOT NULL COMMENT 'Id do usuário que fez a avaliação.',
  PRIMARY KEY (`id`),
  INDEX `fk_Avaliacao_Usuario1_idx` (`fk_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_Avaliacao_Usuario1`
    FOREIGN KEY (`fk_id_usuario`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL COMMENT 'Data da realização do pedido.',
  `valor_total` FLOAT NOT NULL COMMENT 'Valor total do pedido.',
  `status` VARCHAR(20) NOT NULL,
  `id_avaliacao` INT NULL,
  `fk_id_usuario` INT NOT NULL,
  `fk_id_metodo_de_pagamento` INT NOT NULL,
  `fk_id_endereco` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pedido_Usuario1_idx` (`fk_id_usuario` ASC) VISIBLE,
  INDEX `fk_Pedido_MétodoPagamento1_idx` (`fk_id_metodo_de_pagamento` ASC) VISIBLE,
  INDEX `fk_Pedido_Endereco1_idx` (`fk_id_endereco` ASC) VISIBLE,
  INDEX `fk_Pedido_Avaliacao1_idx` (`id_avaliacao` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Usuario1`
    FOREIGN KEY (`fk_id_usuario`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_MétodoPagamento1`
    FOREIGN KEY (`fk_id_metodo_de_pagamento`)
    REFERENCES `sebo_virtual`.`Historico_Metodo_Pagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Endereco1`
    FOREIGN KEY (`fk_id_endereco`)
    REFERENCES `sebo_virtual`.`Historico_Endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Avaliacao1`
    FOREIGN KEY (`id_avaliacao`)
    REFERENCES `sebo_virtual`.`Avaliacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Condicao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Condicao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Historico_Anuncio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Historico_Anuncio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_anuncio` INT NOT NULL,
  `estoque` INT NOT NULL DEFAULT 1 COMMENT 'Quantidade disponível do anúncio.',
  `titulo` VARCHAR(100) NOT NULL COMMENT 'Título do anúncio.',
  `descricao` VARCHAR(200) NULL,
  `preco` FLOAT NOT NULL,
  `data_modificacao` DATETIME NOT NULL,
  `fk_id_usuario` INT NOT NULL,
  `fk_id_condicao` INT NOT NULL,
  `fk_id_produto` INT NOT NULL,
  `fk_id_status` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Historico_Anuncio_Usuario1_idx` (`fk_id_usuario` ASC) VISIBLE,
  INDEX `fk_Historico_Anuncio_Condicao1_idx` (`fk_id_condicao` ASC) VISIBLE,
  INDEX `fk_Historico_Anuncio_Produto1_idx` (`fk_id_produto` ASC) VISIBLE,
  INDEX `fk_Historico_Anuncio_Status1_idx` (`fk_id_status` ASC) VISIBLE,
  CONSTRAINT `fk_Historico_Anuncio_Usuario1`
    FOREIGN KEY (`fk_id_usuario`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historico_Anuncio_Condicao1`
    FOREIGN KEY (`fk_id_condicao`)
    REFERENCES `sebo_virtual`.`Condicao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historico_Anuncio_Produto1`
    FOREIGN KEY (`fk_id_produto`)
    REFERENCES `sebo_virtual`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historico_Anuncio_Status1`
    FOREIGN KEY (`fk_id_status`)
    REFERENCES `sebo_virtual`.`Status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Imagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Imagem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(500) NOT NULL,
  `fk_id_anuncio` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Imagem_Anuncio1_idx` (`fk_id_anuncio` ASC) VISIBLE,
  CONSTRAINT `fk_Imagem_Anuncio1`
    FOREIGN KEY (`fk_id_anuncio`)
    REFERENCES `sebo_virtual`.`Historico_Anuncio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Pedido_tem_Anuncio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Pedido_tem_Anuncio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_pedido` INT NOT NULL COMMENT 'Id do pedido.',
  `id_anuncio` INT NOT NULL COMMENT 'Id do anúncio.',
  `quantidade` INT NOT NULL COMMENT 'Quantidade comprada do anúncio.',
  INDEX `fk_Pedido_has_Anuncio_Anuncio1_idx` (`id_anuncio` ASC) VISIBLE,
  INDEX `fk_Pedido_has_Anuncio_Pedido1_idx` (`id_pedido` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Pedido_has_Anuncio_Pedido1`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `sebo_virtual`.`Pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_has_Anuncio_Anuncio1`
    FOREIGN KEY (`id_anuncio`)
    REFERENCES `sebo_virtual`.`Historico_Anuncio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Telefone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ddi` VARCHAR(2) NOT NULL DEFAULT '55',
  `ddd` VARCHAR(2) NOT NULL,
  `numero` VARCHAR(9) NOT NULL,
  `tipo` VARCHAR(20) NOT NULL,
  `fk_id_usuario` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Telefone_Usuario1_idx` (`fk_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_Telefone_Usuario`
    FOREIGN KEY (`fk_id_usuario`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Autor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Publicacao_tem_Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Publicacao_tem_Autor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_id_produto` INT NOT NULL,
  `fk_id_autor` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Livro_has_Autor_Autor1_idx` (`fk_id_autor` ASC) VISIBLE,
  INDEX `fk_Livro_has_Autor_Livro1_idx` (`fk_id_produto` ASC) VISIBLE,
  CONSTRAINT `fk_Livro_has_Autor_Livro1`
    FOREIGN KEY (`fk_id_produto`)
    REFERENCES `sebo_virtual`.`Publicacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Livro_has_Autor_Autor1`
    FOREIGN KEY (`fk_id_autor`)
    REFERENCES `sebo_virtual`.`Autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Legenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Legenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Midia_tem_Legenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Midia_tem_Legenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_id_produto` INT NOT NULL,
  `fk_id_legenda` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Midia_has_Legenda_Legenda1_idx` (`fk_id_legenda` ASC) VISIBLE,
  INDEX `fk_Midia_has_Legenda_Midia1_idx` (`fk_id_produto` ASC) VISIBLE,
  CONSTRAINT `fk_Midia_has_Legenda_Midia1`
    FOREIGN KEY (`fk_id_produto`)
    REFERENCES `sebo_virtual`.`Midia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Midia_has_Legenda_Legenda1`
    FOREIGN KEY (`fk_id_legenda`)
    REFERENCES `sebo_virtual`.`Legenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Fale_Conosco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Fale_Conosco` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `fk_id_usuario` INT NULL,
  `fk_id_telefone` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Fale_Conosco_Usuario1_idx` (`fk_id_usuario` ASC) VISIBLE,
  INDEX `fk_Fale_Conosco_Telefone1_idx` (`fk_id_telefone` ASC) VISIBLE,
  CONSTRAINT `fk_Fale_Conosco_Usuario1`
    FOREIGN KEY (`fk_id_usuario`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fale_Conosco_Telefone1`
    FOREIGN KEY (`fk_id_telefone`)
    REFERENCES `sebo_virtual`.`Telefone` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Usuario_favorita_Anuncio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Usuario_favorita_Anuncio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_id_usuario` INT NOT NULL,
  `fk_id_anuncio` INT NOT NULL,
  INDEX `fk_Usuario_has_HistoricoAnuncio_HistoricoAnuncio1_idx` (`fk_id_anuncio` ASC) VISIBLE,
  INDEX `fk_Usuario_has_HistoricoAnuncio_Usuario1_idx` (`fk_id_usuario` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Usuario_has_HistoricoAnuncio_Usuario1`
    FOREIGN KEY (`fk_id_usuario`)
    REFERENCES `sebo_virtual`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_HistoricoAnuncio_HistoricoAnuncio1`
    FOREIGN KEY (`fk_id_anuncio`)
    REFERENCES `sebo_virtual`.`Historico_Anuncio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Motivo_Devolucao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Motivo_Devolucao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sebo_virtual`.`Pedido_tem_Anuncio_Devolvido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sebo_virtual`.`Pedido_tem_Anuncio_Devolvido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_id_pedido` INT NOT NULL,
  `fk_id_anuncio` INT NOT NULL,
  `quantidade_devolvida` INT NOT NULL,
  `fk_id_motivo_devolucao` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pedido_has_Historico_Anuncio_Historico_Anuncio1_idx` (`fk_id_anuncio` ASC) VISIBLE,
  INDEX `fk_Pedido_has_Historico_Anuncio_Pedido1_idx` (`fk_id_pedido` ASC) VISIBLE,
  INDEX `fk_Pedido_tem_Anuncio_Devolvido_MotivoDevolucao1_idx` (`fk_id_motivo_devolucao` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_has_Historico_Anuncio_Pedido1`
    FOREIGN KEY (`fk_id_pedido`)
    REFERENCES `sebo_virtual`.`Pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_has_Historico_Anuncio_Historico_Anuncio1`
    FOREIGN KEY (`fk_id_anuncio`)
    REFERENCES `sebo_virtual`.`Historico_Anuncio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_tem_Anuncio_Devolvido_MotivoDevolucao1`
    FOREIGN KEY (`fk_id_motivo_devolucao`)
    REFERENCES `sebo_virtual`.`Motivo_Devolucao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
