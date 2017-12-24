package main.business;

public abstract class Utilizador {
    
    private String nome;
    private String email;
    private String password;

    public Utilizador (String n, String e, String p) {
        nome = n;
        email = e;
        password = p;    
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
