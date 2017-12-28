/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.business;

/**
 *
 * @author rokai
 */
public class Sala {
	
	private String numero;
	private int capacidade;
	
	public Sala () {
		this.numero = "";
		this.capacidade = 0;
	}
	
	public Sala (String n, int cap) {
		this.numero = n;
		this.capacidade = cap;
	}

	public String getNumero() {
		return numero;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	
}
