package com.test.biz;

import java.util.List;

import com.test.bean.Work;
import com.test.util.PageBean;

public abstract interface WorkBiz {

	List<Work> findByAsc();

	List<Work> findByDesc();

	PageBean queryForPage(int i, int page);

	PageBean queryForPageDesc(int i, int page);

	// ��ʱ��β�ѯ
	List<Work> queryWork(String start, String end);

	// ������Թ�����
	int getManWork(int num);

	// ���Ů�Թ�����
	int getWomanWork(int num);
}
