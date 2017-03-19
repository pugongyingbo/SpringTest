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

	// ������Թ���
	public int getManWork(int num) {
		return this.workDao.getManWork(num);
	}

	// ���Ů�Թ�����
	public int getWomanWork(int num) {
		return this.workDao.getWomanWork(num);
	}

	// ��ʱ��β�ѯ
	public List<Work> queryWork(String start, String end) {
		return workDao.queryWork(start, end);
	}

	// ����
	@Override
	public PageBean queryForPage(int pageSize, int page) {
		String hql = "select count(*) from Work";
		int count = workDao.getCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, count); // ��ҳ��
		int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		int length = pageSize; // ÿҳ��¼��
		int currentPage = PageBean.countCurrentPage(page);

		List<Work> list = workDao.queryForPage("from Work order by id asc", offset, length); // �÷�ҳ�ļ�¼
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

	// ����
	@Override
	public PageBean queryForPageDesc(int pageSize, int page) {
		String hql = "select count(*) from Work";
		int count = workDao.getCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, count); // ��ҳ��
		int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		int length = pageSize; // ÿҳ��¼��
		int currentPage = PageBean.countCurrentPage(page);

		List<Work> list = workDao.queryForPage("from Work order by id desc", offset, length); // �÷�ҳ�ļ�¼
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

}
