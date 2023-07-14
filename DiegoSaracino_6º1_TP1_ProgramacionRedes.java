package TP1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.FileReader;

public class ejercicio {
	static PrintStream ps = System.out;
	static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	
	
	/* 1) Ingresar datos numéricos (por diferentes orígenes, sin usar la clase Scanner para leer o
	escribir e ingresando, por lo menos, 2 veces el numero ‘0’ por cada uno de los orígenes de
	datos entrantes e enviarlos a un algoritmo que los almacene en 2 sectores de memoria
	distintos:*/
	
	public static void ingresarDatos() {
	    ps.println("¿Cuántos datos quiere ingresar?");
	    int cantidadDatos = leerEntero();

	    String[] datos = leerDatosVector(cantDatos);
	    imprimirValoresVector(datos);

	    escribirDatosArchivo(datos);
	    
	    generarArchivoResultadosYError(datos);
	    
	    generarArchivoResultadosYErrorDos(datos);
	    
	    ps.println(leer());

	    ps.println("");
	    ps.println("Se creó correctamente el archivo");
	}

	
	private static int leerEntero() {
	    int cantDatos = 0;
	    
	    try {
	        cantDatos = Integer.parseInt(br.readLine());
	        ps.println("");
	    } catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
	    
	    return cantDatos;
	}

	
	private static String[] leerDatosVector(int cantDatos) {
	    String[] datos = new String[cantDatos];
	    
	    try {
	        for ( int i = 0 ; i < cantDatos ; i++ ) {
	            ps.println("Ingrese el dato para escribirlo en el vector (mínimo 5 datos se solicitan): ");
	            datos[i] = bfr.readLine();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    return datos;
	}

	
	private static void imprimirValoresVector(String[] datos) {
	    ps.println("");
	    ps.println("Valores dentro del vector: ");
	    
	    for( int i = 0 ; i < datos.length ; i++ ) {
	        ps.println(datos[i]);
	    }
	    
	    ps.println("");
	}

	
	private static void escribirDatosArchivo(String[] datos) {
	    File archivo = new File("datos.txt");
	    
	    try {
			FileWriter fw = new FileWriter(archivo , false);
			PrintWriter pw = new PrintWriter(fw);
			
			for( int i = 0 ; i < datos.length ; i++ ) {
			    ps.println("Ingrese el dato para escribirlo en el archivo(mínimo 5 datos se solicitan): ");
			    String dato = bfr.readLine();
			    pw.println(dato);
			}
			
			fw.flush();
			pw.close();
			fw.close();
        } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	}
	
	
	/* 2) Leer los datos numéricos del vector cargado en el punto 1 y generar 2 archivos de salida: */
	
	public static void generarArchivoResultadosYError(String[] datos) {
	    File archivo = new File("resultados.txt");
	    File archivoError = new File("error.txt");
	    
	    try {
	        FileWriter fw = new FileWriter(archivo , false );
	        PrintWriter pw = new PrintWriter(fw);
	        
			FileWriter fwr = new FileWriter(archivoError , true);
			PrintWriter pwr = new PrintWriter(fwr);
			
	        for( int i = 0 ; i < datos.length ; i++ ) {
	            double num1 = Integer.parseInt(datos[i]);
	            
	            // Obtiene el siguiente numero del vector
	            int num2Index = i + 1;
	            if(num2Index >= datos.length) {
	                num2Index = 0; // Vuelve al primer número del vector
	            }
	            
	            double num2 = Integer.parseInt(datos[num2Index]) - 3;
	            
	            String resultado = "";
	            try {
	            	double result = num1 / num2;
	                resultado += result;
	            } catch (NumberFormatException | ArithmeticException e) {
	                pwr.println(datos[i] + " / " + datos[i + 1] + " = " + "error: " + e.getMessage());
	                resultado = "Error: División por cero";
	            }
	            
	            // Escribe en el archivo de resultados
	            String linea = num1 + " / " + num2 + " = " + resultado;
	            pw.println(linea);
	        }
	        
	        fw.flush();
	        fwr.flush();
	        pw.close();
	        fw.close();
	        fwr.close();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	/* 3) Leer los datos numéricos de los 2 orígenes guardados en el punto 1 y generar 2 archivos
	de salida: */
	
	
	public static void generarArchivoResultadosYErrorDos(String[] datos) {
		String cadena = leer();
		String[] lineas = cadena.split("\n");
		
		File archivo = new File("resultadosDos.txt");
		File archivoError = new File("errorDos.txt");
		
		try {
			FileWriter fw = new FileWriter( archivo , true );
			PrintWriter pw = new PrintWriter(fw);

			FileWriter fwr = new FileWriter( archivoError , true );
			PrintWriter pwr = new PrintWriter(fwr);
			
			for( int i = 0 ; i < datos.length ; i++ ) {
                double num1 = Integer.parseInt(datos[i]);
                int num2 = 3;
                
                String resultado = "";
                try {
                    double result = num1 / num2;
                	resultado += result;
                    ps.println(result + ": ");
                } catch (NumberFormatException | ArithmeticException e) {
                	pwr.println(datos[i] + " / " + datos[i + 1] + " = " + "error: " + e.getMessage());
                    resultado = "Error: División por cero";
                }
                
                String linea = (num1 + " / " + num2 + " = " + resultado + "\n");
                pw.write(linea);
            }
		
			
			
			for (int i = 0; i < lineas.length - 1; i++) {
			    if (!lineas[i].isEmpty()) {
			        try {
			            double num1 = Double.parseDouble(lineas[i]);
			            int num2 = 3;

			            String resultado = "";
			            try {
			                double result = num1 / num2;
			                resultado += result;
			                pw.write(num1 + " / " + num2 + " = " + resultado + "\n");
			            } catch (NumberFormatException | ArithmeticException e) {
			                pwr.println(lineas[i] + " / " + lineas[i + 1] + " = " + "error: " + e.getMessage());
			                resultado = "Error: División por cero";
			            }
			        } catch (NumberFormatException e) {
			            // Maneja el error de formato de número inválido en lineas[i]
			            pwr.println("Dato inválido: " + lineas[i]);
			        }
			    }
			}
			
			
			
			
			fw.flush();
	        fwr.flush();
	        pw.close();
	        fw.close();
	        fwr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        

	}
	
	
	public static String leer() {
		   
		String texto="";
		try {
			
			FileReader fr = new FileReader("datos.txt");
			BufferedReader bfr = new BufferedReader( fr );
			
			String linea ="";
		
			while( (linea = bfr.readLine() ) !=  null) {
				texto += "\n" + linea;
			}
			
				br.close();
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return texto;
	}
	
	
}

