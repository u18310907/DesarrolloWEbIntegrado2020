package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ServerRuta.HomeRuta;

/**
 * Servlet implementation class Categoria
 */
@WebServlet("/Categoria")
@MultipartConfig
public class Categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categoria() {
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
		
		HomeRuta ruta=new HomeRuta();
		String codigo=request.getParameter("codigo");
		String nombre=request.getParameter("nombre");
		Model.Categoria cat=new Model.Categoria();
		String resultado;
		try {
			cat.setNombre(nombre);
			 resultado=cat.AgregarCateogria();
		} catch (SQLException e) {
			e.printStackTrace();
			resultado="fail";
		}
		//response.getWriter().append("Result ").append(resultado);
		
		 String message[]= new String[2];
		 message[0]="success";
		 message[1]=ruta.getRuta()+"ListarProducto.jsp";
		 String json = new Gson().toJson(message);	
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 out.print(json);
		 out.flush();
		
		
	}

}
