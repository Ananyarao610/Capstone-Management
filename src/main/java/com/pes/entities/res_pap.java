package com.pes.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class res_pap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String status;
	private Date issueDate;
	private Date returnDate;
	@OneToOne
	private research_paper bookId;
	@OneToOne
	private Students studentsId;

	public res_pap() {
		super();
		
	}

	public res_pap(int id, String status, Date issueDate, Date returnDate, research_paper bookId, Students studentsId) {
		super();
		this.id = id;
		this.status = status;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.bookId = bookId;
		this.studentsId = studentsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public research_paper getBookId() {
		return bookId;
	}

	public void setBookId(research_paper bookId) {
		this.bookId = bookId;
	}

	public Students getStudentsId() {
		return studentsId;
	}

	public void setStudentsId(Students studentsId) {
		this.studentsId = studentsId;
	}

	@Override
	public String toString() {
		return "BookIssued [id=" + id + ", status=" + status + ", issueDate=" + issueDate + ", returnDate=" + returnDate
				+ ", bookId=" + bookId + ", studentsId=" + studentsId + "]";
	}

}
