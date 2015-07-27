package com.saasapp.pojo;

public class DeptAndDocType {

	private String name;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public DeptAndDocType(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
}
