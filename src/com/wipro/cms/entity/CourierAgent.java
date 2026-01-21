package com.wipro.cms.entity;

public class CourierAgent {
	
	private String agentId;
	private String name;
	private boolean active;
	
	public CourierAgent(String agentId, String name, boolean active) {
		this.agentId = agentId;
		this.name = name;
		this.active = active;
	}
	
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
