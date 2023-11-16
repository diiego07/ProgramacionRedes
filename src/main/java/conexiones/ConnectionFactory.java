package conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintStream;

public class ConnectionFactory {
	private static ConnectionFactory fabrica = null;
	
	private ConnectionFactory() {
		
	}
	
	public static ConnectionFactory getInstance() {
		if(fabrica == null) {
			fabrica = new ConnectionFactory();
		}
		return fabrica;
	}
	
	public Connection getConnection(MotorDB db) {
		Connection con;
		switch(db) {
			case MYSQL:
				MySQL sql = new MySQL();
				con = sql.getConnection();
				break;
			case H2:
				H2 h = new H2();
				con = h.getConnection();
				break;
			default:
				con = null;
				break;
		}
		
		return con;
	}
}


class MySQL{
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private String db = "/tiendatrabajo";
	private String port = "3306";
	private String EngineDB = "mysql";
	private String ip = "://localhost:";
	
	private String url = "jdbc:".concat(EngineDB).concat(ip).concat(port).concat(db);
	PrintStream ps = new PrintStream(System.out);
	
	private String user = "root";
	private String pass = "";
	
	Connection conn  = null;
	
	public MySQL() {
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			Logger logg = Logger.getLogger(ConnectionFactory.class.getName());
			logg.log(Level.SEVERE, e.getMessage(), e);
		}
		
		return conn;
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			Logger logg = Logger.getLogger(ConnectionFactory.class.getName());
			logg.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}

class H2{
	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:~/tmp/h2db/ProgramacionSobreRedes";
	private String user = "sa";
	private String pass = "root";
	
	Connection con  = null;
	
	public H2() {
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
		}catch (SQLException e) {
			Logger logg = Logger.getLogger(ConnectionFactory.class.getName());
			logg.log(Level.SEVERE, e.getMessage(), e);
		}
		
		return con;
	}
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			Logger logg = Logger.getLogger(ConnectionFactory.class.getName());
			logg.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
