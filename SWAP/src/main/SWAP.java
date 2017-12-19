/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import swap.data.UtilizadorDAO;

/**
 *
 * @author MarcoSilva
 */
public class SWAP {
    
    UtilizadorDAO utentes;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
    
}
