package br.ufjf.testerds.domains;

public class LevelNav {
	private String title;
	private String link;
	private String icon;
	private Badge badge;
	
	public LevelNav(String name, String url, String icon, Badge badge) {
		super();
		this.title = name;
		this.link = url;
		this.icon = icon;
		this.badge = badge;
	}

	public LevelNav() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String url) {
		this.link = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}
}
