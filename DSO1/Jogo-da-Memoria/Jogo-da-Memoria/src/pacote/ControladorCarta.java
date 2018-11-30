package pacote;

import javax.swing.ImageIcon;

public class ControladorCarta implements IControladorCarta {


	int pontos;

	@Override
	public boolean comparaCarta(Carta botao1, Carta botao2) {
		boolean ehPar;
		System.out.println(botao1.getNumeroImagem());
		System.out.println(botao2.getNumeroImagem());
		if(botao1.getNumeroImagem() == botao2.getNumeroImagem()) {
			sumir(botao1);
			sumir(botao2);
			ehPar = true;
			System.out.println("deu ceeijajdsandkjasdknaskdj");
		}
		else {
			ehPar = false;
			desvirar(botao1);
			desvirar(botao2);}
		return ehPar;
	}

	@Override
	public void virarCarta(Carta botao) {
		String num = Integer.toString(botao.getNumeroImagem());
		System.out.println(botao);
		botao.setIcon(new ImageIcon(getClass().getResource(num + ".jpg")));
	}

	@Override
	public void sumir(Carta carta) {
		carta.setEnabled(false);
	}

	@Override
	public void desvirar(Carta carta) {
		carta.setIcon(new ImageIcon(getClass().getResource("FUNDO.jpg")));
		carta = null;
	}
}