package com.insurance.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paymentInfoId;
	private String nameOnCard;
	private String cardNo;
	private Date expirationDate;
	private String cvv;
	private String nameOnAccount;
	private String accountType;
	private String routingNo;
	private String accountNo;
	
	private String username;
	
	public PaymentInfo() {
		super();
	}

	public PaymentInfo(int paymentInfoId, String nameOnCard, String cardNo, Date expirationDate, String cvv,
			String nameOnAccount, String accountType, String routingNo, String accountNo, String username) {
		super();
		this.paymentInfoId = paymentInfoId;
		this.nameOnCard = nameOnCard;
		this.cardNo = cardNo;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.nameOnAccount = nameOnAccount;
		this.accountType = accountType;
		this.routingNo = routingNo;
		this.accountNo = accountNo;
		this.username = username;
	}

	public int getPaymentInfoId() {
		return paymentInfoId;
	}

	public void setPaymentInfoId(int paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getNameOnAccount() {
		return nameOnAccount;
	}

	public void setNameOnAccount(String nameOnAccount) {
		this.nameOnAccount = nameOnAccount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getRoutingNo() {
		return routingNo;
	}

	public void setRoutingNo(String routingNo) {
		this.routingNo = routingNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
