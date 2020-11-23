package Routes;

public class LocalRoutes{
	private String URL="";
	private String USER="";
	private String PASSWORD="";
    private String CONTROLADOR="";
    private String rutaImagenFull;
    private String rutaImagenThumn;
    private String localRoute;
    private String localRouteJSF;
    
    public LocalRoutes(){
		this.URL="jdbc:mysql://localhost:3306/gamesbd";
		this.USER="root";
		this.PASSWORD="";
		this.CONTROLADOR="com.mysql.jdbc.Driver";
		this.rutaImagenFull="../resources/img/";
		this.rutaImagenThumn="../resources/img/";
		this.localRoute="D:/DesarrolloWEbIntegrado2020/TrabajoFinalWeb/WebContent/resources/pdf/";
		this.localRouteJSF="D://DesarrolloWEbIntegrado2020/JavaSemanaFinal/WebContent/resources/img/dynamic/";
    }

	public String getRutaImagenFull() {
		return rutaImagenFull;
	}

	public void setRutaImagenFull(String rutaImagenFull) {
		this.rutaImagenFull = rutaImagenFull;
	}

	public String getRutaImagenThumn() {
		return rutaImagenThumn;
	}

	public void setRutaImagenThumn(String rutaImagenThumn) {
		this.rutaImagenThumn = rutaImagenThumn;
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

	public String getLocalRoute() {
		return localRoute;
	}

	public void setLocalRoute(String localRoute) {
		this.localRoute = localRoute;
	}

	public String getLocalRouteJSF() {
		return localRouteJSF;
	}

	public void setLocalRouteJSF(String localRouteJSF) {
		this.localRouteJSF = localRouteJSF;
	}
	
	
	
	
    
}
