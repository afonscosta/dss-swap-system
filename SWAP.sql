USE SWAP;

/* INSERT INTO UC () VALUES ('ALG','Algoritmos');

INSERT INTO Horario () VALUES(2,3,2);
INSERT INTO Horario () VALUES(1,3,2);

*/
INSERT INTO Utilizador(idUtilizadores,nome,password,uc,regente) VALUES ('jbb','joao','123','ALG',1);
INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a79089','edgar','213',0);
INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a99999','joao','123',0);
INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a12341','pedro','123',0);
INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a46683','antonio','123',1);
INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a54658','carlos','123',1);
INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a91463','patricia','123',0);
INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a12442','joana','123',0);
INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade) VALUES ('a86753','marco','123',0);


INSERT INTO UtilizadorTurno() VALUES('a79089','TP2','ALG');
INSERT INTO UtilizadorTurno() VALUES('a86753','TP3','ALG');
INSERT INTO UtilizadorTurno() VALUES('a99999','TP1','ALG');
INSERT INTO UtilizadorTurno() VALUES('a54658','TP3','ALG');
INSERT INTO UtilizadorTurno() VALUES('a12341','TP1','ALG');
INSERT INTO UtilizadorTurno() VALUES('a46683','TP2','ALG');
INSERT INTO UtilizadorTurno() VALUES('a12442','TP3','ALG');



INSERT INTO UtilizadorTurno() VALUES('jbb','TP1','ALG');
INSERT INTO UtilizadorTurno() VALUES('jbb','TP2','ALG');
INSERT INTO UtilizadorTurno() VALUES('jbb','TP3','ALG');

INSERT INTO SolicitacaoTroca (turnoS,turnoD,aluno,UC_codigo) VALUES ('TP1','TP2','a99999','ALG');







SELECT UtilizadorTurno.Turno_UC_codigo,Turno.numero
FROM UtilizadorTurno 
JOIN Turno ON Turno.UC_codigo = UtilizadorTurno.Turno_UC_codigo
WHERE Utilizador_idUtilizadores = 'a12341'
AND UtilizadorTurno.Turno_numero <> Turno.numero;



