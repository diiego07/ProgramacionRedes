package UTILES;

import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;

public class ReaderClass {
	static Reader lector;
	
	public ReaderClass() {
		lector = new InputStreamReader(System.in);
	}
	
	public String Leer() {
		int Byte = 0;
		String cadena="";
		try {
			while ( ( Byte = lector.read() ) != '\n' ){
				if ( Byte != '\r' )
					cadena += (char)Byte;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cadena;
	}
}