package com.saasapp.pojo;

import java.util.List;

public class RegionOfAddress {

	private String regionName;
	private List<Hospital> list;
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public List<Hospital> getList() {
		return list;
	}
	public void setList(List<Hospital> list) {
		this.list = list;
	}
	public RegionOfAddress(String regionName, List<Hospital> list) {
		super();
		this.regionName = regionName;
		this.list = list;
	}
}
