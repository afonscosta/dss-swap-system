package main.business;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.data.HorarioDAO;
import main.data.UtilizadorDAO;

public class SWAP {

    private Utilizador sessao;
    private UtilizadorDAO utilizadores;
    private HorarioDAO horarios;

    public SWAP () {
        sessao = null;
        utilizadores = new UtilizadorDAO();
        horarios = new HorarioDAO();
    }

//    private Horario getHorario(Integer ano, Integer semestre) {
//        return horarios.getHorario(ano,semestre);
//    }

    public String extraiChave (String email) {
        StringBuilder res = new StringBuilder();
        if (!email.contains("@")) {
            return null;
        } else {
            for (int i = 0; i < email.length() && email.charAt(i) != '@'; i++) {
                res.append(email.charAt(i));
            }
            return res.toString();
        }
    }

    private boolean aceitaTroca(SolicitacaoTroca t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isRegente(String chave) {
        int isRegente = -1;

        try {
            isRegente = utilizadores.isRegente(chave);
        } catch (SQLException ex) {
            Logger.getLogger(SWAP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (isRegente == 1);
    }
    
    /* USE CASES */

    public boolean registo (String nome,String email, String password,Object wildcard,int regente) {

        String chave = extraiChave(email);

        if (chave == null || utilizadores.containsKey(chave)) {
            return false;
        } else {
            try {
                if (chave.startsWith("a") && Character.isDigit(chave.charAt(1))) { // é um aluno

                    utilizadores.putAluno(chave, new Aluno(nome,email,password,(boolean) wildcard,chave));

                } else if (chave.equals("dcmiei")) { // é direção de curso
                    utilizadores.putDirecaoCurso(chave,nome,password);

                } else { // é docente regente

                    utilizadores.putDocente(chave,new Docente(nome,email,password,(String) wildcard,regente));
                }
            } catch (SQLException ex) {
                Logger.getLogger(SWAP.class.getName()).log(Level.SEVERE, null, ex);
            }

            return true;
        }
    }

    public boolean autentica (String email, String password) {
        String chave = extraiChave(email);
        Utilizador u;
        if(chave == null || ((u = utilizadores.get(chave)) == null))
            return false;
        if (u.getPassword().equals(password) && u.getEmail().equals(email)) {
            sessao = u;
            return true;
        }
        return false;
    }

    public Turno adicionaTurno (String id, String UC_codigo, Integer capacidade, String sala, Integer horarioId, LocalTime horaInicio, LocalTime duracao,Integer aulasPrevistas) {

        Turno t = new Turno(id, UC_codigo, capacidade, sala, horarioId, horaInicio, duracao,aulasPrevistas);
        return t;
    }

    public boolean solicitaTurno(String codUC, String codTurnoD) throws SQLException {
        Aluno alunoAtual = (Aluno) sessao;
        return alunoAtual.solicitaTurno(codUC, codTurnoD, alunoAtual.getNumero());


    }

    public void removeSolicitacaoTurno(String codUc,String codTurno) {
        Aluno alunoAtual = (Aluno) sessao;

        alunoAtual.remFilaEspera(codUc,codTurno);
    }

    public void marcaFaltas(String codUC,String codTurno, ArrayList<String> alunos) {
        UC uc = null;
        try {
            uc = horarios.getUC(codUC);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        uc.marcaFaltas(alunos, codUC, codTurno);

    }

	//Esta função devolve um hashmap dos alunos de um determinado turno
	public Map<String, Aluno> getAlunos(String codUC, String codTurno) {
        Docente doc = (Docente) utilizadores.get(extraiChave(sessao.getEmail()));
        return doc.getAlunos(codUC,codTurno);
	}
	
//    public void analisaTrocaMaisAntiga(String codUc, Integer ano, Integer semest) {
//        Horario h = getHorario(ano,semestre);
//        UC uc = h.getUC(codUc);
//        Troca t = uc.popTrocaMaisAntiga();
//        
//        if (aceitaTroca(t)) { 
//            Aluno a1 = t.primeiro();
//            Aluno a2 = t.segundo();
//        
//            a1.alteraTurno(t);
//            a2.alteraTurno(t);
//        }
//    }

	//Hash com todas as solicitações de um dado aluno
	// key -> codUC
	// value -> solicitacao da respetiva UC
	public HashMap<String, SolicitacaoTroca> getSolicitacoes() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public ArrayList<Turno> getMyTurnos() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public boolean existeUC(String uc) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public boolean existeTurno(String uc, String turno) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	//Todas as solicitações de um dada UC
	public ArrayList<SolicitacaoTroca> getSolicitacoes(String uc) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	//Não precisa de remover a solicitacao
	public void mudaTurno(String codAluno, String codTurnoS, String codTurnoD) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public void docenteRemoveSolicitacaoTurno(String codAluno, String codUC, String codTurnoD) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
