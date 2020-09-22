package Controler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import Model.LoginModel;
import ServerRuta.HomeRuta;

/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/RegistrarUsuario")
@MultipartConfig
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrarUsuario() {
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
		String respuesta;
		HomeRuta rt = new HomeRuta();
		// String codigo = request.getParameter("codigo");
		// String checked = request.getParameter("checked");
	//	String checked;
	//	if (request.getParameterMap().containsKey("checked")) {
	//		checked = request.getParameter("checked");
//		} else {
//			checked = "false";
//		}

		//HttpSession session = request.getSession();
		//String codigo = (String) session.getAttribute("codigo");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		if(password.equals(repassword)) {
	//	if (checked.equalsIgnoreCase("true")) {
			String uploads = rt.getImguser();
			File uploadDir = new File(uploads);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			File cargar = new File(uploads);
			Part filePart = request.getPart("foto"); // Retrieves <input type="file" name="file">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

			int size = fileName.length();
			String NewName = fileName.substring(0, size - 4);
			String extension = fileName.substring(size - 4, size);
			File file = new File(cargar + "/" + NewName + extension);
			try (InputStream fileContent = filePart.getInputStream()) {
				Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
				LoginModel updateuser = new LoginModel();
				updateuser.setNombre(nombre);
				updateuser.setApellido(apellido);
				updateuser.setEmail(email);
				updateuser.setUser(user);
				updateuser.setPassword(password);
				updateuser.setImg(fileName);
				respuesta = updateuser.RegistrarUsuario();
				//response.getWriter().append(respuesta);
				
				 String message[]= new String[2];
				 message[0]="success";
				 message[1]=rt.getRuta()+"Login.jsp";
				 String json = new Gson().toJson(message);	
				 PrintWriter out = response.getWriter();
				 response.setContentType("application/json");
				 response.setCharacterEncoding("UTF-8");
				 out.print(json);
				 out.flush();

			} catch (Exception e) {
				respuesta = "ERROR";
				response.getWriter().append(respuesta);
			}
		}
		else {			
			response.getWriter().append("PASSWORDERROR");
		}		
	}

}
