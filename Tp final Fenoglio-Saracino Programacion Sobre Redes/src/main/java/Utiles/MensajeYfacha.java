package Utiles;

import java.io.PrintStream;

public class MensajeYfacha {
	PrintStream PrintS = new PrintStream(System.out);
	public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\033[0;37m"; 
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public void mensaje(String mensajes) {
    	PrintS.println(mensajes);
    }
    public void mensaje_amrillo(String mensajes) {
    	PrintS.println(ANSI_YELLOW  + mensajes);
    }
    public void mensaje_rojo(String mensajes) {
    	PrintS.println(ANSI_RED + mensajes);
    }
    public void mensaje_azul(String mensajes) {
    	PrintS.println(ANSI_BLUE + mensajes);
    }
    public void mensaje_violeta(String mensajes) {
    	PrintS.println(ANSI_PURPLE + mensajes);
    }
    public void mensaje_blanco(String mensajes) {
    	PrintS.println(ANSI_WHITE+ mensajes);
    }
    public void mensaje_cyan(String mensajes) {
    	PrintS.println(ANSI_CYAN + mensajes);
    }
    public void mensaje_restart(String mensajes) {
    	PrintS.println(ANSI_RESET + mensajes);
    }
    public void mensaje_verde(String mensajes) {
    	PrintS.println(ANSI_GREEN + mensajes);
    }
    public void mensaje_negro(String mensajes) {
    	PrintS.println(ANSI_BLACK + mensajes);
    }
}
