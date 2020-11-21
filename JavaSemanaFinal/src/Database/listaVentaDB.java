package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.google.gson.Gson;

import Model.Foro;
import Model.Venta;



public class listaVentaDB {
	private Connection conexion = null;
	private Statement stm = null;
	private ResultSet ldResultSet;
	private Integer codigo;
	private Integer codjue;
	private Integer codusu;
	private Integer estado;
	private String fecha;
	private String titulo;
	private String descripcion;
	private Double precio;
	private String imagenName;


	public String RegistrarVenta(Venta vent) throws SQLException {
		String data;
		Integer numero=0;
		String resultado="";
		try {
			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query = "INSERT INTO `venta`(`codjue`, `codusu`, `precio`, `fecha`,estado) VALUES (?,?,?,?,?)";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);			
			stmt.setInt(1,vent.getCodjue());
			stmt.setInt(2,vent.getCodusu());
			stmt.setDouble(3,vent.getPrecio());
			stmt.setString(4,vent.getFecha());
			stmt.setString(5,vent.getEstado());
			numero=stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				resultado=rs.getString(1);
			}
			
			//data = "success";
			System.out.println(resultado);
		} catch (Exception e) {
				//e.printStackTrace();
			//data = "fail";
			
		}
		//conexion.close();
		return resultado;
	}
	
	public ArrayList<Venta> leerListaVentaAprobarByID() {
		ArrayList<Venta> listaVenta = new ArrayList<Venta>();
		Venta lisDeHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			ldResultSet = stm.executeQuery("SELECT V.codigo,V.codjue,V.codusu,J.titulo,J.descripcion,J.precio,J.ImagenName FROM venta V INNER JOIN juegos J ON J.codigo=V.codjue INNER JOIN usuario U ON U.codigo=V.codusu WHERE estado=0");
			if (!ldResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = ldResultSet.getInt("codigo");
					codjue = ldResultSet.getInt("codjue");
					codusu = ldResultSet.getInt("codusu");
					titulo = ldResultSet.getString("titulo");
					descripcion = ldResultSet.getString("descripcion");
					precio = ldResultSet.getDouble("precio");
					imagenName = ldResultSet.getString("ImagenName");
					lisDeHallada = new Venta(codigo, codjue, codusu,titulo,descripcion , precio,imagenName);
					listaVenta.add(lisDeHallada);
				} while (ldResultSet.next());
				conexion.close();
				return listaVenta;
				
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<Venta> leerListaVentaAprobar() {
		ArrayList<Venta> listaVenta = new ArrayList<Venta>();
		Venta lisDeHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			ldResultSet = stm.executeQuery("SELECT codigo FROM venta WHERE estado=0");
			if (!ldResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = ldResultSet.getInt("codigo");
					lisDeHallada = new Venta(codigo);
					listaVenta.add(lisDeHallada);
				} while (ldResultSet.next());
				conexion.close();
				return listaVenta;
				
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public  String  VentasInputsServ(Integer codigo)  {
		ConexionDB conectaBD = new ConexionDB();
		conexion = conectaBD.conectar();
		String query;
		query = "SELECT V.codigo,V.codjue,j.titulo,v.codusu,U.usuario,j.precio,U.correo FROM venta V inner join usuario U ON v.codusu=U.codigo INNER JOIN juegos j ON j.codigo=v.codjue WHERE V.codigo="+codigo+"";
		System.out.println(query);
		List<Map<String, Object>> listOfMaps = null;
		try {
			QueryRunner queryRunner = new QueryRunner();
			listOfMaps = queryRunner.query(conexion, query, new MapListHandler());

		} catch (SQLException se) {
			throw new RuntimeException("No se puedo Ejecutar la Consulta.", se);
		} finally {
			DbUtils.closeQuietly(conexion);
		}
		return new Gson().toJson(listOfMaps);
	}
	
	
	public String ActualizarVenta(String codigo,String estado) throws SQLException {
		String data;
		try {
					
			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query = "UPDATE venta SET estado=? WHERE codigo=? ";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setInt(1,Integer.parseInt(estado));
			stmt.setInt(2,Integer.parseInt(codigo));
			stmt.executeUpdate();
			data = "success";
		
		} catch (Exception e) {
				//e.printStackTrace();
			data = "fail";
		}
		//conexion.close();
		return data;
	}
	
	
	

}
