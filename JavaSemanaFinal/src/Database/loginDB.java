package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Login;



public class loginDB {

	private Connection conexion = null;
	private ResultSet proResultSet;
	private PreparedStatement ps;
	private String codigo;
	private String usuario;
	private String password;
	private String correo;
	

	public boolean validate(String usuario, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			ConexionDB conectaBD = new ConexionDB();
			con = conectaBD.conectar();
			ps = con.prepareStatement("SELECT * FROM `usuario` WHERE `usuario`=? and password=?");
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			con.close();
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());			
			return false;
		} 
		return false;
	}
	
	
	public Login validarLogin(String usuarios,String passwords) {
		Login proHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			ps = conexion.prepareStatement("SELECT `codigo`, `usuario`, `password`, `correo` FROM `usuario` WHERE `usuario`=? and password=?");
			ps.setString(1, usuarios);
			ps.setString(2, passwords);
			proResultSet = ps.executeQuery();
			if (!proResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					this.codigo = proResultSet.getString("codigo");
					this.usuario = proResultSet.getString("usuario");
					this.password = proResultSet.getString("password");
					this.correo = proResultSet.getString("correo");
	
					proHallada = new Login(codigo, usuario, password,correo);
				
				} while (proResultSet.next());
				conexion.close();
				return proHallada;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	public String RegistrarUsuario(Login lg) throws SQLException {
		String data;
		try {
			String imagen="8.jpg";
			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query = "INSERT INTO usuario(usuario, password, correo,ImagenName) VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setString(1,lg.getUsuario());
			stmt.setString(2,lg.getPassword());
			stmt.setString(3,lg.getCorreo());
			stmt.setString(4,imagen);
			stmt.executeUpdate();
			System.out.println(query);
			data = "success";
		
		} catch (Exception e) {
				//e.printStackTrace();
			data = "fail";
		}
		//conexion.close();
		return data;
	}
	
	
	
}
