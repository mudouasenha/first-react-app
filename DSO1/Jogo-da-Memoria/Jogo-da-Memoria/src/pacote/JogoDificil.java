package pacote;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pacote.JogoFacil.ButtonHandler;

public class JogoDificil extends JogosMae {
	

	protected Carta[] cartas;
	ControladorCarta controlador;
	private JPanel painelA;
	protected long tempoDeJogo;
	protected long iniciaContaTempo;
	boolean comecou = false;
	int contaClique = 0;
    int qtdCartas = 36;
    int qtdImagens = 18;
	MouseEvent clique;
	public final ImageIcon imagemFundo = new ImageIcon(getClass().getResource("FUNDO.jpg"));
	public final ImageIcon[] arrayFundos = {
			new ImageIcon(getClass().getResource("1.jpg")),
			new ImageIcon(getClass().getResource("2.jpg")),
			new ImageIcon(getClass().getResource("3.jpg")),
			new ImageIcon(getClass().getResource("4.jpg")),   
			new ImageIcon(getClass().getResource("5.jpg")),
			new ImageIcon(getClass().getResource("6.jpg")),
			new ImageIcon(getClass().getResource("7.jpg")),
			new ImageIcon(getClass().getResource("8.jpg")),
			new ImageIcon(getClass().getResource("9.jpg")),
			new ImageIcon(getClass().getResource("10.jpg")),
			new ImageIcon(getClass().getResource("11.jpg")),
			new ImageIcon(getClass().getResource("12.jpg")),
			new ImageIcon(getClass().getResource("13.jpg")),
			new ImageIcon(getClass().getResource("14.jpg")),
			new ImageIcon(getClass().getResource("15.jpg")),
			new ImageIcon(getClass().getResource("16.jpg")),
			new ImageIcon(getClass().getResource("17.jpg")),
			new ImageIcon(getClass().getResource("18.jpg")),
			new ImageIcon(getClass().getResource("19.jpg")),
			new ImageIcon(getClass().getResource("20.jpg")),
			new ImageIcon(getClass().getResource("21.jpg")),
			new ImageIcon(getClass().getResource("22.jpg")),
			new ImageIcon(getClass().getResource("23.jpg")),
			new ImageIcon(getClass().getResource("24.jpg")),
			new ImageIcon(getClass().getResource("25.jpg")),
			new ImageIcon(getClass().getResource("26.jpg")),
			new ImageIcon(getClass().getResource("27.jpg")),
			new ImageIcon(getClass().getResource("28.jpg")),
			new ImageIcon(getClass().getResource("29.jpg")),
			new ImageIcon(getClass().getResource("30.jpg")),
	};
      
		public JogoDificil() {
						
			super("Jogo Dificil");

			controlador = new ControladorCarta();
			Cronometro cronometro = new Cronometro();
			iniciaContaTempo = cronometro.getAtual();
			
            int qtdCartas = 36;
            int qtdImagens = 18;
			painelA = new JPanel();
			add(painelA);
			painelA.setLayout(new GridLayout(6, 6));
			cartas = new Carta[qtdCartas];
            
			//da um numero para cada carta
            int numeroCarta = 1;
			for(int i = 0; i < qtdCartas; i++) {
				cartas[i] = new Carta(numeroCarta);
                numeroCarta++;
                if(numeroCarta > qtdImagens){
                numeroCarta = 1;
                }
			}
			
			//adicionando imagem de fundo para todas as cartas
			for(int i = 0; i < qtdCartas; i++) {
				cartas[i].setIcon(imagemFundo);
			}
								
			//adicionando todas as cartas ao frame
			for(int i = 0; i < qtdCartas; i++) {
				painelA.add(cartas[i]);
			}
			
			//adicionando handlers a todas as cartas
			ButtonHandler handler = new ButtonHandler();
			for(int i = 0; i < qtdCartas; i++) {
				cartas[i].addActionListener(handler);
			}
			
			
			int[] numerosRng = new int[8];


			
			
			
			
			//no final do jogo
			tempoDeJogo = cronometro.getAtual() - iniciaContaTempo;//tem que ser chamado quando o jogo acabar. fazer metodo jogoAcabou
			tempoDeJogo = 10; // apenas para testes
			
			// -----------------------------------------------------------
			// final do jogo
			// salva no arquivo
			//CreateSequentialFile create = new CreateSequentialFile();
			//create.openFile();
			//create.addRecords(tempoDeJogo); // <======= tem q ser o tempo final
			//create.closeFile(); // isso deve ir pro final do jogo
		}
		

		public void sortear() {
			int[] numerosRng = new int[8];

			//horror necessario feat. merda nenhuma funciona
			numerosRng[0] = 2;
			numerosRng[1] = 2;
			numerosRng[2] = 1;
			numerosRng[3] = 0;
			numerosRng[4] = 2;
			numerosRng[5] = 3;
			numerosRng[6] = 1;
			numerosRng[7] = 0;

			Random random = new Random();
			for (int i = 0; i < 8; i++) {
				int rng = random.nextInt(30);//rng = Random Number Generators
				numerosRng[i] = rng;
			}
			
			
			for(int i = 0; i < 4; i++) {
				cartas[i].setNumeroImagem(numerosRng[i]);
				System.out.println(numerosRng[i]);
			}


			//horror necessario feat. merda nenhuma funciona


			for(int i = 0; i < 4; i++) {
				cartas[i+4].setNumeroImagem(numerosRng[i]);
				System.out.println(numerosRng[i]);
			}

			//sortear();


		}

	//classe listener com erro
	class ButtonHandler implements ActionListener {
		Carta botao1 = null;
		int qtdAcertos = 0;


		@Override
		public void actionPerformed(ActionEvent event) {
			
			Carta source = null;
			contaClique++;
			
			if (!comecou) {
				comecou = true;
				//sortear();
			}
			

			//armazena os botoes para comparacao, vira carta
			System.out.println("teste");
			source = (Carta) event.getSource();
			if(botao1 == null){
				botao1 = source;
				controlador.virarCarta(botao1);
			} else
			if(source != botao1) {
				if(controlador.comparaCarta(botao1, source) == true) {
					controlador.virarCarta(source);
					botao1 = null;
					source = null;
					System.out.println(botao1);
					System.out.println(source);
					qtdAcertos++;
					System.out.println(qtdAcertos);
					
				}else {
					controlador.desvirar(botao1);
					controlador.desvirar(source);
					botao1 = null;
					source = null;
				}
			} else {
				return;
			}
			
			if(qtdAcertos >= 18) {
				comecou = false;
				System.out.println("ganhouuu");
				JOptionPane.showMessageDialog(null, "Você Ganhou!!");
				//System.exit(EXIT_ON_CLOSE);
			}
				
			
	}
}
	
}
