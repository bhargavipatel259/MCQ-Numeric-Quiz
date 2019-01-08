package com.mvc.bean;

public class LoginBean {
	public static String uname;
	public static String passwd;

	public static String getusername() {
		return uname;
	}

	public void setusername(String username) {
		LoginBean.uname = username;
	}

	public static String getpasswd() {
		return passwd;
	}

	public void setpassword(String password) {
		LoginBean.passwd = password;
	}

}
