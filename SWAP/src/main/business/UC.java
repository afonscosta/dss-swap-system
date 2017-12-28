package main.business;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import main.data.SolicitacaoTrocaDAO;
import main.data.TurnoDAO;

public class UC {

    private String nome;
    private String codUC;
    private TurnoDAO turnos;
    private SolicitacaoTrocaDAO trocas;

    public UC (String nome,String codUc) {
        this.nome = nome;
        this.codUC = codUc;
        this.turnos = new TurnoDAO();
        this.trocas = new SolicitacaoTrocaDAO();
    }

    public String getNome() {
        return nome;
    }

    public SolicitacaoTroca popTrocaMaisAntiga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    public Troca popTrocaMaisAntiga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Aluno checkTroca(int idTurno, Turno ta) {
        // chamar trocaDAO aqui
    }

    void addFilaDeEspera(Aluno aThis, int idTurno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    boolean trataTroca(String codUC, String codTurnoS, String codTurnoD, String codAluno) throws SQLException {
        boolean encontrou = false;

        // Vai buscar todas as solicitações que envolvem a UC codUC
        ArrayList<SolicitacaoTroca> t = trocas.getAll(codUC);

        //Percorre as solicitações
        Iterator<SolicitacaoTroca> iterator = t.iterator();
        while (!encontrou && iterator.hasNext()) {
            SolicitacaoTroca s = iterator.next();
            // Faz match
            if (codTurnoS.equals(s.getCod_turnoD()) && codTurnoD.equals(s.getCod_turnoS())) {
                turnos.trocaTurnos(codUC, codAluno, codTurnoD, s.getCod_aluno(), s.getCod_turnoD());
                trocas.remFilaEspera(codAluno, codTurnoD, codTurnoS, codUC);
                trocas.remFilaEspera(s.getCod_aluno(),s.getCod_turnoD(),s.getCod_turnoS(),codUC);
                encontrou = true;
            }
        }
        if (!encontrou) {
            trocas.add(new SolicitacaoTroca(codTurnoS, codTurnoD, codAluno),codUC);
        }

        return encontrou;
    }

    void remFilaEspera(String codAluno, String id_turnoD,String id_turnoS,String codUc) {
        trocas.remFilaEspera(codAluno,id_turnoD,id_turnoS,codUc);
    }

    void marcaFaltas(ArrayList<String> alunos, String codUC, String codTurno) {
        Turno t = null;
        t = turnos.getTurno(codTurno,codUC);
        t.marcaFaltas(alunos, codUC, codTurno);
    }

    boolean trataPrioritario(String codUC, String codTurnoS, String codTurnoD, String codAluno) throws SQLException {
        Turno t = turnos.getTurno(codTurnoD,codUC);
        int capacidade = t.getCapacidade();
        int lotacao = turnos.getLotacao(codTurnoD,codUC);
        boolean trocado = false;

        if (lotacao < capacidade) {
           turnos.setTurno(codAluno,codTurnoD,codUC);
           trocado = true;
        } else {
            trocas.add(new SolicitacaoTroca(codTurnoS, codTurnoD, codAluno),codUC);
        }

        return trocado;
    }

    ArrayList<String[]> getSolicitacoes(String uc) {
        return trocas.getSolicitacoes(uc);
    }

    public String getCodUC() {
        return codUC;
    }

    public void putAllTurnos(ArrayList<Turno> turnosArg) {
        turnos.putAllTurnos(turnosArg);
    }
}
