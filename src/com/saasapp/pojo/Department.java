package com.saasapp.pojo;


public class Department {
	
	private String DeptName;
	private String ParentCode;
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public String getParentCode() {
		return ParentCode;
	}
	public void setParentCode(String parentCode) {
		ParentCode = parentCode;
	}
	public Department(String deptName, String parentCode) {
		super();
		DeptName = deptName;
		ParentCode = parentCode;
	}
}
