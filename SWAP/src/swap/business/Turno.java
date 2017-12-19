/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.business;

import java.time.LocalTime;


/**
 *
 * @author edgar
 */
public class Turno {

    public enum Tipo {
        T, TP, PL;
    };
    
    private Integer capacidade;
    private Tipo tipo;
    private String sala;
    private LocalTime horaInicio;
    private LocalTime duracao;
    
    public Turno (Integer capacidade, Tipo tipo, String sala, LocalTime horaInicio, LocalTime duracao) {
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.sala = sala;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    /**
     * @return the capacidade
     */
    public Integer getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the sala
     */
    public String getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     * @return the horaInicio
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the duracao
     */
    public LocalTime getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }
    
}
