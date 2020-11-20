package Controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Database.listaDeseosDB;
import Model.ListDeseos;

@ManagedBean(name = "controllerManagedListaDeseo")
@ViewScoped
public class controllerManagedListaDeseo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Integer codjue;
	private Integer codusu;
	private Integer estado;
	private String fecha;
	private String titulo;
	private String descripcion;
	private Double precio;
	private listaDeseosDB listaDesDB;
	private String imagenName;

	private static ArrayList<ListDeseos> listDeseo;

	public controllerManagedListaDeseo() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String fecha = dtf.format(now);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		//HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		//if(session)
		//String coduser= (String) session.getAttribute("coduser");
		//System.out.println(session);
		
		//FacesContext facesContext = FacesContext.getCurrentInstance();
		/*
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);		
		String coduser = (String) session.getAttribute("coduser");
		*/
		String coduser = (String)  facesContext.getExternalContext().getSessionMap().get("coduser");
		//FacesContext.getExternalContext.getSessionMap().get("coduser");
		//String coduser;
		listaDesDB=new listaDeseosDB();
		
		//if(coduser!=null) {
			//String coduser= (String) session.getAttribute("coduser");
			if(coduser!=null) {
		//	listDeseo = listaDesDB.leerListaDeseos(Integer.parseInt(coduser), fecha);
		//	session.setAttribute("coduser", "0");
			//coduser=(String) session.getAttribute("coduser");
			//System.out.println("Code"+"1");
			listDeseo = listaDesDB.leerListaDeseos(Integer.parseInt(coduser),fecha);
			}
			else {
			listDeseo = listaDesDB.leerListaDeseos(1,fecha);				
			}
	//	}
		//else {
		//	System.out.println("Code"+"0");
			//coduser="1";
		//	listDeseo = listaDesDB.leerListaDeseos(2,fecha);
		//}
		

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodusu() {
		return codusu;
	}

	public void setCodusu(Integer codusu) {
		this.codusu = codusu;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
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

	public listaDeseosDB getlistaDesDB() {
		return listaDesDB;
	}

	public Integer getCodjue() {
		return codjue;
	}

	public void setCodjue(Integer codjue) {
		this.codjue = codjue;
	}

	public ArrayList<ListDeseos> getlistDeseo() {
		return listDeseo;
	}

	public String getImagenName() {
		return imagenName;
	}

	public void setImagenName(String imagenName) {
		this.imagenName = imagenName;
	}

	
	
}
