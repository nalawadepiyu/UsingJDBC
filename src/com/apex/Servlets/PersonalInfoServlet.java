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
import com.apex.vo.PersonalInfoBean;

/**
 * Servlet implementation class PersonalInfoServlet
 */
@WebServlet("/PersonalInfoServlet")
public class PersonalInfoServlet extends HttpServlet {
	
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonalInfoBean personalInfoBean = new PersonalInfoBean();
		
		StringBuffer error = new StringBuffer();
		
		String firstname =  request.getParameter("firstname");
		String middlename = request.getParameter("middlename");
		String lastname = request.getParameter("lastname");
		
		personalInfoBean.setFirstname(firstname);
		personalInfoBean.setMiddlename(middlename);
		personalInfoBean.setLastname(lastname);
		
		if(firstname == null || firstname.trim().length() == 0){
			error.append("<br> Please enter FirstName");
		}
		
		if(middlename == null || middlename.trim().length() == 0){
			error.append("<br> Please enter Middle Name");
		}
		
		if(lastname == null || lastname.trim().length() == 0){
			error.append("<br> Please enter Last Name");
		}
		
		if(error.length() == 0){
			HttpSession session = request.getSession();
			session.setAttribute("personalinfo", personalInfoBean);
			response.sendRedirect("jsp/contactinfo.jsp");
		}
		
		else{
			request.setAttribute("error", error.toString());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/personalinfo.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
