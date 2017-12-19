/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import swap.business.Aluno;
import swap.business.Troca;
import swap.business.UC;
import swap.data.HorarioDAO;
import swap.business.Horario;
import swap.data.UtilizadorDAO;

/**
 *
 * @author MarcoSilva
 */
public class SWAP {
    
    UtilizadorDAO utentes;
    HorarioDAO horarios;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private Horario getHorario(Integer ano, Integer semestre) {
        return horarios.getHorario(ano,semestre);
    }
    
    public String extraiChave (String email) {
        StringBuilder res = new StringBuilder();
        if (!email.contains("@")) {
            return null;
        } else {
            for (int i = 0; i < email.length() && email.charAt(i) != '@'; i++) {
                res.append(email.charAt(i));
                }
        return res.toString();
        }
    }
    
    private boolean aceitaTroca(Troca t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /** USE CASES vvvvv */
    
    public boolean registo (String email, String password) {
        String chave = extraiChave(email);
        
        if (chave == null || !utentes.chaveExiste(chave)) {
            return false;
        } else {
            utentes.addUtente(chave,password,email);
            return true;
        }
    }
    
    public boolean autentica (String email, String password) {
        return utentes.existePar(email,password);
    }
    
    public void analisaTrocaMaisAntiga(String codUc, Integer ano, Integer semestre) {
        Horario h = getHorario(ano,semestre);
        UC uc = h.getUC(codUc);
        Troca t = uc.popTrocaMaisAntiga();
        
        if (aceitaTroca(t)) { 
            Aluno a1 = t.primeiro();
            Aluno a2 = t.segundo();
        
            a1.alteraTurno(t);
            a2.alteraTurno(t);
        }
    }

}
