package Model;

import java.io.Serializable;

public class VideoBean  implements Serializable{
private int codigo;
private String descripcion;
private String fecha;
private String url;
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
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getUrlThumb() {
	return urlThumb;
}
public void setUrlThumb(String urlThumb) {
	this.urlThumb = urlThumb;
}


}
