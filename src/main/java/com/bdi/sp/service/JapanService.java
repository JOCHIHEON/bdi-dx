package com.bdi.sp.service;

import java.util.List;

import com.bdi.sp.vo.Japan;

public interface JapanService {
	
	public List<Japan> getJapanList(Japan j);
	public Japan getJapan(int jpnum);
	public int insertJapan(Japan j);
	public int deleteJapan(int jpnum);
	public int updateJapan(Japan j);
}
