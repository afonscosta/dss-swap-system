package swap.business;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import swap.data.HorarioDAO;
import swap.data.UtilizadorDAO;

public class SWAP {
    
    private Utilizador sessao;
    private UtilizadorDAO utilizadores;
    private HorarioDAO horarios;
    
    public SWAP () {
        sessao = null;
        utilizadores = new UtilizadorDAO();
        //horarios = new HorarioDAO();
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
    
    private boolean aceitaTroca(SolicitacaoTroca t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /* USE CASES */
    
    public boolean registo (String nome,String email, String password,Object wildcard) {
        String chave = extraiChave(email);
        String chaveClone = chave;
        
        if (chave == null || utilizadores.containsKey((chaveClone.substring(1)))) {
            return false;
        } else {
                if (chave.startsWith("a") && Character.isDigit(chave.charAt(1)))
                    try {
                        utilizadores.putAluno(chave, new Aluno(nome,email,password,(Boolean) wildcard,chave));
                } catch (SQLException ex) {
                    Logger.getLogger(SWAP.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public Turno adicionaTurno (String id, String UC_codigo, Integer capacidade, String sala, Integer horarioId, LocalTime horaInicio, LocalTime duracao) {
	
		Turno t = new Turno(id, UC_codigo, capacidade, sala, horarioId, horaInicio, duracao);
		return t;
	}
    
    public boolean solicitaTurno(String codUC, String codTurnoD) throws SQLException {
        Aluno alunoAtual = (Aluno) sessao;
        return alunoAtual.solicitaTurno(codUC, codTurnoD, alunoAtual.getNumero());
        
        
    }
    
    public void removeSolicitacaoTurno(String codUc,String codTurno) {
        Aluno alunoAtual = (Aluno) sessao;
        
        System.out.println("alunoAtual.remFilaEspera(" + codUc + "," + codTurno + ")");
        
        alunoAtual.remFilaEspera(codUc,codTurno);
    }
    
//    public void analisaTrocaMaisAntiga(String codUc, Integer ano, Integer semest) {
//        Horario h = getHorario(ano,semestre);
//        UC uc = h.getUC(codUc);
//        Troca t = uc.popTrocaMaisAntiga();
//        
//        if (aceitaTroca(t)) { 
//            Aluno a1 = t.primeiro();
//            Aluno a2 = t.segundo();
//        
//            a1.alteraTurno(t);
//            a2.alteraTurno(t);
//        }
//    }
}
