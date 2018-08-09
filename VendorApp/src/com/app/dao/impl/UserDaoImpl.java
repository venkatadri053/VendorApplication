package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveUser(User user) {
		return (Integer)ht.save(user);
	}
	@Override
	public User getUserByNameAndPwd(String un, String pwd) {
		String hql="from "+User.class.getName()+
				" where (userEmail=? or userMobile=?) "+
				" and password=? ";
		List<User> userList=ht.find(hql,un,un,pwd);
		return userList!=null?userList.size()>0?userList.get(0):null:null; 
	}
}
