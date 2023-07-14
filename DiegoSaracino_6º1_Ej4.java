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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.io.PrintWriter;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Ejercicio4_Guia {
	static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream ps = new PrintStream(System.out);
	
	
	// A) Una serie de valores num�ricos enteros desde el teclado y los guarde en un List de tipo Integer.

	public static void Ejercicio4a() {
		int seguir = 1, numero;
		
		List<Integer> nums = new ArrayList<Integer>();
		while(seguir == 1) {
			ps.println("Ingrese un n�mero (-99 para terminar): ");
			num = Integer.parseInt(Funcion.funciones.leer());
			if(num != -99) {
				nums.add(num);
			}else{
				seguir = 0;
				break;
			}
			
		}
		Funcion.funciones.mostrarResultado(nums);
	}
	
	
	
	// B) Crea una clase colegio que almacene los apellidos junto a la nacionalidad de los alumnos de un colegio.
	
	public static void Ejercicio4b() {
		Colegio colegio = new Colegio(10);

        colegio.addAlumno("Rodriguez", "España");
        colegio.addAlumno("Fernandez", "España");
        colegio.addAlumno("Giemenez", "Argentina");
        colegio.addAlumno("Acosta", "Brasil");
        colegio.addAlumno("Lopez", "Colombia");
        colegio.addAlumno("Consorti", "Italia");
        colegio.addAlumno("Messi", "Italia");
        colegio.addAlumno("Dybala", "Chile");
        colegio.addAlumno("Neymar", "Portugal");
        
        colegio.showAll();
        
        colegio.showNacionalidad("Espa�a");

        colegio.cuantos();
    
        colegio.borra();
        
        colegio.showAll();
    }
	
	/* C) Crea una colecci�n apropiada que contenga los d�as de la semana.  
		Inserta en la posici�n 4 el elemento �Juernes�.  
		Crea una copia de esa lista a otra llamada listaDos. */ 
	
	public static void Ejercicio4c() {
		List<String> listDias = new ArrayList<>();
        listDias.add("Lunes");
        listDias.add("Martes");
        listDias.add("Mi�rcoles");
        listDias.add(3, "Juernes");
        listDias.add("Jueves");
        listDias.add("Viernes");
        listDias.add("S�bado");
        listDias.add("Domingo");

        List<String> listaDos = new ArrayList<>(listDias);

        listDias.addAll(listaDos);

        ps.println("Elemento en la posici�n 3: " + listDias.get(3));
        ps.println("Elemento en la posici�n 4: " + listDias.get(4));
        ps.println("Primer elemento: " + listDias.get(0));
        ps.println("�ltimo elemento: " + listDias.get(listDias.size() - 1));
        
        ps.println("");
        
        listDias.remove("Juernes");

        if (listDias.contains("Juernes")) {
            ps.println("Se elimin� 'Juernes' de la lista.");
        } else {
            ps.println("'Juernes' no se encontraba en la lista.");
        }
        
        ps.println("");

        ps.println("Contenido de la lista original:");

        Iterator<String> iterator = listDias.iterator();
        while (iterator.hasNext()) {
            ps.println(iterator.next());
        }

        String searchElement = "Lunes";
        boolean elementFound = listDias.stream()
                .map(String::toLowerCase)
                .anyMatch(e -> e.equals(searchElement.toLowerCase()));

        ps.println("");
        
        if (elementFound) {
            ps.println("Se pudo encontrar el elemento '" + searchElement + "' en la lista.");
        } else {
            ps.println("No se pudo encontrar el elemento '" + searchElement + "' en la lista.");
        }
        
        ps.println("");

        listDias.sort(String.CASE_INSENSITIVE_ORDER);

        ps.println("Contenido de la lista ordenada:");
        ps.print(listDias.stream().distinct().findFirst().orElse(""));
        for (int i = 1; i < listDias.size(); i++) {
            ps.print(", " + listDias.get(i));
        }
        ps.println();
    }

	// D) Crea un conjunto al que se le va a llamar jugadores. Inserta en el conjunto los jugadores del FC Barcelona.
	
	public static void Ejercicio4d() {
		List<String> jugadores = new ArrayList<>();
        List<String> jugadores2 = new ArrayList<>();

        jugadores.add("Jordi Alba");
        jugadores.add("Pique");
        jugadores.add("Busquets");
        jugadores.add("Iniesta");
        jugadores.add("Messi");

        ps.println("Nombres de jugadores:");
        Funcion.funciones.imprimirElementos(jugadores);

        ps.println();

        ps.println("�Se encuentra a Neymar Jr en la lista de jugadores?");
        boolean existeNeymar = jugadores.contains("Neymar JR");
        if (existeNeymar) {
        	ps.println("S�, Neymar Jr se encuentra en est� lista.");
        } else {
        	ps.println("No, Neymar Jr no se encuentra en est� lista.");
        }

        ps.println();

        jugadores2.add("Pique");
        jugadores2.add("Busquets");

        ps.println("�Estan todos los elementos de jugadores2 en jugadores?");
        boolean todosEnJugadores = jugadores.containsAll(jugadores2);
        if (todosEnJugadores) {
        	ps.println("S�, todos los elementos de jugadores2 est�n en jugadores.");
        } else {
        	ps.println("No, algunos elementos de jugadores2 no est�n en jugadores.");
        }

        ps.println();

        jugadores.addAll(jugadores2);

        ps.println("Uni�n de jugadores y jugadores2:");
        Funcion.funciones.imprimirElementos(jugadores);

        ps.println();

        ps.println("Intentando agregar a Piqu� nuevamente a jugadores:");
        boolean piqueAgregado = jugadores.add("Pique");
        if (piqueAgregado) {
        	ps.println("Piqu� ha sido agregado correctamente a jugadores.");
        } else {
        	ps.println("Piqu� no pudo ser agregado a jugadores.");
        }
	}
	
	// E) Reglas de bolas de dos colores: cada apuesta en la bola de dos colores consta de 6 n�meros de bolas rojas y 1 n�mero de bolas azules. 
	
	public static void Ejercicio4e() {
        ps.println("Generador de n�meros para apuestas en la bola de dos colores");
        ps.println("");

        int[] numerosRojos = Funcion.funciones.generarNumerosRojos(6);
        int numeroAzul = Funcion.funciones.generarNumeroAleatorio(1, 16);

        ps.println("N�meros de bolas rojas:");
        for (int numeroRojo : numerosRojos) {
            ps.print(numeroRojo + " ");
        }
        ps.println("");
        ps.println("N�mero de bola azul: " + numeroAzul);
	}
	
	// G) Obtener los datos a travez de entreSet y de keySet

	
	public static void Ejercicio4g() {
		// Creado del primer conjunto
        Set<String> conjunto1 = new HashSet<>();
        conjunto1.add("Provincia de Heilongjiang");
        conjunto1.add("Provincia de Zhejiang");
        conjunto1.add("Provincia de Jiangxi");
        conjunto1.add("Provincia de Guangdong");
        conjunto1.add("Provincia de Fujian");

        // Creado del segundo conjunto
        Set<String> conjunto2 = new HashSet<>();
        conjunto2.add("Harbin");
        conjunto2.add("Hangzhou");
        conjunto2.add("Nanchang");
        conjunto2.add("Guangzhou");
        conjunto2.add("Fuzhou");

        // Creado de mapa y almacenamiento de datos
        Map<String, String> mapa = new HashMap<>();
        Iterator<String> iterador1 = conjunto1.iterator();
        Iterator<String> iterador2 = conjunto2.iterator();

        while (iterador1.hasNext() && iterador2.hasNext()) {
            String clave = iterador1.next();
            String valor = iterador2.next();
            mapa.put(clave, valor);
        }

        // Obtencion de datos a trav�s de entrySet
        Set<Map.Entry<String, String>> entradas = mapa.entrySet();
        for (Map.Entry<String, String> entrada : entradas) {
            String clave = entrada.getKey();
            String valor = entrada.getValue();
            System.out.println(clave + " = " + valor);
        }

        // Obtencion de datos a trav�s de keySet
        Set<String> claves = mapa.keySet();
        for (String clave : claves) {
            String valor = mapa.get(clave);
            System.out.println(clave + " = " + valor);
        }
	}
}
