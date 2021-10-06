import java.util.Scanner;

import ar.com.webpages.Button;
import ar.com.webpages.Element;
import ar.com.webpages.ElementAtributes;
import ar.com.webpages.Header;
import ar.com.webpages.Hyperlink;
import ar.com.webpages.Image;
import ar.com.webpages.Paragraph;
import ar.com.webpages.WebPage;

public class Main {	
	
	public static void main(String[] args) {
		String position = null;
		String color = null;
		String text = null;
		String pathtemplate = "template.html";
		int opt, cp, acc;
		boolean salir = false;
		String title;
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Bienvenido al creador de paginas web");
		System.out.println("Desea crear nuevas paginas o modificar una existentes?");
		System.out.println("1.-Crear nuevas");
		System.out.println("2.-Modificar una existente");
		opt = sc.nextInt();
		
		if (opt == 1) {
		System.out.println("Cuantas paginas desea crear?");
		cp = sc.nextInt();
		sc.skip("\r\n");
		title = sc.nextLine();
		System.out.println(title);
		while (cp > 0) {
			
			WebPage wp = new WebPage(pathtemplate);
			System.out.println("Que titulo desea agregarle a la pagina?");
			title = sc.nextLine();
			wp.setTitlePage(title);
					
			while(!salir) {
				System.out.println("Elementos posibles para agregar, eliminar o modificar:");
				System.out.println("1.-Boton");
				System.out.println("2.-Header");
				System.out.println("3.-Hyperlink");
				System.out.println("4.-Paragraph");
				System.out.println("5.-Imagen");
				System.out.println("9.-Salir");
				
				opt = sc.nextInt();								
				
				if (opt != 9) {
					
				System.out.println("Que accion desea realizar?");
				System.out.println("1.-Agregar");
				System.out.println("2.-Modificar");
				System.out.println("3.-Eliminar");
				
				acc = sc.nextInt();
				sc.skip("\r\n");
				
				Element el = null;
				System.out.println("Ingresar position:");
				position = sc.nextLine();
				if (opt != 5) {
					System.out.println("Ingresar color:");
					color = sc.nextLine();
					System.out.println("Ingresar texto:");
					text = sc.nextLine();
				}
					switch (opt) {
						
						case 1:													
							el = new Button(position,color,text);
							break;
							
						
						case 2:	
							System.out.println("Ingresar index:");
							int index = sc.nextInt();
							el = new Header(position,color,text,index);
							break;
						
						case 3:
							System.out.println("Ingresar referencia:");
							String ref = sc.nextLine();
							el = new Hyperlink (position,color,text,ref);
							break;
						
						case 4:
							el = new Paragraph(position, color, text);
							break;
						
						case 5: 
							System.out.println("Ingresar align:");
							String align = sc.nextLine();
							System.out.println("Ingresar width:");
							String width = sc.nextLine();
							System.out.println("Ingresar heigth:");
							String heigth = sc.nextLine();
							System.out.println("Ingresar src:");
							String src = sc.nextLine();
							
							el = new Image(position,align,width,heigth,src);
							break;
					}
					
					//una vez sale del switch tengo que ver que accion se tiene que tomar
					if (acc == 1) {
						wp.addElement(el);
					} else if (acc == 2) {
						//TODO submetodo para modificaciones
						ElementAtributes elemAtMod;
						elemAtMod = modElemento(el);						
						System.out.println("Ingrese nuevo valor para el atributo");
						String newVal = sc.nextLine();
						wp.modElement(el, elemAtMod, newVal);
					} else {
						wp.delElement(el);
					}
					
					System.out.println("ELEMENTO AGREGADO");
					
				}else {
					salir = true;
				}
			}
			cp--;
			//finalizada la creacion de la pagina
			//se escribe como archivo html
			sc.skip("\r\n");
			System.out.println("Finalizando creacion... ingrese nombre del archivo a grabar");
			String fileName = sc.nextLine();
			wp.writeWebPage(fileName.concat(".html"));
		}
		}else {
		//modificacion en progreso
		}
				
		
	}
	
	public static ElementAtributes modElemento(Element el) {
		
		Scanner sc = new Scanner(System.in);
		int opt;
		
		System.out.println("Que atributo del elemento desea modificar?");
		System.out.println("0.-COLOR");
		System.out.println("1.-POSITION");
		System.out.println("2.-TEXT");
		System.out.println("3.-HREF");
		System.out.println("4.-ALIGN");
		System.out.println("5.-WIDTH");
		System.out.println("6.-HEIGHT");
		System.out.println("7.-SRC");
		
		opt = sc.nextInt();
		
		return ElementAtributes.values()[opt];
		
	}
	     	

}
