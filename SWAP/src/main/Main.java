package main;

import presentation.MainWindow;
import swap.business.SWAP;

public class Main {

    public static void main(String[] args) {
		SWAP swap = new SWAP();
		new MainWindow(swap).setVisible(true);
    }
}
