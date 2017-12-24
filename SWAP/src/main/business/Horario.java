package main.business;

import main.data.UcDAO;

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
