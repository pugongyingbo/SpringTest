package com.test.biz.imp;

import java.util.List;

import com.test.bean.Work;
import com.test.biz.WorkBiz;
import com.test.dao.WorkDao;
import com.test.util.PageBean;

public class WorkBizImp implements WorkBiz {

	private WorkDao workDao;

	public WorkDao getWorkDao() {
		return workDao;
	}

	public void setWorkDao(WorkDao workDao) {
		this.workDao = workDao;
	}

	public List<Work> findByAsc() {
		return this.workDao.findByAsc();
	}

	public List<Work> findByDesc() {
		return this.workDao.findByDesc();
	}

	// 获得男性工作
	public int getManWork(int num) {
		return this.workDao.getManWork(num);
	}

	// 获得女性工作量
	public int getWomanWork(int num) {
		return this.workDao.getWomanWork(num);
	}

	// 按时间段查询
	public List<Work> queryWork(String start, String end) {
		return workDao.queryWork(start, end);
	}

	// 升序
	@Override
	public PageBean queryForPage(int pageSize, int page) {
		String hql = "select count(*) from Work";
		int count = workDao.getCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);

		List<Work> list = workDao.queryForPage("from Work order by id asc", offset, length); // 该分页的记录
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

	// 降序
	@Override
	public PageBean queryForPageDesc(int pageSize, int page) {
		String hql = "select count(*) from Work";
		int count = workDao.getCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);

		List<Work> list = workDao.queryForPage("from Work order by id desc", offset, length); // 该分页的记录
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

}
