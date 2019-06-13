/* L�gico_2: */

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
  


    /*Inserções no banco de dados: Associados*/

    insert into Associado values(4299843, 'Vinicius Ferrreira', 'Vila Fatima', '26239537', 'Aluno')
	insert into Associado values(7457465, 'Lucas Calixto', 'Vales dos estagiarios', '(11)3584-3797', 'Aluno')
	insert into Associado values(2747415, 'Thiago Henrique', 'Vale dos Serves', '(11)98141-4033', 'Aluno')
	insert into Associado values(4484012, 'Pedro da rocha', 'Franco da rocha', '(11)2827-6471', 'Professor')
	insert into Associado values(5751263, 'José Campos', 'Campo Limpo', '(11)99594-9610', 'Professor')
	insert into Associado values(3178282, 'Reginaldo Lourenso', 'Tiradentes', '(19)2654-4421', 'Professor')
	insert into Associado values(2441543, 'Reinaldo Prado', 'Tucuruvi', '(18)2799-4165', 'Professor')
	insert into Associado values(1551750, 'Pedro Washigton', 'Higienópolis', '(11)2644-8566', 'Servidor')
	insert into Associado values(3454455, 'Leticia Esmeralda', 'Bela Vista', '(11)99365-5032', 'Servidor')
	insert into Associado values(2507952, 'Marcia APOixoto', 'Nova Jersey', '(17) 2672-8974', 'Servidor')
	insert into Associado values(4242244, 'Robson Linnu', 'Helsinquia', '(17) 99814-8308', 'Professor')
	insert into Associado values(1312592, 'Juliana C. S. Souza', 'Akohabara', '(11) 2754-4907', 'Aluno')
	insert into Associado values(1375707, 'Lidia Beckham', ' Brooklin', '(11) 99263-3307', 'Servidor')

    /*Inserções no banco de dados: Acervo*/
	insert into Acervo values(1,'02/01/2007', '02/01/1975', 'Gregório de Matos', 'livro',608790,32088, 'Poemas Escolhidos')
	insert into Acervo values(2,'12/02/2009', '03/02/1891', 'Machado de Assis', 'livro',769163,75948, 'Quincas Borba')
	insert into Acervo values(3,'04/03/2013', '04/03/2001', 'Carlos Drummond de Andrade', 'livro',862508,49818, 'Claro Enigma')
	insert into Acervo values(4,'08/04/2014', '05/04/2004', 'Graciliano Ramos', 'livro',449522,78141, 'Angústia')
	insert into Acervo values(5,'09/05/2015', '06/05/2005', 'Eça de Queirós', 'livro',136011,68373, 'A Relíquia')
	insert into Acervo values(6,'02/06/2016', '07/06/2000', 'Mr. Catra; Tati Quebra-Barraco; Bonde Do Tigrão', 'midia_digital',576782,60299, 'Furacão 2000: Funk de Verdade')
	insert into Acervo values(7,'26/07/2009', '08/07/1997', 'Sérgio Bloch; Tânia Lamarca', 'midia_digital',482462,64539, 'Tainá - Uma Aventura na Amazônia')
	insert into Acervo values(8,'24/08/2004', '09/08/1994', 'Rob Minkoff; Roger Allers', 'midia_digital',663528,27289, 'O Rei Leão')
	insert into Acervo values(9,'30/09/2009', '10/09/2004', 'Dennie Gordon', 'midia_digital',193144,42107, 'No Pique de Nova York')
	insert into Acervo values(10,'12/10/2012', '11/10/2004', 'John Payson', 'midia_digital',266761,31841, 'Joe e as Baratas')
	insert into Acervo values(11,'19/11/2011', '12/11/2011', 'Ana Pereira', 'revista',112948,44105, 'Capricho: Cansei de ser a santa')
	insert into Acervo values(12,'17/12/2010', '13/11/2010', 'Mauricio de souza', 'revista',544650,28036, 'Turma da Mônica Jovem - Nº 50')
	insert into Acervo values(13,'22/11/2009', '14/12/1999', 'VELOZO, Erica Soares', 'tcc',376668,25884, 'A construção do autor como marca pela autopublicação por livro digital')
	insert into Acervo values(14,'21/10/2014', '15/01/1947', 'LAGO, Crislaine Ferreira', 'tcc',253581,13986, 'Pinacoteca Benedicto Calixto')
	insert into Acervo values(15,'20/09/2019', '16/02/1999', 'ASENJO, Maurício Neves', 'tcc',182796,28186, 'Acessando celular via computador')

    /**/


	select * from Acervo
	
	drop table Associado
	drop table Exemplar
	drop table Livro
	drop table Midias_Digitais
	drop table Reserva
	drop table Revista
	drop table TCC
	drop table Acervo

    -- Delete rows from table 'TableName'
    select * FROM Associado
