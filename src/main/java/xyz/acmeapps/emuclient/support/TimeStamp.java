package xyz.acmeapps.emuclient.support;

import java.sql.Timestamp;

public class TimeStamp {
	
	public Timestamp getTime(){
		
		
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		System.out.println(date);
		return date;
		
	}

}
