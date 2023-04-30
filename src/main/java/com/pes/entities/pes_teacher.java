package com.pes.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class pes_teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int amount;
	private Date date;
	@Column(length = 1000)
	private String partsInfoDetailed;
	@OneToOne
	private teach busId;

	public pes_teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pes_teacher(int id, int amount, Date date, String partsInfoDetailed, teach busId) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.partsInfoDetailed = partsInfoDetailed;
		this.busId = busId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPartsInfoDetailed() {
		return partsInfoDetailed;
	}

	public void setPartsInfoDetailed(String partsInfoDetailed) {
		this.partsInfoDetailed = partsInfoDetailed;
	}

	public teach getBusId() {
		return busId;
	}

	public void setBusId(teach busId) {
		this.busId = busId;
	}

	@Override
	public String toString() {
		return "BusMaintenance [id=" + id + ", amount=" + amount + ", date=" + date + ", partsInfoDetailed="
				+ partsInfoDetailed + ", busid=" + busId + "]";
	}

}
