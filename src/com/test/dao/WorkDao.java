package com.test.dao;

import java.util.List;

import com.test.bean.User;
import com.test.bean.Work;
import com.test.util.PageBean;

public abstract interface WorkDao {

	public abstract List<Work> findByAsc();

	public abstract List<Work> findByDesc();

	// 分页查询
	public List<Work> queryForPage(String hql, int offset, int length);

	// 总记录条数
	public int getCount(String hql);

	// 按时间段查询
	public List<Work> queryWork(String start, String end);

	// 获取男性工作量
	public int getManWork(int num);

	// 获取女性工作量
	public int getWomanWork(int num);

}
