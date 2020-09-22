package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.google.gson.Gson;

import ServerRuta.HomeRuta;

public class Conexion {  
	 HomeRuta obj=new HomeRuta();
	 Connection conexion = null;
	 
	 public Connection conectar() {  
	        try {
	            Class.forName(obj.getCONTROLADOR());
	            conexion = DriverManager.getConnection(obj.getURL(), obj.getUSER(), obj.getPASSWORD());
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
	 
	 
		public static String resultSetToJson(Connection connection, String query) {
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
		
	
		public static String RutaresultSetToJson(Connection connection, String query,String imgurl) {
	        List<Map<String, Object>> listOfMaps = null;
	        try {
	            QueryRunner queryRunner = new QueryRunner();
	            listOfMaps = queryRunner.query(connection, query, new MapListHandler());
	            
	            Map<String, Object> map = new HashMap<String, Object>();
	            map.put("imgurl", imgurl);
	            listOfMaps.add(map);
	            //listOfMaps.add(50, imgurl);
	        } catch (SQLException se) {
	            throw new RuntimeException("No se puedo Ejecutar la Consulta.", se);
	        } finally {
	            DbUtils.closeQuietly(connection);
	        }
	        return new Gson().toJson(listOfMaps);
	    }
		
		
		
		//json.put("Addresses", addresses);
		
		
}
