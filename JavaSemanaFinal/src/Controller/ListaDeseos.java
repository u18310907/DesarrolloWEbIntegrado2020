package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Database.listaDeseosDB;
import Model.ListDeseos;

/**
 * Servlet implementation class ListaDeseos
 */
@WebServlet("/ListaDeseos")
@MultipartConfig
public class ListaDeseos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDeseos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String fecha = dtf.format(now);
		HttpSession session = request.getSession();
		String coduser= (String) session.getAttribute("coduser");
		String codjue = request.getParameter("codjue");
		if(coduser!=null) {
			ListDeseos ld=new ListDeseos();
			ld.setCodjue(Integer.parseInt(codjue));
			ld.setCodusu(Integer.parseInt(coduser));
			ld.setEstado(0);
			ld.setFecha(fecha);			
			listaDeseosDB ldb=new listaDeseosDB();
			try {
				ldb.RegistrarLista(ld);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String json=" ";
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(json);
			out.flush();		
		}
	}

}
