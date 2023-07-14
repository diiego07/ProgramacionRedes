package EjerciciosGuia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

public class Ejercicio3_Guia {
	
	static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream ps = new PrintStream(System.out);

	
	
	// Crear un archivo de texto (en la carpeta del proyecto) que guarde solo el Ãºltimo dato que el usuario escribe por consola.
	
	public static void Ejercicio3a() {
		String[] datos = Funcion.funciones.ingresarDatosEnLista();
		
		File archivo = new File("hola.txt");
		FileWriter fw;
		
		try {
			fw = new FileWriter( archivo , false );
			PrintWriter pw = new PrintWriter(fw);
			if( datos.length > 0 ) {
				String ultimoDato = datos[ datos.length -1 ];
				pw.println(ultimoDato);
			} else {
				pw.println("No se ingresaron los datos.");
			}
			
			fw.flush();
			pw.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// Crear un archivo de texto (en la carpeta del proyecto) que guarde TODOS los valores NUMERICOS que ingrese el
	// usuario por consola, cada uno en un renglÃ³n (puede ingresar otros datos que no sean numero OJO).
	
	public static void Ejercicio3b() {
		String[] datos = Funcion.funciones.ingresarDatosEnLista();
		
		File archivo = new File("datos.txt");
		FileWriter fw;
		
        List<Integer> nums_lista = Funcion.funciones.filtrarNumeros(datos);

        try {
            fw = new FileWriter( archivo , false );
			PrintWriter pw = new PrintWriter(fw);
			
            for (int num : nums_lista) {
                pw.println(num);
            }

            fw.flush();
            pw.close();
            fw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	
	
	// Crear un archivo de texto (fuera de la carpeta del proyecto) que se llame “números.txt” que guarde los números
	// pares desde el 0 al 1000.
	
	public static void Ejercicio3c() {
		List<Integer> nums_pares = new ArrayList<>();
		
		for( int i = 0 ; i <= 1000 ; i += 2) {
			nums_pares.add(i);
		}
		
		File archivo = new File("../Archivos/numeros.txt");
		
		FileWriter fw;
		PrintWriter pw;
		try {
			fw = new FileWriter( archivo , false );
			pw = new PrintWriter(fw);
			
			for( int num : nums_pares ) {
				pw.println(num);
			}
			
			fw.flush();
			pw.close();
			fw.close();
			
			ps.println("Archivo creado exitosamente");
		} catch (IOException e) {
			e.printStackTrace();
			ps.println("Error al crear el archivo: " + e.getMessage());
		}
	}
	
	
	
	// Utilizar el archivo creado anteriormente “números.txt” y leer los valores para mostrarlos por la consola.
	
	public static void Ejercicio3d() {
		String cadena = Funcion.funciones.leerArchivo("../Archivos/numeros.txt");
		
		ps.println(cadena);
	}
	
	
	
	// Utilizar el archivo creado anteriormente “números.txt” y borrarle todos los renglones que contengas números impares.
	
	public static void Ejercicio3e() {
		String cadena = Funcion.funciones.leerArchivo("../Archivos/numeros.txt");
		
		cadena = cadena.replaceAll("(?m)^.*[13579].*$", "");
		
		FileWriter fw;
		PrintWriter pw;
		
		try {
			fw = new FileWriter("../Archivos/numeros.txt");
			pw = new PrintWriter(fw);
			
			pw.println(cadena);
			
			fw.flush();
			pw.close();
			fw.close();
			
			ps.println("El archivo ha sido actualizado.");
		} catch (IOException e) {
			e.printStackTrace();
			ps.println("Error al actualizar el archivo: " + e.getMessage());
		}
	}
	
	
	
	// Utilizar el archivo creado anteriormente “números.txt” (con los números impares eliminados) y colocar en otro archivos 
    // de texto “primos.dat” (fuera de la carpeta del proyecto y de la carpeta que tiene el archivo “números.txt”) todos los
	// números de ”números.txt” que sean primos.
	
	public static void Ejercicio3f() {
	    String cadena = Funcion.funciones.leerArchivo("../Archivos/numeros.txt");
	    
	    List<Integer> nums_primos = new ArrayList<>();
	    
	    File archivo = new File("../ArchivosExtras/primos.dat");
	    
	    FileWriter fw;
	    PrintWriter pw;
	    
	    try {
	        fw = new FileWriter(archivo);
	        pw = new PrintWriter(fw);
	        
	        String[] numeros = cadena.split("\n");
	        
	        for( String num : nums ) {
	        	try {
	                int num = Integer.parseInt(num);
	                if( Funcion.funciones.esPrimo(num) ) {
	                    numerosPrimos.add(num);
	                }
	            } catch (NumberFormatException e) {

	            }
	        }
	        
	        for (int primo : numerosPrimos) {
	            pw.println(primo);
	        }
	        
	        fw.flush();
	        pw.close();
	        fw.close();
	        br.close();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	// Crear un archivo de texto plano (fuera de la carpeta del proyecto) que se llame “caracteres.dat”, cargarle 10 palabras
	// que contengan la letra ‘ñ’ mediante consola. Luego mostrar las 10 palabras por consola con la leyenda “Fichero original: ”
	// y luego editar el fichero para que cambie todas las apariciones de la letra ‘ñ’ por su fonético ‘nie-nio’ y mostrar de
	// nuevo las palabras con la leyenda “Fichero arreglado:”.
	
	public static void Ejercicio3g() {
		
		List<String> palabras = new ArrayList<>();
		
		String rutaArchivo = "../Archivos/caracteres.dat";
		
		//File archivo = new File(rutaArchivo);
	    
	    FileWriter fw;
	    PrintWriter pw;
	    
	   
    	try {
    		for( int i = 0 ; i < 10 ; i++ ) {
    			ps.println("Ingrese la palabra que desee con ñ: ");
    			palabras.add(bfr.readLine());
    		}
    		
    		fw = new FileWriter(rutaArchivo);
	        pw = new PrintWriter(fw);
	        
	        for( String palabra : palabras ) {
	        	pw.println(palabra);
	        }
	        
	        pw.close();
	        
	        ps.println("");
	        ps.println("Fichero original:");
	        ps.println("");
	        FileReader fr = new FileReader(rutaArchivo);
	        BufferedReader bfr = new BufferedReader(fr);
    		
	        String linea;
            while( (linea = bfr.readLine()) != null ) {
                System.out.println(linea);
            }
	        
            br.close();
            
            
            
            List<String> lineasEditadas = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            while ( (linea = br.readLine()) != null ) {
            	String palabraEditada = Funcion.funciones.reemplazarEquivalenteFonetico(linea);
                lineasEditadas.add(palabraEditada);
            }
            
            br.close();

            
            
            fw = new FileWriter(rutaArchivo);
            pw = new PrintWriter(fw);
            
            for( String lineaEditada : lineasEditadas ) {
                pw.println(lineaEditada);
            }
            
            pw.close();

            
	        ps.println("");
            ps.println("Fichero arreglado:");
            ps.println("");
            BufferedReader br2 = new BufferedReader(new FileReader(rutaArchivo));
            while( (linea = br2.readLine()) != null ) {
                ps.println(linea);
            }
            
            br2.close();
            
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
}




























