package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bill_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BillDetails{
	
	@EmbeddedId
	private CompositeKey compositeKey;

	private double amount;
	
	@Column(name = "bill_generation_date")
	private LocalDate billGenerationDate=LocalDate.now();
	
	@Column(name="bill_activation_date")
	private LocalDate billingDate;
	
	//update at the time of payment by owner
	@Column(name = "mode_of_payment")
	private PaymentMode modeOfPayment=null;
	
	//this will set true after payment done by owner
	private boolean status=false;
	
	//date of payment : inserted after payment
	@Column(name = "payment_date")
	private LocalDate paymentDate=null;
	
	private String purpose;
	
	@Column(name = "late_amount")
	private Double latePaymentAmount;
	
	@Column(name = "due_date")
	private LocalDate dueDate;
	
	@Column(name = "actual_paid_amount")
	private Double actualPaidAmount=0.0;
	
	public BillDetails(CompositeKey compositeKey, double amount, LocalDate billingDate, String purpose,
			double latePaymentAmount, LocalDate dueDate) {
		super();
		this.compositeKey = compositeKey;
		this.amount = amount;
		this.billingDate = billingDate;
		this.purpose = purpose;
		this.latePaymentAmount = latePaymentAmount;
		this.dueDate = dueDate;
	}
}
