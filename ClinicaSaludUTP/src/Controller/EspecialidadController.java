package Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.google.gson.Gson;
import Database.EspecialidadDB;
import Model.EspecialidadBean;
import Routes.LocalRoutes;

/**
 * Servlet implementation class RegistrarFoto
 */
@WebServlet("/EspecialidadController")
@MultipartConfig
public class EspecialidadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EspecialidadController() {
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
		
		String action = request.getParameter("action");
		switch (action) {
		case "Registrar":
			Registrar(request, response);break;
		case "Listar":
			Listar(request, response);break;
		case "Actualizar":
			Actualizar(request, response);break;
		case "BuscarId":
			BuscarId(request, response);break;
			
			
			
			
			// default:
			// RequestDispatcher dispatcher =
			// request.getRequestDispatcher("login/login.jsp");
			// dispatcher.forward(request, response);
			// break;
		}
	

	}

	private void Registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message="error";
		
		String nom_Rol = request.getParameter("nom_Rol");
		String descr_Rol = request.getParameter("descr_Rol");

		EspecialidadBean esp = new EspecialidadBean();
		esp.setNom_Rol(nom_Rol);
		esp.setDescr_Rol(descr_Rol);
		EspecialidadDB Execute = new EspecialidadDB();
		try {
			message=Execute.RegistrarEspecialidad(esp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 String json = new Gson().toJson(message);	
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 out.print(json);
		 out.flush();

	}
	
	
	private void Actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message="error";
		
		String codigo = request.getParameter("cod_Rol");
		String nom_Rol = request.getParameter("nom_Rol");
		String descr_Rol = request.getParameter("descr_Rol");

		EspecialidadBean esp = new EspecialidadBean();
		esp.setCodigo(Integer.parseInt(codigo));
		esp.setNom_Rol(nom_Rol);
		esp.setDescr_Rol(descr_Rol);
		EspecialidadDB Execute = new EspecialidadDB();
		try {
			message=Execute.ActualizarESpecialidad(esp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 String json = message;	
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 out.print(json);
		 out.flush();

	}
	
	private void Listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String message;
			EspecialidadDB Execute = new EspecialidadDB();
			message=Execute.ListarEspecialidad();
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(message);
			out.flush();		
		
	}
	
	private void BuscarId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String message;
			String codigo = request.getParameter("codigo");
			EspecialidadBean esp = new EspecialidadBean();
			esp.setCodigo(Integer.parseInt(codigo));
			EspecialidadDB Execute = new EspecialidadDB();
			message=Execute.ListarEspecialidadById(esp);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(message);
			out.flush();		
		
	}

	

}
