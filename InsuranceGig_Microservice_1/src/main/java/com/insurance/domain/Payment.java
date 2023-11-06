package com.insurance.domain;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long paymentId;
	private double amount;
	//private Date insuranceStateDate;
	//private Date insuranceEndDate;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private LocalDate submittedDate;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private LocalDate scheduledDate;
	//private String status;
	private String paymentMethod;
	private String bankAccountNo;
	private String routingNo;
	private String accountType;
	private String cardNo;
	private String expiryDate;
	private String cvv;
	private String nameOnCard;
	private String nameOnAccount;
	private String username;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "addressId")
	//@Embedded
	//private Address billingAddress;
	
	public Payment() {
		super();
	}

	public Payment(Long paymentId, double amount, LocalDate submittedDate, LocalDate scheduledDate,
			String paymentMethod, String bankAccountNo, String routingNo, String accountType, String cardNo,
			String expiryDate, String cvv, String nameOnCard, String nameOnAccount, String username) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.submittedDate = submittedDate;
		this.scheduledDate = scheduledDate;
		this.paymentMethod = paymentMethod;
		this.bankAccountNo = bankAccountNo;
		this.routingNo = routingNo;
		this.accountType = accountType;
		this.cardNo = cardNo;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.nameOnCard = nameOnCard;
		this.nameOnAccount = nameOnAccount;
		this.username = username;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(LocalDate submittedDate) {
		this.submittedDate = submittedDate;
	}

	public LocalDate getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getRoutingNo() {
		return routingNo;
	}

	public void setRoutingNo(String routingNo) {
		this.routingNo = routingNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getNameOnAccount() {
		return nameOnAccount;
	}

	public void setNameOnAccount(String nameOnAccount) {
		this.nameOnAccount = nameOnAccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
