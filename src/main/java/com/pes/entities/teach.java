package com.pes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class teach {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;
	private String busName;
	private String busNumber;
	private String busModel;
	private String busType;
	private int busSeat;
	private String route;
	private String asignStatus;
	@OneToOne(mappedBy = "busId")
	private teacher_record asignBusRecordId;

	public teach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public teach(int busId, String busName, String busNumber, String busModel, String busType, int busSeat,
			String route,
			String asignStatus, teacher_record asignBusRecordId) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.busNumber = busNumber;
		this.busModel = busModel;
		this.busType = busType;
		this.busSeat = busSeat;
		this.route = route;
		this.asignStatus = asignStatus;
		this.asignBusRecordId = asignBusRecordId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusModel() {
		return busModel;
	}

	public void setBusModel(String busModel) {
		this.busModel = busModel;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public int getBusSeat() {
		return busSeat;
	}

	public void setBusSeat(int busSeat) {
		this.busSeat = busSeat;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getAsignStatus() {
		return asignStatus;
	}

	public void setAsignStatus(String asignStatus) {
		this.asignStatus = asignStatus;
	}

	public teacher_record getAsignBusRecordId() {
		return asignBusRecordId;
	}

	public void setAsignBusRecordId(teacher_record asignBusRecordId) {
		this.asignBusRecordId = asignBusRecordId;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", busNumber=" + busNumber + ", busModel=" + busModel
				+ ", busType=" + busType + ", busSeat=" + busSeat + ", route=" + route + ", asignStatus=" + asignStatus
				+ ", asignBusRecordId=" + asignBusRecordId + "]";
	}

}
