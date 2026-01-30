
CREATE TABLE `pals_aptidoes` (
    
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `pal_id` BIGINT UNSIGNED NOT NULL,
    `aptidao_id` BIGINT UNSIGNED NOT NULL,
    `nivel` INT UNSIGNED NOT NULL,
    
    PRIMARY KEY (`id`),
    UNIQUE (`pal_id`, `aptidao_id`),
    
    CONSTRAINT `fk_pals_aptidoes_pal_id`
      FOREIGN KEY (`pal_id`)
      REFERENCES `pals` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE

    CONSTRAINT `fk_pals_aptidoes_aptidao_id`
      FOREIGN KEY (`aptidao_id`)
      REFERENCES `aptidoes` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE

  );
