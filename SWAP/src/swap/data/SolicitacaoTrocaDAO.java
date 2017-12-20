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
import swap.business.SolicitacaoTroca;

/**
 *
 * @author MarcoSilva
 */
public class SolicitacaoTrocaDAO {
    
    private Connection conn;
    
    
    public SolicitacaoTroca get(Object turnoS, Object turnoD) {
		SolicitacaoTroca s = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM SolicitacaoTroca WHERE turnoS=? AND turnoD=?");
            stm.setString(1, (String) turnoS);
            stm.setString(2, (String) turnoD);
            
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                    s = new SolicitacaoTroca(rs.getString("turnoS"),rs.getString("turnoD"),rs.getString("aluno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return s;
    }
    
    public SolicitacaoTroca put(String key, SolicitacaoTroca value) throws SQLException {
           
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO SolicitacaoTroca(turnoS,turnoD,aluno,UC_codigo)\n" +
                "VALUES (?,?,?,?);");
            
            
            stm.setString(1,value.getCod_turnoS());
            stm.setString(2,value.getCod_turnoD());
            stm.setString(3,value.getCod_aluno());
            //ver como colocamos o codigo da UC
            //stm.setString(4, value.getNumero());
            stm.executeUpdate();
        
            Connect.close(conn);
       
            return value;
    }
}
