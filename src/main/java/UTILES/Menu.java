package UTILES;
import java.io.PrintStream;
import PROGRAMA.*;

public class Menu {
	Acciones acc = new Acciones();
	Sincronizacion si = new Sincronizacion();
	ReaderClass rc = new ReaderClass();
	static PrintStream ps = new PrintStream(System.out);
	
	public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";    
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";    
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_MAGENTA = "\u0033[35m";


	
	public Menu() {
		
	}
	
	public void iniciar() {
		si.Synergia(true);
		char op = getMenu();
		switch(op) {
			case '1':
				acc.nuevo();
				getMenu();
				break;
			case '2':
				acc.editar();
				getMenu();
				break;
			case '3':
				acc.discontinuarProd();
				getMenu();
				break;
			case '4':
				acc.select();
				getMenu();
				break;
			case '5':
				mostrarMensaje("¡Nos vemos!");
				si.Synergia(false);
				System.exit(0);
				break;
			default:
				mostrarMensaje("No ha seleccionado ninguna opción. Por favor, intente nuevamente.");
				getMenu();
		}
	}
	
	public char getMenu() {
        char op;
        do {
            mostrarMensaje(
            		ANSI_PURPLE + 
                    "<<< Menú principal >>>\n********************** \n"+
                    ANSI_GREEN
                    + ".1. Agregar un producto. \n" +
                    ANSI_YELLOW
                    + ".2. Editar un producto. \n"+
                    ANSI_RED
                    + ".3. Discontinuar un producto. \n"+
                    ANSI_CYAN
                    + ".4. Mostrar todos los productos. \n"+
                    ANSI_PURPLE
                    + ".5. Cerrar. \n" +
                    ANSI_RESET
            );
            op = obtener_Opcion();
        } while (op < '1' || op > '5');

        return op;
    }
	
	public char obtener_Opcion() {
		char op = rc.Leer().charAt(0);
    	return op;
    }
	
	public  void mostrarMensaje(String cosaAMostrar){
    	ps.println(cosaAMostrar);
    }

}
