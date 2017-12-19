/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


/**
 *
 * @author MarcoSilva
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SGT sgt = new SGT();
        MainWindow mw = new MainWindow(sgt);
        mw.setVisible(true);
    }
}
