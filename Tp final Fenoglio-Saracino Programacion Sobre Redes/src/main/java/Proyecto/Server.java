package Proyecto;

import java.util.Random;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import Utiles.MensajeYfacha;

public class Server{
	private ArrayList<Conexion> Conexiones;
	private ServerSocket Servidor;
	private PrintStream PrintS;
	private MensajeYfacha MYF;
	private boolean ServerApagado;
	protected int port = 5050;

	public Server() {
		Conexiones = new ArrayList<Conexion>();
		ServerApagado = false;
		PrintS = new PrintStream(System.out);
		MYF = new MensajeYfacha();
	}

	public void ServerOn() {
		hiloServidor.start();
		PrintS.println(MYF.ANSI_RED+"ESPERANDO A EL / LOS CLIENTES: ");
	}
	
	Thread hiloServidor = new Thread(
				new Runnable() {
					public void run() {
						try {
				            Servidor = new ServerSocket(port);
				            while(!ServerApagado){
				            	Socket Cliente = Servidor.accept();
				            	Conexion conex = new Conexion(Cliente);
				            	Conexiones.add(conex);
				            	for(Conexion c : Conexiones) {
				                	c.run();
				                }
				            }
						} catch (Exception ex) {
				        	DesconectarServer();
				        }
					}
				}, "InicioDelServer"
			);	
	
	class Conexion extends Thread{
		private Socket Cliente;
		private BufferedReader Lector;
		private PrintStream ps;
		private String Nickname;
		private MensajeYfacha EYC;
		private Random Random;
		private String ColorUsuario;
		
		public Conexion(Socket Cli) {
			this.Cliente = Cli;
			Random = new Random();
			int numero = Random.nextInt(4);
			switch(numero) {
				case 0:
					ColorUsuario = EYC.ANSI_BLUE;
					break;
				case 1:
					ColorUsuario = EYC.ANSI_RED;
					break;
				case 2:
					ColorUsuario = EYC.ANSI_WHITE;
					break;
				case 3:
					ColorUsuario = EYC.ANSI_PURPLE;
					break;
			}
			
			try {
				ps = new PrintStream(Cliente.getOutputStream(), true);
				
				Lector = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		public void run() {
			Thread Servicio = new Thread(new Runnable() {
						public void run(){
							try {
								EYC = new MensajeYfacha();
								ps.println(MensajeYfacha.ANSI_PURPLE + "Ingresa un nickname: " + MensajeYfacha.ANSI_RESET);
								Nickname = Lector.readLine();
								EYC.mensaje(EYC.ANSI_BLUE + Nickname + EYC.ANSI_GREEN + "Se conecto al servidor" + EYC.ANSI_RESET);
								Broadcast(EYC.ANSI_GREEN + Nickname + " se unió al chat" + "\n" + EYC.ANSI_RESET);
								String msg;
								while ((msg = Lector.readLine()) != null) {
				                    if (msg.startsWith("/nick ")) {
				                        String[] partir = msg.split(" ", 2);
				                        if (partir.length == 2) {
				                        	Broadcast(EYC.ANSI_GREEN + Nickname + " cambió su nick a "+ partir[1] + EYC.ANSI_RESET);
				                            EYC.mensaje(EYC.ANSI_PURPLE + Nickname + EYC.ANSI_GREEN +" cambió su nombre a " + EYC.ANSI_YELLOW + partir[1] + EYC.ANSI_RESET);
				                            Nickname = partir[1];
				                            ps.println(EYC.ANSI_YELLOW + "Ahora te llamás "+Nickname+ EYC.ANSI_RESET);
				                        }else{
				                        	ps.println(EYC.ANSI_RED+ "No se cambió tu nombre de usuario. "+ EYC.ANSI_RESET);
				                        }
				                    }else if(msg.startsWith("/quit")){
				                    	Broadcast(EYC.ANSI_YELLOW + Nickname + "se ha desconectado" + EYC.ANSI_RESET);
				                    	CerrarConexion();
				                    }else{
				                    	Broadcast(ColorUsuario + Nickname + ": "+ "\n" + "> " +msg+ EYC.ANSI_RESET);
				                    }
				                }
							}catch(IOException e) {
								CerrarConexion();
							}
							
						}
					}, "ServicioConexion"
				);
			Servicio.start();
		}
		
		public void MandarPaquete(String packeteDeTexto) {
			ps.println(packeteDeTexto);
		}
		
		public void Broadcast(String mensaje) {
			for(Conexion conex : Conexiones) {
				if(conex != null) {
					conex.MandarPaquete(mensaje);
				}
			}
		}
		public void CerrarConexion(){
			try{
				Lector.close();
            	ps.close();
                if (!Cliente.isClosed()) {
                    Cliente.close();
                }
            }catch(IOException e){
            	e.printStackTrace();
            }
		} 
	}
	
	public void DesconectarServer() {
		try {
			ServerApagado = true;
            if (!Servidor.isClosed()) {
                Servidor.close();
            }
            for (Conexion conex : Conexiones) {
            	conex.CerrarConexion();
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}	
}
