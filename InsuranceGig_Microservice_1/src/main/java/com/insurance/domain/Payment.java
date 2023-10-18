package com.insurance.domain;

import java.util.Date;

import jakarta.persistence.CascadeType;
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
	private String cardNo;
	private String expiryDate;
	private String cvv;
	private String nameOnCard;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address billingAddress;
	
	public Payment() {
		super();
	}
	public Payment(int paymentId, double amount, Date insuranceStateDate, Date insuranceEndDate, Date payDate,
			String status) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.insuranceStateDate = insuranceStateDate;
		this.insuranceEndDate = insuranceEndDate;
		this.payDate = payDate;
		this.status = status;
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
	
	
}
