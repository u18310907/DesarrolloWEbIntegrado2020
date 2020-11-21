package Routes;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class GenerarPdf {
	public static  void GeneratePDF(String Cliente, String fecha,String juego, String precio,String operacion) throws IOException {

		  try (PDDocument doc = new PDDocument()) {

	            PDPage myPage = new PDPage();
	            doc.addPage(myPage);

	            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

	                cont.beginText();

	                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
	                cont.setLeading(14.5f);

	                cont.newLineAtOffset(25, 700);
	                String line1 = "       Game Warrior";
	                cont.showText(line1);

	                cont.newLine();

	                String line2 = "RUC 2025488452145";
	                cont.showText(line2);
	                cont.newLine();
	                
	                String line3 = "SUCURSAL: Urb Palo Alto Mz A Lote6";
	                cont.showText(line3);
	                cont.newLine();

	                String line4 = "CEL: 999999999";
	                cont.showText(line4);
	                cont.newLine();
	                
	                String line5 = "AREQUIPA, AREQUIPA, AREQUIPA";
	                cont.showText(line5);
	                cont.newLine();
	                
	                String line6 = "";
	                cont.showText(line6);
	                cont.newLine();
	                
	                String line7 = "----------BOLETA ELECTRONICA----------";
	                cont.showText(line7);
	                cont.newLine();
	                
	                String line8 = "Fecha: "+fecha;
	                cont.showText(line8);
	                cont.newLine();
	                
	                String line9 = "Clente: "+Cliente;
	                cont.showText(line9);
	                cont.newLine();
	                
	                String line10 = "Descripcion            Cantidad        Precio       Total";
	                cont.showText(line10);
	                cont.newLine();
	                
	                String line11 = juego+"      " +"   1                 "+precio+"           "+precio;
	                cont.showText(line11);
	                cont.newLine();
	                
	                
	                String line12 = "";
	                cont.showText(line12);
	                cont.newLine();
	                
	                
	                String line13 = "GRACIAS POR SU VISITA";
	                cont.showText(line13);
	                cont.newLine();


	                cont.endText();
	            }

	            doc.save("D://DesarrolloWEbIntegrado2020/JavaSemanaFinal/WebContent/resources/pdf/"+operacion+"reporte.pdf");
	        }
		 
	}
}
