package com.school.dto;

import java.sql.Date;

public class FeesAmountDto {

	public String branch;
	public String session;
	public String stuClass;
	public String scholarNumberOrName;
	
	public String amount;
	public String date;
	
	public int fees;
	
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public String paymentMode;
	public String senderBankName;
	public String chequeNo;
	public String chequeDate;
	public String accNo;
	public String recBank;
	public String remark;
	
	
	public int receiptNo;
	
	
	
	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}
	public int getReceiptNo() {
		return receiptNo;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getSenderBankName() {
		return senderBankName;
	}
	public void setSenderBankName(String senderBankName) {
		this.senderBankName = senderBankName;
	}
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeDate() {
		return chequeDate;
	}
	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public String getRecBank() {
		return recBank;
	}
	public void setRecBank(String recBank) {
		this.recBank = recBank;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getScholarNumberOrName() {
		return scholarNumberOrName;
	}
	public void setScholarNumberOrName(String scholarNumberOrName) {
		this.scholarNumberOrName = scholarNumberOrName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "FeesAmountDto [branch=" + branch + ", session=" + session + ", stuClass=" + stuClass
				+ ", scholarNumberOrName=" + scholarNumberOrName + ", amount=" + amount + ", date=" + date + "]";
	}	
		 

	
}
