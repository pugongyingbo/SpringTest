package com.test.biz;

import java.util.List;

import com.test.bean.User;
import com.test.util.PageBean;

public abstract interface UserBiz {

	List<User> findByAsc();

	List<User> findByDesc();

	// 正常男性
	int findMan();

	// 正常 女性
	int findWoman();

	// 升序分页
	PageBean queryForPage(int pageSize, int page);

	// 降序分页
	PageBean queryForPageDesc(int pageSize, int page);
}