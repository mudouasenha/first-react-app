package pacote;

import javax.swing.JFrame;

public abstract class JogosMae extends JFrame {
	
	String nomeJanela;
	
	public JogosMae(){
		
		super("Jogo da Mem�ria");
	}

	public JogosMae(String nomeJanela) {
		this.nomeJanela = nomeJanela;
	}
}
