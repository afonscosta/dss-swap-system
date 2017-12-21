package swap.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import swap.business.Aluno;
import swap.business.Falta;

public class FaltaDAO {
    
    private Connection conn;
    
    public boolean containsKey(Object key) {
        boolean r = false;
        
        try {
            conn = Connect.connect();
            String sql = "SELECT `quantidade` FROM `Falta` WHERE `idFalta`=?;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,Integer.parseInt(key.toString()));
            ResultSet rs = stm.executeQuery();
            r = rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    return r;
    }
    
    //só será utilizado no caso de a instância ainda não existir na tabela
    public Falta putFalta(String key, Falta value, Aluno aluno, String UC) throws SQLException {
           
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Falta(quantidade, utilizador, Turno_numero, Turno_UC_codigo)\n" +
                "VALUES (?,?,?,?);");
            
            stm.setString(1, "1");
            stm.setString(2, aluno.getNumero());
            //introduzir o numero do turno
            //introduzir o numero da UC
            stm.executeUpdate();
        
            Connect.close(conn);
       
            return value;
    }
}
