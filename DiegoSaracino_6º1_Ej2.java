package EjerciciosGuia;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio2_Guia {
	static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream ps = new PrintStream(System.out);

	// Dados tres apellidos, la computadora los muestra ordenados alfabéticamente
	
	public static void Ejercicio_2a() {
        ps.println("Introduci tres apellidos para ordenarlos alfabéticamente:");
        String apellido1;
        ps.println("");
        
		try {
			apellido1 = bfr.readLine();
			String apellido2 = bfr.readLine();
	        String apellido3 = bfr.readLine();
	        
	        if (apellido1.compareTo(apellido2) < 0 ) {
	        	if (apellido1.compareTo(apellido3) < 0 ) {
	        		ps.println(apellido1);
	        		if (apellido2.compareTo(apellido3) < 0) {
	        			ps.println(apellido2);
	        			ps.println(apellido3);
	        		} else {
	        			ps.println(apellido3);
	        			ps.println(apellido2);
	        		}
	        	} else {
	        		ps.println(apellido3);
	                ps.println(apellido1);
	                ps.println(apellido2);
	        	}
	        } else {
	        	if (apellido2.compareTo(apellido3) < 0 ) {
	        		ps.println(apellido2);
	        		if (apellido1.compareTo(apellido3) < 0 ) {
	        			ps.println(apellido1);
	        			ps.println(apellido3);
	        		} else {
	        			ps.println(apellido3);
	        			ps.println(apellido1);
	        		}
	        	} else {
	        		ps.println(apellido3);
	        		ps.println(apellido2);
	        		ps.println(apellido1);
	        	}
	        }	
	    } catch (IOException e) {
			e.printStackTrace();
	    }
	}
	
	// Dados cuatro números reales, la computadora indica cuál es el menor.

	
	public static void Ejercicio_2b() {
        try {
	        ps.println("Ingrese cuatro números reales sin coma:");
	        int n1 = Integer.parseInt(br.readLine());
	        int n2 = Integer.parseInt(br.readLine());
	        int n3 = Integer.parseInt(br.readLine());
	        int n4 = Integer.parseInt(br.readLine());
	
	        double nMenor = n1;
	        if (n2 < nMenor) {
	        	nMenor = n2;
	        	if (n3 < nMenor) {
	            	nMenor = n3;
	            	if (n4 < nMenor) {
	                	nMenor = n4;
	            	}
	        	}
	        }
	        
	        ps.println("");
	        ps.println("El número menor es: " + numMenor);
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
	
	// Dado un número, la computadora indica si es par o impar.
	
	public static void Ejercicio_2c() {
		try {
			ps.println("Ingrese un número sin coma: ");
			
	        int n = Integer.parseInt(bfr.readLine());
	        if(n % 2 == 0) {
	        	ps.println("");
	            ps.println(n + " es un número par.");
	        } else {
	        	ps.println("");
	            ps.println(n + " es un número impar.");
	        }
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	// Dados dos números reales, la computadora indica si el mayor es divisible por el menor.
	
	public static void Ejercicio_2d() {
		try {
	        ps.println("Ingrese el primer número:");
	        double n1 = Double.parseDouble(bfr.readLine());
	        ps.println("Ingrese el segundo número:");
	        double n2 = Double.parseDouble(bfr.readLine());

	        double mayor = Math.max(n1, n2);
	        double menor = Math.min(n1, n2);

	        if (mayor % menor == 0) {
	        	ps.println("");
	            ps.println("El mayor es divisible por el menor.");
	        } else {
	        	ps.println("");
	            ps.println("El mayor no es divisible por el menor.");
	        }
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	// Dada la fecha de nacimiento de una persona, la computadora muestra su signo del zodíaco.
	
	public static void Ejercicio_2e() {
		try {
			ps.println("Ingresa tu fecha de nacimiento (formato dd/MM/yyyy): ");
	        String fechaNacimientoText = bfr.readLine();
	        
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        Date fechaNacimiento;
			fechaNacimiento = formatter.parse(fechaNacimientoText);
			
			String signo = funciones.obtenerSignoZodiaco(fechaNacimiento);
			
			ps.println("");
	        ps.println("Tu signo zodiacal es: " + signo);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	// Dado el nombre y apellido de 2 personas, la computadora muestra cuál de los 2 tiene el apellido más largo.
	
	public static void Ejercicio_2f() {
		try {
	        ps.println("Ingresa el nombre y apellido de la primera persona: ");
	        String[] NyA1 = br.readLine().split(" ");
	        String apellido1 = NyA1[NyA1.length - 1];
	        ps.println("Ingresa el nombre y apellido de la segunda persona: ");
	        String[] NyA2 = bfr.readLine().split(" ");
	        String apellido2 = NyA2[NyA2.length - 1];


	        if (apellido1.length() > apellido2.length()) {
	        	ps.println("");
	            ps.println(NyA1[0] + " " + apellido1 + " tiene un apellido más largo.");
	        } else if (apellido1.length() < apellido2.length()) {
	        	ps.println("");
	            ps.println(NyA2[0] + " " + apellido2 + " tiene un apellido más largo.");
	        } else {
	        	ps.println("");
	            ps.println("Ambos tienen apellidos de igual longitud.");
	        }
        }catch (IOException e) {
			e.printStackTrace();
        }
	}
	
	// Dado un entero N natural, la computadora muestra su tabla de multiplicar.
	
	public static void Ejercicio_2g() {
		try {
	        ps.print("Ingrese un número: ");

	        int n = Integer.parseInt(bfr.readLine());
	        
	        ps.println("");
	        
	        for (int i = 1; i <= 10; i++) {
	            ps.println(n + " x " + i + " = " + (n*i));
	        }
    	} catch (IOException e) {
			e.printStackTrace();
        }
	}
	
	// Dado un número natural, la computadora indica si es primo o no.
	
	public static void Ejercicio_2h() {
		try {
			boolean esPrimo = true;
	        ps.println("Ingrese un número natural:");
			int num = Integer.parseInt(bfr.readLine());
			
	        if (num == 1 || num == 0) {
	            ps.println(num + " no es un número primo ni compuesto.");
	            return;
	        }

	        for ( int i = 2 ; i <= num / 2 ; i++ ) {
	            if (num % i == 0) {
	                esPrimo = false;
	                break;
	            }
	        }

	        if (esPrimo) {
	        	ps.println("");
	            ps.println(num + " ese número es primo.");
	        } else {
	        	ps.println("");
	            ps.println(num + " ese número no es primo.");
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
}