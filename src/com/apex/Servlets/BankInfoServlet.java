package com.apex.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apex.dao.DBMethods;
import com.apex.vo.BankInfoBean;

/**
 * Servlet implementation class BankInfoServlet
 */
@WebServlet("/BankInfoServlet")
public class BankInfoServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BankInfoBean bankInfoBean =  new BankInfoBean();
		
		StringBuffer error = new StringBuffer();
		
		
		String bankname = (String) request.getParameter("bankname");
		String accountnumber = (String) request.getParameter("accountnumber");
		String ssn = (String) request.getParameter("ssn");
		
		bankInfoBean.setBankname(bankname);
		bankInfoBean.setAccountnumber(accountnumber);
		bankInfoBean.setSsn(ssn);
		
		
		if(bankname == null || bankname.trim().length() == 0){
			error.append("<br> Please enter bankname");
		}
		
		if(accountnumber == null || accountnumber.trim().length() == 0){
			error.append("<br> Please enter accountnumber");
		}
		
		if(ssn == null || ssn.trim().length() == 0){
			error.append("<br> Please enter ssn");
		}
		System.out.println("error"+error.toString());
		String error2=error.toString();
				
		if(error2.length() == 0){
			HttpSession session = request.getSession();
			session.setAttribute("bankinfo", bankInfoBean);
			
			//DB
			
	DBMethods dBMethods = new DBMethods();
	int i = 0;
		try{
			
				i = dBMethods.insertData(session);				
			}
			catch(SQLException ex){
				ex.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("Row Affedted : " +i);
			
			//request.getRequestDispatcher("page2.jsp").forward();
			
			response.sendRedirect("jsp/success.jsp");
			
		}
		else{
			request.setAttribute("error", error.toString());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bankinfo.jsp");
			rd.forward(request, response);
		}
//		
		
	}

}
