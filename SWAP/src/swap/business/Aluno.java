/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.business;

/**
 *
 * @author edgar
 */
public class Aluno extends Utilizador {
    
    private boolean prioritario;
    private String numero;
    
    
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


    
}