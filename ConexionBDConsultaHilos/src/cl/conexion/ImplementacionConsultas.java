package cl.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImplementacionConsultas implements InterfMetodosConexion {
	
	private String basedatos="test";
	private String url="jdbc:mysql://localhost/" + basedatos;
	private String user ="root";
	private String password="leviatan6112";
	private Connection conexion;
	private Statement instruccion;
	private ResultSet setRes;
	
	@Override
	public void iniciarConexion() throws 
		InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.conexion = DriverManager.getConnection(url, user, password);
	}

	@Override
	public ResultSet consultaBaseDatos(String consulta) throws SQLException 
	{
		if(this.conexion!=null)
		{
			this.instruccion = this.conexion.createStatement();
			this.setRes = this.instruccion.executeQuery(consulta);
			while(setRes.next())
			{
				String resulset = Integer.toString(setRes.getInt(1)) + " " 
						+ setRes.getString(2) + " " 
                        + setRes.getString(3) + " "
                        + setRes.getString(4) + " "
                        + setRes.getString(5) + " "
                        + setRes.getString(6) + " "
                        + setRes.getString(7);
				System.out.println(resulset);
			}
		}
		
		return this.setRes;
	}

	@Override
	public void cerrarConexiones() throws SQLException 
	{
		this.setRes.close();
		this.instruccion.close();
		conexion.close();
	}

	@Override
	public ResultSet consultaBaseDatosThreeParam(String consulta) throws SQLException
	{
		if(this.conexion!=null)
		{
			this.instruccion = this.conexion.createStatement();
			this.setRes = this.instruccion.executeQuery(consulta);
			while(setRes.next())
			{
				String resulset = Integer.toString(setRes.getInt(1)) + " " 
						+ setRes.getString(2) + " " 
	                    + setRes.getString(3);
				System.out.println(resulset);
			}
		}
		
		return this.setRes;
	}
	
	
}
