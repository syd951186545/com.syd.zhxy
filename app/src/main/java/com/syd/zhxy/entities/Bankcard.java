package com.syd.zhxy.entities;

/**
 * Bankcard entity. @author MyEclipse Persistence Tools
 */

public class Bankcard implements java.io.Serializable {

	// Fields

	private String phoneNum;
	private String cardId;
	private Integer type;
	private String idCard;
	private String money;

	// Constructors

	/** default constructor */
	public Bankcard() {
	}

	/** full constructor */
	public Bankcard(String cardId, Integer type, String idCard, String money) {
		this.cardId = cardId;
		this.type = type;
		this.idCard = idCard;
		this.money = money;
	}

	// Property accessors

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

}