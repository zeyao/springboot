package com.example.demo.entity;


public class User {

    private String id;
    
    private String userName;

    private String email;
    

    public User(String id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
    } 
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
    }
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
    }
    
    @Override
    public String toString() {
        return "[" + id + ", " + userName + ", " + email + "]";
    }

}