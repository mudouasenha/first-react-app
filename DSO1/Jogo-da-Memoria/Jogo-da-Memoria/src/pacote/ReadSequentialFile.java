package pacote;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadSequentialFile
{
private ObjectInputStream input;

protected ArrayList <Historico> listaHist ;
public void openFile()
{
   try // open file
   {
      input = new ObjectInputStream(
         new FileInputStream( "historico.ser" ) );
   } // end try
   catch ( IOException ioException )
   {
      System.err.println( "Error opening file." );
   } // end catch
} // end method openFile

// read record from file
public ArrayList<Historico> readRecords()
{
   Historico record;
   
   listaHist = new ArrayList<Historico>();
   
   try // input the values from the file
   { 
      while ( true )
      {
         record = ( Historico ) input.readObject();
         listaHist.add(record);
      }
   }
   catch (EOFException ignored){} // end catch
   catch ( ClassNotFoundException classNotFoundException )
   {
      System.err.println( "Unable to create object." );
   } // end catch
   catch ( IOException ioException )
   {
      System.err.println( "Error during reading from file." );
   } // end catch
   
   return listaHist;

} // end method readRecords

// close file and terminate application
public void closeFile()
{
   try // close file and exit
   {
      if ( input != null )
         input.close();
   } // end try
   catch ( IOException ioException )
   {
      System.err.println( "Error closing file." );
      System.exit( 1 );
   } // end catch
} // end method closeFile
} // end class ReadSequentialFile