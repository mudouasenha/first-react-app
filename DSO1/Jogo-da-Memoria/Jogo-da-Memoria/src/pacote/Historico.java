package pacote;
import java.io.Serializable;

public class Historico implements Serializable{
	   private long tempo;
	   
	   // four-argument constructor initializes a record
	   public Historico(long tempo )
	   {
	      this.setTempo( tempo );
	      
	   } // end four-argument AccountRecordSerializable constructor

	public void setTempo(long tempo) {
		this.tempo = tempo;
		
	}
	
	public long getTempo() {
		
		return this.tempo;
	}

	}