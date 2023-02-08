package com.userManagmentSystem.User;

public class User {

	private int userId;
	private String name;
	private String userName;
	private String addrees;
	private String number;//"Pratham","PrathamWate","Paratwada","884776993"
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String name, String userName, String addrees, String number) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.addrees = addrees;
		this.number = number;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddrees() {
		return addrees;
	}

	public void setAddrees(String addrees) {
		this.addrees = addrees;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
	
}
