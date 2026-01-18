
CREATE TABLE `refresh_tokens` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `token` CHAR(36) NOT NULL,
  `expires_at` TIMESTAMP NOT NULL,
  `usuario_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `refresh_tokens_token_UNIQUE` (`token` ASC) VISIBLE,
  UNIQUE INDEX `refresh_tokens_usuario_id_UNIQUE` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_refresh_tokens_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `usuarios` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
