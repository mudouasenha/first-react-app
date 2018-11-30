package pacote;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CreateSequentialFile
{
   private ObjectOutputStream output; // outputs data to file

   // allow user to specify file name
   public void openFile()
   {
      try // open file
      {
         output = new ObjectOutputStream(
            new FileOutputStream( "./historico.ser" ) );
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error opening file." );
      } // end catch
   } // end method openFile

   // add records to file
   public void addRecords(long tempo)
   {
      Historico record; // object to be written to file

               // create new record
               record = new Historico( tempo );
               try {
				output.writeObject( record );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // output record
        
   } // end method addRecords

   // close file and terminate application 
   public void closeFile() 
   {
      try // close file
      {
         if ( output != null )
            output.close();
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error closing file." );
         System.exit( 1 );
      } // end catch
   } // end method closeFile
}