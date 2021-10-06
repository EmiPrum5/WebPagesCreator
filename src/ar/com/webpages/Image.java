package ar.com.webpages;

import java.util.StringJoiner;

public class Image extends Element{

	private String align;
	private String width;
	private String height;
	private String src;
	
	public Image(String src, String position,String align,String width,String height) {
		super(position);
		this.align = "align=\"" + align + "\"";
		this.width = "width=\"" + width + "\"";
		this.height = "height=\"" + height + "\"";	
		this.labelComment = "<!--b-->";
		this.label = "img";
		this.src = "src=\"" + src + "\"";
		this.labelElement = this.styles() + "\r\n" + this.labelComment;
	}
	
	public Image(String src, String position,String align) {
		super(position);
		this.src = src;
		this.align = "align=\"" + this.align + "\"";
		this.labelComment = "<!--b-->";
		this.label = "img";
		this.src = "src=\"" + src + "\"";
		this.labelElement = this.styles() + "\r\n" + this.labelComment;
	}
	
	public Image(String src, String position) {
		super(position);	
		this.src = src;
		this.labelComment = "<!--b-->";
		this.label = "img";
		this.src = "src=\"" + src + "\"";
		this.labelElement = this.styles() + "\r\n" + this.labelComment;
	}

	@Override
	protected String styles () {
		
		StringJoiner st = new StringJoiner("")
			.add("<" + this.label)
			.add(" " + this.src)
			.add(" style=\"position:" + this.getPosition() + ";\"")
			.add("" + this.align)
			.add("" + this.width)
			.add("" + this.height);		
		System.out.println(st);
				
		return st.toString();
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
		switch (enumAt) {
		case ALIGN:
			this.align = "align=\"" + newAtr + "\"";;
			break;
		case WIDTH:
			this.width = "width=\"" + newAtr + "\"";
			break;
		case HEIGHT:
			this.height = "height=\"" + newAtr + "\"";
			break;
		case SRC:
			this.src = "src=\"" + newAtr + "\"";
			break;
		default:
		//si viene algun atributo que no es de image especifico
		//voy al de element
			super.modifyElem(enumAt, newAtr);
		}
	}

}
