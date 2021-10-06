package ar.com.webpages;

public class Button extends Element{			 
	
	public Button (String position, String color, String text) {
		super(position,color, text);				
		this.labelComment = "<!--b-->";
		this.label = "button";
		this.labelElement = this.styles() + "\r\n" + this.labelComment;
		
	}
	
	
	@Override
	public String modElem(String content, ElementAtributes enumAt, String newAtr) {
		
		String elemNoMod = this.styles() + "\r\n" + this.labelComment;
		String elemMod;
		
		this.modifyElem(enumAt, newAtr);
		//modifico el atributo en el objeto
		elemMod = this.styles() + "\r\n" + this.labelComment;
		//retorno los cambios		
		
		return this.replaceContent(content, elemNoMod, elemMod);
	}
	
}
