package com.libertymutual.goforcode.rolodex_rockstars.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.rolodex_rockstars.models.Card;
import com.libertymutual.goforcode.rolodex_rockstars.repositories.AddressRepository;
import com.libertymutual.goforcode.rolodex_rockstars.repositories.CardRepository;

@RestController
@RequestMapping ("/cards")

public class RolodexController {
	private CardRepository cardRepo;	
	private AddressRepository addressRepo;
	
	public RolodexController (CardRepository cardRepo, AddressRepository addressRepo) {
		
		this.cardRepo = cardRepo;
		this.addressRepo = addressRepo;
	}
	
	

	@GetMapping("")
	public List<Card> getAllCards(){
	return cardRepo.findAll();
	}
	
	@PostMapping("")
	public Card createCard(@RequestBody Card card) {
		addressRepo.save(card.getAddresses());
		return cardRepo.save(card);
	}

}
