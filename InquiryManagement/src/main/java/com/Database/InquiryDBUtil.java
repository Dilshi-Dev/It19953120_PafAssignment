package com.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Inquiry.Inquiry;

public class InquiryDBUtil {

	private static String jdbcURL= "jdbc:mysql://localhost:3306/inquiry_management?useSSL=false";
	private static String jdbcUser = "root";
	private static String jdbcPassword = "1234";
	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_INQUIRY_SQL = "INSERT INTO cus" + " (code,cusID,cusName,eleAccNo,address,email,contact,type,massage,status,password) values" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_INQUIRY_BY_ID = "select code,cusID,cusName,eleAccNo,address,email,contact,type,massage,status,password from cus where code =?";
	private static final String SELECT_ALL_INQUIRY = "select * from cus";
	private static final String DELETE_INQUIRY_SQL = "delete from cus where code = ?;";
	private static final String UPDATE_INQUIRY_SQL = "update cus set cusID = ?,cusName = ?,eleAccNo = ?,address = ?,email = ?,contact = ?,type = ?,massage = ?,status = ?,password = ? where code = ?;";
	
	
	public InquiryDBUtil() {
		
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("jdbcDriver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPassword);
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	
	
	// Insert Inquiry
	public void insertInquiry(Inquiry inquiry) {
		System.out.println(INSERT_INQUIRY_SQL);
		try(Connection connection = getConnection();
		PreparedStatement preparedStatment = connection.prepareStatement(INSERT_INQUIRY_SQL)){
			 
			 
			 preparedStatment.setString(2, inquiry.getCusID());
			 preparedStatment.setString(2, inquiry.getCusName());
			 preparedStatment.setString(3, inquiry.getEleAccNo());
			 preparedStatment.setString(4, inquiry.getAddress());
			 preparedStatment.setString(5, inquiry.getEmail());
			 preparedStatment.setString(6, inquiry.getContact());
			 preparedStatment.setString(7, inquiry.getType());
			 preparedStatment.setString(8, inquiry.getMassage());
			 preparedStatment.setString(9, inquiry.getStatus());
			 preparedStatment.setString(10, inquiry.getPassword());
			 System.out.println(preparedStatment);
			 preparedStatment.executeUpdate();
		}catch (SQLException e) {
			
			printSQLException (e);
		}
		
		
	}

	
	
	// View Inquiry By Code
	
	public Inquiry selectInquiry(int code) {
		Inquiry inquiry = null;
		//Step 1: Establishing a Connection
		try(Connection connection = getConnection();
				// Step2: create a statement using connection object
				PreparedStatement preparedStatment = connection.prepareStatement(SELECT_INQUIRY_BY_ID);){
			preparedStatment.setInt(1, code);
			System.out.println(preparedStatment);
			// Step 3: Execute the quiry or update Quiry
			ResultSet rs = preparedStatment.executeQuery();
			
			// step4: process the result set object
			while (rs.next()) {
				String cusID = rs.getString("cusID");
				String cusName = rs.getString("cusName");
				String eleAccNo = rs.getString("eleAccNo");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String contact = rs.getString("contact");
				String type = rs.getString("type");
				String massage = rs.getString("massage");
				String status = rs.getString("status");
				String password = rs.getString("password");
				inquiry = new Inquiry (cusID,cusName,eleAccNo,address,email,contact,type,massage,status,password);
				
				
			}
			
			
			
		}catch (SQLException e)	{
			printSQLException (e);
			
		}
		
		return inquiry;
	}
	
	// View all Inquiry
	
	public List<Inquiry> selectAll(){
		List <Inquiry> inquiry = new ArrayList<>();
		// step1: estabilish a connection
		try(Connection connection = getConnection();
				// step2: create statment
				PreparedStatement preparedStatment = connection.prepareStatement(SELECT_ALL_INQUIRY );){
			    System.out.print( preparedStatment);
			    // step3: execute the quiry
			    ResultSet rs = preparedStatment.executeQuery();
			    
			    //step4: process the Resuleset
			    
			    while (rs.next()) {
			    	int code =rs.getInt("code");
			    	String cusID = rs.getString("cusID");
					String cusName = rs.getString("cusName");
					String eleAccNo = rs.getString("eleAccNo");
					String address = rs.getString("address");
					String email = rs.getString("email");
					String contact = rs.getString("contact");
					String type = rs.getString("type");
					String massage = rs.getString("massage");
					String status = rs.getString("status");
					String password = rs.getString("password");
					inquiry.add ( new Inquiry (code,cusID,cusName,eleAccNo,address,email,contact,type,massage,status,password));
					
					
					
			    	
			    }
			    
			
		}catch (SQLException e)	{
			printSQLException (e);
			
		}
		return inquiry;
		
	}
	
	
	
	
	
	// Update Inquiry
	public boolean updateInquiry(Inquiry inquiry)throws SQLException{
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statment = connection.prepareStatement(UPDATE_INQUIRY_SQL);){
			System.out.println("update Inquiry:"+statment );
			 statment.setInt(1,inquiry.getCode());
			 statment.setString(2,inquiry.getCusID()); 
			 statment.setString(3,inquiry.getCusName());
			 statment.setString(4,inquiry.getEleAccNo());
			 statment.setString(5,inquiry.getAddress());
			 statment.setString(6,inquiry.getEmail());
			 statment.setString(7,inquiry.getContact());
			 statment.setString(8,inquiry.getType());
			 statment.setString(9,inquiry.getMassage());
			 statment.setString(10,inquiry.getStatus());
			 statment.setString(11,inquiry.getPassword());
			 
			 
			 rowUpdated =  statment.executeUpdate() > 0;
		}
		return  rowUpdated;
	}
	
	
	// Delete Inquiry
	
	public boolean deleteUser(int code)throws SQLException {
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statment = connection.prepareStatement( DELETE_INQUIRY_SQL);){
			 statment.setInt(1, code);
			 rowDeleted =  statment.executeUpdate() > 0;
			
		}
		return rowDeleted ;
	}
	
	
	private void printSQLException(SQLException ex) {
		for(Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException)e).getSQLState());
				System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
				System.err.println("Massage: " + e.getMessage());
				Throwable t = ex.getCause();
				while( t != null) {
					System.out.println("Case: " + t);
					t = t.getCause();
					
				}
			}
			
		}
		
	}
	
	
	
}
