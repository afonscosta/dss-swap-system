package main.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.business.UC;

public class UcDAO implements Map<String,UC> {

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
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UC get(Object key) {

        UC uc = null;

        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("Select * FROM UC WHERE codigo=?;");
            stm.setString(1,(String) key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                uc = new UC(rs.getString("nome"),rs.getString("codigo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UcDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return uc;
    }

    @Override
    public UC put(String key, UC value) {
        return null;
    }

    public void putRefHorario(String key,String horario, UC value) {

        try {
            conn = Connect.connect();

            PreparedStatement stm = conn.prepareStatement("INSERT INTO UC \n" +
                    "VALUES(?,?,?);");

            stm.setString(1, key);
            stm.setString(2, value.getNome());
            stm.setString(3, horario);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
    }

    @Override
    public UC remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putAll(Map<? extends String, ? extends UC> m) {
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
    public Collection<UC> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<String, UC>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putAllArrayList(String horario,ArrayList<UC> ucsArg) {
        for (UC uc : ucsArg) {
            putRefHorario(uc.getCodUC(),horario,uc);
        }
    }
}
