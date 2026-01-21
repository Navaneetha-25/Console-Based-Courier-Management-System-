package com.wipro.cms.entity;

public class ParcelUpdate {
	private String updateId;
	private String parcelId;
	private String date;
	private String notes;
		
	public ParcelUpdate(String updateId, String parcelId, String date, String notes) {
		super();
		this.updateId = updateId;
		this.parcelId = parcelId;
		this.date = date;
		this.notes = notes;
	}
	
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getParcelId() {
		return parcelId;
	}
	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	
}
