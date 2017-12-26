package main.business;

import main.data.TurnoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Docente extends Utilizador {
    private String uc;
    private int regente; /* 0 nao regente, 1 regente (para adicionar em sql) */
    private TurnoDAO turnosLeciona;

    public Docente(String nome, String email, String password, String uc, int regente) {
        super(nome, email, password);
        this.uc = uc;
        this.regente = regente;
        this.turnosLeciona = new TurnoDAO();
    }

    public int getRegente() {
        return regente;
    }

    public String getUC() {
        return this.uc;
    }

    ArrayList<String[]> getAlunos(String codUC, String codTurno) {
        ArrayList<String[]> res = null;
        try {
            res = turnosLeciona.getAlunos(codUC,codTurno);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

	ArrayList<Turno> getTurnos(String codDocente) {
		return turnosLeciona.getTurnos(codDocente);
	}


}
