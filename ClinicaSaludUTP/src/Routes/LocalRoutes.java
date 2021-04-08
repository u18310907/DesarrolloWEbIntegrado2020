package Routes;

public class LocalRoutes {
	private String URL = "";
	private String USER = "";
	private String PASSWORD = "";
	private String CONTROLADOR = "";

	public LocalRoutes() {
		this.URL = "jdbc:mysql://localhost:3306/clinica";
		this.USER = "root";
		this.PASSWORD = "";
		this.CONTROLADOR = "com.mysql.jdbc.Driver";
	}
	
	public String getURL() {
		return URL;
	}

	public String getUSER() {
		return USER;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public String getCONTROLADOR() {
		return CONTROLADOR;
	}

}
