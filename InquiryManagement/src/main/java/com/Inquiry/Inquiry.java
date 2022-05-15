package com.Inquiry;

public class Inquiry {
	
	private int code;
	private String cusID;
	private String cusName;
	private String eleAccNo;
	private String address;
	private String email;
	private String contact;
	private String type;
	private String massage;
	private String status;
	private String password;
	
	
	
	public Inquiry(String cusID, String cusName, String eleAccNo, String address, String email, String contact,
			String type, String massage, String status, String password) {
		this.cusID = cusID;
		this.cusName = cusName;
		this.eleAccNo = eleAccNo;
		this.address = address;
		this.email = email;
		this.contact = contact;
		this.type = type;
		this.massage = massage;
		this.status = status;
		this.password = password;
	}
	public Inquiry(int code, String cusID, String cusName, String eleAccNo, String address, String email, String contact,
			String type, String massage, String status, String password) {
		this.code = code;
		this.cusID = cusID;
		this.cusName = cusName;
		this.eleAccNo = eleAccNo;
		this.address = address;
		this.email = email;
		this.contact = contact;
		this.type = type;
		this.massage = massage;
		this.status = status;
		this.password = password;
	}
	public int getCode() {
		return code;
	}
	public String getCusID() {
		return cusID;
	}
	public String getCusName() {
		return cusName;
	}
	public String getEleAccNo() {
		return eleAccNo;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getContact() {
		return contact;
	}
	public String getType() {
		return type;
	}
	public String getMassage() {
		return massage;
	}
	public String getStatus() {
		return status;
	}
	public String getPassword() {
		return password;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setCusID(String cusID) {
		this.cusID = cusID;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public void setEleAccNo(String eleAccNo) {
		this.eleAccNo = eleAccNo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
