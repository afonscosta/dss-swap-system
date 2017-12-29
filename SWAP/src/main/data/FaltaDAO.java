package main.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FaltaDAO {

    private Connection conn;

    public boolean containsKey(String codTurno, String codUc, String alunoNum) {
        boolean r = false;

        try {
            conn = Connect.connect();
            String sql = "SELECT * FROM Falta WHERE Turno_numero=? AND Turno_UC_codigo=? AND utilizador=?;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,codTurno);
            stm.setString(2,codUc);
            stm.setString(3,alunoNum);
            ResultSet rs = stm.executeQuery();

            boolean ret = rs.next();

            Connect.close(conn);

            return (ret);

        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    //só será utilizado no caso de a instância ainda não existir na tabela
    public void putFalta(String aluno, String codTurno, String codUc,Integer vezes) {

        try {

            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Falta(quant, utilizador, Turno_numero, Turno_UC_codigo)\n" +
                    "VALUES (?,?,?,?);");

            stm.setInt(1, vezes);
            stm.setString(2, aluno);
            stm.setString(3, codTurno);
            stm.setString(4, codUc);
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Connect.close(conn);
        }
    }

    public void incFalta(String a, String codTurno, String codUc,Integer vezes) {
        try {

            conn = Connect.connect();

            PreparedStatement stm = conn.prepareStatement("UPDATE Falta SET quant = quant + ? WHERE utilizador = ? AND Turno_numero = ? AND Turno_UC_codigo=?");
            stm.setInt(1,vezes);
            stm.setString(2, a);
            stm.setString(3, codTurno);
            stm.setString(4, codUc);
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
    }

    public void verificaLimiteFaltas(String a, String codTurno, String codUC) {
        try {

        conn = Connect.connect();

        PreparedStatement stm = conn.prepareStatement("SELECT f.quant, \n " +
                                                                    "t.aulasPrevistas \n " +
                                                                    "FROM Falta f \n " +
                                                                    "JOIN Turno t ON f.Turno_numero = t.numero AND f.Turno_UC_codigo = t.UC_codigo \n" +
                                                                    "WHERE f.utilizador = ? AND t.numero = ? AND t.UC_codigo = ?;");
        stm.setString(1,a);
        stm.setString(2,codTurno);
        stm.setString(3,codUC);
        ResultSet rs = stm.executeQuery();

        if (rs.next()) {

            int aulasPrevistas = rs.getInt("aulasPrevistas");
            int cap = (int) Math.ceil(aulasPrevistas * 0.25);
            int faltasAluno = rs.getInt("quant");

            if (faltasAluno >= cap) {
                removeAlunoTurno(a, codTurno, codUC);
            }

        }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
    }

    private void removeAlunoTurno(String a, String codTurno, String codUC) {
        try {

            conn = Connect.connect();

            PreparedStatement stm = conn.prepareStatement("DELETE FROM UtilizadorTurno WHERE Utilizador_idUtilizadores = ? AND Turno_numero = ? AND Turno_UC_codigo = ?;");
            stm.setString(1,a);
            stm.setString(2,codTurno);
            stm.setString(3,codUC);
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
    }
}
