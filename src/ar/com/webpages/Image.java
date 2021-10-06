package ar.com.webpages;

import java.util.StringJoiner;

public class Image extends Element{

	private String align;
	private String width;
	private String height;
	private String src;
	
	public Image(String src, String position,String aling,String width,String height) {
		super(position);
		this.align = "align=\"" + align + "\"";
		this.width = "width=\"" + width + "\"";
		this.height = "height=\"" + height + "\"";	
		this.labelComment = "<!--b-->";
		this.label = "img";
		this.src = "src=\"" + src + "\"";
		this.labelElement = "";
	}
	
	public Image(String src, String position,String aling) {
		super(position);
		this.src = src;
		this.align = "align=\"" + this.align + "\"";				
	}
	
	public Image(String src, String position) {
		super(position);	
		this.src = src;
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
		// TODO Auto-generated method stub
		return null;
	}

}
