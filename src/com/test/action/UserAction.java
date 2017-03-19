package com.test.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.User;
import com.test.biz.UserBiz;
import com.test.util.PageBean;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private User user;
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private UserBiz userBiz;

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	private int page;
	private PageBean pageBean;

	
	//查询状态正常男性
	public String findMan() throws Exception {

		int num = this.userBiz.findMan();
		ActionContext.getContext().put("num", num);
		return "success";
	}
	//查询状态正常女性
	public String findWoman() throws Exception {

		int num = this.userBiz.findWoman();
		ActionContext.getContext().put("num", num);
		return "success";
	}
	//分页升序
	@SuppressWarnings("unchecked")
	public String getPageList() {
		this.pageBean = userBiz.queryForPage(2, page);
		userList = this.pageBean.getList();
		return "success";
	}
	//分页降序
	@SuppressWarnings("unchecked")
	public String getPageDesc() {
		this.pageBean = userBiz.queryForPageDesc(2, page);
		userList = this.pageBean.getList();
		return "success";
	}
	
	
	public String findByAsc() throws Exception {
		@SuppressWarnings("rawtypes")
		List list = this.userBiz.findByAsc();
		ActionContext.getContext().put("list", list);
		return "success";
	}

	public String findByDesc() throws Exception {
		@SuppressWarnings("rawtypes")
		List list = this.userBiz.findByDesc();
		ActionContext.getContext().put("list", list);
		return "success";
	}
}
