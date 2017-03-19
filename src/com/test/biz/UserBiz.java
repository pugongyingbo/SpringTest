package com.test.biz;

import java.util.List;

import com.test.bean.User;
import com.test.util.PageBean;

public abstract interface UserBiz {

	List<User> findByAsc();

	List<User> findByDesc();

	// ��������
	int findMan();

	// ���� Ů��
	int findWoman();

	// �����ҳ
	PageBean queryForPage(int pageSize, int page);

	// �����ҳ
	PageBean queryForPageDesc(int pageSize, int page);
}