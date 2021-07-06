CREATE SCHEMA IF NOT EXISTS `eglobus` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `eglobus`.`users` (
                                   `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                   `name` VARCHAR(45) NOT NULL,
                                   PRIMARY KEY (`id`),
                                   UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `eglobus`.`orders` (
                                    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                    `user_id` INT UNSIGNED NOT NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
                                    CONSTRAINT `user_id`
                                        FOREIGN KEY (`user_id`)
                                            REFERENCES `eglobus`.`users` (`id`)
                                            ON DELETE NO ACTION
                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `eglobus`.`products` (
                                      `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                      `name` VARCHAR(45) NOT NULL,
                                      `price` DECIMAL(10,2) UNSIGNED NULL,
                                      PRIMARY KEY (`id`),
                                      UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `eglobus`.`order_products` (
                                            `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                            `order_id` INT UNSIGNED NOT NULL,
                                            `product_id` INT UNSIGNED NOT NULL,
                                            `quantity` INT UNSIGNED NOT NULL,
                                            `last_price` DECIMAL(10,2) UNSIGNED NOT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                            INDEX `fk_order_id_idx` (`order_id` ASC) VISIBLE,
                                            INDEX `fk_product_id_idx` (`product_id` ASC) VISIBLE,
                                            CONSTRAINT `fk_order_id`
                                                FOREIGN KEY (`order_id`)
                                                    REFERENCES `eglobus`.`orders` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION,
                                            CONSTRAINT `fk_product_id`
                                                FOREIGN KEY (`product_id`)
                                                    REFERENCES `eglobus`.`products` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO users (name) VALUES
('Sergey'),
('Nikita'),
('Daniil');

INSERT INTO orders (user_id) VALUES (1), (2), (3);

INSERT INTO products (name, price) VALUES
('Молоко 3,5%, 1 л', 89.99),
('Сметана 15%, 300 г', 75.99),
('Хлеб Бородинский, 300 г', 21.99),
('Сыр Четук 45%, 370 г', 231.99),
('Хлопья овсяные, 500 г', 63.99);

INSERT INTO order_products (order_id, product_id, quantity, last_price) VALUES
(1, 1, 1, 69.99),
(1, 2, 1, 67.99),
(1, 5, 1, 63.99),
(2, 1, 2, 89.99),
(2, 3, 2, 21.99),
(2, 4, 1, 231.99),
(3, 1, 2, 74.99),
(3, 3, 1, 20.99),
(3, 4, 1, 228.99),
(3, 5, 2, 63.99);