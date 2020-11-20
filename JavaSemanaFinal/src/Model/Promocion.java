package Model;

public class Promocion {

	private Integer codigo;
	private Integer codjue;
	private String titulo;
	private String descripcion;
	private Double descuento;
	public Promocion(Integer codigo, Integer codjue, String titulo, String descripcion, Double descuento) {
		this.codigo = codigo;
		this.codjue = codjue;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.descuento = descuento;
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
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
	
	
}
