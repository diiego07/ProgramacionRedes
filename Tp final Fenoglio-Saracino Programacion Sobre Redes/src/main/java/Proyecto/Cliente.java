package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import Utiles.MensajeYfacha;



public class Cliente extends Thread{
	 private Socket Cliente;
	 private BufferedReader BReader;
	 private InputStreamReader InputSR;
	 private PrintStream PrintS;
	 private boolean Desconexion;
	 private String IP = "127.0.0.1";
	 private int Puerto = 5050;
	 private MensajeYfacha MYF;
	 
	 public Cliente() {
			
		}
	 public void ClienteOn() {
			run();
		}
	 public void run() {
		 try {
			Cliente = new Socket(IP, Puerto);
			InputSR = new InputStreamReader(Cliente.getInputStream());
			BReader = new BufferedReader(InputSR);
			PrintS = new PrintStream(Cliente.getOutputStream());
			MYF = new MensajeYfacha();
			
			Thread Listener = new Thread( new Runnable() {
				public void run() {
					while(!Desconexion)
					{
						try {
			                BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
			                while (!Desconexion) {                    
			                    String mensaje = Reader.readLine();
			                    if (mensaje.equals("/salir")) {
			                    	Reader.close();
			                    	CerrarConexion();
			                    }else{
			                    	PrintS.println(mensaje);
			                    }
			                }
			            } catch (IOException e) {
			            	CerrarConexion();
			            }
					}
				}
			});
			Listener.start();
			
			String mensaje;
			
			while((mensaje = BReader.readLine()) != null) {
				MYF.mensaje(mensaje);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	 }
	 public void CerrarConexion() {
			Desconexion = true;
	        try {
	        	BReader.close();
	        	PrintS.close();
	            if (!Cliente.isClosed()) {
	                Cliente.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
}

	
