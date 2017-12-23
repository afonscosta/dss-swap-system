USE SWAP;

INSERT INTO UC () VALUES ('ALG','Algoritmos');

INSERT INTO Horario () VALUES(2,3,2);
INSERT INTO Horario () VALUES(1,3,2);

INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a79089','edgar','213',0);
INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a99999','joao','123',0);


INSERT INTO Sala () VALUES('101',200);

INSERT INTO Turno () VALUES('TP2','ALG',20,1,'101','09:00:00','01:00:00');

INSERT INTO UtilizadorTurno() VALUES('a79089','TP2','ALG');

INSERT INTO Turno() VALUES('TP1','ALG',20,1,'101','09:00:00','01:00:00');
INSERT INTO Turno() VALUES('TP4','ALG',20,1,'101','09:00:00','01:00:00');

INSERT INTO UtilizadorTurno() VALUES('a99999','TP1','ALG');



INSERT INTO SolicitacaoTroca (turnoS,turnoD,aluno,UC_codigo) VALUES ('TP1','TP2','a99999','ALG');
