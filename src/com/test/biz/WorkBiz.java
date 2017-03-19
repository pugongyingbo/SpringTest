package com.test.biz;

import java.util.List;

import com.test.bean.Work;
import com.test.util.PageBean;

public abstract interface WorkBiz {

	List<Work> findByAsc();

	List<Work> findByDesc();

	PageBean queryForPage(int i, int page);

	PageBean queryForPageDesc(int i, int page);

	// 按时间段查询
	List<Work> queryWork(String start, String end);

	// 获得男性工作量
	int getManWork(int num);

	// 获得女性工作量
	int getWomanWork(int num);
}
