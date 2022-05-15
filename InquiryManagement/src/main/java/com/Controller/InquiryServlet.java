package com.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.InquiryDBUtil;
import com.Inquiry.Inquiry;

/**
 * Servlet implementation class InquiryServlet
 */
@WebServlet("/")
public class InquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private InquiryDBUtil inquiryDBUtil;
    

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		inquiryDBUtil = new InquiryDBUtil();
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertInquiry(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		case "/edit":
			showEditform(request, response);
			break;
		case "/update":
			try {
				updateInqiry(request, response);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default:
			try {
				ListInquiry(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
		
		}
		
		
		
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = request.getRequestDispatcher("user-form.jsp");
		dis.forward(request, response);
		}
	
	// insert user handel
	private void insertInquiry (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String cusID = request.getParameter("cusID");
		String cusName = request.getParameter("cusName");
		String eleAccNo = request.getParameter("eleAccNo");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String type = request.getParameter("type");
		String massage = request.getParameter("massage");
		String status = request.getParameter("status");
		String password = request.getParameter("password");
		Inquiry newInquiry = new Inquiry(cusID,cusName,eleAccNo,address,email,contact,type,massage,status,password);
		
		
		inquiryDBUtil.insertInquiry(newInquiry);
		response.sendRedirect("List");
		
		
	}
 // delete user
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		int code = Integer.parseInt(request.getParameter("code"));
		try {
			inquiryDBUtil.deleteUser(code);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("List");
	}
	
	
	
	//edit
	private void showEditform(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("code"));
		
		Inquiry existingInquiry = null;
		try {
		RequestDispatcher dis = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("inquiry",existingInquiry);
		dis.forward(request, response);}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
	
	
	
	}
	
	
	
	//update
	
	private void updateInqiry (HttpServletRequest request, HttpServletResponse response) throws  IOException, SQLException{
		
		int code = Integer.parseInt(request.getParameter("code"));
		String cusID = request.getParameter("cusID");
		String cusName = request.getParameter("cusName");
		String eleAccNo = request.getParameter("eleAccNo");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String type = request.getParameter("type");
		String massage = request.getParameter("massage");
		String status = request.getParameter("status");
		String password = request.getParameter("password");
		
		Inquiry inquiry = new Inquiry (cusID,cusName,eleAccNo,address,email,contact,type,massage,status,password);
		inquiryDBUtil.updateInquiry(inquiry);
		response.sendRedirect("List");
		
	}
	
	
	
	
	// default
	
	
	private void ListInquiry (HttpServletRequest request, HttpServletResponse response) throws  SQLException,ServletException, IOException{
		try {
			List<Inquiry> listInquiry = inquiryDBUtil.selectAll();
			request.setAttribute("listInquiry ", listInquiry);
			RequestDispatcher dis = request.getRequestDispatcher("user-list.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
