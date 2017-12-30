/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import javax.swing.JFileChooser;
import main.business.SWAP;

/**
 *
 * @author rokai
 */
public class CarregarHorario extends javax.swing.JFrame {

	private SWAP s;
	
	/**
	 * Creates new form CarregarHorario
	 */
	public CarregarHorario() {
		initComponents();
	}
	
	/**
	 * Creates new form CarregarHorario
	 */
	public CarregarHorario(SWAP s) {
		initComponents();
		this.s = s;
		int fase = s.getFase();
		if (fase == 0)
			this.jButtonCarregarHorario.setEnabled(true);
			this.jButtonPrimeiraFase.setEnabled(true);
			this.jButtonSegundaFase.setEnabled(false);
		if (fase == 1) {
			this.jButtonCarregarHorario.setEnabled(false);
			this.jButtonPrimeiraFase.setEnabled(false);
			this.jButtonSegundaFase.setEnabled(true);
		}
		else if (fase == 2) {
			this.jButtonCarregarHorario.setEnabled(false);
			this.jButtonPrimeiraFase.setEnabled(true);
			this.jButtonSegundaFase.setEnabled(false);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jButtonCarregarHorario = new javax.swing.JButton();
        jButtonConcluido = new javax.swing.JButton();
        jButtonPrimeiraFase = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSegundaFase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Opções disponíveis");

        jButtonCarregarHorario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonCarregarHorario.setText("Carregar Horário");
        jButtonCarregarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarregarHorarioActionPerformed(evt);
            }
        });

        jButtonConcluido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonConcluido.setText("Sair");
        jButtonConcluido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConcluidoMouseClicked(evt);
            }
        });

        jButtonPrimeiraFase.setText("Fase 1");
        jButtonPrimeiraFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrimeiraFaseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Começar primeira fase de trocas");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Começar segunda fase de trocas");

        jButtonSegundaFase.setText("Fase 2");
        jButtonSegundaFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSegundaFaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonConcluido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSegundaFase))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonCarregarHorario)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPrimeiraFase)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButtonCarregarHorario)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonPrimeiraFase))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonSegundaFase))
                .addGap(18, 18, 18)
                .addComponent(jButtonConcluido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConcluidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConcluidoMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButtonConcluidoMouseClicked

    private void jButtonCarregarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarregarHorarioActionPerformed
		this.jFileChooser1.setVisible(true);
		int result = this.jFileChooser1.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			String filePath = this.jFileChooser1.getSelectedFile().getPath();
			s.carregaInfo(filePath);
			this.dispose();
		} else if (result == JFileChooser.CANCEL_OPTION) {
			this.jFileChooser1.setVisible(false);
		}
    }//GEN-LAST:event_jButtonCarregarHorarioActionPerformed

    private void jButtonPrimeiraFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrimeiraFaseActionPerformed
        s.changeFase(1);
		this.jButtonCarregarHorario.setEnabled(false);
		this.jButtonPrimeiraFase.setEnabled(false);
		this.jButtonSegundaFase.setEnabled(true);
    }//GEN-LAST:event_jButtonPrimeiraFaseActionPerformed

    private void jButtonSegundaFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSegundaFaseActionPerformed
        s.changeFase(2);
		this.jButtonCarregarHorario.setEnabled(false);
		this.jButtonPrimeiraFase.setEnabled(true);
		this.jButtonSegundaFase.setEnabled(false);
    }//GEN-LAST:event_jButtonSegundaFaseActionPerformed

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
			java.util.logging.Logger.getLogger(CarregarHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CarregarHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CarregarHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CarregarHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CarregarHorario().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCarregarHorario;
    private javax.swing.JButton jButtonConcluido;
    private javax.swing.JButton jButtonPrimeiraFase;
    private javax.swing.JButton jButtonSegundaFase;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
