package pacote;

public interface IControladorCarta {

	public boolean comparaCarta(Carta botao1, Carta botao2);

	public void virarCarta(Carta botao);

	public void sumir(Carta carta);

	public void desvirar(Carta carta);
}

