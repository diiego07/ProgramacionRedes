package Funcion;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Random;

public class funciones {
	static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream ps = System.out;
	
	// Lee la cadena de texto.
	
	public static String leer() {
		int Byte = 0;
		String cadena = "";
		try {
			while( ( Byte = System.in.read() ) != '\n') {
				if( Byte != '\r') {
					cadena += (char)Byte;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cadena;
	}

	
	
	// Ingresa los datos que solicita el usuario en la lista.
	
	public static String[] ingresarDatosEnLista() {

        ps.println("Â¿CuÃ¡ntos datos quiere ingresar?");
        int cant_datos = 0;
        
        try {
            cant_datos = Integer.parseInt(bfr.readLine());
            ps.println("");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        String[] datos = new String[cant_datos];

        try {
            for( int i = 0 ; i < cant_datos ; i++ ) {
                ps.println("Ingrese el dato: ");
                datos[i] = bfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ps.println("");
        ps.println("Se creÃ³ el archivo correctamente");

        return datos;
    }
	
	
	
	// Filtra los datos numericos de la lista
	
	public static List<Integer> filtrarNumeros(String[] datos) {
        List<Integer> nums_lista = new ArrayList<>();
        
        for (String dato : datos) {
            try {
                int num = Integer.parseInt(dato);
                numerosLista.add(num);
            } catch (NumberFormatException e) {
                // No es nÃºmero entero, continuar
            }
        }
        
        return nums_lista;
        
	}
	
	
	
	// Lee cualquier archivo de texto plano que se la pase como parámetro.
	
	public static String leerArchivo(String nombreArchivo) {
	    String texto = "";

	    try {
	        FileReader fr = new FileReader(nombreArchivo);
	        BufferedReader bfr = new BufferedReader(fr);

	        String linea = "";

	        while ((linea = bfr.readLine()) != null) {
	            texto += "\n" + linea;
	        }

	        bfr.close();

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return texto;
	}
	
    
	
	// Determina si un número es primo.
	
	public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
	
	
	
	// Dependiendo de la palabra que contenga ñ, reemplaza la ñ por su equivalente fonético.
	
	public static String reemplazarEquivalenteFonetico(String palabra) {
        String palabraEditada = "";
        int i = 0;
        
        while( i < palabra.length() ) {
            char c = palabra.charAt(i);
            if( c == 'ñ' && i < palabra.length() - 1 ) {
                char siguiente = palabra.charAt(i + 1);
                switch(siguiente) {
                    case 'a':
                        palabraEditada += "nia";
                        break;
                    case 'e':
                        palabraEditada += "nie";
                        break;
                    case 'i':
                        palabraEditada += "nii";
                        break;
                    case 'o':
                        palabraEditada += "nio";
                        break;
                    case 'u':
                        palabraEditada += "niu";
                        break;
                    default:
                        palabraEditada += "nio";
                        break;
                }
                i++;
            } else {
                palabraEditada += c;
            }
            i++;
        }
        return palabraEditada;
    }
	
	
	
	//
	public static void mostrarResultado(List<Integer> numeros) {
		ps.println("NÃºmeros ingresados: " + leerValores(numeros));
		ps.println("Suma de valores: " + sumarValores(numeros));
		ps.println("Promedio de valores: " + sumarValores(numeros)/numeros.size());
	}
	
	
	
	//
	public static int leerValores(List<Integer> nums) {
		int cantNum = 0;
		for( int i = 0 ; i < nums.size() ; i++ ) {
			cantNum+=1;
		}
		return cantNum;
	}
	
	
	
	//
	public static int sumarValores(List<Integer> nums) {
		int suma = 0;
		for(Integer num : nums) {
			suma += num;
		}
		return suma;
	}
	
	
	
	//
	public static void imprimirElementos(List<String> lista) {
        Iterator<String> iterator = lista.iterator();
        while (iterator.hasNext()) {
            String jugador = iterator.next();
            System.out.println(jugador);
        }
    }
	
	
	
	//
	 public static int[] generarNumsRojos(int cant) {
        int[] numsRojos = new int[cant];
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            int numRojo;
            do {
                numRojo = generarNumAleatorio(1, 33);
            } while (existeNumero(numsRojos, numRojo));

            numsRojos[i] = numRojo;
        }

        return numsRojos;
	 }
	 
	 
	 
	 
	 public static boolean existeNumero(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return true;
            }
        }
        return false;
	 }
	 
	 
	 
	 
	 public static int generarNumAleatorio(int min, int max) {
	        Random random = new Random();
	        return random.nextInt(max - min + 1) + min;
	 }
}












