package com.app.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class CompositeKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="bill_id")
    private String billId;
	@Column(name="user_id")
	private int userId;
	
}

/*
 * Regarding Composite Primary Key:
 * =======================
 * In order to define composite keys, we should implement the given rules:

The composite key class should be public.
The composite key class must implement the Serializable interface.
The class must have a constructor.
The class should have equals()  and hashCode() methods.
*/
