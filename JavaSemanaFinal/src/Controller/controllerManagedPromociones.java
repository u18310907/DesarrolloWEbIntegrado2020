package Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import Database.juegosDB;
import Database.promocionDB;
import Model.Juegos;
import Model.Promocion;
import Routes.LocalRoutes;

@ManagedBean(name = "controllerManagedPromociones")
@RequestScoped
@SessionScoped
public class controllerManagedPromociones {
	private Integer codigo;
	private Integer codjue;
	private String titulo;
	private String descripcion;
	private Double descuento;
	private promocionDB promoDB;
	private juegosDB juegoDB;

	// Select
	private String txtcodigo;
	private String selectJuego;
	private String txtpromocion;
	private String txtmonto;
	private String txtestado;
	private String txtidoperacion;

	// InsertUpdteJuegos
	private String txtJtitulo;
	private String txtJdescripcion;
	private String txtJcategoria;
	private String txtJcomentario;
	private String txtJprecio;
	private Part txtJImangen;
	private String txtJCheck;
	private String sltJuegoBox;
	private String txtJidjuego;

	public controllerManagedPromociones() {
	}

	public void insertar() {
		promoDB = new promocionDB();
		Promocion pr = new Promocion();
		pr.setCodjue(Integer.parseInt(selectJuego));
		pr.setDescripcion(txtpromocion);
		pr.setDescuento(Double.parseDouble(txtmonto));
		pr.setEstado(txtestado);

		try {
			String resultado = promoDB.RegistrarPromocion(pr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void actualizar() {
		// System.out.println("codgio "+txtidoperacion);
		// System.out.println("juego "+selectJuego);
		// System.out.println("promocion "+txtpromocion);
		// System.out.println("monto "+txtmonto);
		// System.out.println("estado "+txtestado);
		promoDB = new promocionDB();
		Promocion pr = new Promocion();
		pr.setCodjue(Integer.parseInt(selectJuego));
		pr.setDescripcion(txtpromocion);
		pr.setDescuento(Double.parseDouble(txtmonto));
		pr.setEstado(txtestado);
		pr.setCodigo(Integer.parseInt(txtidoperacion));
		

		try {
			String resultado = promoDB.ActualizarPromocion(pr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		
		
		*/
	}

	public void insertarJuego() {
		LocalRoutes ruta=new LocalRoutes();
		String imagen = "";
		String resultado;
		juegoDB = new juegosDB();
		Juegos J = new Juegos();

		J.setTitulo(txtJtitulo);
		J.setDescripcion(txtJdescripcion);
		J.setCategoria_id(Integer.parseInt(txtJcategoria));
		J.setObservacion(txtJcomentario);
		J.setPrecio(Double.parseDouble(txtJprecio));
		if (txtJCheck.equalsIgnoreCase("false")) {
			imagen = "default.jpg";
			J.setImagenName(imagen);
			try {
				resultado = juegoDB.RegistrarJuego(J);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			try (InputStream input = txtJImangen.getInputStream()) {

				String fileName = txtJImangen.getSubmittedFileName();
				Files.copy(input, new File(ruta.getLocalRouteJSF(), fileName).toPath());
				J.setImagenName(fileName);
				resultado = juegoDB.RegistrarJuego(J);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void actualizarJuego() {
		LocalRoutes ruta=new LocalRoutes();
		String imagen = "";
		String resultado;
		juegoDB = new juegosDB();
		Juegos J = new Juegos();

		J.setTitulo(txtJtitulo);
		J.setDescripcion(txtJdescripcion);
		J.setCategoria_id(Integer.parseInt(txtJcategoria));
		J.setObservacion(txtJcomentario);
		J.setPrecio(Double.parseDouble(txtJprecio));
		J.setCodigo(Integer.parseInt(txtJidjuego));
		System.out.println("codigo"+txtJidjuego);
		
		if (txtJCheck.equalsIgnoreCase("false")) {
			imagen = "";
			J.setImagenName(imagen);
			try {
				resultado = juegoDB.ActualizarJuego(J);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			try (InputStream input = txtJImangen.getInputStream()) {

				String fileName = txtJImangen.getSubmittedFileName();
				Files.copy(input, new File(ruta.getLocalRouteJSF(), fileName).toPath());
				J.setImagenName(fileName);
				resultado = juegoDB.ActualizarJuego(J);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Promocion> getpromoList() {
		ArrayList<Promocion> promoList = new ArrayList<Promocion>();
		promoDB = new promocionDB();
		promoList = promoDB.leerpromociones();
		return promoList;
	}

	public ArrayList<Promocion> getselectpromoList() {
		ArrayList<Promocion> selectpromoList = new ArrayList<Promocion>();
		promoDB = new promocionDB();
		selectpromoList = promoDB.leerPublicados();
		return selectpromoList;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Integer getCodjue() {
		return codjue;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Double getDescuento() {
		return descuento;
	}

	public promocionDB getPromoDB() {
		return promoDB;
	}

	public String getSelectJuego() {
		return selectJuego;
	}

	public void setSelectJuego(String selectJuego) {
		this.selectJuego = selectJuego;
	}

	public String getTxtpromocion() {
		return txtpromocion;
	}

	public void setTxtpromocion(String txtpromocion) {
		this.txtpromocion = txtpromocion;
	}

	public String getTxtcodigo() {
		return txtcodigo;
	}

	public void setTxtcodigo(String txtcodigo) {
		this.txtcodigo = txtcodigo;
	}

	public String getTxtmonto() {
		return txtmonto;
	}

	public void setTxtmonto(String txtmonto) {
		this.txtmonto = txtmonto;
	}

	public String getTxtestado() {
		return txtestado;
	}

	public void setTxtestado(String txtestado) {
		this.txtestado = txtestado;
	}

	public String getTxtidoperacion() {
		return txtidoperacion;
	}

	public void setTxtidoperacion(String txtidoperacion) {
		this.txtidoperacion = txtidoperacion;
	}

	public String getTxtJtitulo() {
		return txtJtitulo;
	}

	public void setTxtJtitulo(String txtJtitulo) {
		this.txtJtitulo = txtJtitulo;
	}

	public String getTxtJdescripcion() {
		return txtJdescripcion;
	}

	public void setTxtJdescripcion(String txtJdescripcion) {
		this.txtJdescripcion = txtJdescripcion;
	}

	public String getTxtJcategoria() {
		return txtJcategoria;
	}

	public void setTxtJcategoria(String txtJcategoria) {
		this.txtJcategoria = txtJcategoria;
	}

	public String getTxtJcomentario() {
		return txtJcomentario;
	}

	public void setTxtJcomentario(String txtJcomentario) {
		this.txtJcomentario = txtJcomentario;
	}

	public String getTxtJprecio() {
		return txtJprecio;
	}

	public void setTxtJprecio(String txtJprecio) {
		this.txtJprecio = txtJprecio;
	}

	public Part getTxtJImangen() {
		return txtJImangen;
	}
	public void setTxtJImangen(Part txtJImangen) {
		this.txtJImangen = txtJImangen;
	}
	public String getTxtJCheck() {
		return txtJCheck;
	}

	public void setTxtJCheck(String txtJCheck) {
		this.txtJCheck = txtJCheck;
	}

	public String getSltJuegoBox() {
		return sltJuegoBox;
	}

	public void setSltJuegoBox(String sltJuegoBox) {
		this.sltJuegoBox = sltJuegoBox;
	}

	public String getTxtJidjuego() {
		return txtJidjuego;
	}

	public void setTxtJidjuego(String txtJidjuego) {
		this.txtJidjuego = txtJidjuego;
	}
	
	
	
	

}
