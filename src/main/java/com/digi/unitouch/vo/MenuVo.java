package com.digi.unitouch.vo;

public class MenuVo
{
	private String functionName;
	private String uri;
	private String menuName;
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public MenuVo(String functionName, String uri, String menuName) {
		super();
		this.functionName = functionName;
		this.uri = uri;
		this.menuName = menuName;
	}
	@Override
	public String toString() {
		return "MenuVo [functionName=" + functionName + ", uri=" + uri + ", menuName=" + menuName + "]";
	}
	

}

	
