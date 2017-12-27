package main.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.business.SolicitacaoTroca;

public class SolicitacaoTrocaDAO implements List<SolicitacaoTroca> {

    private Connection conn;

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<SolicitacaoTroca> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<SolicitacaoTroca> getAll(String codUC) {
        ArrayList<SolicitacaoTroca> trocas = new ArrayList<>();
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM SolicitacaoTroca WHERE UC_codigo=?");
            stm.setString(1, (String) codUC);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                trocas.add(new SolicitacaoTroca(rs.getString("turnoS"),rs.getString("turnoD"),rs.getString("aluno")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return trocas;
    }

    public boolean add(SolicitacaoTroca e, String codUC) {
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO SolicitacaoTroca(turnoS,turnoD,aluno,UC_codigo)\n" +
                    "VALUES (?,?,?,?);");
            stm.setString(1, e.getCod_turnoS());
            stm.setString(2, e.getCod_turnoD());
            stm.setString(3, e.getCod_aluno());
            stm.setString(4, codUC);
            stm.executeUpdate();
            Connect.close(conn);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoTrocaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends SolicitacaoTroca> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int i, Collection<? extends SolicitacaoTroca> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SolicitacaoTroca get(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SolicitacaoTroca set(int i, SolicitacaoTroca e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(int i, SolicitacaoTroca e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SolicitacaoTroca remove(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<SolicitacaoTroca> listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<SolicitacaoTroca> listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<SolicitacaoTroca> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean add(SolicitacaoTroca e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remFilaEspera(String codAluno, String codTurnoD, String codTurnoS,String codUc) {
        conn = Connect.connect();
        try {
            PreparedStatement stm = conn.prepareStatement("DELETE FROM SolicitacaoTroca WHERE aluno=? AND turnoS=? AND turnoD=? AND UC_codigo=?");

            stm.setString(1, codAluno);
            stm.setString(2, codTurnoS);
            stm.setString(3, codTurnoD);
            stm.setString(4, codUc);

            stm.executeUpdate();

            Connect.close(conn);

        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoTrocaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String[]> getSolicitacoes(String uc) {
        ArrayList<String[]> res = new ArrayList<>();

        try {
            conn = Connect.connect();

            PreparedStatement stm = conn.prepareStatement("SELECT * FROM SolicitacaoTroca WHERE UC_codigo=?;");

            stm.setString(1,uc);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String[] arr = new String[3];

                arr[0] = rs.getString("aluno");
                arr[1] = rs.getString("turnoS");
                arr[2] = rs.getString("turnoD");

                res.add(arr);
            }

            conn.close();

            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public HashMap<String,String[]> getSolicitacoesAluno(String codAluno) {
        HashMap<String,String[]> res = new HashMap<>();

        try {
            conn = Connect.connect();

            PreparedStatement stm = conn.prepareStatement("SELECT * FROM SolicitacaoTroca WHERE aluno=?;");

            stm.setString(1,codAluno);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String[] arr = new String[3];

                arr[0] = rs.getString("aluno");
                arr[1] = rs.getString("turnoS");
                arr[2] = rs.getString("turnoD");

                res.put(rs.getString("UC_codigo"),arr);
            }

            conn.close();

            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
