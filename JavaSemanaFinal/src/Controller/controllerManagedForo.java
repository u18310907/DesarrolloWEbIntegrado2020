package Controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Database.ForoDB;
import Database.comentariosDB;
import Database.listaDeseosDB;
import Model.Comentarios;
import Model.Foro;

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

}
