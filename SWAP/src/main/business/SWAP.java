package main.business;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
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

    public Turno adicionaTurno (String id, String UC_codigo, Integer capacidade, String sala, Integer horarioId, LocalTime horaInicio, LocalTime duracao,Integer aulasPrevistas,int diaSemana) {

        Turno t = new Turno(id, UC_codigo, capacidade, sala, horarioId, horaInicio, duracao,aulasPrevistas,diaSemana);
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
    public ArrayList<String[]> getAlunos(String codUC, String codTurno) {
        Docente doc = (Docente) utilizadores.get(extraiChave(sessao.getEmail()));
        return doc.getAlunos(codUC,codTurno);
    }

    public void analisaTroca(String codAluno,String codUc,String codTurnoS,String codTurnoD,boolean aceita) {

        docenteRemoveSolicitacaoTurno(codAluno,codUc,codTurnoD,codTurnoS);

        if (aceita) {
            Aluno a = (Aluno) utilizadores.get(codAluno);
            a.moveTurno(codUc,codTurnoS,codTurnoD,codAluno);


        }
    }

    public ArrayList<Turno> getMyTurnos() {
        ArrayList<Turno> res = null;
        String chave = this.extraiChave(sessao.getEmail());
        if (chave.startsWith("a") && Character.isDigit(chave.charAt(1))) { // é um aluno

            Aluno a = (Aluno) utilizadores.get(this.extraiChave(sessao.getEmail()));
            res = a.getTurnos(this.extraiChave(sessao.getEmail()));

        } else if (!chave.equals("dcmiei")) {
            Docente d = (Docente) utilizadores.get(this.extraiChave(sessao.getEmail()));
            res = d.getTurnos(this.extraiChave(sessao.getEmail()));

        }
        return res;
    }

    public boolean existeUC(String uc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean existeTurno(String uc, String turno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Todas as solicitações de um dada UC
    public ArrayList<String[]> getSolicitacoesUC(String uc) {
        Docente docente = (Docente) sessao;

        return docente.getSolicitacoes(uc);
    }

    public void docenteRemoveSolicitacaoTurno(String codAluno, String codUC, String codTurnoD,String codTurnoS) {
        Docente docenteAtual = (Docente) sessao;

        docenteAtual.remFilaEspera(codAluno,codUC,codTurnoD,codTurnoS);
    }

    public String[] getAluno(String chave) {
        Aluno a = (Aluno) utilizadores.get(chave);
        String[] res = new String[3];
        res[0] = a.getNumero();
        res[1] = a.getNome();
        res[2] = a.getEmail();
        return res;
    }

    public HashMap<String,String[]> getSolicitacoesAluno() {
        Aluno aluno = (Aluno) sessao;

        return aluno.getSolicitacoes(aluno.getNumero());
    }
}
