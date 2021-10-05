package ar.com.webpages;

public class Paragraph extends Element{

	public Paragraph(String position, String color, String text) {
		super(position, color, text);
		this.labelComment = "<!--b-->";
		this.label = "p";
		this.labelElement = this.styles(label) + "\r\n" + this.labelComment;				
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

}
