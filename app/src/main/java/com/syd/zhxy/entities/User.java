package com.syd.zhxy.entities;
// default package



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private String account;
     private String password;
     private String phoneNum;
     private String userName;
     private String token;


    // Constructors

    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(String phoneNum, String token) {
        this.phoneNum = phoneNum;
        this.token = token;
    }
    
    /** full constructor */
    public User(String account, String password, String phoneNum, String userName, String token) {
        this.account = account;
        this.password = password;
        this.phoneNum = phoneNum;
        this.userName = userName;
        this.token = token;
    }

   
    // Property accessors

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return this.account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }
    
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
   








}