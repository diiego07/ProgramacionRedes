package PROGRAMA;
import DTO.StockDTO;
import DAO.StockDAO;
import java.util.LinkedList;
import conexiones.MotorDB;
import java.io.PrintStream;
import UTILES.*;

public class Acciones {
	ReaderClass rc = new ReaderClass();
	PrintStream ps = new PrintStream(System.out);
	
	public Acciones() {
		
	}
	
	public void nuevo() {
		ps.println("Ingrese el nombre del producto: ");
		String n = rc.Leer();
		ps.println("Ingrese la descripción del producto: ");
		String d = rc.Leer();
		ps.println("Ingrese el Precio de Compra del producto: ");
		float pc = Float.parseFloat(rc.Leer());
		ps.println("Ingrese el Precio de Venta del producto: ");
		float pv = Float.parseFloat(rc.Leer());
		ps.println("Ingrese la cantidad de productos en stock: ");
		int c = Integer.parseInt(rc.Leer());
		boolean disc = false;
		StockDTO sdt = new StockDTO(n, d, pc, pv, c, disc);
		StockDAO sd = new StockDAO();
		sd.add(sdt);
		ps.println("Producto agregado.");
	}
	
	public void editar() {
		StockDAO sd = new StockDAO();
		ps.println("Ingrese el ID del producto que desea editar: ");
		int idOg = Integer.parseInt(rc.Leer());
		StockDTO sdt = sd.get(idOg);
		ps.println("Edite el nombre del producto. Nombre anterior ("+ sdt.getNombre() +")");
		String nuevoN = rc.Leer();
		sdt.setNombre(nuevoN);
		ps.println("Edite la descripción del producto. Desc anterior ("+ sdt.getDescripcion() +")");
		String nuevoD = rc.Leer();
		sdt.setDescripcion(nuevoD);
		ps.println("Edite el precio de compra del producto. Precio anterior ("+ sdt.getPrecio_compra() +")");
		float npc = Float.parseFloat(rc.Leer());
		sdt.setPrecio_compra(npc);
		ps.println("Edite el precio de venta del producto. Precio anterior ("+ sdt.getPrecio_venta() +")");
		float npv = Float.parseFloat(rc.Leer());
		sdt.setPrecio_venta(npv);
		ps.println("Edite la cantidad del producto. Cantidad anterior ("+ sdt.getCant() +")");
		int nCant = Integer.parseInt(rc.Leer());
		sdt.setCant(nCant);
		sd.update(sdt);
		ps.println("Producto editado.");
	}
	
	public void discontinuarProd() {
		StockDAO sd = new StockDAO();
		ps.println("Ingrese el ID del producto que desea discontinuar: ");
		int idOg = Integer.parseInt(rc.Leer());
		StockDTO sdt = sd.get(idOg);
		sdt.setDiscontinuado(true);
		sd.discontinuar(sdt);
		ps.println("Producto discontinuado.");
	}
	
	public void select() {
		ps.println("A continuación, todos los productos: ");
		StockDAO sd = new StockDAO();
		LinkedList<StockDTO> aux = sd.getAll(MotorDB.MYSQL);
		for(StockDTO sdt : aux) {
			ps.println(sdt.toString());
		}
	}
}
