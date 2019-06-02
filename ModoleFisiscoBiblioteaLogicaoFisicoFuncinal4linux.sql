/* Lógico_2: */

CREATE TABLE Acervo (
    Codigo_Acervo INTEGER PRIMARY KEY,
    Data_entrada DATE,
    Publicacao DATE,
    Autor VARCHAR(255),
    Tipo VARCHAR(255),
    Tombo INTEGER,
    Patrimonio INTEGER,
    Titulo VARCHAR(255)
);

CREATE TABLE Exemplar (
    Codigo_Exemplar INTEGER,
    Quantidade INTEGER,
    NF NUMERIC,
    fk_Acervo_Codigo_Acervo INTEGER,
    fk_Associado_Prontuario INTEGER,
    ID INTEGER,
    Data_emp DATE,
    Data_dev DATE,
    PRIMARY KEY (Codigo_Exemplar, ID)
);

CREATE TABLE Associado (
    Prontuario INTEGER PRIMARY KEY,
    Nome VARCHAR(255),
    Endereco VARCHAR(255),
    Telefone VARCHAR(255),
    Tipo VARCHAR(255)
);

CREATE TABLE Professor (
    fk_Associado_Prontuario INTEGER PRIMARY KEY
);

CREATE TABLE Aluno (
    fk_Associado_Prontuario INTEGER PRIMARY KEY
);

CREATE TABLE Servidor (
    fk_Associado_Prontuario INTEGER PRIMARY KEY
);

CREATE TABLE Livro (
    ISBN INTEGER,
    editora VARCHAR(255),
    Edicao INTEGER,
    fk_Acervo_Codigo_Acervo INTEGER PRIMARY KEY
);

CREATE TABLE Revista (
    Edicao INTEGER,
    fk_Acervo_Codigo_Acervo INTEGER PRIMARY KEY
);

CREATE TABLE TCC (
    FK_Acervo_Codigo_Acervo INTEGER PRIMARY KEY
);

CREATE TABLE Midias_Digitais (
    Tipo VARCHAR(255),
    fk_Acervo_Codigo_Acervo INTEGER PRIMARY KEY
);

CREATE TABLE Reserva (
    fk_Acervo_Codigo_Acervo INTEGER,
    fk_Associado_Prontuario INTEGER,
    Numero_Reserva INTEGER,
    Data_Realizacao DATE,
    Data_Reserva DATE,
    PRIMARY KEY (Numero_Reserva, fk_Acervo_Codigo_Acervo, fk_Associado_Prontuario)
);
 
ALTER TABLE Exemplar ADD CONSTRAINT FK_Exemplar_2
    FOREIGN KEY (fk_Acervo_Codigo_Acervo)
    REFERENCES Acervo (Codigo_Acervo)
    
 
ALTER TABLE Exemplar ADD CONSTRAINT FK_Exemplar_3
    FOREIGN KEY (fk_Associado_Prontuario)
    REFERENCES Associado (Prontuario)
   
 
ALTER TABLE Professor ADD CONSTRAINT FK_Professor_2
    FOREIGN KEY (fk_Associado_Prontuario)
    REFERENCES Associado (Prontuario)

 
ALTER TABLE Aluno ADD CONSTRAINT FK_Aluno_2
    FOREIGN KEY (fk_Associado_Prontuario)
    REFERENCES Associado (Prontuario)
 
 
ALTER TABLE Servidor ADD CONSTRAINT FK_Servidor_2
    FOREIGN KEY (fk_Associado_Prontuario)
    REFERENCES Associado (Prontuario)
  
 
ALTER TABLE Livro ADD CONSTRAINT FK_Livro_2
    FOREIGN KEY (fk_Acervo_Codigo_Acervo)
    REFERENCES Acervo (Codigo_Acervo)
 
 
ALTER TABLE Revista ADD CONSTRAINT FK_Revista_2
    FOREIGN KEY (fk_Acervo_Codigo_Acervo)
    REFERENCES Acervo (Codigo_Acervo)
   
 
ALTER TABLE TCC ADD CONSTRAINT FK_TCC_2
    FOREIGN KEY (FK_Acervo_Codigo_Acervo)
    REFERENCES Acervo (Codigo_Acervo)
    
 
ALTER TABLE Midias_Digitais ADD CONSTRAINT FK_Midias_Digitais_2
    FOREIGN KEY (fk_Acervo_Codigo_Acervo)
    REFERENCES Acervo (Codigo_Acervo)
   
 
ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_2
    FOREIGN KEY (fk_Acervo_Codigo_Acervo)
    REFERENCES Acervo (Codigo_Acervo)
 
 
ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_3
    FOREIGN KEY (fk_Associado_Prontuario)
    REFERENCES Associado (Prontuario)
  


	insert into Associado values(4002, 'Vinicius', 'VilaFatima', 087, 'Aluno')
	insert into Associado values(4003, 'Lucas Calixto', 'Vales dos estagiarios', 088, 'Servidor')
	insert into Associado values(4004, 'Thiago', 'Vale dos Severs', 089, 'Professor')
	insert into Acervo values(121,'02/06/2019', '02/06/2019', 'Pedro Pocket', 'livro',245878,001230, 'Professor')

	select * from Acervo
	
	drop table Associado
	drop table Exemplar
	drop table Livro
	drop table Midias_Digitais
	drop table Reserva
	drop table Revista
	drop table TCC
	drop table Acervo