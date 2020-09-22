package Controler;

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

import Model.LoginModel;
import ServerRuta.HomeRuta;
/**
 * Servlet implementation class PerfilUser
 */
@WebServlet("/PerfilUser")
@MultipartConfig
public class PerfilUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilUser() {
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
		
		HttpSession session = request.getSession();
		String codigo= (String) session.getAttribute("codigo");
		
		
		HomeRuta rut=new HomeRuta();
		
		LoginModel lm=new LoginModel();
		String imgurl=rut.getGetrutaimguser();
		lm.setImgurl(imgurl);
		lm.setCodigo(codigo);
		String json = lm.ObtenerDatosUsuario();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		out.flush();
		
		
		/*
	
		LoginModel userperson=new LoginModel("Company","Alex Martin","Palli Uscamaita","U18310907@UTP.EDU.PE","colores.jpg",rut.getGetrutaimguser(),"A001");
		String json = new Gson().toJson(userperson);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		out.flush();
		*/
		//response.getWriter().append("C   ").append(codigo);
		
	}

}
