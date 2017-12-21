package swap.business;

public class Docente extends Utilizador {
    String uc;
    
    public Docente(String nome, String email, String password, String uc) {
        super(nome, email, password);
        this.uc = uc;
    }
    
}
