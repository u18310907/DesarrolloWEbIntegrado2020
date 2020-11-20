package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Promocion;

public class promocionDB {
	private Connection conexion = null;
	private Statement stm = null;
	private ResultSet proResultSet;
	private Integer codigo;
	private Integer codjue;
	private String titulo;
	private String descripcion;
	private Double descuento;

	public ArrayList<Promocion> leerpromociones() {
		ArrayList<Promocion> promocion = new ArrayList<Promocion>();
		Promocion proHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			proResultSet = stm.executeQuery(
					"SELECT p.codigo,j.codigo as 'codjue',j.titulo,p.descripcion,p.descuento FROM promocion p inner JOIN juegos j on p.codjue=j.codigo  order BY  p.codigo DESC");
			if (!proResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = proResultSet.getInt("codigo");
					codjue = proResultSet.getInt("codjue");
					titulo = proResultSet.getString("titulo");
					descripcion = proResultSet.getString("descripcion");
					descuento = proResultSet.getDouble("descuento");
					proHallada = new Promocion(codigo, codjue, titulo,descripcion , descuento);
					promocion.add(proHallada);
				} while (proResultSet.next());
				conexion.close();
				return promocion;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}

}
