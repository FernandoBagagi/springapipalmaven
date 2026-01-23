
CREATE TABLE `refresh_tokens` (
    
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `token` CHAR(36) NOT NULL,
    `expires_at` TIMESTAMP NOT NULL,
    `usuario_id` BIGINT UNSIGNED NOT NULL,
    
    PRIMARY KEY (`id`),
    UNIQUE (`token`),
    UNIQUE (`usuario_id`),
    
    CONSTRAINT `fk_refresh_tokens_usuario`
      FOREIGN KEY (`usuario_id`)
      REFERENCES `usuarios` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE

  );
