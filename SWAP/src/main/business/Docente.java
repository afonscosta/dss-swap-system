package main.business;

import main.data.TurnoDAO;
import main.data.UcDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Docente extends Utilizador {
    private String uc;
    private int regente; /* 0 nao regente, 1 regente (para adicionar em sql) */
    private TurnoDAO turnosLeciona;
    private UcDAO ucsLeciona;

    public Docente(String nome, String email, String password, String uc, int regente) {
        super(nome, email, password);
        this.uc = uc;
        this.regente = regente;
        this.turnosLeciona = new TurnoDAO();
        this.ucsLeciona = new UcDAO();
    }

    public int getRegente() {
        return regente;
    }

    public String getUC() {
        return this.uc;
    }

    ArrayList<String[]> getAlunos(String codUC, String codTurno) {
        ArrayList<String[]> res = null;
        res = turnosLeciona.getAlunos(codUC,codTurno);

        return res;
    }

	ArrayList<Turno> getTurnos(String codDocente) {
		return turnosLeciona.getTurnos(codDocente);
	}


    void remFilaEspera(String codAluno, String codUC, String codTurnoD,String codTurnoS) {
        UC uc = ucsLeciona.get(codUC);

        uc.remFilaEspera(codAluno,codTurnoD,codTurnoS,codUC);
    }

    ArrayList<String[]> getSolicitacoes(String uc) {
        UC uct = ucsLeciona.get(uc);

        return uct.getSolicitacoes(uc);

    }
}
