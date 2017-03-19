package com.test.dao;

import java.util.List;

import com.test.bean.User;
import com.test.bean.Work;
import com.test.util.PageBean;

public abstract interface WorkDao {

	public abstract List<Work> findByAsc();

	public abstract List<Work> findByDesc();

	// ��ҳ��ѯ
	public List<Work> queryForPage(String hql, int offset, int length);

	// �ܼ�¼����
	public int getCount(String hql);

	// ��ʱ��β�ѯ
	public List<Work> queryWork(String start, String end);

	// ��ȡ���Թ�����
	public int getManWork(int num);

	// ��ȡŮ�Թ�����
	public int getWomanWork(int num);

}
