package com.mvc.dao;

import java.security.MessageDigest;
import java.sql.SQLException;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RegisterDao {
	

	public static String Encryption_sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	public String registerUser(RegisterBean rb) {
		String frstname = rb.getFname();
		String lstname = rb.getLname();
		String usrname = rb.getUname();
		String pswd = Encryption_sha256(rb.getPasswd());
		
		String r = rb.getRole();

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "insert into UserTable(f_name,l_name,u_name,passwd,role) values (?,?,?,?,?)"; 
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query); 
			
			preparedStatement.setString(1, frstname);
			preparedStatement.setString(2, lstname);
			preparedStatement.setString(3, usrname);
			preparedStatement.setString(4, pswd);
			preparedStatement.setString(5, r);

			int i = preparedStatement.executeUpdate();

			if (i != 0) 
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Oops.. Something went wrong ..!"; 
	}


}