package main.business;

import java.sql.SQLException;
import main.data.TurnoDAO;
import main.data.UcDAO;

public class Aluno extends Utilizador {

    private boolean prioritario;
    private String numero;
    private UcDAO ucs;
    private TurnoDAO turnos;

    public Aluno(String nome, String email, String password, boolean prioritario,String numero) {
        super(nome, email, password);
        this.prioritario = prioritario;
        this.numero = numero;
        this.ucs = new UcDAO();
        this.turnos = new TurnoDAO();
    }

    public boolean getPrioridade() {
        return prioritario;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    public void alteraTurno(SolicitacaoTroca t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    boolean solicitaTurno(String codUC, String codTurnoD, String codAluno) throws SQLException {
        boolean trocou = false;

        UC uct = ucs.get(codUC);

        String codTurnoS = turnos.getCodMyTurno(codUC, codAluno);

        if (this.prioritario) {
            trocou = uct.trataPrioritario(codUC,codTurnoS,codTurnoD,codAluno);
        } else {
            trocou = uct.trataTroca(codUC, codTurnoS, codTurnoD, codAluno);

        }
        return trocou;
    }

    void remFilaEspera(String codUc, String id_turnoD) {
        UC uct = ucs.get(codUc);

        String id_turnoS = turnos.getCodMyTurno(codUc, this.numero);

        uct.remFilaEspera(this.getNumero(),id_turnoD,id_turnoS,codUc);
    }
}
