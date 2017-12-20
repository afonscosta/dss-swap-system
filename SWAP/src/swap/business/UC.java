/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.business;

import java.util.ArrayList;
import java.util.Iterator;
import swap.data.SolicitacaoTrocaDAO;
import swap.data.TurnoDAO;

/**
 *
 * @author edgar
 */
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

	public boolean trataTroca(String codUC, String codTurnoS, String codTurnoD, String codAluno) {
		boolean encontrou = false;
		
		// Vai buscar todas as solicitacoes que envolvem a UC codUC
		ArrayList<SolicitacaoTroca> t = trocas.getAll(codUC);
		
		//Percorre as solicitacoes
		Iterator<SolicitacaoTroca> iterator = t.iterator();
		while (!encontrou && iterator.hasNext()) {
			SolicitacaoTroca s = iterator.next();
			
			// Faz match
			if (codTurnoS.equals(s.getCod_turnoD()) && codTurnoD.equals(s.getCod_turnoS())) {
				//Fazer a troca propriamente dita
				encontrou = true;
			}
		}
		trocas.add(new SolicitacaoTroca(codTurnoS, codTurnoD, codAluno));
		return encontrou;
	}

}
