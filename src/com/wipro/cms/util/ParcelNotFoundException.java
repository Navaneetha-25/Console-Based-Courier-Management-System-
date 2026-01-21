package com.wipro.cms.util;

public class ParcelNotFoundException extends Exception{
	    public ParcelNotFoundException() {
	        super("Parcel not found.");
	    }

	    public ParcelNotFoundException(String message) {
	        super(message);
	    }
}
