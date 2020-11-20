package Model;

public class Login {

	private String codigo;
	private String usuario;
	private String password;
	private String correo;
	
	public Login() {
		this.codigo = "";
		this.usuario = "";
		this.password = "";
		this.correo = "";
		
	}
	public Login(String codigo, String usuario, String password, String correo) {

		this.codigo = codigo;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
	}
	
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
	
	
	
}
