package ar.com.webpages;

public class Button extends Element{
	
	private String labelComment = "<!--b-->";
	private String labelElement; 
	private String label = "button";
	
	public Button (String position, String color, String text) {
		super(position,color, text);				
				
		
		labelElement = this.styles(label) + "\r\n" + this.labelComment;
	}

	@Override
	public String addElem(String content) { 
		//buscar el comentario donde pueda agregar este elemento
		//en este caso se agrega dentro del comentario del body
		return this.replaceContent(content, this.labelComment, this.labelElement);				
	}

	@Override
	public String deleteElem(String content) {	
		//los comentarios no deberan estar identados para poder borrarlos correctamente 
		return this.replaceContent(content, this.labelElement, this.labelComment);		
	}
	
	@Override
	public String modElem(String content, ElementAtributes enumAt, String newAtr) {
		
		String elemNoMod = this.styles(label) + "\r\n" + this.labelComment;
		String elemMod;
		
		this.modifyElem(enumAt, newAtr);
		//modifico el atributo en el objeto
		elemMod = this.styles(label) + "\r\n" + this.labelComment;
		//retorno los cambios		
		
		return this.replaceContent(content, elemNoMod, elemMod);
	}
	
}
