package pacote;

public class ControllerJogo implements IControllerJogo {

	int pontos;
	
	@Override
	public void pontua() {
		pontos = pontos +2;
		
	}

	@Override
	public void comparaCarta(Carta botao1, Carta botao2) {
		if(botao1.getImageIcon() == botao2.getImageIcon()) {
			pontua();
			sumir(botao1);
			sumir(botao2);
		}
		else
			desvirar(botao1);
			desvirar(botao2);
		
	}

	@Override
	public void virarCarta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarPontuacao() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sumir(Carta carta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desvirar(Carta carta) {
		// TODO Auto-generated method stub
		
	}

}
