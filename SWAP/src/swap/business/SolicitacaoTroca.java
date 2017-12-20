/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.business;

/**
 *
 * @author edgar
 */
public class SolicitacaoTroca {
    
    private String cod_turnoS;
    private String cod_turnoD;
    private String cod_aluno;

    public SolicitacaoTroca(String cod_turnoS, String cod_turnoD, String cod_aluno) {
        this.cod_turnoS = cod_turnoS;
        this.cod_turnoD = cod_turnoD;
        this.cod_aluno = cod_aluno;
    }

    public String getCod_turnoS() {
        return cod_turnoS;
    }

    public String getCod_turnoD() {
        return cod_turnoD;
    }

    public String getCod_aluno() {
        return cod_aluno;
    }

    public void setCod_turnoS(String cod_turnoS) {
        this.cod_turnoS = cod_turnoS;
    }

    public void setCod_turnoD(String cod_turnoD) {
        this.cod_turnoD = cod_turnoD;
    }

    public void setCod_aluno(String cod_aluno) {
        this.cod_aluno = cod_aluno;
    }

    

    public Aluno primeiro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Aluno segundo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	/*
    public Aluno primeiro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    
}
