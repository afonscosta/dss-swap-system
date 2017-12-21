package swap.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import swap.business.Horario;
import swap.business.Tuplo;

public class HorarioDAO implements Map<Tuplo, Horario>{
	
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsValue(Object o) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Horario get(Object key) {
        Tuplo t = (Tuplo) key;
	Horario h = null;
	int ano = (int) t.getL();
	int semestre = (int) t.getR();
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Horario WHERE ano=? AND semestre=?");
            stm.setInt(1, ano);
            stm.setInt(2, ano);
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

    @Override
    public Horario put(Tuplo k, Horario v) {
	Horario h = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Horario\n" +
                "VALUES (?, ?)\n" +
                "ON DUPLICATE KEY UPDATE ano=VALUES(ano),  semestre=VALUES(semestre)", Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, (int) k.getL());
            stm.setInt(2, (int) k.getR());
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
    public void putAll(Map<? extends Tuplo, ? extends Horario> map) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Tuplo> keySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Horario> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<Tuplo, Horario>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
