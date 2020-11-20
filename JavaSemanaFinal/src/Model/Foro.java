package Model;

public class Foro {

	private String Cantidad;
	private Integer codigo;
	private Integer coduser;
	private Integer codjuego;
	private String comentario;
	private String fecha;
	
	public Foro(){
		
		
	}

	public Foro(String cantidad) {
		super();
		Cantidad = cantidad;
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCoduser() {
		return coduser;
	}

	public void setCoduser(Integer coduser) {
		this.coduser = coduser;
	}

	public Integer getCodjuego() {
		return codjuego;
	}

	public void setCodjuego(Integer codjuego) {
		this.codjuego = codjuego;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	

	
	
}
