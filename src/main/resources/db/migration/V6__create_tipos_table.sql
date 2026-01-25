
CREATE TABLE `tipos` (
    
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `codigo_enum` VARCHAR(15) NOT NULL,
    `nome` VARCHAR(20) NOT NULL,
    
    PRIMARY KEY (`id`),
    UNIQUE (`codigo_enum`),
    
    CONSTRAINT 
      `chk_codigo_enum_tipos`
    CHECK (
      `codigo_enum` 
      IN 
      ('GRAMA',
       'TERRA',
       'ELETRICO',
       'AGUA',
       'FOGO',
       'GELO',
       'DRACONICO',
       'ESCURIDAO',
       'NAO_ELEMENTAL')
    )

  );
    