/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import swap.business.SWAP;

/**
 *
 * @author edgar
 */
public class MainWindow {
    /**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SWAP s = new SWAP();
		new Iniciar(s).setVisible(true);
	}
}
