package com.bdi.sp.vo;

public class Depart {
	private Integer dino;
	private String diname;
	private String didesc;
	private Integer dicnt;
	public Integer getDino() {
		return dino;
	}
	public void setDino(Integer dino) {
		this.dino = dino;
	}
	public String getDiname() {
		return diname;
	}
	public void setDiname(String diname) {
		this.diname = diname;
	}
	public String getDidesc() {
		return didesc;
	}
	public void setDidesc(String didesc) {
		this.didesc = didesc;
	}
	public Integer getDicnt() {
		return dicnt;
	}
	public void setDicnt(Integer dicnt) {
		this.dicnt = dicnt;
	}
	@Override
	public String toString() {
		return "Depart [dino=" + dino + ", diname=" + diname + ", didesc=" + didesc + ", dicnt=" + dicnt + "]";
	}

}
