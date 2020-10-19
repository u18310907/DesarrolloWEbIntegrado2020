package Model;

import java.io.Serializable;

public class CategoriaFotoBean implements Serializable{
	private int codigo;
	private String Titulo;
	private String descripcion;
	private String fecha;
	private String urlFull;
	
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	private String urlThumb;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getUrlFull() {
		return urlFull;
	}
	public void setUrlFull(String urlFull) {
		this.urlFull = urlFull;
	}
	public String getUrlThumb() {
		return urlThumb;
	}
	public void setUrlThumb(String urlThumb) {
		this.urlThumb = urlThumb;
	}

}
