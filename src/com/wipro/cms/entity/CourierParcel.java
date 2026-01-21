package com.wipro.cms.entity;

public class CourierParcel {
	private String parcelId;
	private String senderName;
	private String receiverName;
	private String agentId;
	private String status;
	
	public CourierParcel(String parcelId, String senderName, String receiverName, String agentId, String status) {
		this.parcelId = parcelId;
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.agentId = agentId;
		this.status = status;
	}

	public String getParcelId() {
		return parcelId;
	}

	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
