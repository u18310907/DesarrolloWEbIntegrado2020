import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controllerManagedBean")
@SessionScoped
public class controllerManagedBean {
	private Integer clave;
	private String nombre;
	private Integer trimestre;
	private String requisito;
	private String telefono;
	private String direccion;
	private String observacion;
	private GestorDB gestorBD;

	private static ArrayList<uea> ueasList;

	public controllerManagedBean() {
		gestorBD = new GestorDB();
		ueasList = gestorBD.leerUeas();
	}

	public Integer getClave() {
		return clave;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getTrimestre() {
		return trimestre;
	}

	public String getRequisito() {
		return requisito;
	}
	

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getObservacion() {
		return observacion;
	}

	public GestorDB getGestorBD() {
		return gestorBD;
	}

	public ArrayList<uea> getueasList() {
		return ueasList;
	}

}
