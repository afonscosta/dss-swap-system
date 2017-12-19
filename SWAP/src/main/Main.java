/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import presentation.MainWindow;
import swap.business.SWAP;


/**
 *
 * @author MarcoSilva
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SWAP swap = new SWAP();
        MainWindow mw = new MainWindow(swap);
        mw.setVisible(true);
    }
}
