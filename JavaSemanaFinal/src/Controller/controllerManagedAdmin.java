package Controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Database.listaVentaDB;
import Model.ListDeseos;
import Model.Venta;
import Routes.Mailer;
import Routes.GenerarPdf;


@ManagedBean(name = "controllerManagedAdmin")
@RequestScoped
public class controllerManagedAdmin implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Integer codjue;
	private Integer codusu;
	private Integer estado;
	private String fecha;
	private String titulo;
	private String descripcion;
	private Double precio;
	private listaVentaDB listaDesDB;
	private String imagenName;
	private String usuario;
	private String juego;
	private String vprecio;
	private String ventselect;
	private String codigoOpera;
	private String correo;
	


	private static ArrayList<ListDeseos> listDeseo;

	public controllerManagedAdmin() {
	/*	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String fecha = dtf.format(now);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String coduser = (String)  facesContext.getExternalContext().getSessionMap().get("coduser");
		listaDesDB=new listaDeseosDB();
			if(coduser!=null) {
			listDeseo = listaDesDB.leerListaDeseos(Integer.parseInt(coduser),fecha);
			}
			else {
			listDeseo = listaDesDB.leerListaDeseos(1,fecha);				
			}
			*/
	}
	
	
	public void resultado() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String fecha = dtf.format(now);
		
		
		//System.out.println("juego "+juego);
		//System.out.println("usuario "+usuario);
		//System.out.println("precio "+vprecio);
		//System.out.println("Selected "+ventselect);
		//System.out.println("CodigoOperacion "+codigoOpera);
		//System.out.println("CodigoOperacion "+correo);
		 listaDesDB= new listaVentaDB();
		 try {
			 
			GenerarPdf.GeneratePDF(usuario,fecha,juego,vprecio,codigoOpera);
			 
			String exito=listaDesDB.ActualizarVenta(codigoOpera, ventselect);
			if(exito.equals("success")) {
				String to=correo;
				String subject="Compra de Video Juego";
				String msg="Su compra se realizo exitosamente :  "
							+"\n\n\n\n\n\n\n"
							+"Atentamente Game Warrior ";				
				Mailer.sendArchive(to, subject, msg,codigoOpera);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	
		
	}
	
	public ArrayList<Venta> getlistAprobar(){
		 ArrayList<Venta> listAprobar = new ArrayList<Venta>();
		 listaDesDB= new listaVentaDB();
		 listAprobar= listaDesDB.leerListaVentaAprobar();
		 return listAprobar;
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

	public listaVentaDB getlistaDesDB() {
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

	public String getVprecio() {
		return vprecio;
	}

	public void setVprecio(String vprecio) {
		this.vprecio = vprecio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}

	public String getVentselect() {
		return ventselect;
	}

	public void setVentselect(String ventselect) {
		this.ventselect = ventselect;
	}

	public String getCodigoOpera() {
		return codigoOpera;
	}

	public void setCodigoOpera(String codigoOpera) {
		this.codigoOpera = codigoOpera;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}



	

	
}
