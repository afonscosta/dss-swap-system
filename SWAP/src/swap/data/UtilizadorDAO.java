/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import swap.business.Utilizador;

/**
 *
 * @author MarcoSilva
 */
public class UtilizadorDAO implements Map<String,Utilizador> {

    private Connection conn;
    
    public boolean chaveExiste(String chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean existePar(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addUtente(String chave, String password, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        boolean r = false;
        
        try {
            conn = Connect.connect();
            String sql = "SELECT `nome` FROM `Utilizador` WHERE `idUtilizadores`=?;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,Integer.parseInt(key.toString()));
            ResultSet rs = stm.executeQuery();
            r = rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    return r;
    }


    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilizador get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilizador putAluno(String key, Aluno value) throws SQLException {
            Aluno al = null;
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Utilizador(nome,password,prioridade,numero)\n" +
                "VALUES (?.?.?.?)\n" +
                Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,value.getNome());
            stm.setString(2,value.getPassword());
            stm.setString(3,String.valueOf(value.getPrioridade()));
            stm.setString(4,value.getNumero());
            stm.executeUpdate();
            
            return value;
    }

    @Override
    public Utilizador remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Utilizador> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilizador put(String key, Utilizador value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
