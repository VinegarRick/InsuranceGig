package com.insurance.domain;

import java.util.Date;

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
	private int paymentId;
	private double amount;
	private Date insuranceStateDate;
	private Date insuranceEndDate;
	private Date payDate;
	private String status;
	private String paymentMethod;
	private String bankAccountNo;
	private String routingNo;
	private String accountType;
	private String cardNo;
	private String expiryDate;
	private String cvv;
	private String nameOnCard;
	private String nameOnAccount;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "addressId")
	@Embedded
	private Address billingAddress;
	
	public Payment() {
		super();
	}

	public Payment(int paymentId, double amount, Date insuranceStateDate, Date insuranceEndDate, Date payDate,
			String status, String paymentMethod, String bankAccountNo, String routingNo, String accountType,
			String cardNo, String expiryDate, String cvv, String nameOnCard, String nameOnAccount,
			Address billingAddress) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.insuranceStateDate = insuranceStateDate;
		this.insuranceEndDate = insuranceEndDate;
		this.payDate = payDate;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.bankAccountNo = bankAccountNo;
		this.routingNo = routingNo;
		this.accountType = accountType;
		this.cardNo = cardNo;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.nameOnCard = nameOnCard;
		this.nameOnAccount = nameOnAccount;
		this.billingAddress = billingAddress;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getInsuranceStateDate() {
		return insuranceStateDate;
	}

	public void setInsuranceStateDate(Date insuranceStateDate) {
		this.insuranceStateDate = insuranceStateDate;
	}

	public Date getInsuranceEndDate() {
		return insuranceEndDate;
	}

	public void setInsuranceEndDate(Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	
	
}
