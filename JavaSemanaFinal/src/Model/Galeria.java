package Model;

public class Galeria {

	private Integer codigo;
	private Integer codjue;
	private String titulo;
	private String descripcion;
	private String imagenName;
	private Integer estado;
	
	
	public Galeria() {
		
		
	}
	public Galeria(Integer codigo, Integer codjue, String titulo, String descripcion, String imagenName,
			Integer estado) {
		this.codigo = codigo;
		this.codjue = codjue;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagenName = imagenName;
		this.estado = estado;
	}
	
	public Galeria(Integer codigo, Integer codjue, String titulo, String descripcion, String imagenName
			) {
		this.codigo = codigo;
		this.codjue = codjue;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagenName = imagenName;

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
	public String getImagenName() {
		return imagenName;
	}
	public void setImagenName(String imagenName) {
		this.imagenName = imagenName;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
