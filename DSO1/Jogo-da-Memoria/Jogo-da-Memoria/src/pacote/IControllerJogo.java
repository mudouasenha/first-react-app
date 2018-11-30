package pacote;

public interface IControllerJogo {

	public void pontua();
	
	public void comparaCarta(Carta botao1, Carta botao2);
	
	public void virarCarta();
	
	public void mostrarPontuacao();
	
	public void sumir(Carta carta);
	
	public void desvirar(Carta carta);
}
