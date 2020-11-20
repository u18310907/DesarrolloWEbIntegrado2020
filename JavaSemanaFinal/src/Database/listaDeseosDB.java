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

import Model.ListDeseos;



public class listaDeseosDB {
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


	public String RegistrarLista(ListDeseos ld) throws SQLException {
		String data;
		try {
					
			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query = "INSERT INTO `listadeseos`(`codjue`, `codusu`, `estado`, `fecha`) VALUES (?,?,?,?)";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setInt(1,ld.getCodjue());
			stmt.setInt(2,ld.getCodusu());
			stmt.setInt(3,ld.getEstado());
			stmt.setString(4,ld.getFecha());
			stmt.executeUpdate();
			data = "success";
		
		} catch (Exception e) {
				//e.printStackTrace();
			data = "fail";
		}
		//conexion.close();
		return data;
	}
	
	
	public ArrayList<ListDeseos> leerListaDeseos(int codigoUser,String fechaEnviada) {
		System.out.println("Test "+codigoUser);
		ArrayList<ListDeseos> listadeseos = new ArrayList<ListDeseos>();
		ListDeseos lisDeHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			ldResultSet = stm.executeQuery("SELECT LD.codigo,LD.codjue,LD.codusu,J.titulo,J.descripcion,J.precio,J.ImagenName FROM listadeseos LD INNER JOIN juegos J ON J.codigo=LD.codjue INNER JOIN usuario U ON U.codigo=LD.codusu WHERE LD.fecha = '"+fechaEnviada+"' AND LD.codusu="+codigoUser+" AND LD.estado=0");
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
					lisDeHallada = new ListDeseos(codigo, codjue, codusu,titulo,descripcion , precio,imagenName);
					listadeseos.add(lisDeHallada);
				} while (ldResultSet.next());
				conexion.close();
				return listadeseos;
				
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public  String  ListDeseosById(String fechaEnviada,Integer codigoUser, Integer codjuego)  {
		ConexionDB conectaBD = new ConexionDB();
		conexion = conectaBD.conectar();
		String query;

		query = "SELECT LD.codigo,LD.codjue,LD.codusu,J.titulo,J.descripcion,J.precio,J.ImagenName FROM listadeseos LD INNER JOIN juegos J ON J.codigo=LD.codjue INNER JOIN usuario U ON U.codigo=LD.codusu WHERE LD.fecha = '"+fechaEnviada+"' AND LD.codusu="+codigoUser+" AND LD.estado=0 AND J.codigo="+codjuego+" ";
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
	

}
