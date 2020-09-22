package Controler;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import Database.Conexion;
import Model.LoginModel;

import ServerRuta.HomeRuta;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
@MultipartConfig
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		HttpSession sesion = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HomeRuta ruta = new HomeRuta();
		LoginModel user = new LoginModel(username, password);
		Conexion cdx = new Conexion();
		Connection con;
		con = cdx.conectar();
		String dato = "0";
		int respuesta = 0;
		try {
			respuesta = user.ValidarUsuario(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (respuesta > 0 && sesion.getAttribute("usuario") == null) {
			int codigo = 0;
			try {
				codigo = user.ValidarSession(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sesion.setAttribute("codigo", String.valueOf(codigo));
			String message[] = new String[2];
			message[0] = "success";
			message[1] = ruta.getRuta() + "ListarProducto.jsp";

			String json = new Gson().toJson(message);

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(json);
			out.flush();
		} else {
			response.getWriter().append("0");
		}

	}

}
