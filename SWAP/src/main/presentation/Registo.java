/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.presentation;
import main.business.SWAP;

/**
 *
 * @author rokai
 */
public class Registo extends javax.swing.JFrame {

	private SWAP s;
	private boolean docente;
	private boolean aluno;
	private boolean dc;
	
	/**
	 * Creates new form Registo
	 */
	private Registo() {
		initComponents();
	}
	
	public Registo(SWAP s) {
		initComponents();
		this.s = s;
		this.jCheckBoxPrio.setEnabled(false);
		this.jCheckBoxRegente.setEnabled(false);
		this.jTextFieldUC.setEnabled(false);
		docente = false;
		aluno = false;
		dc = false;
		this.jLabelInvalidoEmail.setVisible(false);
		this.jLabelInvalidoPass.setVisible(false);
		this.jLabelInvalidoPassConf.setVisible(false);
		this.jCheckBoxShowPass.setSelected(false);
	}

	

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jCheckBoxPrio = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldUC = new javax.swing.JTextField();
        jCheckBoxRegente = new javax.swing.JCheckBox();
        jLabelInvalidoEmail = new javax.swing.JLabel();
        jLabelInvalidoPass = new javax.swing.JLabel();
        jLabelInvalidoPassConf = new javax.swing.JLabel();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jPasswordFieldPassConf = new javax.swing.JPasswordField();
        jCheckBoxShowPass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registo");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closingWindowCustom(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Criar conta");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Insira os dados para criar uma nova conta.");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Criar uma palavra-passe");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Confirmar palavra-passe");

        jTextFieldNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEmailFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEmailFocusGained(evt);
            }
        });

        jCheckBoxPrio.setText("Prioritário");

        jLabel6.setText("UC (Sigla)");

        jCheckBoxRegente.setText("Regente");

        jLabelInvalidoEmail.setForeground(new java.awt.Color(255, 0, 0));
        jLabelInvalidoEmail.setText("Inválido!");

        jLabelInvalidoPass.setForeground(new java.awt.Color(255, 0, 0));
        jLabelInvalidoPass.setText("Inválido!");

        jLabelInvalidoPassConf.setForeground(new java.awt.Color(255, 0, 0));
        jLabelInvalidoPassConf.setText("Inválido!");

        jPasswordFieldPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldPassFocusGained(evt);
            }
        });

        jPasswordFieldPassConf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldPassConfFocusGained(evt);
            }
        });

        jCheckBoxShowPass.setText("Mostrar palavras-passe");
        jCheckBoxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldPassConf)
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldEmail)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxPrio))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldUC)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxRegente))
                    .addComponent(jPasswordFieldPass)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelInvalidoEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelInvalidoPassConf)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelInvalidoPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jCheckBoxShowPass)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBoxPrio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelInvalidoEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelInvalidoPass)
                    .addComponent(jCheckBoxShowPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelInvalidoPassConf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldPassConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCheckBoxRegente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
		String nome = this.jTextFieldNome.getText();
		String email = this.jTextFieldEmail.getText();
		String pass = new String(this.jPasswordFieldPass.getPassword());
		String passVerifica = new String(this.jPasswordFieldPassConf.getPassword());
//		String chave = s.extraiChave(email);
		String uc = this.jTextFieldUC.getText();

		if (pass.equals(passVerifica)) {
			if (aluno) {
				s.registo(nome, email, pass, this.jCheckBoxPrio.isSelected(), -1);
			}
			else if (dc) {
				s.registo(nome, email, pass, null, -1);
			}
			else if (docente) {
				int pressed = (this.jCheckBoxRegente.isSelected()) ? 1 : 0;
				s.registo(nome, email, pass, uc, pressed );
			}
			new MainWindow(s).setVisible(true);
			this.dispose();
		}
		else {
			this.jLabelInvalidoPass.setVisible(true);
			this.jLabelInvalidoPassConf.setVisible(true);
		}
			
    }//GEN-LAST:event_jButton1MouseClicked

	private String checkEmail (String email) {
		String res = null;
		if (email != null && !email.equals("")) {
			for (int i = 0; i < email.length(); i++) 
				if (email.charAt(i) == '@') {
					String sufixo = (String) email.subSequence(i, email.length());
					if (sufixo.equals("@di.uminho.pt") || sufixo.equals("@alunos.uminho.pt")) {
						String chave = s.extraiChave(email);
						if (chave.length() > 1)
							res = chave;
					}
					i = email.length();
				}
		}
		return res;
	}
	
    private void jTextFieldEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusLost
        String email = this.jTextFieldEmail.getText();
		String chave;
		if ((chave = this.checkEmail(email)) != null) {
			if (chave.startsWith("a") && Character.isDigit(chave.charAt(1))) {
				this.jTextFieldUC.setEnabled(false);
				this.jCheckBoxRegente.setEnabled(false);
				this.jCheckBoxRegente.setSelected(false);
				this.jCheckBoxPrio.setEnabled(true);
				this.aluno = true;
				this.dc = false;
				this.docente = false;
			}
			else if (chave.equals("dcmiei")) {
				this.jTextFieldUC.setEnabled(false);
				this.jCheckBoxPrio.setEnabled(false);
				this.jCheckBoxPrio.setSelected(false);
				this.jCheckBoxRegente.setEnabled(false);
				this.jCheckBoxRegente.setSelected(false);
				this.dc = true;
				this.aluno = false;
				this.docente = false;
			}
			else {
				this.jTextFieldUC.setEnabled(true);
				this.jCheckBoxRegente.setEnabled(true);
				this.jCheckBoxPrio.setEnabled(false);
				this.jCheckBoxPrio.setSelected(false);
				this.docente = true;
				this.aluno = false;
				this.dc = false;
			}
		}
		else
			this.jLabelInvalidoEmail.setVisible(true);
    }//GEN-LAST:event_jTextFieldEmailFocusLost

    private void jTextFieldEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusGained
        this.jLabelInvalidoEmail.setVisible(false);
    }//GEN-LAST:event_jTextFieldEmailFocusGained

    private void jPasswordFieldPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPassFocusGained
        this.jLabelInvalidoPass.setVisible(false);
		this.jLabelInvalidoPassConf.setVisible(false);
    }//GEN-LAST:event_jPasswordFieldPassFocusGained

    private void jPasswordFieldPassConfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPassConfFocusGained
        this.jLabelInvalidoPass.setVisible(false);
		this.jLabelInvalidoPassConf.setVisible(false);
    }//GEN-LAST:event_jPasswordFieldPassConfFocusGained

    private void jCheckBoxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxShowPassActionPerformed
        if (this.jCheckBoxShowPass.isSelected()) {
            this.jPasswordFieldPass.setEchoChar((char)0);
			this.jPasswordFieldPassConf.setEchoChar((char)0);
        }
		else {
            this.jPasswordFieldPass.setEchoChar('•');
			this.jPasswordFieldPassConf.setEchoChar('•');
		}
    }//GEN-LAST:event_jCheckBoxShowPassActionPerformed

    private void closingWindowCustom(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closingWindowCustom
        new MainWindow(s).setVisible(true);
		this.dispose();
    }//GEN-LAST:event_closingWindowCustom

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
			java.util.logging.Logger.getLogger(Registo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Registo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Registo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Registo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Registo().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxPrio;
    private javax.swing.JCheckBox jCheckBoxRegente;
    private javax.swing.JCheckBox jCheckBoxShowPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelInvalidoEmail;
    private javax.swing.JLabel jLabelInvalidoPass;
    private javax.swing.JLabel jLabelInvalidoPassConf;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JPasswordField jPasswordFieldPassConf;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldUC;
    // End of variables declaration//GEN-END:variables
}
