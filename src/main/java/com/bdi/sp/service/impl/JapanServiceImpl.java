package com.bdi.sp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdi.sp.dao.JapanDAO;
import com.bdi.sp.service.JapanService;
import com.bdi.sp.vo.Japan;

@Service
public class JapanServiceImpl implements JapanService {

	@Autowired
	private JapanDAO jdao;
	@Override
	public List<Japan> getJapanList(Japan j) {
		// TODO Auto-generated method stub
		return jdao.getJapanList(j);
	}

	@Override
	public Japan getJapan(int jpnum) {
		// TODO Auto-generated method stub
		return jdao.getJapan(jpnum);
	}

	@Override
	public int insertJapan(Japan j) {
		// TODO Auto-generated method stub
		return jdao.insertJapan(j);
	}

	@Override
	public int deleteJapan(int jpnum) {
		// TODO Auto-generated method stub
		return jdao.deleteJapan(jpnum);
	}

	@Override
	public int updateJapan(Japan j) {
		// TODO Auto-generated method stub
		return jdao.updateJapan(j);
	}

}
