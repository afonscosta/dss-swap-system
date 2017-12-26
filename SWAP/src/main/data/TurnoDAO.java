package main.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.business.Aluno;
import main.business.Turno;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                t = new Turno((String) key, rs.getString("UC_codigo"),
                        rs.getInt("capacidade"),
                        rs.getString("Sala_numero"),
                        rs.getInt("Horario_numero"),
                        rs.getTime("horaInicio").toLocalTime(),
                        rs.getTime("duracao").toLocalTime(),
                        rs.getInt("aulasPrevistas"));
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
                    rs.getTime("duracao").toLocalTime(),
                    rs.getInt("aulasPrevistas"));
        }

        return null;
    }

    public ArrayList<String[]> getAlunos(String codUC, String codTurno) throws SQLException {
        ArrayList<String[]> res = new ArrayList<>();

        conn = Connect.connect();
        String sql = "SELECT * FROM UtilizadorTurno \n " +
                "JOIN Utilizador ON Utilizador_idUtilizadores = idUtilizadores \n " +
                "WHERE Turno_UC_codigo = ? AND Turno_numero = ? AND uc IS NULL;";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1,codUC);
        stm.setString(2,codTurno);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
			String[] aluno = new String[5];
			aluno[0] = rs.getString("idUtilizadores");
			aluno[1] = rs.getString("nome");
			aluno[2] = rs.getString("idUtilizadores") + "@alunos.uminho.pt";
			aluno[3] = rs.getString("password");
			aluno[4] = rs.getString("prioridade");
            res.add(aluno);
        }

        return res;
    }

    public int getLotacao(String codTurnoD, String codUC) {
        int res = Integer.MAX_VALUE;
        conn = Connect.connect();
        String sql = "SELECT COUNT(*) FROM UtilizadorTurno \n" +
                "WHERE Turno_numero=? AND Turno_UC_codigo=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,codTurnoD);
            stm.setString(2,codUC);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                res = rs.getInt("COUNT(*)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void setTurno(String codAluno, String codTurnoD, String codUC) throws SQLException {
        conn = Connect.connect();

        //Troca o turno do aluno1
        PreparedStatement stm = conn.prepareStatement("UPDATE UtilizadorTurno\n"
                + "SET Turno_numero = ?\n"
                + "WHERE Utilizador_idUtilizadores = ? AND Turno_UC_codigo = ?;");

        stm.setString(1, codTurnoD);
        stm.setString(2, codAluno);
        stm.setString(3, codUC);
        stm.executeUpdate();

        //Troca as faltas do aluno1
        PreparedStatement stm2 = conn.prepareStatement("UPDATE Falta\n"
                + "SET Turno_numero = ?\n"
                + "WHERE utilizador = ? AND Turno_UC_codigo = ?;");

        stm2.setString(1, codTurnoD);
        stm2.setString(2, codAluno);
        stm2.setString(3, codUC);
        stm2.executeUpdate();

        Connect.close(conn);

    }

	public ArrayList<Turno> getTurnos(String codDocente) {
		ArrayList<Turno> res = new ArrayList<>();

        conn = Connect.connect();
        String sql = "SELECT * "
			+ "FROM UtilizadorTurno JOIN Turno "
			+ "ON Turno_numero = numero AND Turno_UC_codigo = UC_codigo "
			+ "WHERE Utilizador_idUtilizadores = ?;";
        PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1,codDocente);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				res.add(new Turno(rs.getString("numero"),
					              rs.getString("UC_codigo"),
								  rs.getInt("capacidade"),
								  rs.getString("Sala_numero"),
								  rs.getInt("Horario_numero"),
					              rs.getTime("horaI").toLocalTime(),
								  rs.getTime("duracao").toLocalTime(),
				                  rs.getInt("aulasPrevistas")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(TurnoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
        return res;
	}
}
