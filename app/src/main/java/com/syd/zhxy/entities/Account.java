package com.syd.zhxy.entities;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer accountId;
	private Integer accountNum;
	private String accountPass;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(Integer accountNum, String accountPass) {
		this.accountNum = accountNum;
		this.accountPass = accountPass;
	}

	// Property accessors

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getAccountNum() {
		return this.accountNum;
	}

	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountPass() {
		return this.accountPass;
	}

	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}

}