CREATE TABLE `terminal_autobuse`.`usuario` (
    `id_usuario` INT NOT NULL AUTO_INCREMENT, 
    `email` VARCHAR(40) NULL, 
    `password` VARCHAR(30) NULL, 
    `nombre` VARCHAR(30) NULL, 
    `apellido` VARCHAR(30) NULL, 
    PRIMARY KEY (`id_usuario`));

CREATE TABLE `terminal_autobuse`.`cliente` (
    `id_cliente` INT NOT NULL, 
    `telefono` INT NULL, 
    `fech_ingreso` INT NULL, 
    PRIMARY KEY (`id_cliente`));