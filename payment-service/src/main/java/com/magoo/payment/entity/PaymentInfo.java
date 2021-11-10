package com.magoo.payment.entity;

public class PaymentInfo {
	
	private String transactionId;
	
	private String movieId;
	private String modeOfPayment;
	
	private double totAmountPaid;
	
	private boolean payStatus;
	
	
	public PaymentInfo()
	{
		
	}


	public PaymentInfo(String transactionId, String movieId, String modeOfPayment, double totAmountPaid,
			boolean payStatus) {
		super();
		this.transactionId = transactionId;
		this.movieId = movieId;
		this.modeOfPayment = modeOfPayment;
		this.totAmountPaid = totAmountPaid;
		this.payStatus = payStatus;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getMovieId() {
		return movieId;
	}


	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}


	public String getModeOfPayment() {
		return modeOfPayment;
	}


	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}


	public double getTotAmountPaid() {
		return totAmountPaid;
	}


	public void setTotAmountPaid(double totAmountPaid) {
		this.totAmountPaid = totAmountPaid;
	}


	public boolean isPayStatus() {
		return payStatus;
	}


	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}


	@Override
	public String toString() {
		return "PaymentInfo [transactionId=" + transactionId + ", movieId=" + movieId + ", modeOfPayment="
				+ modeOfPayment + ", totAmountPaid=" + totAmountPaid + ", payStatus=" + payStatus + "]";
	}
	
}
	