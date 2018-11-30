package pacote;

public class Cronometro {  
	private long fim;
    private long inicio = 0;  
  
    // Construtor - tambem ativa o cronometro.  
    public Cronometro() {  
         inicio = System.currentTimeMillis();  
    }  
  
    // retorna tempo em segundos   
    // nao interrompe o cronometro, pode ser chamado varias vezes  
    public long getAtual() {  
        long mili = System.currentTimeMillis() - inicio;
        fim = Math.round(mili / 1000.0);  
        return fim;
        
    }  
}  