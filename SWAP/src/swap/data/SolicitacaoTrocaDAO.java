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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import swap.business.SolicitacaoTroca;

/**
 *
 * @author MarcoSilva
 */
public class SolicitacaoTrocaDAO implements List<SolicitacaoTroca> {
    
    private Connection conn;    

	@Override
	public int size() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Iterator<SolicitacaoTroca> iterator() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T> T[] toArray(T[] ts) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public ArrayList<SolicitacaoTroca> getAll(String codUC) {
		ArrayList<SolicitacaoTroca> trocas = new ArrayList<>();
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM SolicitacaoTroca WHERE UC_codigo=?"); 
			stm.setString(1, (String) codUC);
            ResultSet rs = stm.executeQuery();
			
            while (rs.next()) {
                    trocas.add(new SolicitacaoTroca(rs.getString("turnoS"),rs.getString("turnoD"),rs.getString("aluno")));
            }
			
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return trocas;
	}
	
	public boolean add(SolicitacaoTroca e, String codUC) {
		try {
			conn = Connect.connect();
			PreparedStatement stm = conn.prepareStatement("INSERT INTO SolicitacaoTroca(turnoS,turnoD,aluno,UC_codigo)\n" +
				"VALUES (?,?,?,?);");
			
			
			stm.setString(1, e.getCod_turnoS());
			stm.setString(2, e.getCod_turnoD());
			stm.setString(3, e.getCod_aluno());
			stm.setString(4, codUC);
			stm.executeUpdate();
			
			Connect.close(conn);
			
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(SolicitacaoTrocaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean containsAll(Collection<?> clctn) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean addAll(Collection<? extends SolicitacaoTroca> clctn) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean addAll(int i, Collection<? extends SolicitacaoTroca> clctn) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean removeAll(Collection<?> clctn) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean retainAll(Collection<?> clctn) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	@Override
	public SolicitacaoTroca get(int i) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public SolicitacaoTroca set(int i, SolicitacaoTroca e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void add(int i, SolicitacaoTroca e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public SolicitacaoTroca remove(int i) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ListIterator<SolicitacaoTroca> listIterator() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ListIterator<SolicitacaoTroca> listIterator(int i) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<SolicitacaoTroca> subList(int i, int i1) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean add(SolicitacaoTroca e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
