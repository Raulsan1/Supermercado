package supermercadoDAO;

import java.sql.*;

public class Conectar {
	
	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String host = "localhost";
	final private String user = "root";
	final private String passwd = "Raul1234";
	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	private Object preparedStatement ;

	
	
	public Conectar () {
		try {
			
			// Cargamos el driver de MySQL.
			Class.forName(driver);
			
			//Configuramos la conexion con la BBDD
			connect = DriverManager.getConnection("jdbc:mysql://"+ host +"/Juego?"+ "user="+ user + "&password= "+ passwd);
			
			//El Statement permite realizar consutlas SQL a la base de datos.
			statement = connect.createStatement();
			
		} catch (Exception e) {
			System.out.println("Error al crear la conexion: "+e.getLocalizedMessage());
		}
	}
	
	public void cerrarConexion (Connection connect) {
	
		try {
			if (connect != null) {
				connect.close();
			}
			
		} catch (Exception e) {
			
		}
	}
	
	public void realizarEjemplo() throws Exception{
		Conectar dao = new Conectar();
		
		try {
			
			//Almacenamos el set de resultados de la consulta a la BBDD.
			resultSet = dao.getStatement().executeQuery("select * from equipos");
			
			//Repetimos para cada set de datos contenido en resultset
			while(resultSet.next()) {
				
				for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++) {
					System.out.print(resultSet.getString(i)+" | ");
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			System.out.println("Error al realizar la consulta: "+e.getLocalizedMessage());
		} finally {
			try {
				dao.cerrarConexion(dao.getConnect());
			} catch (Exception e) {
				System.out.println("Error al cerrar las conexiones: "+ e.getLocalizedMessage());
			}
		}
	}
	
	public Object getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(Object preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public String getDriver() {
		return driver;
	}

	public String getHost() {
		return host;
	}

	public String getUser() {
		return user;
	}

	public String getPasswd() {
		return passwd;
	}
}
