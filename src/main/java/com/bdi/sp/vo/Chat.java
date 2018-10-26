package com.bdi.sp.vo;

public class Chat {
	private String msg;
	private String name;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Chat [msg=" + msg + ", name=" + name + "]";
	}
}
