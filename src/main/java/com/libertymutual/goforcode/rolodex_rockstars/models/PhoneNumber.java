package com.libertymutual.goforcode.rolodex_rockstars.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity

public class PhoneNumber {
	@Id
	@GeneratedValue(generator = "PhoneNumberIdSeq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "PhoneNumberIdSeq", sequenceName = "PhoneNumberIdSeq")
	private Long id;

	@ManyToOne
	private Card card;

	private String type;
	private String number;
	
	public void addCardToPhoneNumber(Card card) {
		this.card = card;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
