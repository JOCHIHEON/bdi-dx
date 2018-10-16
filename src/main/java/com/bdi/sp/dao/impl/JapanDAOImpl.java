package com.bdi.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.JapanDAO;
import com.bdi.sp.vo.Japan;

@Repository
public class JapanDAOImpl implements JapanDAO {
	
	@Autowired
	public SqlSession ss;
	
	@Override
	public List<Japan> getJapanList(Japan j) {
		// TODO Auto-generated method stub
		return ss.selectList("com.bdi.sp.JapanMapper.selectJapanList",j);
	}

	@Override
	public Japan getJapan(int jpnum) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.bdi.sp.JapanMapper.selectJapan", jpnum);
	}

	@Override
	public int insertJapan(Japan j) {
		// TODO Auto-generated method stub
		return ss.insert("com.bdi.sp.JapanMapper.insertJapan",j);
	}

	@Override
	public int deleteJapan(int jpnum) {
		// TODO Auto-generated method stub
		return ss.delete("com.bdi.sp.JapanMapper.deleteJapan",jpnum);
	}

	@Override
	public int updateJapan(Japan j) {
		// TODO Auto-generated method stub
		return ss.update("com.bdi.sp.JapanMapper.updateJapan",j);
	}


}
