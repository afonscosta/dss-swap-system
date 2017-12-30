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
import main.business.Sala;

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
                String numSala = rs.getString("Sala_numero");
                stm = conn.prepareStatement("SELECT * FROM Sala WHERE numero=?");
                stm.setString(1, numSala);
                ResultSet rs1 = stm.executeQuery();
                if (rs1.next()) {
                    Sala sala = new Sala(rs1.getString("numero"), rs1.getInt("capacidade"));
                    t = new Turno((String) key, rs.getString("UC_codigo"),
                            rs.getInt("capacidade"),
                            sala,
                            rs.getTime("horaInicio").toLocalTime(),
                            rs.getTime("duracao").toLocalTime(),
                            rs.getInt("aulasPrevistas"),
                            rs.getInt("diaSemana"));
                }
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

    public Turno put(Object key, Turno value) {

        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Sala(numero,capacidade)\n" +
                    "VALUES (?,?)"
                    + "ON DUPLICATE KEY UPDATE numero=VALUES(numero),  capacidade=VALUES(capacidade);");
            stm.setString(1, value.getSala().getNumero());
            stm.setInt(2, value.getSala().getCapacidade());
            stm.executeUpdate();

            conn = Connect.connect();
            stm = conn.prepareStatement("INSERT INTO Turno(numero,UC_codigo,capacidade,Sala_numero,horaI,duracao,aulasPrevistas,diaSemana)\n" +
                    "VALUES (?,?,?,?,?,?,?,?);");
            stm.setString(1, value.getId());
            stm.setString(2, (String) key);
            stm.setInt(3, value.getCapacidade());
            stm.setString(4, value.getSala().getNumero());
            stm.setObject(5, value.getHoraInicio());
            stm.setObject(6, value.getDuracao());
            stm.setInt(7,value.getAulasPrevistas());
            stm.setInt(8,value.getDiaSemana());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }

        return value;
    }

    public void trocaTurnos(String codUC, String codAluno1, String codTurnoD1, String codAluno2, String codTurnoD2) {

        try {

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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
    }

    public Turno getTurno(String codTurno,String cod_UC) {

        Turno t = null;

        try {
            conn = Connect.connect();
            String sql = "SELECT * FROM Turno WHERE numero=? AND UC_codigo=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,codTurno);
            stm.setString(2,cod_UC);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                String numSala = rs.getString("Sala_numero");
                stm = conn.prepareStatement("SELECT * FROM Sala WHERE numero=?");
                stm.setString(1, numSala);
                ResultSet rs1 = stm.executeQuery();
                if (rs1.next()) {
                    Sala sala = new Sala(rs1.getString("numero"), rs1.getInt("capacidade"));
                    t = new Turno(rs.getString("numero"),
                            rs.getString("UC_codigo"),
                            rs.getInt("capacidade"),
                            sala,
                            rs.getTime("horaI").toLocalTime(),
                            rs.getTime("duracao").toLocalTime(),
                            rs.getInt("aulasPrevistas"),
                            rs.getInt("diaSemana"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }

        return t;
    }

    public ArrayList<String[]> getAlunos(String codUC, String codTurno) {
        ArrayList<String[]> res = new ArrayList<>();

        try {

            conn = Connect.connect();
            String sql = "SELECT * FROM UtilizadorTurno \n " +
                    "JOIN Utilizador ON Utilizador_idUtilizadores = idUtilizadores \n " +
                    "WHERE Turno_UC_codigo = ? AND Turno_numero = ? AND prioridade IS NOT NULL;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, codUC);
            stm.setString(2, codTurno);
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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
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
        } finally {
            Connect.close(conn);
        }
        return res;
    }

    public void setTurno(String codAluno, String codTurnoD, String codUC) {
        try {

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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }

    }

    public ArrayList<Turno> getTurnos(String codDocente) {
        ArrayList<Turno> res = new ArrayList<>();

        conn = Connect.connect();
        String sql = "SELECT * \n"
                + "FROM UtilizadorTurno JOIN Turno \n"
                + "ON Turno_numero = numero AND Turno_UC_codigo = UC_codigo \n"
                + "JOIN Utilizador ON Utilizador_idUtilizadores = idUtilizadores \n"
                + "WHERE Utilizador_idUtilizadores = ?;";
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1,codDocente);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String numSala = rs.getString("Sala_numero");
                stm = conn.prepareStatement("SELECT * FROM Sala WHERE numero=?");
                stm.setString(1, numSala);
                ResultSet rs1 = stm.executeQuery();
                if (rs1.next()) {
                    Sala sala = new Sala(rs1.getString("numero"), rs1.getInt("capacidade"));
                    res.add(new Turno(rs.getString("numero"),
                            rs.getString("UC_codigo"),
                            rs.getInt("capacidade"),
                            sala,
                            rs.getTime("horaI").toLocalTime(),
                            rs.getTime("duracao").toLocalTime(),
                            rs.getInt("aulasPrevistas"),
                            rs.getInt("diaSemana")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public void putAllTurnos(ArrayList<Turno> turnos) {
        for (Turno t : turnos) {
            put(t.getUC_codigo(),t);
        }

    }

    public HashMap<String,ArrayList<String[]>> getNotMyTurnos(String chave) {
        HashMap<String,ArrayList<String[]>> res = new HashMap<>();

        try {

            conn = Connect.connect();

            String sql = "SELECT UtilizadorTurno.Turno_UC_codigo,Turno.numero, Turno.diaSemana, Turno.horaI, Turno.duracao \n"
                       + "FROM UtilizadorTurno  \n"
                       + "JOIN Turno ON Turno.UC_codigo = UtilizadorTurno.Turno_UC_codigo \n"
                       + "WHERE Utilizador_idUtilizadores = ?\n"
                       + "AND UtilizadorTurno.Turno_numero <> Turno.numero;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,chave);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String uc = rs.getString("Turno_UC_codigo");

				String[] turno = new String[4];
				turno[0] = rs.getString("numero");
				turno[1] = rs.getString("diaSemana");
				turno[2] = rs.getTime("horaI").toString();
				turno[3] = rs.getTime("duracao").toString();

                if (!res.containsKey(uc)) {
                    ArrayList arr = new ArrayList<>();
                    arr.add(turno);
                    res.put(uc,arr);
                } else {
                    ArrayList arr = res.get(uc);
                    arr.add(turno);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return res;
    }
}
