package com.test.dao;

import java.util.List;

import com.test.bean.User;
import com.test.util.PageBean;

public abstract interface UserDao {

	public abstract List<User> findByAsc();

	public abstract List<User> findByDesc();

	
	//����
	public abstract int findMan();
	//Ů��
	public abstract int findWoman();

	// ��ҳ��ѯ
	public List<User> queryForPage(String hql, int offset, int length);

	// �ܼ�¼����
	public int getCount(String hql);

}
