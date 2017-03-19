package com.test.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.Work;
import com.test.biz.WorkBiz;
import com.test.biz.imp.WorkBizImp;
import com.test.util.PageBean;

@SuppressWarnings("serial")
public class WorkAction extends ActionSupport {
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Work> getWorkList() {
		return workList;
	}

	public void setWorkList(List<Work> workList) {
		this.workList = workList;
	}

	private int page;
	private PageBean pageBean;

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	private List<Work> workList;
	private Work work;

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	private WorkBiz workBiz;

	public WorkBiz getWorkBiz() {
		return workBiz;
	}

	public void setWorkBiz(WorkBiz workBiz) {
		this.workBiz = workBiz;
	}

	// 分页
	@SuppressWarnings("unchecked")
	public String getPageList() {
		this.pageBean = workBiz.queryForPage(2, page);
		workList = this.pageBean.getList();
		return "success";
	}

	// 分页
	@SuppressWarnings("unchecked")
	public String getPageDesc() {
		this.pageBean = workBiz.queryForPageDesc(2, page);
		workList = this.pageBean.getList();
		return "success";
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	private String start;
	private String end;
	private List<Work> list;

	public List<Work> getList() {
		return list;
	}

	public void setList(List<Work> list) {
		this.list = list;
	}

	// 按时间段查询工作
	public String queryWork() throws Exception {

		list = workBiz.queryWork(start, end);
		return "success";
	}

	private int num;

	// 查询男女工作比率
	public String queryRate() {

		int manNum = workBiz.getManWork(num);
		int womanNum = workBiz.getWomanWork(num);
		float rate = manNum / womanNum;
		ActionContext.getContext().put("rate", rate);
		return "success";
	}

	public String findByAsc() throws Exception {
		@SuppressWarnings("rawtypes")
		List list = this.workBiz.findByAsc();
		ActionContext.getContext().put("list", list);
		return "success";
	}

	public String findByDesc() throws Exception {
		@SuppressWarnings("rawtypes")
		List list = this.workBiz.findByDesc();
		ActionContext.getContext().put("list", list);
		return "success";
	}
}
