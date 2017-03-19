package com.test.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DtWork generated by hbm2java
 */
@Entity
@Table(name = "dt_work", catalog = "test")
public class Work implements java.io.Serializable {

	private Integer id;
	private int userId;
	private String work;
	private Date addTime;

	public Work() {
	}

	public Work(int userId, Date addTime) {
		this.userId = userId;
		this.addTime = addTime;
	}

	public Work(int userId, String work, Date addTime) {
		this.userId = userId;
		this.work = work;
		this.addTime = addTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "work", length = 500)
	public String getWork() {
		return this.work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "add_time", nullable = false, length = 19)
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}