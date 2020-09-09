package Controlador;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
@MultipartConfig
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String Login="View/Index.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//String acceso="";
		//String action=request.getParameter("accion");
		//if(action.equalsIgnoreCase("listar")) {
		//String	acceso=Login;
	
		//String username =request.getParameter("username");
		//String password =request.getParameter("password");
		//request.setAttribute("username", request.getParameter("username"));
	
			//	}
		//RequestDispatcher vista = request.getRequestDispatcher(acceso);
		//vista.forward(request, response);
	//	response.getWriter().append("LLego la data").append(username);
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		//request.setAttribute("username", request.getParameter("username"));
		System.out.println(username);
		System.out.println(password);
			//	}
		//RequestDispatcher vista = request.getRequestDispatcher(acceso);
		//vista.forward(request, response);
		response.getWriter().append("LLego la data").append(password);
		
		
	}

}
