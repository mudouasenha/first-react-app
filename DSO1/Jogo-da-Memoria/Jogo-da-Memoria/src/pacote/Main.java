package pacote;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {


    	ControladorJogo game = new ControladorJogo();
    	game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	game.setSize(860, 600);
    	game.setVisible(true);
    	game.setResizable(true);
    }
}

