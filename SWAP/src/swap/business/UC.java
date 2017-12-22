package swap.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import swap.data.SolicitacaoTrocaDAO;
import swap.data.TurnoDAO;

public class UC {
    
    private String nome;
    private TurnoDAO turnos;
    private SolicitacaoTrocaDAO trocas;
    
    public UC (String nome) {
        this.nome = nome;
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

    public boolean trataTroca(String codUC, String codTurnoS, String codTurnoD, String codAluno) throws SQLException {
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
                trocas.remFilaEspera(codAluno, codTurnoS, codTurnoD, codUC);
                trocas.remFilaEspera(s.getCod_aluno(),s.getCod_turnoS(),s.getCod_turnoD(),codUC);
                encontrou = true;
            }
	}        
        if (!encontrou) {
            trocas.add(new SolicitacaoTroca(codTurnoS, codTurnoD, codAluno),codUC);
        }

        return encontrou;
    }

    void remFilaEspera(String codAluno, String id_turnoD,String id_turnoS,String codUc) {
        trocas.remFilaEspera(codAluno,id_turnoS,id_turnoD,codUc);
    }

    public void marcaFaltas(ArrayList<String> alunos, String codTurno) {
        Turno t = null;
        try {
            t = turnos.getTurno(codTurno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        t.marcaFaltas(alunos,codTurno);
    }
}
