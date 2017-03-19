package com.test.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.util.PageBean;

public class UserDaoImp extends HibernateDaoSupport implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByAsc() {
		Session session = this.getSession();
		Query query = session.createQuery("from User order by id asc");

		List<User> list = (List<User>) query.list();
		return list;
	}

	@Override
	public List<User> findByDesc() {
		Session session = this.getSession();
		Query query = session.createQuery("from User order by id desc");
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		return list;
	}
	
	@Override
	public int findMan() {

		Session session = this.getSession();
		Query query = session.createQuery("select count(*) from User as u where u.status = 1 and u.sex = 0");

		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public int findWoman() {
		Session session = this.getSession();

		Query query = session.createQuery("select count(*) from User as u where u.status = 1 and u.sex = 1");

		return ((Long) query.uniqueResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryForPage(String hql, int offset, int length) {
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<User> list = (List<User>) q.list();
		return list;
	}

	@Override
	public int getCount(String hql) {
		Session session = this.getSession();

		Query q = session.createQuery(hql);

		return Integer.parseInt(q.list().get(0).toString());
	}

}
