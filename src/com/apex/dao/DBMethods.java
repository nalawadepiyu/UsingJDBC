package com.apex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.apex.vo.BankInfoBean;
import com.apex.vo.ContactInfoBean;
import com.apex.vo.PersonalInfoBean;


public class DBMethods {
	Connection con = null;
	
	DBConnection dbConnection = new DBConnection();
	
	public int insertData(HttpSession hs) throws Exception
	{
		PersonalInfoBean personalInfoBean = (PersonalInfoBean) hs.getAttribute("personalinfo");
		ContactInfoBean contactInfoBean = (ContactInfoBean) hs.getAttribute("contactinfo");
		BankInfoBean bankInfoBean =  (BankInfoBean) hs.getAttribute("bankinfo");
		
		PreparedStatement ps = null;
		
		int rowsInserted = 0;
		try{
		
		con = dbConnection.getConnection();
		
		String query = "insert into Person(firstName, middleName, lastName,street,city, state, country, bankname, accountnumber, ssn) values (?,?,?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(query);
		ps.setString(1,  personalInfoBean.getFirstname());
		ps.setString(2,  personalInfoBean.getMiddlename());
		ps.setString(3,  personalInfoBean.getLastname());
		
		ps.setString(4, contactInfoBean.getStreet());
		ps.setString(5, contactInfoBean.getCity());
		ps.setString(6, contactInfoBean.getState());
		ps.setString(7, contactInfoBean.getCountry());
		
		ps.setString(8, bankInfoBean.getBankname());
		ps.setString(9, bankInfoBean.getAccountnumber());
		ps.setString(10, bankInfoBean.getSsn());
		
		rowsInserted = ps.executeUpdate();

		if (rowsInserted != 1) {
			throw new Exception("Error in inserting the row");

   		}   
		
		con.close();
		}
         catch(Exception e) {
		   e.printStackTrace();	
		   throw e;
		}
		
		return rowsInserted;	
		
	}

}
