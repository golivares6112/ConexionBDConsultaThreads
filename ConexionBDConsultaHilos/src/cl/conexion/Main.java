package cl.conexion;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args)
	{
		
		ImplementacionConsultas implCons = new ImplementacionConsultas();
		HiloConsultas consulta1 = new HiloConsultas("select * from usuarios;", implCons);
		HiloConsultas consulta2 = new HiloConsultas("select * from usuarios where username = 'laurence796015';", implCons);
		HiloConsultas consulta3 = new HiloConsultas("select * from usuarios where username LIKE 'd%';", implCons);
		HiloConsultas consulta4 = new HiloConsultas("select idusuarios, username, password from usuarios where username LIKE 'e%';", implCons);
		
		try {
			
			implCons.iniciarConexion();
			consulta1.run();
			consulta2.run();
			consulta3.run();
			consulta4.run("select idusuarios, username, password from usuarios where username LIKE 'e%';");
			implCons.cerrarConexiones();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
