package com.test.biz.imp;

import java.util.List;

import com.test.bean.User;
import com.test.biz.UserBiz;
import com.test.dao.UserDao;
import com.test.util.PageBean;

public class UserBizImp implements UserBiz {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 正常男性
	@Override
	public int findMan() {
		return this.userDao.findMan();
	}

	// 正常女性
	@Override
	public int findWoman() {
		return this.userDao.findWoman();
	}

	// 升序分页
	@Override
	public PageBean queryForPage(int pageSize, int page) {
		String hql = "select count(*) from User";
		int count = userDao.getCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);

		List<User> list = userDao.queryForPage("from User order by id asc", offset, length); // 该分页的记录
		// 把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	// 降序分页
	@Override
	public PageBean queryForPageDesc(int pageSize, int page) {
		String hql = "select count(*) from User";
		int count = userDao.getCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);

		List<User> list = userDao.queryForPage("from User order by id desc", offset, length); // 该分页的记录
		// 把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	public List<User> findByAsc() {
		return this.userDao.findByAsc();
	}

	public List<User> findByDesc() {
		return this.userDao.findByDesc();
	}

}
