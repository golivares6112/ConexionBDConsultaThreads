package cl.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface InterfMetodosConexion {
	public void iniciarConexion() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ResultSet consultaBaseDatos(String consulta) throws SQLException;
	public ResultSet consultaBaseDatosThreeParam(String consulta) throws SQLException;
	public void cerrarConexiones() throws SQLException;
}
