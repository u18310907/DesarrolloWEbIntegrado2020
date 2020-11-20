package Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



import Database.loginDB;
import Model.Login;
@ManagedBean(name = "controllerManagedLogin")
@SessionScoped
public class controllerManagedLogin implements Serializable{
	private static final long serialVersionUID = 1094801825228386363L;
	private String codigo;
	private String usuario;
	private String password;
	private String correo;
	private loginDB logearse;
	private Login ld;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Login getvalidateUsernamePassword() {
		logearse=new loginDB();
		boolean valid = logearse.validate(usuario, password);
		if (valid) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			ld=logearse.validarLogin(usuario, password);
			session.setAttribute("codigo", ld.getCodigo());
	
			return ld;
		} else {
			return ld;
		}
	}

	//logout event, invalidate session
	public String logout() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		session.invalidate();
		return "";
	}
}

