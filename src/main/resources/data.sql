
CREATE SCHEMA IF NOT EXISTS `pizzaShop` DEFAULT CHARACTER SET utf8 ;
USE `pizzaShop` ;

--------------------------------------
-- Table `pizzaShop`.`basis_pizza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaShop`.`basis_pizza` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `radius` INT(11) NOT NULL,
  `wage_basis` INT(11) NOT NULL,
  `price_basis` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pizzaShop`.`good_pizza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaShop`.`good_pizza` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT(11) NOT NULL,
  `proc_value` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pizzaShop`.`basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaShop`.`basket` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `good_pizza_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `good_pizza_id`),
  INDEX `fk_basket_good_pizza_idx` (`good_pizza_id` ASC),
  CONSTRAINT `fk_basket_good_pizza`
    FOREIGN KEY (`good_pizza_id`)
    REFERENCES `pizzaShop`.`good_pizza` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pizzaShop`.`coupon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaShop`.`coupon` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `used` INT(11) NULL DEFAULT NULL,
  `count_discont` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pizzaShop`.`history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaShop`.`history` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `order_pizza_id` INT(11) NOT NULL,
  `timeOrder` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pizzaShop`.`ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaShop`.`ingredients` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name_ingredient` VARCHAR(45) NOT NULL,
  `price_per_kg` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pizzaShop`.`pizza_const`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaShop`.`pizza_const` (
  `wage_ingredient` INT(11) NULL DEFAULT NULL,
  `good_pizza_id` INT(11) NOT NULL,
  `basis_pizza_id` INT(11) NOT NULL,
  `ingredients_id` INT(11) NOT NULL,
  PRIMARY KEY (`good_pizza_id`, `basis_pizza_id`, `ingredients_id`),
  INDEX `fk_pizza_const_basis_pizza1_idx` (`basis_pizza_id` ASC),
  INDEX `fk_pizza_const_ingredients1_idx` (`ingredients_id` ASC),
  CONSTRAINT `fk_pizza_const_basis_pizza1`
    FOREIGN KEY (`basis_pizza_id`)
    REFERENCES `pizzaShop`.`basis_pizza` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pizza_const_good_pizza1`
    FOREIGN KEY (`good_pizza_id`)
    REFERENCES `pizzaShop`.`good_pizza` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pizza_const_ingredients1`
    FOREIGN KEY (`ingredients_id`)
    REFERENCES `pizzaShop`.`ingredients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pizzaShop`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaShop`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name_user` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;




ALTER TABLE pizzaShop.ingredients AUTO_INCREMENT = 1;
INSERT INTO pizzaShop.ingredients(id, name_ingredient, price_per_kg)
VALUES(1,"name_ingredient_1",1);
INSERT INTO pizzaShop.ingredients(id, name_ingredient, price_per_kg)
VALUES(2,"name_ingredient_2",2);
INSERT INTO pizzaShop.ingredients(id, name_ingredient, price_per_kg)
VALUES(3,"name_ingredient_3",3);

ALTER TABLE pizzaShop.basis_pizza AUTO_INCREMENT = 1;
INSERT INTO pizzaShop.basis_pizza(id,radius,wage_basis, price_basis)
VALUES(1,10,10,10);
INSERT INTO pizzaShop.basis_pizza(id,radius,wage_basis, price_basis)
VALUES(2,12,12,12);
INSERT INTO pizzaShop.basis_pizza(id,radius,wage_basis, price_basis)
VALUES(3,13,13,13);

ALTER TABLE pizzaShop.good_pizza AUTO_INCREMENT = 1;
INSERT INTO pizzaShop.good_pizza(id,name,price, proc_value)
VALUES(1,"name_pizza_1",0,100);
INSERT INTO pizzaShop.good_pizza(id,name,price, proc_value)
VALUES(2,"name_pizza_2",0,100);
INSERT INTO pizzaShop.good_pizza(id,name,price, proc_value)
VALUE(3,"name_pizza_3",0,100);

ALTER TABLE pizzaShop.pizza_const AUTO_INCREMENT = 1;
INSERT INTO pizzaShop.pizza_const(wage_ingredient,good_pizza_id,basis_pizza_id, ingredients_id)
VALUES(1,1,1,1);
INSERT INTO pizzaShop.pizza_const(wage_ingredient,good_pizza_id,basis_pizza_id, ingredients_id)
VALUES(1,2,2,1);
INSERT INTO pizzaShop.pizza_const(wage_ingredient,good_pizza_id,basis_pizza_id, ingredients_id)
VALUES(2,2,2,2);
INSERT INTO pizzaShop.pizza_const(wage_ingredient,good_pizza_id,basis_pizza_id, ingredients_id)
VALUES(1,3,3,1);
INSERT INTO pizzaShop.pizza_const(wage_ingredient,good_pizza_id,basis_pizza_id, ingredients_id)
VALUES(2,3,3,2);
INSERT INTO pizzaShop.pizza_const(wage_ingredient,good_pizza_id,basis_pizza_id, ingredients_id)
VALUES(3,3,3,3);

ALTER TABLE pizzaShop.basket AUTO_INCREMENT = 1;
INSERT INTO pizzaShop.basket(good_pizza_id)
VALUES(1);
INSERT INTO pizzaShop.basket(good_pizza_id)
VALUES(2);
INSERT INTO pizzaShop.basket(good_pizza_id)
VALUES(3);
ALTER TABLE pizzaShop.history AUTO_INCREMENT = 1;
INSERT INTO pizzaShop.history(order_pizza_id, timeOrder)
VALUES(1,now());
INSERT INTO pizzaShop.history(order_pizza_id, timeOrder)
VALUES(2,now());
INSERT INTO pizzaShop.history(order_pizza_id, timeOrder)
VALUES(3,now());

