package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Routes.LocalRoutes;

public class Conexion {
	LocalRoutes route;
	Connection conexion = null;

	public Connection conectar() {
		route = new LocalRoutes();
		try {
			Class.forName(route.getCONTROLADOR());
			conexion = DriverManager.getConnection(route.getURL(), route.getUSER(), route.getPASSWORD());
			System.out.println("Conexión OK");

		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		return conexion;
	}
}
