package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.google.gson.Gson;

import Model.CategoriaFotoBean;
import Model.FotoBean;
import Routes.LocalRoutes;

public class CategoriaFotoDao {
	public static String ConsultarLista() {
		Conexion con = new Conexion();
		Connection connection = con.conectar();
		String query = "SELECT * FROM `categoria_fotos";
		List<Map<String, Object>> listOfMaps = null;
		try {
			QueryRunner queryRunner = new QueryRunner();
			listOfMaps = queryRunner.query(connection, query, new MapListHandler());

		} catch (SQLException se) {
			throw new RuntimeException("No se puedo Ejecutar la Consulta.", se);
		} finally {
			DbUtils.closeQuietly(connection);
		}
		return new Gson().toJson(listOfMaps);
	}

	public String RutasListar() {
		
		List<String> listOfMaps =new ArrayList<String>();
		try {
		LocalRoutes lr = new LocalRoutes();
		listOfMaps.add(lr.getRutaImagenFull());
		listOfMaps.add(lr.getRutaImagenThumn());
		
		} catch (Exception e) {
		System.out.println(e);
		}

		return new Gson().toJson(listOfMaps);

	}
	
	public int regitrar(CategoriaFotoBean CFB) throws ClassNotFoundException {

			String INSERT_USERS_SQL = "INSERT INTO `categoria_fotos`(`Titulo`, `descripcion`, `fecha`, `urlFull`, `urlThumb`) VALUES (?,?,?,?,?)";
			int result = 0;
			Conexion con = new Conexion();
			Connection connection = con.conectar();
			try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				preparedStatement.setString(1, CFB.getTitulo());
				preparedStatement.setString(2, CFB.getDescripcion());
				preparedStatement.setString(3, CFB.getFecha());
				preparedStatement.setString(4, CFB.getUrlFull());
				preparedStatement.setString(5, CFB.getUrlThumb());
				System.out.println(preparedStatement);
				result = preparedStatement.executeUpdate();

			} catch (SQLException e) {
				printSQLException(e);

			}
			return result;
	
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
