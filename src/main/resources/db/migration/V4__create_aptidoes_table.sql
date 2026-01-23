
CREATE TABLE `aptidoes` (
    
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `codigo_enum` VARCHAR(20) NOT NULL,
    `nome` VARCHAR(30) NOT NULL,
    
    PRIMARY KEY (`id`),
    UNIQUE (`codigo_enum`),
    
    CONSTRAINT 
      `chk_codigo_enum_aptidoes`
    CHECK (
      `codigo_enum` 
      IN 
      ('ACENDER_FOGO',
        'PLANTIO',
        'TRABALHO_MANUAL',
        'CORTAR_ARVORES',
        'MANIPULACAO',
        'TRANSPORTE',
        'REGA',
        'GERACAO_DE_ENERGIA',
        'COLETA',
        'GARIMPO',
        'REFRIGERACAO',
        'FAZENDA')
    )

  );
