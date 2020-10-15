package com.jesperapps.api.utils;

public class StatusFolder {
	public static String ACTIVE="Active";
	public static String DELETED = "Deleted";
	public static String INACTIVE = "InActive";
	
	public static String getStatus(String status) {
		if(StatusFolder.INACTIVE.toLowerCase().equalsIgnoreCase(status.toLowerCase())) {
			return StatusFolder.INACTIVE;
		}else {
			return StatusFolder.ACTIVE;
		}
	}

}
