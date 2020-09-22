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
import javax.servlet.http.Part;

import com.google.gson.Gson;

import Model.Producto;
import ServerRuta.HomeRuta;
/**
 * Servlet implementation class AgregarProducto
 */
@WebServlet("/AgregarProducto")
@MultipartConfig
public class AgregarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarProducto() {
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
		HomeRuta rt=new HomeRuta();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String categoria = request.getParameter("categoria");
		String proveedor = request.getParameter("proveedor");
		String unidad = request.getParameter("unidad");
		String precio = request.getParameter("precio");
		String observaciones = request.getParameter("observaciones");

		//String uploads = System.getProperty("user.dir") + "ImagenesServer";
		String uploads = rt.getImgproductos();
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
		//System.out.println(NewName);
		//System.out.println(extension);

		// File file =File.createTempFile(NewName, extension, cargar);
		File file = new File(cargar + "/" + NewName + extension);
		//System.out.println(file);
		try (InputStream fileContent = filePart.getInputStream()) {
			Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
			//Producto producto=new Producto(codigo, nombre, descripcion, proveedor, unidad, precio, observaciones,categoria,fileName);
			Producto producto=new Producto();
			producto.setCodigo(codigo);
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setCategoria(Integer.parseInt(categoria));
			producto.setProveedor(proveedor);
			producto.setUnidad(unidad);
			producto.setPrecio(Double.parseDouble(precio));
			producto.setObservaciones(observaciones);
			producto.setImg(fileName);
			String informacion=producto.AgregarProducto();
			
			
			//Codigo
			//Nombre
			//Descripcion
			//Categoria
			//Proveedor
			//Unidad
			//Precio
			//Observaciones
			//img
			
			//response.getWriter().append("Informacion ").append(informacion);
			
			//String json = new Gson().toJson(producto);			
			//PrintWriter out = response.getWriter();
			//response.setContentType("application/json");
			//response.setCharacterEncoding("UTF-8");
			//out.print(json);
			//out.flush();
			
			//response.getWriter().append("Okey").append(user);
		} catch (Exception e) {
		//	response.getWriter().append("Error").append("");
		}
		
		
		 String message[]= new String[2];
		 message[0]="success";
		 message[1]=rt.getRuta()+"ListarProducto.jsp";
		 String json = new Gson().toJson(message);	
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 out.print(json);
		 out.flush();
	}

}
