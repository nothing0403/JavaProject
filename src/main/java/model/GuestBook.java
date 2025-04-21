package model;

import java.util.Date;

public class GuestBook {

	private String userName;
	private String message;
	private Date date;
	
	public GuestBook(String userName, String message) {
		this.userName = userName;
		this.message = message;
		this.date = new Date();
	}

	public String toString() {
		return userName+":"+message+date;
	}

	public String getUserName() {
		return userName;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}
	
}
