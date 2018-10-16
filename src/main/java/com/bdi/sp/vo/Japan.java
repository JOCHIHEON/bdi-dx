package com.bdi.sp.vo;

import java.util.List;

public class Japan {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private Integer jpnum;
	private String jpname;
	private String jpdesc;

	@Override
	public String toString() {
		return "Japan [jpnum=" + jpnum + ", jpname=" + jpname + ", jpdesc=" + jpdesc + "]";
	}
	public Integer getJpnum() {
		return jpnum;
	}
	public void setJpnum(Integer jpnum) {
		this.jpnum = jpnum;
	}
	public String getJpname() {
		return jpname;
	}
	public void setJpname(String jpname) {
		this.jpname = jpname;
	}
	public String getJpdesc() {
		return jpdesc;
	}
	public void setJpdesc(String jpdesc) {
		this.jpdesc = jpdesc;
	}
}
