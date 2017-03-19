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

	// ��������
	@Override
	public int findMan() {
		return this.userDao.findMan();
	}

	// ����Ů��
	@Override
	public int findWoman() {
		return this.userDao.findWoman();
	}

	// �����ҳ
	@Override
	public PageBean queryForPage(int pageSize, int page) {
		String hql = "select count(*) from User";
		int count = userDao.getCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, count); // ��ҳ��
		int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		int length = pageSize; // ÿҳ��¼��
		int currentPage = PageBean.countCurrentPage(page);

		List<User> list = userDao.queryForPage("from User order by id asc", offset, length); // �÷�ҳ�ļ�¼
		// �ѷ�ҳ��Ϣ���浽Bean��
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	// �����ҳ
	@Override
	public PageBean queryForPageDesc(int pageSize, int page) {
		String hql = "select count(*) from User";
		int count = userDao.getCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, count); // ��ҳ��
		int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		int length = pageSize; // ÿҳ��¼��
		int currentPage = PageBean.countCurrentPage(page);

		List<User> list = userDao.queryForPage("from User order by id desc", offset, length); // �÷�ҳ�ļ�¼
		// �ѷ�ҳ��Ϣ���浽Bean��
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
