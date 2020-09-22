package Model;

import Database.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginModel {
	private String user;
	private String password;
	private String nombre;
	private String apellidos;
	private String correo;
	private String img;
	private String imgurl;
	private String codigo;
	// Variables Vue
	private String email;
	private String apellido;
	private String repassword;

	// Variables Vue

	public int ValidarUsuario(String username, String password) throws SQLException {
		try {

			int dato = 0;
			Conexion cdx = new Conexion();
			Connection con = cdx.conectar();
			PreparedStatement ps;
			// Statement smt;
			ResultSet rs;
			String query = "SELECT COUNT(*) AS CANTIDAD FROM usuarios WHERE user=? AND password=? LIMIT 1";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			// stmt = con.createStatement();
			// rs = stmt.executeQuery("SELECT COUNT(*) AS CANTIDAD FROM usuarios WHERE
			// user='COMPANY' AND password='ABC123'");
			while (rs.next()) {
				dato = rs.getInt("CANTIDAD");
			}
			return dato;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}

	}
	
	
	public int ValidarSession(String username, String password) throws SQLException {
		try {

			int dato = 0;
			Conexion cdx = new Conexion();
			Connection con = cdx.conectar();
			PreparedStatement ps;
			// Statement smt;
			ResultSet rs;
			String query = "SELECT codigo FROM usuarios WHERE user=? AND password=? LIMIT 1";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			// stmt = con.createStatement();
			// rs = stmt.executeQuery("SELECT COUNT(*) AS CANTIDAD FROM usuarios WHERE
			// user='COMPANY' AND password='ABC123'");
			while (rs.next()) {
				dato = rs.getInt("codigo");
			}
			return dato;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}

	}

	// public String ValidarUsuario(String usuario,String password) {
	// Conexion conectar=new Conexion();
	// /return conectar.resultSetToJson(conectar.conectar(), "Select * fron
	// Usuarios");
//	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public LoginModel() {
		this.codigo = "";
		this.nombre = "";
		this.apellido = "";
		this.user = "";
		this.password = "";
		this.email = "";
		this.img = "";
	}

	public LoginModel(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public LoginModel(String user, String password, String nombre, String apellidos, String correo, String img) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.user = user;
		this.password = password;
		this.img = img;
	}

	public LoginModel(String user, String nombre, String apellidos, String correo, String img, String imgurl,
			String codigo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellidos;
		this.email = correo;
		this.user = user;
		this.password = "Palli";
		this.repassword = "Palli";
		this.img = imgurl + img;
		this.imgurl = imgurl;
	}

	public String ObtenerDatosUsuario() {
		int codigo=Integer.parseInt(this.codigo);
		String query = "SELECT * FROM `usuarios` WHERE `codigo`= "+codigo+"";
		Conexion cdx = new Conexion();
		Connection con;
		con = cdx.conectar();
		// String json = cdx.RutaresultSetToJson(con, query,this.imgurl);
		String json = cdx.RutaresultSetToJson(con, query, this.imgurl);
		// resultSetToJson
		return json;

	}
	
	public String VistaUsuario() {
		int codigo=Integer.parseInt(this.codigo);
		String query = "SELECT user,img FROM `usuarios` WHERE `codigo`= "+codigo+"";
		Conexion cdx = new Conexion();
		Connection con;
		con = cdx.conectar();
		// String json = cdx.RutaresultSetToJson(con, query,this.imgurl);
		String json = cdx.RutaresultSetToJson(con, query, this.imgurl);
		// resultSetToJson
		return json;

	}
	
	public String ActualziarUsuario() throws SQLException {
		String data;
		try {
			Conexion cdx = new Conexion();
			Connection con = cdx.conectar();
			PreparedStatement ps;
			String query = "UPDATE usuarios SET nombre=?, apellido=?, user=?, email=? WHERE codigo=?";
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setString(1, this.nombre);
			stmt.setString(2, this.apellido);
			stmt.setString(3, this.user);
			stmt.setString(4, this.email);		
			stmt.setInt(5,Integer.parseInt(this.codigo));
			stmt.executeUpdate();
			data = "success";
		} catch (Exception e) {
				e.printStackTrace();
			data = "fail";
		}
		return data;

	}
	
	
	public String ActualziarUsuarioIMG() throws SQLException {
		String data;
		try {
			Conexion cdx = new Conexion();
			Connection con = cdx.conectar();
			PreparedStatement ps;
			
			String query = "UPDATE usuarios SET nombre=?, apellido=?, user=?, email=?, img=? WHERE codigo=?";
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setString(1, this.nombre);
			stmt.setString(2, this.apellido);
			stmt.setString(3, this.user);
			stmt.setString(4, this.email);
			stmt.setString(5, this.img);
			stmt.setInt(6,Integer.parseInt(this.codigo));
			stmt.executeUpdate();
			data = "success";
		} catch (Exception e) {
				e.printStackTrace();
			data = "fail";
		}
		return data;

	}
	
	
	
	public String RegistrarUsuario() throws SQLException {
		String data;
		try {
			Conexion cdx = new Conexion();
			Connection con = cdx.conectar();
			PreparedStatement ps;
			
			String query = "INSERT INTO `usuarios`(`nombre`, `apellido`, `user`, `password`, `email`, `img`) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setString(1, this.nombre);
			stmt.setString(2, this.apellido);
			stmt.setString(3, this.user);
			stmt.setString(4, this.password);
			stmt.setString(5, this.email);
			stmt.setString(6, this.img);
			stmt.executeUpdate();
			data = "success";
		} catch (Exception e) {
				e.printStackTrace();
			data = "fail";
		}
		return data;
	}
	
	

}
