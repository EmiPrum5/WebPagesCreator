import ar.com.webpages.Button;
import ar.com.webpages.WebPage;

public class Main {	
	
	public static void main(String[] args) {
		String pathtemplate = "template.html";
		
		WebPage wp = new WebPage(pathtemplate);
		
		System.out.println(wp.getContent());
		
		Button btn = new Button("absolute","red", " hola ");
		wp.addElement(btn);
		wp.modElement(btn);

		wp.writeWebPage("firstwebeichitimiel.html");

	}
	     

}
