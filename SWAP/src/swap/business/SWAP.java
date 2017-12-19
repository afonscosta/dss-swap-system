/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.business;

import java.sql.SQLException;
import swap.data.HorarioDAO;
import swap.data.UtilizadorDAO;

/**
 *
 * @author edgar
 */
public class SWAP {
    
    private Utilizador sessao;
    UtilizadorDAO utentes;
    HorarioDAO horarios;
    
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
    
    public boolean registo (String nome,String email, String password,Boolean priod) {
        String chave = extraiChave(email);


        if (chave == null || !utentes.containsKey((chave)) {
            return false;
        } else {
            try {
                switch(chave.charAt(0))  {

}
                utentes.putAluno(chave,new Aluno(nome,email,password,false,chave));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
