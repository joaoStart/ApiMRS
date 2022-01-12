CREATE TABLE cliente(
	id bigint NOT NULL auto_increment,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,

    PRIMARY KEY (ID)
);