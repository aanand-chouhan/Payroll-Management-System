
package com.vy.bo;

import java.io.InputStream;
import java.sql.Blob;

import lombok.Data;

@Data
	public class MembersBO {
		private int eNo;
		private String name;
		private String fName;
		private String desg;
		private String role;
		private String addrs;
		private String mobileNo;
		private String email;
		private String pwd;
		private String gender;
		private float sal;
		private java.sql.Date dob;
		private java.sql.Date doj;
		private String panNo;
		private String adharNo;
		private String uan;
		private String qualification;
		private String imagePath;
		private InputStream image;
		private String docName;
		private String imageName;
		private String memberID;
	}


