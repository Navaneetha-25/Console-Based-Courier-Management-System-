package com.wipro.cms.util;

public class AgentNotFoundException extends Exception {
	
	    public AgentNotFoundException() {
	        super("Courier agent not found.");
	    }

	    public AgentNotFoundException(String message) {
	        super(message);
	    }

}
