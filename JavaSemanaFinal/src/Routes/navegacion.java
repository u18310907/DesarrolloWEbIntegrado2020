package Routes;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="paginaRender")
@RequestScoped
public class navegacion implements Serializable{

	private static final long serialVersionUID = 1L;

	public String metodo1() 
	{
		return "Home";
	}
	
	public String metodo2() {
		return "contacto";
	}
}