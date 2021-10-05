import ar.com.webpages.Button;
import ar.com.webpages.Hyperlink;
import ar.com.webpages.Paragraph;
import ar.com.webpages.WebPage;

public class Main {	
	
	public static void main(String[] args) {
		String pathtemplate = "template.html";
		
		WebPage wp = new WebPage(pathtemplate);
		
		System.out.println(wp.getContent());
		
		Button btn = new Button("relative","red", " hola ");
		wp.addElement(btn);
		wp.modElement(btn);		
		
		
		Paragraph para = new Paragraph("relative", "yellow", "como andan todos"); 
		
		wp.addElement(para);
		wp.modElement(para);		
		
		
		
		
		Hyperlink hl = new Hyperlink("relative", "yellow", "soy un hipertexto", "https://www.google.com"); 
		
		wp.addElement(hl);
		
		wp.modElement(hl);
		
		wp.delElement(para);
		
		wp.delElement(hl);
		
		wp.addElement(para);
		
		wp.addElement(hl);
	
		
		wp.writeWebPage("firstwebeichitimiel.html");

		
		
	}
	     

}
