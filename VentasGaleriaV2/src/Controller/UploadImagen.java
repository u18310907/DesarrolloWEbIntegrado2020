package Controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.Part;

import Routes.LocalRoutes;

public class UploadImagen {

	public String uploadImagen(Part fileparts,String fecha, String urlFull) {
		String finalname;
		LocalRoutes lc=new LocalRoutes();
		String uploads = lc.getLocalRoute();
		File uploadDir = new File(uploads);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		File cargar = new File(uploads);
		Part filePart = fileparts;
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

		int size = fileName.length();
		String NewName = fileName.substring(0, size - 4);
		String extension = fileName.substring(size - 4, size);
		File file = new File(cargar + "/" +fecha+urlFull + extension);
		finalname=fecha+urlFull+extension;
		try (InputStream fileContent = filePart.getInputStream()) {
			Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		//	 OutputStream output = Files.newOutputStream(path);
			//    IOUtils.copy(in, out); 
		} catch (Exception e) {
				System.out.println(e);
				return "";
		}
		return finalname;
	}
}
