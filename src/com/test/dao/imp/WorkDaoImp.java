package com.test.dao.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.test.bean.Work;
import com.test.dao.WorkDao;

public class WorkDaoImp extends HibernateDaoSupport implements WorkDao {

	// 分页
	@Override
	public List<Work> queryForPage(String hql, int offset, int length) {
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
	}

	@Override
	public int getCount(String hql) {
		Session session = this.getSession();
		Query q = session.createQuery(hql);

		return Integer.parseInt(q.list().get(0).toString());
	}

	// 男性工作量
	public int getManWork(int num) {
		String sql = "select w.id from dt_user as u,dt_work as w where u.status=1 and u.sex=0 and u.id=w.user_id";
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		num = query.list().size();
		return num;

	}

	// 女性工作量
	public int getWomanWork(int num) {
		String sql = "select w.id from dt_user as u,dt_work as w where u.status=1 and u.sex=1 and u.id=w.user_id";
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		num = query.list().size();
		return num;

	}

	// 按时间段查询
	@SuppressWarnings("unchecked")
	public List<Work> queryWork(String start, String end) {

		Date startTime = java.sql.Date.valueOf(start);
		Date endTime = java.sql.Date.valueOf(end);

		// String sql = "select * from dt_work where add_time between '" +
		// startTime + "' and '" + endTime + "'";
		String hql = "from Work as w where w.addTime between '" + startTime + "' and '" + endTime + "'";
		Session session = this.getSession();
		Query q = session.createQuery(hql);

		List<Work> list = new ArrayList<Work>();
		list = (List<Work>) q.list();

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Work> findByAsc() {
		Session session = this.getSession();
		Query query = session.createQuery("from Work order by id asc");
		List<Work> list = (List<Work>) query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Work> findByDesc() {
		Session session = this.getSession();
		Query query = session.createQuery("from Work order by id desc");
		List<Work> list = (List<Work>) query.list();
		return list;
	}
}
