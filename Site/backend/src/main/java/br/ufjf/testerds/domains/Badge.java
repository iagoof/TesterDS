package br.ufjf.testerds.domains;

public class Badge {
	private String variant;
	private String text;
	
	public Badge(String variant, String text) {
		super();
		this.variant = variant;
		this.text = text;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
