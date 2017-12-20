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
import swap.business.Turno;
import java.time.LocalTime;
/**
 *
 * @author Daniel Maia
 */
public class TurnoDAO {
    private Connection conn;
    
    public Turno get(Object key) {
		Turno t = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Turno WHERE numero=?");
            stm.setString(1, (String) key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                t = new Turno((String) key, rs.getString("UC_codigo"), rs.getInt("capacidade"), rs.getInt("Horario_numero"),
                              rs.getString("Sala_numero"), (LocalTime) rs.getObject("horaInicio"), (LocalTime) rs.getObject("duracao") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return t;
    }
    
    public Turno put(int key, Turno value) throws SQLException {
           
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Turno(numero,UC_codigo,capacidade,Horario_numero,Sala_numero,horaI,duracao)\n" +
                "VALUES (?,?,?,?,?,?);");
            
            
            stm.setInt(1,value.getId());
            stm.setInt(2,value.getUC_codigo());
            stm.setObject(3,value.getTipo());
            stm.setInt(4, value.getCapacidade());
            stm.setObject(5, value.get);
            stm.executeUpdate();
        
            Connect.close(conn);
       
            return value;
    }
}
