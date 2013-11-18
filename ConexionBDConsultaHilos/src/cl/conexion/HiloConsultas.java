package cl.conexion;

import java.sql.SQLException;

public class HiloConsultas extends Thread{
	
	private ImplementacionConsultas consultasPreparadas;
	private String consulta;
	
	public HiloConsultas(String c, ImplementacionConsultas consultasP)
	{
		this.consultasPreparadas = consultasP;
		this.consulta = c;
	}
	public void run()
	{
		System.out.println("___________________________________________________________");
		try {
			this.consultasPreparadas.consultaBaseDatos(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("___________________________________________________________");
	}
	
	public void run(String consulta)
	{
		this.consulta = consulta;
		System.out.println("___________________________________________________________");
		try {
			this.consultasPreparadas.consultaBaseDatosThreeParam(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("___________________________________________________________");
	}
}
