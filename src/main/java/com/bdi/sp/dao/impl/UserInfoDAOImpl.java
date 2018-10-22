package com.bdi.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.UserInfoDAO;
import com.bdi.sp.vo.User;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	public SqlSession ss;
	
	@Override
	public List<User> getUserList(User ui) {
		return ss.selectList("com.bdi.sp.vo.User.selectUserList",ui);
	}
	@Override
	public User getUser(User ui) {
		return ss.selectOne("com.bdi.sp.vo.User.selectUser",ui);
	}
	
	@Override
	public int idDupUser(String uiid) {
		return ss.selectOne("com.bdi.sp.vo.User.idDupUser",uiid);
	}
	
	@Override
	public int insertUser(User ui) {
		return ss.insert("com.bdi.sp.vo.User.insertUser",ui);
	}
	

	@Override
	public int deleteUser(int uino) {
		return ss.delete("com.bdi.sp.vo.User.deleteUser",uino);
	}
	

	@Override
	public int updateUser(User ui) {
		return ss.update("com.bdi.sp.vo.User.updateUser",ui);
	}


	@Override
	public int loginUser(User ui) {
		int cnt=0;
		if(ss.selectOne("com.bdi.sp.vo.User.loginUser",ui)!=null) {
			cnt++;
		}
		return cnt;
	}
	

	
}
