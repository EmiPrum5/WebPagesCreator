package ar.com.webpages;

public class Hyperlink extends Element{

	private String reference;
	
	public Hyperlink(String position, String color, String text, String reference) {
		super(position, color, text);
		this.labelComment = "<!--b-->";
		this.reference = reference;
		this.label = "a";
		this.labelElement = this.styles() + "\r\n" + this.labelComment;
			
	}
	
	@Override
	protected String styles() {
		
		String styEs = super.styles();
		//llamando al metodo de la superclase defino el primer estilo		
		String styleHyper = styEs.substring(0,2) + " href = \"" + this.reference + "\" " + styEs.substring(3,styEs.length());						
		
		return styleHyper;		
	}

	@Override
	public String modElem(String content, ElementAtributes enumAt, String newAtr) {
		String elemNoMod = this.styles() + "\r\n" + this.labelComment;		
		
		this.modifyElem(enumAt, newAtr);
		//modifico el atributo en el objeto
		this.labelElement = this.styles() + "\r\n" + this.labelComment;
		//retorno los cambios				
		
		return this.replaceContent(content, elemNoMod, this.labelElement);
	}

	@Override
	protected void modifyElem(ElementAtributes enumAt, String newAtr) {
		if (enumAt == ElementAtributes.HREF) { 
			this.reference = newAtr;		
		} else {
			super.modifyElem(enumAt, newAtr);
		}		
	}
	
}
