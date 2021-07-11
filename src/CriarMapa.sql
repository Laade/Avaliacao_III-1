CREATE TABLE MAPA (
   id VARCHAR(20) NOT NULL,
   descricao VARCHAR(30) NOT NULL,
   simbolo VARCHAR(35) NOT NULL,
   tipoCor int NOT NULL,
   PRIMARY KEY (id) 
   FOREIGN KEY (tipoCor)
);

CREATE TABLE COR_RGB (
   tipoCor int NOT NULL,
   red INT NOT NULL,
   green INT NOT NULL,
   blue INT,
   PRIMARY KEY (tipoCor)
);

CREATE TABLE COR_CMYK (
   tipoCor int NOT NULL,
   cyan INT NOT NULL,
   magenta INT NOT NULL,
   yellow INT NOT NULL,
   keyblack INT NOT NULL,
   PRIMARY KEY (tipoCor)
);
