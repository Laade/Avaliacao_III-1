CREATE SCHEMA `mapas` ;

CREATE TABLE MAPA (
   id VARCHAR(20) NOT NULL,
   descricao VARCHAR(30) NOT NULL,
   PRIMARY KEY (id) 
);

CREATE TABLE SIMBOLO (
   id INT NOT NULL,
   descricao VARCHAR(30) NOT NULL,
   PRIMARY KEY (id)
   
);

CREATE TABLE COR(
   id INT NOT NULL,
   simbolo_id INT NOT NULL,
   red INT NULL,
   green INT NULL,
   blue INT NULL,
   cyan INT NULL,
   magenta INT NULL,
   yellow INT NULL,
   keyblack INT NULL,
   tipocor INT NULL,
   descricao VARCHAR(45) NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (simbolo_id) REFERENCES SIMBOLO(id)
);

INSERT INTO `mapas`.`simbolo` (`id`,`descricao`) VALUES (1,"ÁGUA");
INSERT INTO `mapas`.`simbolo` (`id`,`descricao`) VALUES (2,"VEGETAÇÃO");
INSERT INTO `mapas`.`simbolo` (`id`,`descricao`) VALUES (3,"TERRENO");
INSERT INTO `mapas`.`simbolo` (`id`,`descricao`) VALUES (4,"PEDRAS E ROCHAS");
INSERT INTO `mapas`.`simbolo` (`id`,`descricao`) VALUES (5,"CONSTRUÇÕES");
INSERT INTO `mapas`.`simbolo` (`id`,`descricao`) VALUES (6,"ÁREA ISOLADA");




INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (1,1,0,0,139,0,0,0,0,1,'MAR - AZUL ESCURO');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (2,1,0,0,205,0,0,0,0,1,'RIO - AZUL MEDIO');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (3,1,0,0,255,0,0,0,0,1,'LAGO - AZUL');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (4,1,0,0,0,25,6,0,10,2,'CHARCOS - AZUL CLARO');

INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (5,2,0,100,0,0,0,0,0,1,'FLORESTA - VERDE ESCURO');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (6,2,41,171,135,0,0,0,0,1,'AREA SEMIABERTA - SELVA VERDE');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (7,2,0,0,0,41,0,48,24,2,'AREA DE CULTIVO - VERDE CLARO');

INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (8,3,150,75,0,0,0,0,0,1,'TERRENO IRREGULAR - MARROM ESCURO');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (9,3,92,64,51,0,0,0,0,1,'EROSAO - MARROM');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (10,3,0,0,0,0,30,45,64,2,'CURVA DE NIVEL - MARROM');

INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (11,4,0,0,0,0,0,0,0,1,'PEDRA GIGANTE - PRETO');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (12,4,128,128,128,0,0,0,0,1,'AFLORAMENTO ROCHOSO - CINZA');

INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (13,5,255,0,0,0,0,0,0,1,'AREA PAVIMENTADA');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (14,5,255,0,0,0,0,0,0,1,'ESTRADAS VICINAIS');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (15,5,0,0,0,0,0,16,50,2,'ESTRADA LARGA');

INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (16,6,255,0,0,0,0,0,0,1,'AREA ISOLADA');
INSERT INTO `mapas`.`cor`(`id`,`simbolo_id`,`red`,`green`,`blue`,`cyan`,`magenta`,`yellow`,`keyblack`,`tipocor`,`descricao`) VALUES (17,6,0,0,0,0,100,100,0,2,'AREA ISOLADA');

