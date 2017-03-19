package com.test.dao;

import java.util.List;

import com.test.bean.User;
import com.test.util.PageBean;

public abstract interface UserDao {

	public abstract List<User> findByAsc();

	public abstract List<User> findByDesc();

	
	//男性
	public abstract int findMan();
	//女性
	public abstract int findWoman();

	// 分页查询
	public List<User> queryForPage(String hql, int offset, int length);

	// 总记录条数
	public int getCount(String hql);

}
