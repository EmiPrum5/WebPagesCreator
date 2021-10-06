package ar.com.webpages;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class WebPage {
		
	private String path = "C:\\Users\\emili\\OneDrive\\Documentos\\Importantes\\CapArcor\\Java\\Proyectos\\WebPagesGenerator\\";
	private String contenido;
	private List<String> elementos;
	
	
	public WebPage(String nameFile) {
	//el path va a almacenar el directorio donde se almacene el nuevo archivo
	//o el directorio donde ya existe en el caso de que se elija modificar
		this.path = this.path.concat(nameFile);
		elementos = new ArrayList<String>();
		almacenarContenido();
	}
	
	private void almacenarContenido() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea;		
				
		try {
			archivo = new File (this.path);
	        //abro el archivo e instancio el buffer para poder leer almacenando en el			
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			
			StringJoiner content = new StringJoiner("\r\n");
			
	        while((linea=br.readLine())!=null)
	        	 content.add(linea) ;		         	         
			
			this.contenido = content.toString();						
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se ha encontrado el archivo");
		}finally{
	         try{                    
	            if( fr != null ){   
	               fr.close();     
	            }                  
	         }catch (IOException e2){ 
	            e2.printStackTrace();	            
	         }
	      }	
	}
	
	
	public void addElement(Element el) {
		//voy a trabajar con el contenido del archivo
		//para no ir abriendolo y cerrando todo el tiempo
		this.contenido = el.addElem(this.contenido);
		System.out.println(contenido);
	}
	
	public void delElement(Element el) {
		this.contenido = el.deleteElem(this.contenido);
		System.out.println(contenido);
	}
	
	public void modElement(Element el, ElementAtributes enumAt, String newAtr) {
		this.contenido = el.modElem(this.contenido, enumAt, newAtr);
		System.out.println(contenido);
	}
	
	public String getContent() {
		//solo para probar
		return this.contenido;
	}
	
	public void writeWebPage(String pathFileWrite) {
	//una vez agregados los elementos o modificado
	//se escribe la pagina en el path indicado
		String pathWrite;
		FileWriter file = null;
		PrintWriter pw = null;
		
		if (pathFileWrite == "") {
			//si es vacio significa que estamos usando una pagina ya creada
			pathWrite = this.path;
		} else {
			//sino es que estamos creando una por primera vez	
			File folder = new File (this.path);				
			pathWrite = folder.getParent().concat(System.getProperty("file.separator")).concat(pathFileWrite);			
		}		
				
		try {
			file = new FileWriter(pathWrite);
			pw = new PrintWriter(file);

			pw.print(this.contenido);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Ocurrio un problema con el archivo");
		}finally {		
				try {
					if (file != null) 
						file.close();
					} 
				catch (IOException e) {
					e.printStackTrace();
					System.out.println("Problema al cerrar el archivo");
				}
			}		
				
	}

}
