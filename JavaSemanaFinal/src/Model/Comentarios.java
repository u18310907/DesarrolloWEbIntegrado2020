package Model;

public class Comentarios {

	private Integer codigo;
	private String titulo;
	private String comentario;
	private String usuario;
	private String imagenName;
	private String fecha;

	
	public Comentarios() {
		
	}
	
	public Comentarios(Integer codigo, String titulo, String comentario, String usuario, String imagenName,String fecha) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.comentario = comentario;
		this.usuario = usuario;
		this.imagenName=imagenName;
		this.fecha=fecha;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getImagenName() {
		return imagenName;
	}

	public void setImagenName(String imagenName) {
		this.imagenName = imagenName;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

	
}
