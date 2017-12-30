package main.business;

import java.io.FileReader;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.*;
import static java.lang.Math.toIntExact;

import main.data.HorarioDAO;
import main.data.UtilizadorDAO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SWAP {

    private Utilizador sessao;
    private UtilizadorDAO utilizadores;
    private HorarioDAO horarios;

    public SWAP () {
        sessao = null;
        utilizadores = new UtilizadorDAO();
        horarios = new HorarioDAO();
    }

//    private Horario getHorario(Integer ano, Integer semestre) {
//        return horarios.getHorario(ano,semestre);
//    }

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

//    private boolean aceitaTroca(SolicitacaoTroca t) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    public boolean isRegente(String chave) {
        int isRegente = -1;

        isRegente = utilizadores.isRegente(chave);

        return (isRegente == 1);
    }
    
    /* USE CASES */

    public boolean registo (String nome,String email, String password,Object wildcard,int regente) {

        String chave = extraiChave(email);

        if (chave == null || utilizadores.containsKey(chave)) {
            return false;
        } else {
            if (chave.startsWith("a") && Character.isDigit(chave.charAt(1))) { // é um aluno

                utilizadores.putAluno(chave, new Aluno(nome,email,password,(boolean) wildcard,chave));

            } else if (chave.equals("dcmiei")) { // é direção de curso
                utilizadores.putDirecaoCurso(chave,nome,password, 0);

            } else { // é docente
                System.out.println(wildcard);
                utilizadores.putDocente(chave,new Docente(nome,email,password,(String) wildcard,regente));
            }

            return true;
        }
    }

    public boolean autentica (String email, String password) {
        String chave = extraiChave(email);
        Utilizador u;
        if(chave == null || ((u = utilizadores.get(chave)) == null))
            return false;
        if (u.getPassword().equals(password) && u.getEmail().equals(email)) {
            sessao = u;
            return true;
        }
        return false;
    }

    public Turno adicionaTurno (String id, String UC_codigo, Integer capacidade, Sala sala, LocalTime horaInicio, LocalTime duracao,Integer aulasPrevistas,int diaSemana) {

        Turno t = new Turno(id, UC_codigo, capacidade, sala, horaInicio, duracao,aulasPrevistas,diaSemana);
        return t;
    }

    public boolean solicitaTurno(String codUC, String codTurnoD) throws SQLException {
        Aluno alunoAtual = (Aluno) sessao;
		DirecaoCurso dc = (DirecaoCurso) utilizadores.get("dcmiei");
        return alunoAtual.solicitaTurno(codUC, codTurnoD, alunoAtual.getNumero(), dc.getFase());
    }

    public void removeSolicitacaoTurno(String codUc,String codTurno) {
        Aluno alunoAtual = (Aluno) sessao;

        alunoAtual.remFilaEspera(codUc,codTurno);
    }

    public void marcaFaltas(String codUC,String codTurno, HashMap<String,Integer> alunos) {
        UC uc = null;
        uc = horarios.getUC(codUC);

        uc.marcaFaltas(alunos, codUC, codTurno);

    }

    //Esta função devolve um hashmap dos alunos de um determinado turno
    public ArrayList<String[]> getAlunos(String codUC, String codTurno) {
        Docente doc = (Docente) utilizadores.get(extraiChave(sessao.getEmail()));
        return doc.getAlunos(codUC,codTurno);
    }

    public void analisaTroca(String codAluno,String codUc,String codTurnoS,String codTurnoD,boolean aceita) {

        docenteRemoveSolicitacaoTurno(codAluno,codUc,codTurnoD,codTurnoS);

        if (aceita) {
            Aluno a = (Aluno) utilizadores.get(codAluno);
            a.moveTurno(codUc,codTurnoS,codTurnoD,codAluno);


        }
    }

    public ArrayList<String[]> getMyTurnos() {
        ArrayList<String[]> res = null;
        ArrayList<Turno> resWithTurnos = null;

        String chave = this.extraiChave(sessao.getEmail());
        if (chave.startsWith("a") && Character.isDigit(chave.charAt(1))) { // é um aluno

            Aluno a = (Aluno) utilizadores.get(this.extraiChave(sessao.getEmail()));
            resWithTurnos = a.getTurnos(this.extraiChave(sessao.getEmail()));
            res = this.castTurnosToStringArray(resWithTurnos);

        } else if (!chave.equals("dcmiei")) {
            Docente d = (Docente) utilizadores.get(this.extraiChave(sessao.getEmail()));
            resWithTurnos = d.getTurnos(this.extraiChave(sessao.getEmail()));
            res = this.castTurnosToStringArray(resWithTurnos);
        }

        return res;
    }

    public HashMap<String,ArrayList<String>> getNotMyTurnos() {
       Aluno a = (Aluno) sessao;
       String chave = a.getNumero();

       return a.getNotMyTurnos(chave);
    }

    private ArrayList<String[]> castTurnosToStringArray(ArrayList<Turno> arrTurnos) {
        ArrayList<String[]> res = new ArrayList<>();
        for (Turno t : arrTurnos) {
            String[] turnoString = new String[8];
            turnoString[0] = t.getUC_codigo();
            turnoString[1] = t.getId();
            turnoString[2] = t.getSala().getNumero();
            turnoString[3] = t.getCapacidade().toString();
            turnoString[4] = Integer.toString(t.getDiaSemana());
            turnoString[5] = t.getHoraInicio().toString();
            turnoString[6] = t.getDuracao().toString();
            turnoString[7] = t.getAulasPrevistas().toString();
            res.add(turnoString);
        }
        return res;
    }

    public boolean existeUC(String uc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean existeTurno(String uc, String turno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Todas as solicitações de um dada UC
    public ArrayList<String[]> getSolicitacoesUC(String uc) {
        Docente docente = (Docente) sessao;

        return docente.getSolicitacoes(uc);
    }

    public void docenteRemoveSolicitacaoTurno(String codAluno, String codUC, String codTurnoD,String codTurnoS) {
        Docente docenteAtual = (Docente) sessao;

        docenteAtual.remFilaEspera(codAluno,codUC,codTurnoD,codTurnoS);
    }

    public String[] getAluno(String chave) {
        Aluno a = (Aluno) utilizadores.get(chave);
        String[] res = new String[3];
        res[0] = a.getNumero();
        res[1] = a.getNome();
        res[2] = a.getEmail();
        return res;
    }

    public HashMap<String,String[]> getSolicitacoesAluno() {
        Aluno aluno = (Aluno) sessao;

        return aluno.getSolicitacoes(aluno.getNumero());
    }


    public double getHash(int[] k) {
        return (Math.pow(k[0],2) / k[1]);
    }

    public void carregaInfo(String filePath) {

        JSONParser parser = new JSONParser();

        try {
            // Informação encontrada guardada em memória temporariamente
            Map<String,Sala> salasEncontradas = new HashMap<>();
            Map<Double,Horario> horariosEncontrados = new HashMap<>();
            Map<Double,ArrayList<UC>> ucsEncontradas = new HashMap<>();
            Map<String,ArrayList<Turno>> turnosEncontrados = new HashMap<>();

            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;

            // Navegar as salas
            JSONArray salas = (JSONArray) jsonObject.get("salas");
            Iterator itSalas = salas.iterator();
            while (itSalas.hasNext()) {
                JSONObject curr = (JSONObject) itSalas.next();

                String nome = (String) curr.get("sala");
                int capacidade = toIntExact((long)curr.get("capacidade"));

                salasEncontradas.put(nome,new Sala(nome,capacidade));
            }


            //Navegar as UCs
            JSONArray ucs = (JSONArray) jsonObject.get("ucs");
            Iterator itUCs = ucs.iterator();
            while (itUCs.hasNext()) {
                JSONObject curr = (JSONObject) itUCs.next();

                int ano = toIntExact((long)curr.get("ano"));
                int semestre = toIntExact((long)curr.get("semestre"));
                String sigla = (String) curr.get("sigla");

                int[] k = {ano,semestre};

                // é uma entrada de horário única?
                boolean unique = true;
                for (double d : horariosEncontrados.keySet()) {
                    if (getHash(k) == d) {
                        unique = false;
                        break;
                    }
                }

                if (unique) {
                    horariosEncontrados.put(getHash(k),new Horario(ano,semestre));
                    ucsEncontradas.put(getHash(k),new ArrayList<>());
                }

                ucsEncontradas.get(getHash(k)).add(new UC((String)curr.get("nome"),sigla));

                // Navega turnos DENTRO da uc
                JSONArray turnos = (JSONArray) curr.get("turnos");
                for (int i = 0; i < turnos.size(); i++) {
                    JSONObject currentObj = (JSONObject) turnos.get(i);
                    Turno t = new Turno(
                            (String)currentObj.get("numero"),
                            sigla,
                            toIntExact((long)currentObj.get("capacidade")),
                            salasEncontradas.get(currentObj.get("sala")),
                            LocalTime.parse((String)currentObj.get("horaI")),
                            LocalTime.parse((String)currentObj.get("duracao")),
                            toIntExact((long)currentObj.get("aulasPrevistas")),
                            toIntExact((long)currentObj.get("diaSemana")));
                    if (!turnosEncontrados.containsKey(sigla)) {
                        turnosEncontrados.put(sigla,new ArrayList<>());
                    }
                    turnosEncontrados.get(sigla).add(t);
                }
            }

            // Procura acabou, usar as ligações SQL e colocar tudo em disco

            // Registar todos os horaŕios
            horarios.putAllHash(horariosEncontrados);

            // Registar todas as UCs
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 2; j++) {
                    int[] k = {i, j};
                    if (horarios.containsKey(getHash(k))) {
                        Horario h = horarios.get(k);
                        String idNum = horarios.getId(h);
                        h.putAll(idNum, ucsEncontradas.get(getHash(k)));
                    }
                }
            }

            // Registar todos os turnos
            for (String ucCod : turnosEncontrados.keySet()) {
                UC uc = horarios.getUC(ucCod);
                uc.putAllTurnos(turnosEncontrados.get(uc.getCodUC()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	public void inscreveNasUCs(ArrayList<String> ucsEscolhidas, String codAluno) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public void changeFase(int i) {
		DirecaoCurso dc = (DirecaoCurso) sessao;
		utilizadores.updateFase(this.extraiChave(dc.getEmail()), i);
	}
	
	public int getFase() {
		return utilizadores.getFase("dcmiei");
	}
}