package Model;

public class Juegos {

	private Integer codigo;
	private String titulo;
	private String descripcion;
	private Integer categoria_id;
	private String nombre;

	private String observacion;
	private String imagenName;
	private Double precio;
	
	
	public Juegos(){}

	
	public Juegos(Integer codigo, String titulo, String descripcion, String nombre, String observacion,
			String imagenName) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.observacion = observacion;
		this.imagenName = imagenName;
	}
	
	public Juegos(Integer codigo, String titulo, String descripcion, String nombre, String observacion,
			String imagenName, double precio) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.observacion = observacion;
		this.imagenName = imagenName;
		this.precio=precio;
	}
	


	public Juegos(Integer codigo, String titulo, String descripcion,
			String imagenName,Double precio) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagenName = imagenName;
		this.precio=precio;
	}
	
	public Juegos(Integer codigo, String titulo, String descripcion,
			String imagenName) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagenName = imagenName;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}




	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getImagenName() {
		return imagenName;
	}


	public void setImagenName(String imagenName) {
		this.imagenName = imagenName;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
