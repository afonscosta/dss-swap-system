/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.business;

import swap.data.UcDAO;

/**
 *
 * @author edgar
 */
public class Horario {
	
	private int ano;
	private int semestre;
	private UcDAO ucs;
	
	public Horario(int ano, int semestre) {
		this.ano = ano;
		this.semestre = semestre;
		ucs = new UcDAO();
	}

    public UC getUC(String codUc) {
		return ucs.get(codUc);
    }
    
}
