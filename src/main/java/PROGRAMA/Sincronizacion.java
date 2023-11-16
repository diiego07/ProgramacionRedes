package PROGRAMA;
import DAO.*;
import DTO.StockDTO;

import java.util.LinkedList;

import conexiones.MotorDB;

public class Sincronizacion {
	private StockDAO sd = new StockDAO();
	
	public Sincronizacion() {
		
	}
	
	public void Synergia(Boolean entrada) {
		LinkedList<StockDTO> stockNube = this.sd.getAll(MotorDB.H2);
		LinkedList<StockDTO> stockLocal = this.sd.getAll(MotorDB.MYSQL);
		if(entrada == true) {
			for(StockDTO sdt : stockNube) {
				if(!stockLocal.contains(sdt) || stockLocal.isEmpty()) {
					stockLocal.add(sdt);
				}
			}
			this.sd.borrarTodo(MotorDB.MYSQL);
			this.sd.add(stockLocal, MotorDB.MYSQL);
		}else {
			for(StockDTO sdt : stockLocal) {
				if(!stockNube.contains(sdt)) {
					stockNube.add(sdt);
				}
			}
			this.sd.borrarTodo(MotorDB.H2);
			this.sd.add(stockNube, MotorDB.H2);
		}
	}
}
