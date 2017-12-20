/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import swap.business.SWAP;

/**
 *
 * @author rokai
 */
public class AlunoMain extends javax.swing.JFrame {

	SWAP s;
	private DefaultTableModel t;
	/**
	 * Creates new form AlunoMain
	 */
	public AlunoMain() {
		initComponents();
		t = new DefaultTableModel();
		t.addColumn("");
		t.addColumn("segunda-feira");
		t.addColumn("terca-feira");
		t.addColumn("quarta-feira");
		t.addColumn("quinta-feira");
		t.addColumn("sexta-feira");
		Vector v9 = new Vector(1);
		Vector v10 = new Vector(1);
		Vector v11 = new Vector(1);
		Vector v12 = new Vector(1);
		Vector v13 = new Vector(1);
		Vector v14 = new Vector(1);
		Vector v15 = new Vector(1);
		Vector v16 = new Vector(1);
		Vector v17 = new Vector(1);
		v9.add(0, "9:00");
		v10.add(0, "10:00");
		v11.add(0, "11:00");
		v12.add(0, "12:00");
		v13.add(0, "13:00");
		v14.add(0, "14:00");
		v15.add(0, "15:00");
		v16.add(0, "16:00");
		v17.add(0, "17:00");
		t.addRow(v9);
		t.addRow(v10);
		t.addRow(v11);
		t.addRow(v12);
		t.addRow(v13);
		t.addRow(v14);
		t.addRow(v15);
		t.addRow(v16);
		t.addRow(v17);
		
		jTable1.setModel(t);
		ColoringCellRenderer r = new ColoringCellRenderer();
		jTable1.getColumnModel().getColumn(1).setCellRenderer(r);
		jTable1.getColumnModel().getColumn(2).setCellRenderer(r);
		jTable1.getColumnModel().getColumn(3).setCellRenderer(r);
		jTable1.getColumnModel().getColumn(4).setCellRenderer(r);
		jTable1.getColumnModel().getColumn(5).setCellRenderer(r);
		//Segunda
		r.setHighlighted(2,1,true, new Color(0, 255, 0));
		r.setHighlighted(3,1,true, new Color(0, 255, 0));
		r.setHighlighted(5,1,true, new Color(0, 255, 0));
		r.setHighlighted(6,1,true, new Color(0, 255, 0));
		r.setHighlighted(7,1,true, new Color(255, 0, 0));
		r.setHighlighted(8,1,true, new Color(255, 0, 0));
		//Terca
		r.setHighlighted(0,2,true, new Color(0, 255, 0));
		r.setHighlighted(1,2,true, new Color(0, 255, 0));
		r.setHighlighted(2,2,true, new Color(0, 255, 0));
		r.setHighlighted(3,2,true, new Color(0, 255, 0));
		//Quarta
		r.setHighlighted(0,3,true, new Color(0, 255, 0));
		r.setHighlighted(1,3,true, new Color(0, 255, 0));
		r.setHighlighted(2,3,true, new Color(0, 255, 0));
		r.setHighlighted(3,3,true, new Color(0, 255, 0));
		r.setHighlighted(5,3,true, new Color(255, 255, 0));
		r.setHighlighted(6,3,true, new Color(255, 255, 0));
		//Quinta
		r.setHighlighted(2,4,true, new Color(0, 255, 0));
		r.setHighlighted(3,4,true, new Color(0, 255, 0));
		r.setHighlighted(5,4,true, new Color(0, 255, 0));
		r.setHighlighted(6,4,true, new Color(0, 255, 0));
		r.setHighlighted(7,4,true, new Color(0, 255, 0));
		r.setHighlighted(8,4,true, new Color(0, 255, 0));
		//Sexta
		r.setHighlighted(0,5,true, new Color(0, 255, 0));
		r.setHighlighted(1,5,true, new Color(0, 255, 0));
		r.setHighlighted(2,5,true, new Color(0, 255, 0));
		r.setHighlighted(3,5,true, new Color(0, 255, 0));
		jTable1.setDefaultEditor(Object.class, null);
	}
	
