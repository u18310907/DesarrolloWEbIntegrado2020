package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Database.CategoriaFotoDao;
import Model.CategoriaFotoBean;

/**
 * Servlet implementation class ActualizarCategoriImg
 */
@WebServlet("/ActualizarCategoriImg")
@MultipartConfig
public class ActualizarCategoriImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualizarCategoriImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String fecha = dtf.format(now);
		String titulo = request.getParameter("Titulo");
		String descripcion = request.getParameter("descripcion");
		String urlFull = request.getParameter("urlFull");
		String urlThumb = request.getParameter("urlFull");
		String codigo = request.getParameter("codigo");
		String checked;
		if (request.getParameterMap().containsKey("checked")) {
			checked = request.getParameter("checked");
		} else {
			checked = "false";
		}
		if (checked.equalsIgnoreCase("true")) {
			UploadImagen upload = new UploadImagen();
			Part filePart = request.getPart("foto");
			urlFull = upload.uploadImagen(filePart, fecha, urlFull);
			urlThumb = urlFull;

			if (!urlFull.equalsIgnoreCase("")) {
				CategoriaFotoBean FC = new CategoriaFotoBean();
				FC.setCodigo(Integer.parseInt(codigo));
				FC.setTitulo(titulo);
				FC.setDescripcion(descripcion);
				FC.setFecha(fecha);
				FC.setUrlFull(urlFull);
				FC.setUrlThumb(urlThumb);
				try {
					CategoriaFotoDao CFD = new CategoriaFotoDao();
					CFD.actualizarWithImg(FC);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} else {
			CategoriaFotoBean FC = new CategoriaFotoBean();
			FC.setCodigo(Integer.parseInt(codigo));
			FC.setTitulo(titulo);
			FC.setDescripcion(descripcion);
			FC.setFecha(fecha);
			// FC.setUrlFull(urlFull);
			// FC.setUrlThumb(urlThumb);
			try {
				CategoriaFotoDao CFD = new CategoriaFotoDao();
				CFD.actualizar(FC);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
