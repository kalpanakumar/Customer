package com.data;
import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class LogInJDO {
	@Persistent
private String Password;
	@Persistent
private String Email;
	public String getPassword() {
		return Password;
	}
	public void setPassword(String userName) {
		Password = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}

