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
import com.apex.vo.ContactInfoBean;

/**
 * Servlet implementation class ContactInfo
 */
@WebServlet("/ContactInfo")
public class ContactInfoServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactInfoBean contactInfoBean = new ContactInfoBean();
		
		StringBuffer error = new StringBuffer();
		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		
		contactInfoBean.setStreet(street);
		contactInfoBean.setCity(city);
		contactInfoBean.setState(state);
		contactInfoBean.setCountry(country);
		
		if(street == null || street.trim().length() == 0){
			error.append("<br> Please enter street");
		}
		
		if(city == null || city.trim().length() == 0){
			error.append("<br> Please enter city Name");
		}
		
		if(state == null || state.trim().length() == 0){
			error.append("<br> Please enter state Name");
		}
		
		if(country == null || country.trim().length() == 0){
			error.append("<br> Please enter country Name");
		}
		
				
		if(error.length() == 0){
			HttpSession session = request.getSession();
			session.setAttribute("contactinfo", contactInfoBean);			
			response.sendRedirect("jsp/bankinfo.jsp");
		}
		else{
			request.setAttribute("error", error.toString());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/contactinfo.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
	}

}
