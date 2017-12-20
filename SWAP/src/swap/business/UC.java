/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.business;

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
    */

    Aluno checkTroca(int idTurno, Turno ta) {
        // chamar trocaDAO aqui
    }

    void addFilaDeEspera(Aluno aThis, int idTurno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
