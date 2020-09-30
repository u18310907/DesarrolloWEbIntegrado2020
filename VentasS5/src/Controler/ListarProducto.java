package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Database.Conexion;
import Model.Producto;

/**
 * Servlet implementation class ListarProducto
 */
@WebServlet("/ListarProducto")
@MultipartConfig
public class ListarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarProducto() {
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

		// response.sendRedirect(request.getContextPath() + "/View/ListarProducto.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Producto pro = new Producto();

		String c = request.getParameter("c");
		// Producto pro=new Producto("A001","LEHE", "TARRO 500MG", "GLORIA", "LTA",
		// "5.50", " UNIDADES");
	
		
	
		String json = pro.ListaProductos(c);
		// String json = new Gson().toJson(pro);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		out.flush();
	

/*
		if(c.equalsIgnoreCase("null")) {
		response.getWriter().append("Es nulo");
		}else{
			response.getWriter().append("No es nulo");
		}
		*/

	}

}
