package ar.com.webpages;

import java.util.StringJoiner;

public abstract class Element {
	
	private String position;
	private String color;
	private String text;
	
	public Element(String position, String color) {
	//constructor para elementos que no contengan texto como lista
		this.position = position;
		this.color = color;		
	}	
	
	public Element(String position, String color, String text) {
		this.position = position;
		this.color = color;
		this.text = text;
	}
	
	public abstract String addElem(String content);
	public abstract String deleteElem(String content);
	public abstract String modElem(String content,ElementAtributes enumAt, String newAtr);
	
	protected void modifyElem(ElementAtributes enumAt, String newAtr) {
	//utilizo el de element para todos menos para los que no contentengan algun atributo
		
		switch (enumAt) {
		
		case COLOR:
			this.color = newAtr;
			break;
		case POSITION:
			this.position = newAtr;
			break;
		case TEXT:
			this.text = newAtr;			
			break;							
		}		
	};
	
		
	public String getPosition() {
		return this.position;
	}
	public String getColor() {
		return this.color;
	}
	public String getText() {
		return this.text;
	}
	
	protected String replaceContent(String content, String replace, String toReplace) {
		return content.replaceAll(replace,toReplace);
	}
	
	protected String styles (String labelE) {
	//refactorizar	
		StringJoiner st = new StringJoiner("")
				.add("<" + labelE);		
		
		if (this.getColor() != "" || this.getPosition() != "") {
			st.add(" style=\"");
			
			if (this.getColor() != "") {
				st.add("color:" + this.getColor() + ";");
			}
			if (this.getPosition() != "") {
				st.add("position:" + this.getPosition() + ";");			
			}			
			st.add("\">");			
		} else {
			st.add(">");
		}
		
		if (this.getText() != "") {
			st.add(this.getText());
		}
		st.add("</" + labelE + ">");			
				
		
		return st.toString();
	}
		
}
