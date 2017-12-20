/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.business;

import swap.data.TurnoDAO;
import swap.data.UcDAO;


/**
 *
 * @author edgar
 */
public class Aluno extends Utilizador {
    
    private boolean prioritario;
    private String numero;
    private UcDAO ucs;
    private TurnoDAO turnos;
    
    public Aluno(String nome, String email, String password, boolean prioritario,String numero) {
        super(nome, email, password);
        this.prioritario = prioritario;
        this.numero = numero;
    }

    public boolean getPrioridade() {
        return prioritario;
    }
    
    public String getNumero() {
        return numero;
    }
    
    
    public void alteraTurno(Troca t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean solicitaTurno(String uc, int idTurno) {
        UC uct = ucs.get(uc);
        
        Turno ta = turnos.getTurno(uc,idTurno);
        
        Aluno colega_troca = uct.checkTroca(idTurno,ta);
        
        if (colega_troca != null) {
            System.out.println("Ainda não");
        } else {
            uct.addFilaDeEspera(this,idTurno);
        }
        
        return true;
    }


    
}
