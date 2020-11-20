package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Database.loginDB;
import Model.Login;

/**
 * Servlet implementation class loginCon
 */
@WebServlet("/loginCon")
@MultipartConfig
public class loginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCon() {
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
		HttpSession sesion = request.getSession();
		String username = request.getParameter("user");
		String password = request.getParameter("passwd");
/*
		Login lg = new Login();
		lg.setUsuario(username);
		lg.setPassword(password);
*/	
		loginDB lgDB=new loginDB();
		if(lgDB.validate(username, password)) {
			Login lg= lgDB.validarLogin(username, password);	
			sesion.setAttribute("coduser", String.valueOf(lg.getCodigo()));
			sesion.setAttribute("username", lg.getUsuario());
			sesion.setAttribute("usermail", lg.getCorreo());
			
			/*String message[] = new String[2];
			message[0] = "success";
			message[1] = ""*/

			String json = new Gson().toJson(lg);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(json);
			out.flush();
			//response.getWriter().append("1");
		}
		else {
			response.getWriter().append("0");
		}
	}

}
