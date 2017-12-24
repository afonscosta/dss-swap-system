package main;

import main.presentation.MainWindow;
import main.business.SWAP;

public class Main {

    public static void main(String[] args) {
		SWAP swap = new SWAP();
		new MainWindow(swap).setVisible(true);
    }
}
