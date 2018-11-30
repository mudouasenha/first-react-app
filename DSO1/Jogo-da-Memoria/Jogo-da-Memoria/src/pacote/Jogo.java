package pacote;

import javax.swing.*;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Jogo extends JogosMae{
	protected Carta[] cartas;
	private JPanel painelA;
	

	
	MouseEvent clique;
	public final ImageIcon[] arrayFundos = {
			new ImageIcon(getClass().getResource("FUNDO.jpg")),
			new ImageIcon(getClass().getResource("1.jpg")),
			new ImageIcon(getClass().getResource("2.jpg")),
			new ImageIcon(getClass().getResource("3.jpg")),
			new ImageIcon(getClass().getResource("4.jpg")),
			new ImageIcon(getClass().getResource("5.jpg")),
			new ImageIcon(getClass().getResource("6.jpg")),
	};
	
		//trocar pra string
		public String[] arrayFundos2;
    	ArrayList<String> posicao = (ArrayList<String>) (Arrays.asList(arrayFundos2));
    	
    	
    	
		public Jogo() {
			
			super();
			//nao funcionou pra ImageIcon, vamos relacionar cada carta com uma posicao pra fazer
			Collections.sort(posicao);
			Collections.sort(posicao);
			
			painelA = new JPanel();
			add(painelA);
			painelA.setLayout(new GridBagLayout());
			cartas = new Carta[6];
                        
			
			for(int i = 0; i < 6; i++) {
				cartas[i] = new Carta(i);
			}
			
			for(int i = 0; i < 6; i++) {
			cartas[i].setIcon(arrayFundos[0]);
			}
			
					
			//adicionando cartas ao frame
			for(int i = 0; i < 6; i++) {
			painelA.add(cartas[i]);}

			
			//adicionando handlers
			ButtonHandler handler = new ButtonHandler();
			for(int i = 0; i < 6; i++) {
				cartas[i].addActionListener(handler);
			}
		}
	//classe listener com erro
	class ButtonHandler implements ActionListener {
            Carta botao1 = null;
			Carta botao2 = null;
            boolean botao2Clicado = false;
            
		@Override
		public void actionPerformed(ActionEvent event) {
			Carta source = null;
                        botao1 = (Carta) event.getSource();
				/*//System.out.println("botao1= "+botao1);
				//System.out.println("botao2= "+botao2);
				while((botao1 == null || botao2 == null) && botao2Clicado == false) {
					source = (JButton) event.getSource();
					if(botao1 == null){
						botao1 = source;
                                                System.out.println(botao1);}
					else
						if(source == botao1)
							return;
                                                else{
                                                        botao2Clicado = true;
							botao2 = source;}
				}
				System.out.println(botao1);
				System.out.println(botao2);*/
			
                
              
                //int random = (int) (Math.random() * 6) + 1;
                //botao1.setIcon(arrayFundos[random]);		
                
                //metodo compara cartas
                //if(botao1.getImagemFundo() == botao2.getImagemFundo()) {}
			}	
			
			//public void comparaCartas()
			
		}
		
	
	}





