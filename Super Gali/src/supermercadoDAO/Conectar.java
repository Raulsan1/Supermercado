package supermercadoDAO;

import java.sql.*;

/**
* Clase que representa la conexion con la base de datos
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class Conectar {
	
	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String host = "localhost";
	final private String user = "root";
	final private String passwd = "Raul1234";
	private Connection connect;
	private Statement statement;
	private Object preparedStatement ;

	/**
	 * Constructor de la clase Conectar
	 */
	public Conectar () {
		try {
			
			Class.forName(driver);
			
			connect = DriverManager.getConnection("jdbc:mysql://"+ host +"/Supermercado?"+ "user="+ user + "&password="+ passwd);
			
			statement = connect.createStatement();
			
		} catch (Exception e) {
			System.out.println("Error al crear la conexion: "+e.getLocalizedMessage());
		}
	}
	
	/**
	 * Metodo para cerrar la conexion con la base de datos
	 * @param connect conexion con la base de datos
	 */
	
	public void cerrarConexion (Connection connect) {
	
		try {
			if (connect != null) {
				connect.close();
			}
			
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * @return de preparedStatement
	 */
	public Object getPreparedStatement() {
		return preparedStatement;
	}
	
	/**
	 * @param preparedStatement prepared statement que se asigna
	 */
	public void setPreparedStatement(Object preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
	
	/**
	 * @return de la conexion
	 */
	public Connection getConnect() {
		return connect;
	}
	
	/**
	 * @param connect asignacion de la conexion
	 */
	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	
	/**
	 * @return de statement
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * @return de preparedStatement
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * @return del driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @return del host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return del usuario
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return de la contraseña
	 */
	public String getPasswd() {
		return passwd;
	}
}
