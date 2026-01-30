
CREATE TABLE `pals_tipos` (
    
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `pal_id` BIGINT UNSIGNED NOT NULL,
    `tipo_id` BIGINT UNSIGNED NOT NULL,
    
    PRIMARY KEY (`id`),
    UNIQUE (`pal_id`, `tipo_id`),
    
    CONSTRAINT `fk_pals_tipos_pal_id`
      FOREIGN KEY (`pal_id`)
      REFERENCES `pals` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,

    CONSTRAINT `fk_pals_tipos_tipo_id`
      FOREIGN KEY (`tipo_id`)
      REFERENCES `tipos` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE

  );
