package swap.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import swap.business.Aluno;
import swap.business.Turno;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

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
                t = new Turno((String) key, rs.getString("UC_codigo"), rs.getInt("capacidade"), rs.getString("Sala_numero"),
                              rs.getInt("Horario_numero"), (LocalTime) rs.getObject("horaInicio"), (LocalTime) rs.getObject("duracao") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        
        return t;
    }
    
    //Falta fazer esta query (o que está lá dentro está mal)
    public String getCodMyTurno(String codUC, String codAluno) {
        
        String codTurnoS = null;
        
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT T.numero\n"
				+ "FROM Utilizador AS U JOIN UtilizadorTurno AS UT ON idUtilizadores = UT.Utilizador_idUtilizadores\n "
				+ "JOIN Turno           AS T  ON Turno_numero = T.numero AND Turno_UC_codigo = T.UC_codigo\n "
				+ "WHERE T.UC_codigo = ? AND U.idUtilizadores = ?;");
            
            stm.setString(1, codUC);
	    stm.setString(2, codAluno);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                codTurnoS = rs.getString("numero");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        
        return codTurnoS;
    }
	
    public Turno put(int key, Turno value) throws SQLException {
           
        conn = Connect.connect();
        PreparedStatement stm = conn.prepareStatement("INSERT INTO Turno(numero,UC_codigo,capacidade,Horario_numero,Sala_numero,horaI,duracao)\n" +
                                                      "VALUES (?,?,?,?,?,?);");
        stm.setString(1,value.getId());
        stm.setString(2,value.getUC_codigo());
        stm.setInt(3, value.getCapacidade());
        stm.setInt(4,value.getHorarioId());
        stm.setString(5, value.getSala());
        stm.setObject(6, value.getHoraInicio());
        stm.setObject(7,value.getDuracao());
        stm.executeUpdate();

        Connect.close(conn);
       
        return value;
    }

    public void trocaTurnos(String codUC, String codAluno1, String codTurnoD1, String codAluno2, String codTurnoD2) throws SQLException {

        conn = Connect.connect();
                
	//Troca o turno do aluno1
	PreparedStatement stm = conn.prepareStatement("UPDATE UtilizadorTurno\n"
			+ "SET Turno_numero = ?\n"
			+ "WHERE Utilizador_idUtilizadores = ? AND Turno_UC_codigo = ?;");

	stm.setString(1, codTurnoD1);
	stm.setString(2, codAluno1);
	stm.setString(3, codUC);
	stm.executeUpdate();

	//Troca o turno do aluno2
	PreparedStatement stm1 = conn.prepareStatement("UPDATE UtilizadorTurno\n"
			+ "SET Turno_numero = ?\n"
			+ "WHERE Utilizador_idUtilizadores = ? AND Turno_UC_codigo = ?;");

	stm1.setString(1, codTurnoD2);
	stm1.setString(2, codAluno2);
	stm1.setString(3, codUC);
	stm1.executeUpdate();

	//Troca as faltas do aluno1
	PreparedStatement stm2 = conn.prepareStatement("UPDATE Falta\n"
			+ "SET Turno_numero = ?\n"
			+ "WHERE utilizador = ? AND Turno_UC_codigo = ?;");

	stm2.setString(1, codTurnoD1);
	stm2.setString(2, codAluno1);
	stm2.setString(3, codUC);
	stm2.executeUpdate();

	//Troca as faltas do aluno2
	PreparedStatement stm3 = conn.prepareStatement("UPDATE Falta\n"
			+ "SET Turno_numero = ?\n"
			+ "WHERE utilizador = ? AND Turno_UC_codigo = ?;");

	stm3.setString(1, codTurnoD2);
	stm3.setString(2, codAluno2);
	stm3.setString(3, codUC);
	stm3.executeUpdate();

        Connect.close(conn);
    }

    public Turno getTurno(String codTurno,String cod_UC) throws SQLException {

        conn = Connect.connect();
        String sql = "SELECT * FROM Turno WHERE numero=? AND UC_codigo=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1,codTurno);
        stm.setString(2,cod_UC);
        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            return new Turno(rs.getString("numero"),
                    rs.getString("UC_codigo"),
                    rs.getInt("capacidade"),
                    rs.getString("Sala_numero"),
                    rs.getInt("Horario_numero"),
                    rs.getTime("horaI").toLocalTime(),
                    rs.getTime("duracao").toLocalTime());
        }

        return null;
    }

    public Map<String,Aluno> getAlunos(String codUC, String codTurno) throws SQLException {
        Map<String,Aluno> res = new HashMap<>();

        conn = Connect.connect();
        String sql = "SELECT * FROM UtilizadorTurno \n " +
                "JOIN Utilizador ON Utilizador_idUtilizadores = idUtilizadores \n " +
                "WHERE Turno_UC_codigo = ? AND Turno_numero = ?;";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1,codUC);
        stm.setString(2,codTurno);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            res.put(rs.getString("Utilizador_idUtilizadores"),
                    new Aluno(rs.getString("nome"),rs.getString("idUtilizadores")+"@alunos.uminho.pt",rs.getString("password"),
                            rs.getBoolean("prioridade"),rs.getString("idUtilizadores")));
        }

        return res;
    }
}
