/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.business.SWAP;

/**
 *
 * @author rokai
 */
public class AlunoSolicitaTurno extends javax.swing.JFrame {

	private SWAP s;
	private DefaultTableModel t;
	private HashMap<String, ArrayList<String[]>> notMyTurnos;
	private HashMap<String, ArrayList<String[]>> solicitacoes;
	
	/**
	 * Creates new form AlunoMain
	 */
	public AlunoSolicitaTurno() {
		initComponents();
		s = null;
	}
	
	/**
	 * Creates new form AlunoMain
	 * @param s
	 * @param solicitacoes
	 */
	public AlunoSolicitaTurno(SWAP s, HashMap<String, ArrayList<String[]>> solicitacoes) {
		initComponents();
		this.s = s;
		this.solicitacoes = solicitacoes;		
		this.notMyTurnos = s.getNotMyTurnos();
		
		
		for (String ucSolicitada : solicitacoes.keySet())
			if (notMyTurnos.containsKey(ucSolicitada))
				for (int i = 0; i < solicitacoes.get(ucSolicitada).size(); i++)
					for (int j = 0; j < notMyTurnos.get(ucSolicitada).size(); j++)
						if (solicitacoes.get(ucSolicitada).get(i)[2].equals(notMyTurnos.get(ucSolicitada).get(j)[0]))
							notMyTurnos.get(ucSolicitada).remove(j);
		

		for (String uc : notMyTurnos.keySet()) {
			this.jComboBoxUCs.addItem(uc);
		}
		this.jLabelInvalidoUC.setVisible(false);
		this.jLabelInvalidoTurno.setVisible(false);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonSolicita = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelInvalidoUC = new javax.swing.JLabel();
        jLabelInvalidoTurno = new javax.swing.JLabel();
        jComboBoxUCs = new javax.swing.JComboBox<>();
        jComboBoxTurnos = new javax.swing.JComboBox<>();
        jTextFieldDiaDaSemana = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldHoraI = new javax.swing.JTextField();
        jTextFieldDuracao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                windowClosingCustom(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Solicita turno");

        jButtonSolicita.setText("Solicita");
        jButtonSolicita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSolicitaMouseClicked(evt);
            }
        });

        jLabel4.setText("UC");

        jLabel5.setText("Turno");

        jLabelInvalidoUC.setForeground(new java.awt.Color(255, 0, 0));
        jLabelInvalidoUC.setText("Inválido!");

        jLabelInvalidoTurno.setForeground(new java.awt.Color(255, 0, 0));
        jLabelInvalidoTurno.setText("Inválido!");

        jComboBoxUCs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUCsActionPerformed(evt);
            }
        });

        jComboBoxTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurnosActionPerformed(evt);
            }
        });

        jLabel2.setText("Dia da Semana");

        jLabel3.setText("Hora de Início");

        jLabel6.setText("Duração");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelInvalidoUC))
                            .addComponent(jComboBoxUCs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelInvalidoTurno))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldDiaDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jButtonSolicita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabelInvalidoUC)
                    .addComponent(jLabelInvalidoTurno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxUCs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDiaDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonSolicita)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

	
    private void jButtonSolicitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSolicitaMouseClicked
//        String uc = this.jTextFieldUC.getText();
//		String turno = this.jTextFieldTurno.getText();
		String uc = (String) this.jComboBoxUCs.getSelectedItem();
		String turno = (String) this.jComboBoxTurnos.getSelectedItem();
		if (uc != null && !uc.equals("")) {
			if (turno != null && !turno.equals("")) {
				try {
					if (s.solicitaTurno(uc, turno)) {
						this.dispose();
						JOptionPane.showMessageDialog(this.rootPane,
							"A sua troca foi realizada com sucesso.");
					}
					else {
						this.dispose();
						JOptionPane.showMessageDialog(this.rootPane,
							"Neste momento não existe nenhuma troca compativel.\n"
							+ "A sua solicitação foi adicionada à fila de espera.");
					}
					new AlunoSolicitacoesTurno(s).setVisible(true);
				} catch (SQLException ex) {
					Logger.getLogger(AlunoSolicitaTurno.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			else
				this.jLabelInvalidoTurno.setVisible(true);
		}
		else
			this.jLabelInvalidoUC.setVisible(true);
			
    }//GEN-LAST:event_jButtonSolicitaMouseClicked

    private void jComboBoxUCsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUCsActionPerformed
        String ucSelected = (String) this.jComboBoxUCs.getSelectedItem();
		this.jComboBoxTurnos.removeAllItems();
		for (String[] turno : notMyTurnos.get(ucSelected)) {
			this.jComboBoxTurnos.addItem(turno[0]);
		}
    }//GEN-LAST:event_jComboBoxUCsActionPerformed

    private void jComboBoxTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurnosActionPerformed
        String ucSelected = (String) this.jComboBoxUCs.getSelectedItem();
		String turnoSelected = (String) this.jComboBoxTurnos.getSelectedItem();
		for (String[] turno : notMyTurnos.get(ucSelected))
			if (turno[0].equals(turnoSelected)) {
				this.jTextFieldDiaDaSemana.setText(parseIntDia(Integer.parseInt(turno[1])));
				this.jTextFieldHoraI.setText(turno[2]);
				this.jTextFieldDuracao.setText(turno[3]);
			}
    }//GEN-LAST:event_jComboBoxTurnosActionPerformed

    private void windowClosingCustom(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosingCustom
        this.dispose();
		new AlunoSolicitacoesTurno(s).setVisible(true);
    }//GEN-LAST:event_windowClosingCustom

	private String parseIntDia(int diaSemana) {
        String[] arr = {"Segunda","Terça","Quarta","Quinta","Sexta"};

        return (arr[diaSemana] + "-feira");
    }
	
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
			java.util.logging.Logger.getLogger(AlunoSolicitaTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AlunoSolicitaTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AlunoSolicitaTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AlunoSolicitaTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AlunoSolicitaTurno().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSolicita;
    private javax.swing.JComboBox<String> jComboBoxTurnos;
    private javax.swing.JComboBox<String> jComboBoxUCs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelInvalidoTurno;
    private javax.swing.JLabel jLabelInvalidoUC;
    private javax.swing.JTextField jTextFieldDiaDaSemana;
    private javax.swing.JTextField jTextFieldDuracao;
    private javax.swing.JTextField jTextFieldHoraI;
    // End of variables declaration//GEN-END:variables
}
