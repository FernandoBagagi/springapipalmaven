
CREATE TABLE `pals` (
    
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `numero` VARCHAR(4) NOT NULL,
    `nome` VARCHAR(100) NOT NULL,
    `descricao` TEXT NOT NULL,
    
    PRIMARY KEY (`id`),
    UNIQUE (`numero`),
    UNIQUE (`nome`)

  );
    