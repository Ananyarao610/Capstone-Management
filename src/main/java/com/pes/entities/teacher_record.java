package com.pes.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class teacher_record {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int asignBusRecordId;
	private String driverName;
	private String driverAddress;
	private String driverPhone;
	private Date asignDate;
	@OneToOne
	@JoinColumn(name = "Bus_id")
	private teach busId;
	@OneToOne
	@JoinColumn(name = "v_id")
	private pes_meet_stat vehicleConditionId;

	public teacher_record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public teacher_record(int asignBusRecordId, String driverName, String driverAddress, String driverPhone,
			Date asignDate, teach busId, pes_meet_stat vehicleConditionId) {
		super();
		this.asignBusRecordId = asignBusRecordId;
		this.driverName = driverName;
		this.driverAddress = driverAddress;
		this.driverPhone = driverPhone;
		this.asignDate = asignDate;
		this.busId = busId;
		this.vehicleConditionId = vehicleConditionId;
	}

	public int getAsignBusRecordId() {
		return asignBusRecordId;
	}

	public void setAsignBusRecordId(int asignBusRecordId) {
		this.asignBusRecordId = asignBusRecordId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverAddress() {
		return driverAddress;
	}

	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public Date getAsignDate() {
		return asignDate;
	}

	public void setAsignDate(Date asignDate) {
		this.asignDate = asignDate;
	}

	public teach getBusId() {
		return busId;
	}

	public void setBusId(teach busId) {
		this.busId = busId;
	}

	public pes_meet_stat getVehicleConditionId() {
		return vehicleConditionId;
	}

	public void setVehicleConditionId(pes_meet_stat vehicleConditionId) {
		this.vehicleConditionId = vehicleConditionId;
	}

	@Override
	public String toString() {
		return "AsignBusRecord [asignBusRecordId=" + asignBusRecordId + ", driverName=" + driverName
				+ ", driverAddress=" + driverAddress + ", driverPhone=" + driverPhone + ", asignDate=" + asignDate
				+ ", busId=" + busId + ", vehicleConditionId=" + vehicleConditionId + "]";
	}

}
