package DAO;
import java.util.LinkedList;
import DTO.*;
import conexiones.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockDAO implements GeneralDAO<StockDTO> {
	ConnectionFactory con_fact = ConnectionFactory.getInstance();
	final Logger logg = Logger.getLogger(StockDAO.class.getName());

	public int add(StockDTO stock) {
		PreparedStatement pre_sta = null;
		Connection con = null;
		
		try {
			con = con_fact.getConnection(MotorDB.MYSQL);
			
			String sql = "INSERT INTO stock(nombre, descripcion, precio_compra, precio_venta, cant, discontinuado) VALUES (?, ?, ?, ?, ?, ?)";
			pre_sta = con.prepareStatement(sql);
			
			pre_sta.setString(1, stock.getNombre());
			pre_sta.setString(2, stock.getDescripcion());
			pre_sta.setFloat(3, stock.getPrecio_compra());
			pre_sta.setFloat(4, stock.getPrecio_venta());
			pre_sta.setInt(5, stock.getCant());
			pre_sta.setBoolean(6, stock.isDiscontinuado());
			
			return pre_sta.executeUpdate();
		}catch (SQLException ex) {
			logg.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(stock.getNombre())).concat(" - TABLA: STOCK"), ex);
		} finally {
			try {
				pre_sta.close();
				con.close();
			} catch (SQLException ex) {
				logg.log(Level.SEVERE, null, ex);
			}
		}
		
		return 0;
	}

	public int add(LinkedList<StockDTO> lista, MotorDB tipo) {
		PreparedStatement pre_sta = null;
		Connection con = null;
		
		try {
			con = con_fact.getConnection(tipo);
			
			for(StockDTO stock : lista) {
				String sql = "INSERT INTO stock(nombre, descripcion, precio_compra, precio_venta, cant, discontinuado) VALUES (?, ?, ?, ?, ?, ?)";
				pre_sta = con.prepareStatement(sql);
				pre_sta.setString(1, stock.getNombre());
				pre_sta.setString(2, stock.getDescripcion());
				pre_sta.setFloat(3, stock.getPrecio_compra());
				pre_sta.setFloat(4, stock.getPrecio_venta());
				pre_sta.setInt(5, stock.getCant());
				pre_sta.setBoolean(6, stock.isDiscontinuado());
			}
			
			return pre_sta.executeUpdate();
		}catch (SQLException ex) {
			logg.log(Level.SEVERE, null, ex);
		} finally {
			try {
				pre_sta.close();
				con.close();
			} catch (SQLException ex) {
				logg.log(Level.SEVERE, null, ex);
			}
		}
		
		return 0;
	}
	
	public int add(LinkedList<StockDTO> lista) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrar(StockDTO aBorrar) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrar(LinkedList<StockDTO> aBorrar) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int borrarTodo(MotorDB tipo) {
		PreparedStatement pre_sta = null;
		Connection con = null;

		try {
			String sql = "DELETE FROM stock";

			con = con_fact.getConnection(tipo);
			pre_sta = con.prepareStatement(sql);

			return pre_sta.executeUpdate();
		} catch (SQLException ex) {
			logg.log(Level.SEVERE, null, ex);
		} finally {
			try {
				pre_sta.close();
				con.close();
			} catch (SQLException ex) {
				logg.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}

	public int update(StockDTO registro) {
		PreparedStatement pre_sta = null;
		Connection con = null;

		try {
			String consulta = "UPDATE stock SET nombre=? , descripcion=? , precio_compra=?, precio_venta=?, cant=? WHERE id=?";

			con = con_fact.getConnection(MotorDB.MYSQL);
			pre_sta = con.prepareStatement(consulta);

			pre_sta.setString(1, registro.getNombre());
			pre_sta.setString(2, registro.getDescripcion());
			pre_sta.setFloat(3, registro.getPrecio_compra());
			pre_sta.setFloat(4, registro.getPrecio_venta());
			pre_sta.setInt(5, registro.getCant());
			pre_sta.setInt(6, registro.getId());

			return pre_sta.executeUpdate();
		} catch (SQLException ex) {
			logg.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(registro.getId())).concat(" - TABLA: STOCK"), ex);
		} finally {
			try {
				pre_sta.close();
				con.close();
			} catch (SQLException ex) {
				logg.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}
	
	public int discontinuar(StockDTO registro) {
		PreparedStatement pre_sta = null;
		Connection con = null;

		try {
			String consulta = "UPDATE stock SET discontinuado=? WHERE id=?";

			con = con_fact.getConnection(MotorDB.MYSQL);
			pre_sta = con.prepareStatement(consulta);

			pre_sta.setBoolean(1, registro.isDiscontinuado());
			pre_sta.setInt(2, registro.getId());

			return pre_sta.executeUpdate();
		} catch (SQLException ex) {
			logg.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(registro.getId())).concat(" - TABLA: STOCK"), ex);
		} finally {
			try {
				pre_sta.close();
				con.close();
			} catch (SQLException ex) {
				logg.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}

	public int update(LinkedList<StockDTO> registro) {
		// TODO Auto-generated method stub
		return 0;
	}

	public LinkedList<StockDTO> getAll(MotorDB motomoto) {
		Connection con = null;
		PreparedStatement pre_sta = null;
		ResultSet res_set = null;

		LinkedList<StockDTO> aux = new LinkedList<StockDTO>();

		String sql = "SELECT * FROM stock";

		try {
			con = con_fact.getConnection(motomoto);
			pre_sta = con.prepareStatement(sql);

			res_set = pre_sta.executeQuery();

			while (res_set.next()) {
				aux.add(new StockDTO(res_set.getInt("id"), res_set.getString("nombre"), res_set.getString("descripcion"), res_set.getFloat("precio_compra"),
						res_set.getFloat("precio_venta"), res_set.getInt("cant"), res_set.getBoolean("discontinuado"))); 
			}
		} catch (SQLException e) {
			logg.log(Level.SEVERE, null, e);
		} finally {
			cerrar_Conexiones(res_set, pre_sta, con);
		}

		return aux;
	}
	
	public StockDTO get(int id) {
		Connection con = null;
		PreparedStatement pre_sta = null;
		ResultSet res_set = null;

		String sql = "SELECT * FROM empleado WHERE id=?";

		try {
			con = con_fact.getConnection(MotorDB.MYSQL);
			pre_sta = con.prepareStatement(sql);

			pre_sta.setInt(1, id);

			res_set = pre_sta.executeQuery();

			while (res_set.next()) {
				return (StockDTO) DTOFactory.getInstance().getDTO(Tabla.STOCK, res_set);
			}
		} catch (SQLException e) {
			logg.log(Level.SEVERE, null, e);
		} finally {
			cerrar_Conexiones(res_set, pre_sta, con);
		}
		
		return null;
	}
	
	public LinkedList<StockDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void cerrar_Conexiones(ResultSet res_set, PreparedStatement pre_sta, Connection con) {
		try {
			if (res_set != null)
				res_set.close();
			if (pre_sta != null)
				pre_sta.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			logg.log(Level.SEVERE, null, e);
		}
	}
}
