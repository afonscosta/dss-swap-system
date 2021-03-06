package main.business;

import main.data.FaltaDAO;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Turno {

    private String id;
    private String UC_codigo;
    private Integer capacidade;
    private Sala sala;
    private LocalTime horaInicio;
    private LocalTime duracao;
    private Integer aulasPrevistas;
    private int diaSemana;

    private FaltaDAO faltas;

    public Turno (String id, String UC_codigo, Integer capacidade, Sala sala, LocalTime horaInicio, LocalTime duracao,Integer aulasPrevistas,int diaSemana) {
        this.id = id;
        this.capacidade = capacidade;
        this.UC_codigo = UC_codigo;
        this.sala = sala;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
        this.aulasPrevistas = aulasPrevistas;
        this.diaSemana = diaSemana;
        this.faltas = new FaltaDAO();
    }

    public Integer getAulasPrevistas() {
        return aulasPrevistas;
    }

    public void setAulasPrevistas (Integer ap) {
        this.aulasPrevistas = ap;
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

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setUC_codigo(String UC_codigo) {
        this.UC_codigo = UC_codigo;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
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

    void marcaFaltas(HashMap<String,Integer> alunos, String codUC, String codTurno) {
        for (Map.Entry<String, Integer> entry : alunos.entrySet()) {
            String aluno = entry.getKey();
            Integer vezes = entry.getValue();
            if (faltas.containsKey(codTurno, codUC, aluno)) {
                // linha ja existe, incrementar nr
                faltas.incFalta(aluno, codTurno, codUC,vezes);

                // verificar se faltas comprometem a estadia do aluno no turno
                faltas.verificaLimiteFaltas(aluno,codTurno,codUC);
            } else {
                // primeira falta, adicionar registo
                faltas.putFalta(aluno,codTurno,codUC,vezes);
            }

        }
    }
}
