package com.wipro.cms.util;

public class ParcelOperationException extends Exception {
	public ParcelOperationException() {
		super("Parcel Operation error");
	}
	
	public ParcelOperationException(String message) {
		super(message);
	}
}
