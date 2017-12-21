package swap.business;

public class DocenteRegente extends Utilizador {
    String uc;

    public DocenteRegente(String nome, String email, String password,String uc) {
        super(nome, email, password);
        this.uc = uc;
    }
    
}
