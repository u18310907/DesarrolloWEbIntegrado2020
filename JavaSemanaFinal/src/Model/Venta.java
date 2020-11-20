package Model;

public class Venta {
private Integer codigo;
private Integer codjue;
private Integer codusu;
private String fecha;
private String titulo;
private String descripcion;
private Double precio;
private String imagenName;
private String estado;


public Venta() {}
public Venta(Integer codigo) {
	this.codigo = codigo;
}
public Venta(Integer codigo, Integer codjue, Integer codusu,Double precio, String fecha) {
	super();
	this.codigo = codigo;
	this.codjue = codjue;
	this.codusu = codusu;
	this.precio=precio;
	this.fecha = fecha;
}


public Venta(Integer codigo, Integer codjue, Integer codusu, String titulo, String descripcion,Double precio, String imagenName) {
	super();
	this.codigo = codigo;
	this.codjue = codjue;
	this.codusu = codusu;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.precio = precio;
	this.imagenName=imagenName;
}



public Integer getCodigo() {
	return codigo;
}
public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}
public Integer getCodjue() {
	return codjue;
}
public void setCodjue(Integer codjue) {
	this.codjue = codjue;
}
public Integer getCodusu() {
	return codusu;
}
public void setCodusu(Integer codusu) {
	this.codusu = codusu;
}

public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Double getPrecio() {
	return precio;
}
public void setPrecio(Double precio) {
	this.precio = precio;
}
public String getImagenName() {
	return imagenName;
}
public void setImagenName(String imagenName) {
	this.imagenName = imagenName;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}






}