	/**
	 * Creates new form AlunoMain
	 */
	public AlunoMain(SWAP s) {
		this.s = s;
		initComponents();
		t = new DefaultTableModel();
		t.addColumn("");
		t.addColumn("segunda-feira");
		t.addColumn("terca-feira");
		t.addColumn("quarta-feira");
		t.addColumn("quinta-feira");
		t.addColumn("sexta-feira");
		Vector v9 = new Vector(1);
		Vector v10 = new Vector(1);
		Vector v11 = new Vector(1);
		Vector v12 = new Vector(1);
		Vector v13 = new Vector(1);
		Vector v14 = new Vector(1);
		Vector v15 = new Vector(1);
		Vector v16 = new Vector(1);
		Vector v17 = new Vector(1);
		v9.add(0, "9:00");
		v10.add(0, "10:00");
		v11.add(0, "11:00");
		v12.add(0, "12:00");
		v13.add(0, "13:00");
		v14.add(0, "14:00");
		v15.add(0, "15:00");
		v16.add(0, "16:00");
		v17.add(0, "17:00");
		t.addRow(v9);
		t.addRow(v10);
		t.addRow(v11);
		t.addRow(v12);
		t.addRow(v13);
		t.addRow(v14);
		t.addRow(v15);
		t.addRow(v16);
		t.addRow(v17);
		
		jTable1.setModel(t);
		ColoringCellRenderer r = new ColoringCellRenderer();
		jTable1.getColumnModel().getColumn(1).setCellRenderer(r);
		jTable1.getColumnModel().getColumn(2).setCellRenderer(r);
		jTable1.getColumnModel().getColumn(3).setCellRenderer(r);
		jTable1.getColumnModel().getColumn(4).setCellRenderer(r);
		jTable1.getColumnModel().getColumn(5).setCellRenderer(r);
		//Segunda
		r.setHighlighted(2,1,true, new Color(0, 255, 0));
		r.setHighlighted(3,1,true, new Color(0, 255, 0));
		r.setHighlighted(5,1,true, new Color(0, 255, 0));
		r.setHighlighted(6,1,true, new Color(0, 255, 0));
		r.setHighlighted(7,1,true, new Color(255, 0, 0));
		r.setHighlighted(8,1,true, new Color(255, 0, 0));
		//Terca
		r.setHighlighted(0,2,true, new Color(0, 255, 0));
		r.setHighlighted(1,2,true, new Color(0, 255, 0));
		r.setHighlighted(2,2,true, new Color(0, 255, 0));
		r.setHighlighted(3,2,true, new Color(0, 255, 0));
		//Quarta
		r.setHighlighted(0,3,true, new Color(0, 255, 0));
		r.setHighlighted(1,3,true, new Color(0, 255, 0));
		r.setHighlighted(2,3,true, new Color(0, 255, 0));
		r.setHighlighted(3,3,true, new Color(0, 255, 0));
		r.setHighlighted(5,3,true, new Color(255, 255, 0));
		r.setHighlighted(6,3,true, new Color(255, 255, 0));
		//Quinta
		r.setHighlighted(2,4,true, new Color(0, 255, 0));
		r.setHighlighted(3,4,true, new Color(0, 255, 0));
		r.setHighlighted(5,4,true, new Color(0, 255, 0));
		r.setHighlighted(6,4,true, new Color(0, 255, 0));
		r.setHighlighted(7,4,true, new Color(0, 255, 0));
		r.setHighlighted(8,4,true, new Color(0, 255, 0));
		//Sexta
		r.setHighlighted(0,5,true, new Color(0, 255, 0));
		r.setHighlighted(1,5,true, new Color(0, 255, 0));
		r.setHighlighted(2,5,true, new Color(0, 255, 0));
		r.setHighlighted(3,5,true, new Color(0, 255, 0));
		jTable1.setDefaultEditor(Object.class, null);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Horário");

        jTable1.setBackground(new java.awt.Color(238, 238, 238));
        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"9:00", "", null, null, null, null},
                {"10:00", null, null, null, null, null},
                {"11:00", null, null, null, null, null},
                {"12:00", null, null, null, null, null},
                {"13:00", null, null, null, null, null},
                {"14:00", null, null, null, null, null},
                {"15:00", null, null, null, null, null},
                {"16:00", null, null, null, null, null},
                {"17:00", null, null, null, null, null}
            },
            new String [] {
                "", "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira"
            }
        ));
        jTable1.setRowHeight(50);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Sair");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setText("Informação adicional necessária");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(143, 143, 143))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
			Component comp = jTable1.prepareRenderer(renderer, row, col);
			comp.setBackground(Color.red);
			return comp;
		}
	
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
		this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

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
			java.util.logging.Logger.getLogger(AlunoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AlunoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AlunoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AlunoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AlunoMain().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
