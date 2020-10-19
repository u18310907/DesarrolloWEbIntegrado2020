package Routes;



public class LocalRoutes{
	private String URL="";
	private String USER="";
	private String PASSWORD="";
    private String CONTROLADOR="";
    private String rutaImagenFull;
    private String rutaImagenThumn;
    private String localRoute;
    
    public LocalRoutes(){
		this.URL="jdbc:mysql://localhost:3306/gal_sem10";
		this.USER="root";
		this.PASSWORD="";
		this.CONTROLADOR="com.mysql.jdbc.Driver";
		this.rutaImagenFull="../Resources/images/";
		this.rutaImagenThumn="../Resources/images/";
		this.localRoute="D:/DesarrolloWEbIntegrado2020/VentasGaleriaV2/WebContent/Resources/images/";
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
	
    
}
