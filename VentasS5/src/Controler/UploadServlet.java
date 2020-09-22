package Controler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;




/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String UPLOAD_DIRECTORY = "upload";
//	 private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
//	    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
//	    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		//File uploads = new File(System.getProperty("user.dir"));
		String uploads = System.getProperty("user.dir") + "ImagenesServer";
		  File uploadDir = new File(uploads);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	        
	    File cargar = new File(uploads);  
		String txtDir = request.getParameter("prueba");
		//String foto = request.getParameter("foto");
		
		 //String uploadPath = getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
	    // ...
		 Part filePart = request.getPart("foto"); // Retrieves <input type="file" name="file">
		 String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		
		 int size = fileName.length();
		 String NewName = fileName.substring(0,size-4);
		 String extension= fileName.substring(size-4,size);
		 System.out.println(NewName);
		 System.out.println(extension);
	
		 //File file =File.createTempFile(NewName, extension, cargar);
		 File file = new File(cargar+"/"+ NewName+ extension );
		 System.out.println(file);
		 try ( InputStream fileContent = filePart.getInputStream()) {
		     Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		     response.getWriter().append("Okey").append(txtDir);
		 }
		 catch (Exception e) {
			 response.getWriter().append("Error").append("");
		}
		// response.getWriter().append("LLego la data").append(txtDir);
		
	}

}
