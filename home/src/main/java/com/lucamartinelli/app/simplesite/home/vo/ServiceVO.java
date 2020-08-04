package com.lucamartinelli.app.simplesite.home.vo;

public class ServiceVO {
	
	private String name;
	private String displayInfo;
	private String url;
	
	public ServiceVO() {
	}

	public ServiceVO(String name, String displayInfo, String url) {
		super();
		this.name = name;
		this.displayInfo = displayInfo;
		this.url = url;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayInfo() {
		return displayInfo;
	}
	public void setDisplayInfo(String displayInfo) {
		this.displayInfo = displayInfo;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
