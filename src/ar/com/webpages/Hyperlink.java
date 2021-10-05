package ar.com.webpages;

public class Hyperlink extends Element{

	private String reference;
	
	public Hyperlink(String position, String color, String text, String reference) {
		super(position, color, text);
		this.labelComment = "<!--b-->";
		this.reference = reference;
		this.label = "a";
		this.labelElement = this.styles(label) + "\r\n" + this.labelComment;
			
	}
	
	@Override
	protected String styles(String labelE) {
		
		String styEs = super.styles(labelE);
		//llamando al metodo de la superclase defino el primer estilo		
		String styleHyper = styEs.substring(0,2) + " href = \"" + this.reference + "\" " + styEs.substring(3,styEs.length());						
		
		return styleHyper;		
	}

	@Override
	public String addElem(String content) {
		return this.replaceContent(content, this.labelComment, this.labelElement); 
	}

	@Override
	public String deleteElem(String content) {
		return this.replaceContent(content, this.styles(label), "");
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

	@Override
	protected void modifyElem(ElementAtributes enumAt, String newAtr) {
		if (enumAt == ElementAtributes.HREF) { 
			this.reference = newAtr;		
		} else {
			super.modifyElem(enumAt, newAtr);
		}		
	}
	
}
