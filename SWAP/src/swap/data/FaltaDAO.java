package swap.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import swap.business.Aluno;
import swap.business.Falta;

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
    public void putFalta(String aluno, String codTurno, String codUc) throws SQLException {

        conn = Connect.connect();
        PreparedStatement stm = conn.prepareStatement("INSERT INTO Falta(quant, utilizador, Turno_numero, Turno_UC_codigo)\n" +
                "VALUES (1,?,?,?);");

        stm.setString(1, aluno);
        stm.setString(2, codTurno);
        stm.setString(3, codUc);
        stm.executeUpdate();

        Connect.close(conn);
    }

    public void incFalta(String a, String codTurno, String codUc) throws SQLException {
        conn = Connect.connect();

        PreparedStatement stm = conn.prepareStatement("UPDATE Falta SET quant = quant + 1 WHERE utilizador = ? AND Turno_numero = ? AND Turno_UC_codigo=?");
        stm.setString(1,a);
        stm.setString(2,codTurno);
        stm.setString(3,codUc);
        stm.executeUpdate();

        Connect.close(conn);
    }
}
