package Controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson;

import Database.loginDB;
import Model.Login;


/**
 * Servlet implementation class loginSV
 */
@WebServlet("/loginSV")
@MultipartConfig
public class loginSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		String correo = request.getParameter("correo");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		/*
		System.out.println(correo);
		System.out.println(usuario);
		System.out.println(password);
		*/
		
		Login lg=new Login();
		
		loginDB lgDB=new loginDB();
		
		//if(lgDB.validate(usuario, password)) {

			
			try {
				String json="";
				lg.setPassword(password);
				lg.setCorreo(correo);
				lg.setUsuario(usuario);
				json = lgDB.RegistrarUsuario(lg);
		
				response.getWriter().append("ok");
				/*
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(json);
				out.flush();
				*/
			} catch (SQLException e) {
				
				//System.out.println("error");
				//e.printStackTrace();
				response.getWriter().append("fail");
			}

		
		//}
		
	
		
		
		
		
	}

}
