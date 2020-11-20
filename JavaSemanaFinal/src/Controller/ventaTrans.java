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
import Database.listaVentaDB;
import Model.Venta;
import Routes.Mailer;

/**
 * Servlet implementation class Venta
 */
@WebServlet("/Venta")
@MultipartConfig
public class ventaTrans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ventaTrans() {
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
		String codigo= (String) session.getAttribute("coduser");
		String usermail= (String) session.getAttribute("usermail");
		
		System.out.println("codigo"+codigo);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String fecha = dtf.format(now);
		if(codigo == null || codigo == "") {
			codigo="1";
		}
		
		String codjue = request.getParameter("codjue");
		String precio = request.getParameter("precio");
		String titulo = request.getParameter("titulo");
		
		Venta ven=new Venta();
		ven.setCodjue(Integer.parseInt(codjue));
		ven.setPrecio(Double.parseDouble(precio));
		ven.setCodusu(Integer.parseInt(codigo));
		ven.setFecha(fecha);
		ven.setEstado("0");
		
		listaVentaDB lvDB=new listaVentaDB();
		try {
			String numero=lvDB.RegistrarVenta(ven);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();			
			String to=usermail;
			String subject="Compra de Video Juego";
			String msg="Se realizo la compra del video juego   :  "
						+"\nCodigo unico Operacion : AED-0000-"+numero
						+"\n\nTitulo : "+titulo
						+"\nCosto de : "+precio
						+"\n\nPara confirmar tendra que realizar un deposito dentro de las  24 horas a la cuenta"
						+"\n\n\n Nº 1111-1111-11-0123456789  "
						+"\n\n\n Despues de haber realizado el deposito sirva a responder este correo adjuntando el voucher"
						+"\n\n\n\n\n\n\n"
						+"Atentamente Game Warrior ";
			
			Mailer.send(to, subject, msg);
			out.print("message has been sent successfully");
			out.close();
			response.getWriter().append("OK ");
		} catch (SQLException e) {
			response.getWriter().append("Fail");
		}

	}

}
