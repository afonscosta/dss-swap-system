package swap.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import swap.business.Aluno;
import swap.business.Docente;
import swap.business.Utilizador;

public class UtilizadorDAO implements Map<String,Utilizador> {

    private Connection conn;
    
    public boolean existePar(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addUtente(String chave, String password, String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsKey(Object key) {
        boolean r = false;
        
        try {
            conn = Connect.connect();
            String sql = "SELECT `nome` FROM `Utilizador` WHERE `idUtilizadores`=?;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,(String) key);
            ResultSet rs = stm.executeQuery();
            r = rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    return r;
    }


    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Utilizador get(Object key) {
	
        Utilizador u = null;
        
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Utilizador WHERE idUtilizadores=?");
            stm.setString(1, (String) key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String chave = rs.getString("idUtilizadores");
		//Não temos dados para preencher o aluno
                if (chave.startsWith("a") && Character.isDigit(chave.charAt(1))) {
                    u = new Aluno(rs.getString("nome"),chave + "@alunos.uminho.pt", rs.getString("password"), rs.getBoolean("prioridade"),chave );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        
        return u;
    }

    public void putAluno(String key, Aluno value) throws SQLException {
           
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade)\n" +
                "VALUES (?,?,?,?);");
            
             
            int bool = value.getPrioridade() == true ? 1 : 0;
            
            stm.setString(1, value.getNumero());
            stm.setString(2,value.getNome());
            stm.setString(3,value.getPassword());
            stm.setString(4,String.valueOf(bool));
            stm.executeUpdate();
        
            Connect.close(conn);
    }

    
    public void putDocente(String key, Docente value) throws SQLException {
        conn = Connect.connect();
        PreparedStatement stm = conn.prepareStatement("INSERT INTO Utilizador(idUtilizadores,nome,password,uc,regente) VALUES(?,?,?,?,?);");
        stm.setString(1,key);
        stm.setString(2,value.getNome());
        stm.setString(3,value.getPassword());
        stm.setString(4,value.getUC());
        stm.setInt(5,value.getRegente());
        stm.executeUpdate();
        
        Connect.close(conn);
    }
    
        public void putDirecaoCurso(String chave, String email, String password) throws SQLException {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Utilizador(idUtilizadores,email,password) VALUES(?,?,?);");
            stm.setString(1,chave);
            stm.setString(2,email);
            stm.setString(3,password);
            stm.executeUpdate();
            
            Connect.close(conn);
    }
    
    
    @Override
    public Utilizador remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Utilizador> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Utilizador put(String key, Utilizador value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putDC(String chave, Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }




}
