package main.data;

import java.sql.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import main.business.Horario;
import main.business.Tuplo;
import main.business.UC;

public class HorarioDAO implements Map<int[],Horario>{

    private Connection conn;

    public Horario getHorario(Integer ano, Integer semestre) {
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
    public boolean containsKey(Object o) {
        try {
            conn = Connect.connect();

            PreparedStatement stm = conn.prepareStatement("SELECT COUNT(*) FROM Horario WHERE (POW(ano,2)) / semestre = ?;");
            stm.setDouble(1,(double) o);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return (rs.getInt("COUNT(*)") == 1);
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }

        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Horario get(Object key) {
        Horario h = null;
        int ano = ((int[]) key)[0];
        int semestre = ((int[]) key)[1];
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Horario WHERE ano=? AND semestre=?");
            stm.setInt(1, ano);
            stm.setInt(2, semestre);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                h = new Horario(rs.getInt("ano"),rs.getInt("semestre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return h;
    }

    public Horario put(int[] k, Horario v) {
        Horario h = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Horario (ano,semestre)\n" +
                    "VALUES (?, ?)\n" +
                    "ON DUPLICATE KEY UPDATE ano=VALUES(ano),  semestre=VALUES(semestre)", Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, k[0]);
            stm.setInt(2, k[1]);
            stm.executeUpdate();

            h = v;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return h;
    }

    @Override
    public Horario remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putAll(Map<? extends int[], ? extends Horario> m) {
        for (Horario h : m.values()) {
            int[] k = {h.getAno(),h.getSemestre()};
            this.put(k,h);
        }
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<int[]> keySet() {
        return null;
    }

    @Override
    public Collection<Horario> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<int[], Horario>> entrySet() {
        return null;
    }

    public UC getUC(String codUC) {
        try {

            conn = Connect.connect();
            String sql = "SELECT * FROM UC WHERE codigo=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, codUC);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return new UC(rs.getString("nome"), rs.getString("codigo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }

        return null;
    }

    public String getId(Horario h) {
        try {
            conn = Connect.connect();
            String sql = "SELECT numero FROM Horario WHERE ano = ? AND semestre = ?;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(h.getAno()));
            stm.setString(2, Integer.toString(h.getSemestre()));
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return rs.getString("numero");
            } else {
                return "-1";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return null;
    }

    public void putAllHash(Map<Double, Horario> horariosEncontrados) {
        for (Horario h : horariosEncontrados.values()) {
            int[] k = {h.getAno(),h.getSemestre()};
            this.put(k,h);
        }
    }
}
