package com.bdi.sp.vo;

public class User {

	private Integer uino;
	private String uiid;
	private String uipwd;
	private String uiname;
	private String uinickname;
	private String uiemail;
	private String uibirth;
	private Integer uiphoneno;
	private Integer uigender;
	private Integer uiactive;
	@Override
	public String toString() {
		return "UserInfo [uino=" + uino + ", uiid=" + uiid + ", uipwd=" + uipwd + ", uiname=" + uiname + ", uinickname="
				+ uinickname + ", uiemail=" + uiemail + ", uibirth=" + uibirth + ", uiphoneno=" + uiphoneno
				+ ", uigender=" + uigender + ", uiactive=" + uiactive + "]";
	}
	public Integer getUino() {
		return uino;
	}
	public void setUino(Integer uino) {
		this.uino = uino;
	}
	public String getUiid() {
		return uiid;
	}
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	public String getUipwd() {
		return uipwd;
	}
	public void setUipwd(String uipwd) {
		this.uipwd = uipwd;
	}
	public String getUiname() {
		return uiname;
	}
	public void setUiname(String uiname) {
		this.uiname = uiname;
	}
	public String getUinickname() {
		return uinickname;
	}
	public void setUinickname(String uinickname) {
		this.uinickname = uinickname;
	}
	public String getUiemail() {
		return uiemail;
	}
	public void setUiemail(String uiemail) {
		this.uiemail = uiemail;
	}
	public String getUibirth() {
		return uibirth;
	}
	public void setUibirth(String uibirth) {
		this.uibirth = uibirth;
	}
	public Integer getUiphoneno() {
		return uiphoneno;
	}
	public void setUiphoneno(Integer uiphoneno) {
		this.uiphoneno = uiphoneno;
	}
	public Integer getUigender() {
		return uigender;
	}
	public void setUigender(Integer uigender) {
		this.uigender = uigender;
	}
	public Integer getUiactive() {
		return uiactive;
	}
	public void setUiactive(Integer uiactive) {
		this.uiactive = uiactive;
	}
}
