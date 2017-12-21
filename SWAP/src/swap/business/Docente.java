package swap.business;

public class Docente extends Utilizador {
    String uc;
    int regente; /* 0 nao regente, 1 regente (para adicionar em sql) */
    
    public Docente(String nome, String email, String password, String uc, int regente) {
        super(nome, email, password);
        this.uc = uc;
        this.regente = regente;
    }
    
    public int getRegente() {
        return regente;
    }
    
    public String getUC() {
        return this.uc;
    }
    
}
