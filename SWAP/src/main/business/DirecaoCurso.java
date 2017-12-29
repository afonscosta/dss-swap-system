/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.business;

public class DirecaoCurso extends Utilizador {

    private int fase;

    public DirecaoCurso(String nome, String email, String password, int fase) {
       super(nome,email,password);
	   this.fase = fase;
    }

	public int getFase() {
		return fase;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}

}
