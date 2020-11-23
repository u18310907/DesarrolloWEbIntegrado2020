package Controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import Database.ForoDB;
import Model.Foro;
import Routes.Mailer;

@ManagedBean(name = "controllerManagedForo")

@RequestScoped
public class controllerManagedForo {
	private Integer codigo;
	private String titulo;
	private String comentario;
	private String usuario;
	private String imagenName;
	private String fecha;
	private ForoDB foroDB;
	private String cantidad;
	// private static ArrayList<Comentarios> comList;
	
	
	//Send mensaje
	private String msjnombre;
	private String msjasunto;
	private String msjcomentario;
	private String msjemail;

	public controllerManagedForo() {
		// comDB = new comentariosDB();
		// comList = comDB.leercom();
	}

	public void resultado() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String fecha = dtf.format(now);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String coduser = (String) facesContext.getExternalContext().getSessionMap().get("coduser");
		String codjue = "1";
		if (coduser != null) {
			Foro fr = new Foro();
			fr.setCoduser(Integer.parseInt(coduser));
			fr.setCodjuego(Integer.parseInt(codjue));
			fr.setFecha(fecha);
			fr.setComentario(comentario);

			ForoDB frdb = new ForoDB();
			try {
				frdb.RegistrarComentarios(fr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void sendmensaje() {
		String to=msjemail;
		String subject=msjasunto;
		String msg="Buenos Dias señor : "+msjnombre+"\n\\n"+ msjcomentario;
		Mailer.send(to, subject, msg);
		
	}

	public String getCantidad() {
		foroDB = new ForoDB();
		cantidad = foroDB.userCantidad();
		return cantidad;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getImagenName() {
		return imagenName;
	}

	public String getFecha() {
		return fecha;
	}

	public ForoDB getforoDB() {
		return foroDB;
	}

	public String getMsjnombre() {
		return msjnombre;
	}

	public void setMsjnombre(String msjnombre) {
		this.msjnombre = msjnombre;
	}

	public String getMsjasunto() {
		return msjasunto;
	}

	public void setMsjasunto(String msjasunto) {
		this.msjasunto = msjasunto;
	}

	public String getMsjcomentario() {
		return msjcomentario;
	}

	public void setMsjcomentario(String msjcomentario) {
		this.msjcomentario = msjcomentario;
	}

	public String getMsjemail() {
		return msjemail;
	}

	public void setMsjemail(String msjemail) {
		this.msjemail = msjemail;
	}
	
	
	
	
	

}
