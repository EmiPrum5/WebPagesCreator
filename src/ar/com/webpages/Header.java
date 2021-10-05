package ar.com.webpages;

public class Header extends Element{	
	
	private int index; 
	
	public Header(String position, String color, String text, int index) {
		super(position, color, text);
		this.index = index;
		this.labelComment = "<!--b-->";
		this.label = "h";
		this.labelElement = this.styles(label) + "\r\n" + this.labelComment; 
	}
	
	@Override
	public String styles (String labelE) {
		
		String styEs = super.styles(labelE);
		String styleHeader = styEs.substring(0, 2) + this.index + " " + 
		styEs.substring(3, styEs.length());
		return styleHeader;
		
	}

	@Override
	public String modElem(String content, ElementAtributes enumAt, String newAtr) {
		String elemNoMod = this.styles(label) + "\r\n" + this.labelComment;		
		
		this.modifyElem(enumAt, newAtr);
		//modifico el atributo en el objeto
		this.labelElement = this.styles(label) + "\r\n" + this.labelComment;
		//retorno los cambios				
		
		return this.replaceContent(content, elemNoMod, this.labelElement);
	}

	

}
