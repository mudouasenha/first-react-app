package pacote;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class ControladorJogo extends JFrame {

    protected JPanel painel;
	protected JButton iniciar;
    protected JButton ranking;
    protected JButton opcaoNivel;
    protected JButton sair;
    protected String nivelSelecionado = "facil";///////////////////////////////////////////MUDAR DEPOIS 
    protected JButton facil;
    protected JButton medio;
    protected JButton dificil;
    protected JDesktopPane desktop;
    protected ImageIcon icon;
    protected Image image;
    protected long tempo;
    public ControladorJogo(){
        
        super("Jogo da Memoria");
        JMenuBar bar = new JMenuBar();
        JMenu menu= new JMenu("Opcoes");
        JMenuItem frameInterno = new JMenuItem("Selecionar Nivel");
        
        setJMenuBar(bar);
        bar.add(menu);
        menu.add(frameInterno);
        
        desktop = new JDesktopPane() {
        	public void paintComponent(Graphics g) {
            	g.drawImage(image, 0, 0, desktop.getWidth(), desktop.getHeight(), desktop);
            }
        };
        
        add(desktop);
        painel = new JPanel();
        
        frameInterno.addActionListener( 
        		new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						JInternalFrame frame = new JInternalFrame("Selecione", true, true, true, true);
						JPanel painelB = new JPanel();
						frame.add(painelB, BorderLayout.CENTER);
						frame.setSize(160, 170);
						frame.setVisible(true);
						desktop.add(frame);
						facil = new JButton(" Nivel Facil ");
						medio = new JButton(" Nivel Medio ");
						dificil = new JButton(" Nivel Dificil ");
						
						painelB.add(facil);
						painelB.add(medio);
						painelB.add(dificil);
						
						facil.addActionListener( new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								nivelSelecionado ="facil";
								frame.setVisible(false);
							}
						});
						medio.addActionListener( new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								nivelSelecionado ="medio";
								frame.setVisible(false);
							}
						});
						dificil.addActionListener( new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								nivelSelecionado ="dificil";
								frame.setVisible(false);
							}	
						});
					}
        		}	
        );
        
        ImageIcon icon = new ImageIcon(getClass().getResource("dog.jpg"));
        image = icon.getImage();
        GridLayout grid = new GridLayout();
        
        iniciar = new JButton("START");
        iniciar.addActionListener(
        		new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println(nivelSelecionado);
						if(nivelSelecionado.equalsIgnoreCase("facil")){
							JogoFacil jogoFacil = new JogoFacil();
							jogoFacil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jogoFacil.setSize(800, 500);
							jogoFacil.setVisible(true);
							jogoFacil.setResizable(true);
						}
						if(nivelSelecionado.equalsIgnoreCase("medio")){
							JogoFacil jogoNormal = new JogoFacil();
							jogoNormal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jogoNormal.setSize(800, 500);
							jogoNormal.setVisible(true);
							jogoNormal.setResizable(true);
						}
						if(nivelSelecionado.equalsIgnoreCase("dificil")){
							JogoFacil jogoDificil = new JogoFacil();
							jogoDificil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jogoDificil.setSize(800, 500);
							jogoDificil.setVisible(true);
							jogoDificil.setResizable(true);
						}
						
						
					}
        }
        );
        ranking = new JButton("RANKING");
        ranking.addActionListener( 
        		new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {						
						ArrayList<Historico> scores = new ArrayList<>();
						ReadSequentialFile read = new ReadSequentialFile();
						read.openFile();
						scores = read.readRecords();
						read.closeFile();
						
						Comparator<Historico> ch = new Comparator<Historico>() {
							@Override
							public int compare(Historico h1, Historico h2) {
								if (h1.getTempo() < h2.getTempo()) {
									return -1;
								} else {
									if (h1.getTempo() == h2.getTempo()) {
										return 0;
									} else {
										return 1;
									}
								}
							};
						};
						
						scores.sort(ch);
						
						
						StringBuilder strings = new StringBuilder();
						for (int i = 0; i < scores.size() ; i++) {
							strings.append("Jogador " + (i+1) + " - " + scores.get(i).getTempo() + "\n");	
						}
						JOptionPane.showMessageDialog(null, strings, "SCORES", JOptionPane.PLAIN_MESSAGE);
						/*JogoFacil jogo = new JogoFacil();
						Historico hist = new Historico(10);
						ReadSequentialFile read = new ReadSequentialFile();
						read.openFile();
						ArrayList<Historico> scores = read.readRecords();
						read.closeFile();
						
						
						CreateSequentialFile application = new CreateSequentialFile();

					      application.openFile();
					      
					      for(int i = 0; scores.size()<i ; i++) {
					    	  read.listaHist = scores ;
					    	  
					      }
					    		  
					      application.addRecords(hist.getTempo());
					
					      application.closeFile();
						
					      
						JOptionPane.showMessageDialog(null,hist.getTempo() + "\n" +  hist.getTempo(), "SCORE", JOptionPane.PLAIN_MESSAGE);
					*/
					}
        		}
        );
        
        sair = new JButton("SAIR DO JOGO");
        sair.addActionListener( 
        		new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(EXIT_ON_CLOSE);
					}
        		}
        );
        
        desktop.add(painel, BorderLayout.CENTER);
        desktop.add(iniciar);
        iniciar.setSize(230, 70);
        
        ranking.setLocation(310, 60);
        
        desktop.add(ranking);
        ranking.setSize(230,40);
        iniciar.setLocation(310, 236);
      
        desktop.add(sair);
        sair.setSize(230,40);
        sair.setLocation(310, 420); 
    }
}