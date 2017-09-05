package com.libertymutual.goforcode.rolodex_rockstars.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.rolodex_rockstars.models.Card;
import com.libertymutual.goforcode.rolodex_rockstars.repositories.CardRepository;

@RestController
@RequestMapping ("/card")

public class RolodexController {
	private CardRepository cardRepo;	
	
	public RolodexController (CardRepository cardRepo) {
		
		this.cardRepo = cardRepo;
	}
	
	

	@GetMapping("")
	public List<Card> getAllCards(){
		
	return cardRepo.findAll();
		
	}

}
