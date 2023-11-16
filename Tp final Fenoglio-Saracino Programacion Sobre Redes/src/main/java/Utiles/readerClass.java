package Utiles;

import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;

public class readerClass {
	static Reader reader;
	
	public readerClass() {
		reader = new InputStreamReader( System.in );
		
	}
	
	public String leer()
	{
		
		int Byte = 0;
		String cadena="";

		try {
			while ( ( Byte = reader.read() ) != '\n' )
			{
				if ( Byte != '\r' );
					cadena += (char)Byte;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return cadena;
	}
}
