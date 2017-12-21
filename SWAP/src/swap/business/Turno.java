package swap.business;

import java.time.LocalTime;

public class Turno {

    /*
    public enum Tipo {
        T, TP, PL;
    }
    */
    
    private String id;
    private String UC_codigo;    
    private Integer capacidade;
    private Integer horarioId;
    private String sala;
    private LocalTime horaInicio;
    private LocalTime duracao;
   
    public Turno (String id, String UC_codigo, Integer capacidade, String sala, Integer horarioId, LocalTime horaInicio, LocalTime duracao) {
        this.id = id;
        this.capacidade = capacidade;
        this.UC_codigo = UC_codigo;
        this.sala = sala;
        this.horarioId = horarioId;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }

    public String getId() {
        return id;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getUC_codigo() {
        return UC_codigo;
    }

    public void setUC_codigo(String UC_codigo) {
        this.UC_codigo = UC_codigo;
    }

    /** 
    public Tipo getTipo() {
        return tipo;
    }*/

    /**
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }*/

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }

}
