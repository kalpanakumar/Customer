package com.data;

import java.util.HashMap;


import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class CustomerJDO {
	

	  //  @PrimaryKey
	  //  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 //   private Key key;

	    @Persistent
	    private String Name;
//	    @Persistent
//	    private String mobileNumber;
//	    
//	    @Persistent
//	    private String email;
//	    @Persistent
//	    private String[] email;
//	    @Persistent
//	    private String[] Label;
	    @Persistent
	    HashMap< String,String> mobileNumber;
	    public HashMap<String, String> getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(HashMap<String, String> mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		@Persistent
	    HashMap< String,String> email;
	    
	    public HashMap<String, String> getEmail() {
			return email;
		}
		public void setEmail(HashMap<String, String> email) {
			this.email = email;
		}

		@Persistent
	    private String Address; 
	    @Persistent
	   private String Id;
	    private String AccountEmail;
	  //getter and setter methods
	    
		public String getAccountEmail() {
			return AccountEmail;
		}

		public void setAccountEmail(String accountEmail) {
			AccountEmail = accountEmail;
		}

		public String getId() {
			return Id;
		}

		public void setId(String id) {
			Id = id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			this.Name = name;
		}

//		public String getMobileNumber() {
//			return mobileNumber;
//		}
//
//		public void setMobileNumber(String mobileNumber) {
//			this.mobileNumber = mobileNumber;
//		}

		
		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

//		public String[] getEmail() {
//			return email;
//		}
//
//		public void setEmail(String[] email) {
//			this.email = email;
//		}
//
//		public String[] getLabel() {
//			return Label;
//		}
//
//		public void setLabel(String[] label) {
//			Label = label;
//		}
	    
	}

	

	


