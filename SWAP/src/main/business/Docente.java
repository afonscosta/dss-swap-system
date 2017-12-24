package main.business;

import main.data.TurnoDAO;

import java.sql.SQLException;
import java.util.Map;

public class Docente extends Utilizador {
    String uc;
    int regente; /* 0 nao regente, 1 regente (para adicionar em sql) */
    TurnoDAO turnosLeciona;

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

    public Map<String,Aluno> getAlunos(String codUC, String codTurno) {
        Map<String,Aluno> res = null;
        try {
            res = turnosLeciona.getAlunos(codUC,codTurno);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }
}
