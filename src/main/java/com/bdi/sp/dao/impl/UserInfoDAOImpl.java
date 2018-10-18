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
		// TODO Auto-generated method stub
		return ss.selectList("com.bdi.sp.vo.User.selectUserList",ui);
	}
	

	@Override
	public User getUser(int uino) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.bdi.sp.vo.User.selectUser", uino);
	}
	

	@Override
	public int insertUser(User ui) {
		// TODO Auto-generated method stub
		return ss.insert("com.bdi.sp.vo.User.insertUser",ui);
	}
	

	@Override
	public int deleteUser(int uino) {
		// TODO Auto-generated method stub
		return ss.delete("com.bdi.sp.vo.User.deleteUser",uino);
	}
	

	@Override
	public int updateUser(User ui) {
		// TODO Auto-generated method stub
		return ss.update("com.bdi.sp.vo.User.updateUser",ui);
	}


	@Override
	public int loginUser(User ui) {
		// TODO Auto-generated method stub
		int cnt=0;
		if(ss.selectOne("com.bdi.sp.vo.User.loginUser",ui)!=null) {
			cnt++;
		}
		return cnt;
	}
	

	
}
