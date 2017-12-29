package main.business;

import main.data.UcDAO;

import java.util.ArrayList;

public class Horario {

	private int ano;
	private int semestre;
	private UcDAO ucs;
    private TurmaDAO turmas;

	public Horario(int ano, int semestre) {
		this.ano = ano;
		this.semestre = semestre;
		ucs = new UcDAO();
        turmas = new TurmaDAO();
	}

	public UC getUC(String codUc) {
		return ucs.get(codUc);
	}

	public UcDAO getUcs() {
		return ucs;
	}

	public int getAno() {
		return ano;
	}

	public int getSemestre() {
		return semestre;
	}

	void putAll(String horario,ArrayList<UC> ucsArg) {
			ucs.putAllArrayList(horario,ucsArg);
	}
}
