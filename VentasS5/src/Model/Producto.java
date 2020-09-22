package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.Conexion;

public class Producto {
	private String codigo;
	private String nombre;
	private String descripcion;
	private int categoria;
	private String proveedor;
	private String unidad;
	private double precio;
	private String observaciones;
	private String img;

	public Producto() {
		this.codigo = "";
		this.nombre = "";
		this.descripcion = "";
		this.categoria = 0;
		this.proveedor = "";
		this.unidad = "";
		this.precio = 0;
		this.observaciones = "";
		this.img = "";
	}

	public Producto(String codigo, String nombre, String descripcion, String proveedor, String unidad, String precio,
			String observaciones) {
		// this.codigo = codigo;
		// this.nombre = nombre;
		// this.descripcion = descripcion;
		// this.proveedor = proveedor;
		// this.unidad = unidad;
		// this.precio = precio;
		// this.observaciones = observaciones;
	}

	public Producto(String codigo, String nombre, String descripcion, String proveedor, String unidad, String precio,
			String observaciones, String categoria, String img) {
		// this.codigo = codigo;
		// this.nombre = nombre;
		// this.descripcion = descripcion;
//		this.proveedor = proveedor;
		// this.unidad = unidad;
		// this.precio = precio;
		// this.observaciones = observaciones;
//		this.categoria = categoria;
		// this.img = img;
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String ListaProductos(String categoria) {
		String query;
		if (categoria.equalsIgnoreCase("null")) {
			query = "SELECT p.codigo,p.nombre,p.descripcion,p.proveedor,p.unidad,p.precio,p.observaciones,p.img,c.nombre AS categoria FROM productos p INNER JOIN categoria c on c.codigo=p.categoria";
		} else {
			query = "SELECT p.codigo,p.nombre,p.descripcion,p.proveedor,p.unidad,p.precio,p.observaciones,p.img,c.nombre AS categoria FROM productos p INNER JOIN categoria c on c.codigo=p.categoria WHERE c.nombre='" + categoria + "'";

		}
				
		Conexion cdx = new Conexion();
		Connection con;
		con = cdx.conectar();
		String json = cdx.resultSetToJson(con, query);
		return json;
		

	}

	public String AgregarProducto() throws SQLException {
		String data;
		try {
			//int dato = 0;
			Conexion cdx = new Conexion();
			Connection con = cdx.conectar();
			PreparedStatement ps;
			// Statement smt;
			//ResultSet rs;

			String query = "INSERT INTO `productos`(`nombre`, `descripcion`, `categoria`, `proveedor`, `unidad`, `precio`, `observaciones`, `img`) VALUES (?,?,?,?,?,?,?,?)";
			// String query="SELECT COUNT(*) AS CANTIDAD FROM usuarios WHERE user=? AND
			// password=?";
			PreparedStatement stmt = con.prepareStatement(query);
			// stmt.setString(1,this.codigo);
			stmt.setString(1, this.nombre);
			stmt.setString(2, this.descripcion);
			stmt.setInt(3, this.categoria);
			stmt.setString(4, this.proveedor);
			stmt.setString(5, this.unidad);
			stmt.setDouble(6, this.precio);
			stmt.setString(7, this.observaciones);
			stmt.setString(8, this.img);
			stmt.executeUpdate();
			data = "success";
		} catch (Exception e) {
				e.printStackTrace();
			data = "fail";
		}
		return data;

		// stmt = con.createStatement();
		// rs = stmt.executeQuery("SELECT COUNT(*) AS CANTIDAD FROM usuarios WHERE
		// user='COMPANY' AND password='ABC123'");
		// while(rs.next()){
		// dato=rs.getInt("CANTIDAD");
		// }
		// return dato;

	}

}
