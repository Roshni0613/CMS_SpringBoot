package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{

	//unique id pk from base entity class
	@Column(name = "first_name",length = 30)
	@NotBlank(message = "First Name cannot be blank")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be blank")
	@Column(name = "last_name",length = 20)
	private String lastName;
	
	
	@Column(name = "email_id",length = 50,unique = true)
	private String email;
	
	@NotBlank
	@Length(min=4,max = 20, message = "Invalid password length")
	@Column
	@JsonIgnore
	@Pattern(regexp = "((?=.*\\d)(?=.*[A-Z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid password")
	private String password;
	
	@Transient
	@JsonIgnore
	private String confirmPassword;
	
	@Column(name = "mobile_number",length = 10)
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String mobileNumber;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name="house_number",length = 10,unique=true)
	@NotBlank(message = "Please enter house number")
	private String houseNumber;

	@JsonIgnore
	@OneToMany(mappedBy = "complaintUser",cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Complaints> complaint;
	
	//helper methods
	public void addComplaint(Complaints com) {
		complaint.add(com);
		com.setComplaintUser(this);
	}
	public void remComplaint(Complaints com) {
		complaint.remove(com);
		com.setComplaintUser(null);
	}
	
	public User(@NotBlank(message = "First Name cannot be blank") String firstName,
			@NotBlank(message = "Last Name cannot be blank") String lastName, String email,
			@NotBlank @Length(min = 4, max = 20, message = "Invalid password length") @Pattern(regexp = "((?=.*\\d)(?=.*[A-Z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid password") String password,
			String confirmPassword, @Pattern(regexp = "(^$|[0-9]{10})") String mobileNumber, Role role,
			@NotBlank(message = "Please enter house number") String houseNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.mobileNumber = mobileNumber;
		this.role = role;
		this.houseNumber = houseNumber;
	}	
	
	
}