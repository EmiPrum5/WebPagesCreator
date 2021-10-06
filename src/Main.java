import ar.com.webpages.Button;
import ar.com.webpages.Header;
import ar.com.webpages.Hyperlink;
import ar.com.webpages.Image;
import ar.com.webpages.Paragraph;
import ar.com.webpages.WebPage;

public class Main {	
	
	public static void main(String[] args) {
		String pathtemplate = "template.html";
		
		WebPage wp = new WebPage(pathtemplate);
		
		System.out.println(wp.getContent());
		
		/*Button btn = new Button("relative","red", " hola ");
		wp.addElement(btn);
		wp.modElement(btn);		
		
		
		Paragraph para = new Paragraph("relative", "yellow", "como andan todos"); 
		
		wp.addElement(para);
		wp.modElement(para);		
		
		*/
		
		
		Hyperlink hl = new Hyperlink("relative", "yellow", "soy un hipertexto", "https://www.google.com"); 
		
		wp.addElement(hl);
		
		wp.modElement(hl);
		
		/*wp.delElement(para);
		
		wp.delElement(hl);
		
		wp.addElement(para);*/			
		
		/*Header h1 = new Header("relative","brown", "Aca siendo un H1", 1);
	
		wp.addElement(h1);*/
		
		//Image img = new Image("C:\\Users\\emili\\OneDrive\\Documentos\\Importantes\\CapArcor\\Java\\Proyectos\\WebPagesGenerator\\avcaida.png",
		//"relative", "left", "300", "300");
		
		//wp.addElement(img);
		
		wp.writeWebPage("firstwebeichitimiel.html");

		
		
	}
	     

}
