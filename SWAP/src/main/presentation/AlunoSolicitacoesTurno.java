/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.business.SWAP;

/**
 *
 * @author rokai
 */
public class AlunoSolicitacoesTurno extends javax.swing.JFrame {

	private DefaultTableModel t;
	private SWAP s;
	private HashMap<String, ArrayList<String[]>> solicitacoes;
	private String uc;
	private String turnoD;
	
	/**
     * Creates new form MainInterface
     */
    public AlunoSolicitacoesTurno() {
        initComponents();
    }
	
    /**
     * Creates new form MainInterface
	 * @param s
     */
    public AlunoSolicitacoesTurno(SWAP s) {
        initComponents();
		this.uc = null;
		this.turnoD = null;
		this.s = s;
		
		t = new DefaultTableModel();
		t.addColumn("UC");
		t.addColumn("Turno destino");
		jTable1.setModel(t);
		jTable1.setDefaultEditor(Object.class, null);
		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(479);
		
		this.presentSolicitacoes();
		
	}

	private void presentSolicitacoes() {
		this.solicitacoes = s.getSolicitacoesAluno();
		if (solicitacoes.containsKey("BD"))
			System.out.println("Elems: " + solicitacoes.get("BD").size());
		System.out.println("RowCount " + t.getRowCount());
		int countRow = t.getRowCount();
		for (int i = countRow-1; i >= 0; i--) {
			t.removeRow(i);
			System.out.println(i);
		}
		for (Entry<String, ArrayList<String[]>> e : solicitacoes.entrySet())
			for (String[] turno : e.getValue() )
				t.addRow(new Object[]{e.getKey(), turno[2]});
	}
	
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonRemSolicitacao = new javax.swing.JButton();
        jButtonNewSolicitacao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema de Gestão de Quotas");
        setLocation(new java.awt.Point(200, 200));
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                windowClosingCustom(evt);
            }
        });

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.lightGray, null, null));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(-100);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Número");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Nome");
        }

        jButtonRemSolicitacao.setText("Remove solicitação");
        jButtonRemSolicitacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRemSolicitacaoMouseClicked(evt);
            }
        });

        jButtonNewSolicitacao.setText("Nova solicitação");
        jButtonNewSolicitacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNewSolicitacaoMouseClicked(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRemSolicitacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNewSolicitacao)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemSolicitacao)
                    .addComponent(jButtonNewSolicitacao))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
		this.dispose();
		new AlunoMain(s).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        if (evt.getClickCount() == 1) {
			int row = jTable1.rowAtPoint(evt.getPoint());
			int col = jTable1.columnAtPoint(evt.getPoint());
			if (row >= 0 && col >= 0) {
				this.uc = (String) jTable1.getValueAt(row, 0);
				this.turnoD = (String) jTable1.getValueAt(row, 1);
			}
		}
    }//GEN-LAST:event_jTable1MousePressed

    private void jButtonNewSolicitacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNewSolicitacaoMouseClicked
        new AlunoSolicitaTurno(s, solicitacoes).setVisible(true);
		this.dispose();
    }//GEN-LAST:event_jButtonNewSolicitacaoMouseClicked

    private void jButtonRemSolicitacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRemSolicitacaoMouseClicked
		if (uc != null && turnoD != null) {
			s.removeSolicitacaoTurno(uc, turnoD);
			this.presentSolicitacoes();
		}
    }//GEN-LAST:event_jButtonRemSolicitacaoMouseClicked

    private void windowClosingCustom(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosingCustom
        this.dispose();
		new AlunoMain(s).setVisible(true);
    }//GEN-LAST:event_windowClosingCustom

	
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlunoSolicitacoesTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlunoSolicitacoesTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlunoSolicitacoesTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlunoSolicitacoesTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlunoSolicitacoesTurno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNewSolicitacao;
    private javax.swing.JButton jButtonRemSolicitacao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
