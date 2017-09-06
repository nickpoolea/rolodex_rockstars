package com.libertymutual.goforcode.rolodex_rockstars.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

@Entity

public class Card {

	@Id
	@GeneratedValue(generator = "CardIdSeq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "CardIdSeq", sequenceName = "CardIdSeq")
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String firstName;

	@Column(nullable = false, length = 100)
	private String lastName;

	@Column(nullable = false, length = 10)
	private String title;

	@Column(nullable = true, length = 100)
	private String company;

	@OneToMany(mappedBy = "card")
	@Column(nullable = true, length = 100)
	private List<Address> addresses;

	@OneToMany(mappedBy = "card")
	@Column(nullable = true, length = 100)
	private List<PhoneNumber> phoneNumbers;

	public Card() {

	}

	public Card(String firstName, String lastName, String title, String company, String address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.title = company;
		this.title = address;
		this.title = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
