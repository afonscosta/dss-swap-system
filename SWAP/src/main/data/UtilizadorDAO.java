package main.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import main.business.Aluno;
import main.business.DirecaoCurso;
import main.business.Docente;
import main.business.Utilizador;

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
                } else if (chave.equals("dcmiei")) {
                    u = new DirecaoCurso(rs.getString("nome"),rs.getString("idUtilizadores") + "@di.uminho.pt",rs.getString("password"));
                } else {
                    u = new Docente(rs.getString("nome"),rs.getString("idUtilizadores") + "@di.uminho.pt",rs.getString("password"),rs.getString("uc"),rs.getInt("regente"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }

        return u;
    }

    public void putAluno(String key, Aluno value) {
        try {

            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Utilizador(idUtilizadores,nome,password,prioridade)\n" +
                    "VALUES (?,?,?,?);");


            int bool = value.getPrioridade() == true ? 1 : 0;

            stm.setString(1, value.getNumero());
            stm.setString(2, value.getNome());
            stm.setString(3, value.getPassword());
            stm.setString(4, String.valueOf(bool));
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
    }


    public void putDocente(String key, Docente value) {
        try {

            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Utilizador(idUtilizadores,nome,password,uc,regente) VALUES(?,?,?,?,?);");
            stm.setString(1, key);
            stm.setString(2, value.getNome());
            stm.setString(3, value.getPassword());
            stm.setString(4, value.getUC());
            stm.setInt(5, value.getRegente());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
    }

    public void putDirecaoCurso(String chave, String nome, String password) {
        try {

            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Utilizador(idUtilizadores,nome,password) VALUES(?,?,?);");
            stm.setString(1, chave);
            stm.setString(2, nome);
            stm.setString(3, password);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
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

    public int isRegente(String chave) {
        int res = -1;

        try {

            conn = Connect.connect();
            String sql = "SELECT regente FROM Utilizador WHERE idUtilizadores=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, chave);
            ResultSet rs = stm.executeQuery();

            res = (rs.next()) ? rs.getInt("regente") : -1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
            return res;
        }

    }




}
