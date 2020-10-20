package Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import Database.FotoDao;
import Model.FotoBean;
import Routes.LocalRoutes;

/**
 * Servlet implementation class RegistrarFoto
 */
@WebServlet("/RegistrarFoto")
@MultipartConfig
public class RegistrarFoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrarFoto() {
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
		boolean responseauto=false;
		try {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			String fecha = dtf.format(now);
			String titulo = request.getParameter("titulo");
			String descripcion = request.getParameter("descripcion");
			int cat_codigo = Integer.parseInt(request.getParameter("catid"));
			String urlFull = request.getParameter("urlFull");
			String urlThumb = request.getParameter("urlFull");
			if(cat_codigo!=0) {
			UploadImagen upload = new UploadImagen();
			Part filePart = request.getPart("foto");
			urlFull = upload.uploadImagen(filePart, fecha, urlFull);
			urlThumb = urlFull;

			if (!urlFull.equalsIgnoreCase("")) {
				FotoBean FB = new FotoBean();
				FB.setTitulo(titulo);
				FB.setDescripcion(descripcion);
				FB.setCat_codigo(cat_codigo);
				FB.setFecha(fecha);
				FB.setUrlFull(urlFull);
				FB.setUrlThumb(urlThumb);
				FotoDao FD = new FotoDao();
				FD.regitrar(FB);
				responseauto=true;
			}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String rpt=""+responseauto;
		response.getWriter().append(rpt);

	}

}
