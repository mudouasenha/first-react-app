package pacote;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Carta extends JButton {
		ImageIcon imageIcon;
		int numeroImagem;
		int x;
		int y;
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
				new ImageIcon(getClass().getResource("18.jpg")),
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
		
		public Carta(int numeroImagem) {
			this.imageIcon = imagemFundo;
			this.numeroImagem = numeroImagem;
			this.x = 0;
			this.y = 0;
		}
		
		public Carta() {
		}
		
		public int getNumeroImagem() {
			return numeroImagem;
		}
		
		public void setNumeroImagem(int numeroImagem) {
			this.numeroImagem = numeroImagem;
		}
				
		public ImageIcon getImageIcon() {
			return imageIcon;
		}
		
		public void setImageIcon(ImageIcon imageIcon) {
			this.imageIcon = imageIcon;
		}
		
		public int getX() {
			return x;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public int getY() {
			return y;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
}
