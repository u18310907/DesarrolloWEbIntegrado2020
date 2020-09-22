package ServerRuta;

public class HomeRuta {

	
	//Database Conexiones
	private String URL="jdbc:mysql://localhost:3306/ventasweb";
	private String USER="root";
	private String PASSWORD="";
    private String CONTROLADOR="com.mysql.jdbc.Driver";
    
    

    
	//Variables para Guardar archivos
	private String ruta;
	private String imgproductos;
	private String imguser;
	private String getrutaimgpro;
	private String getrutaimguser;
    
	
	public HomeRuta() {
		this.ruta="http://localhost:8080/VentasS5/View/";
		this.imgproductos="D:/DesarrolloWEbIntegrado2020/VentasS5/WebContent/Imagenes/Productos/";
		this.imguser="D:/DesarrolloWEbIntegrado2020/VentasS5/WebContent/Imagenes/User/";
		this.getrutaimguser="../Imagenes/User/";
		this.getrutaimgpro="../Imagenes/Productos/";
		
		
		this.URL="jdbc:mysql://localhost:3306/ventasweb";
		this.USER="root";
		this.PASSWORD="";
		this.CONTROLADOR="com.mysql.jdbc.Driver";
	}
	public String getGetrutaimgpro() {
		return getrutaimgpro;
	}
	public void setGetrutaimgpro(String getrutaimgpro) {
		this.getrutaimgpro = getrutaimgpro;
	}
	public String getGetrutaimguser() {
		return getrutaimguser;
	}
	public void setGetrutaimguser(String getrutaimguser) {
		this.getrutaimguser = getrutaimguser;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getImgproductos() {
		return imgproductos;
	}
	public void setImgproductos(String imgproductos) {
		this.imgproductos = imgproductos;
	}
	public String getImguser() {
		return imguser;
	}
	public void setImguser(String imguser) {
		this.imguser = imguser;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getUSER() {
		return USER;
	}
	public void setUSER(String uSER) {
		USER = uSER;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getCONTROLADOR() {
		return CONTROLADOR;
	}
	public void setCONTROLADOR(String cONTROLADOR) {
		CONTROLADOR = cONTROLADOR;
	}


	
	
	
	
}
