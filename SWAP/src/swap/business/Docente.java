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
public class Docente extends Utilizador {
    String uc;
    
    public Docente(String nome, String email, String password, String uc) {
        super(nome, email, password);
        this.uc = uc;
    }
    
}
