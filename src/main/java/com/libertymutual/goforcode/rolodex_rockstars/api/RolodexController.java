package com.libertymutual.goforcode.rolodex_rockstars.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.rolodex_rockstars.models.Address;
import com.libertymutual.goforcode.rolodex_rockstars.models.Card;
import com.libertymutual.goforcode.rolodex_rockstars.models.PhoneNumber;
import com.libertymutual.goforcode.rolodex_rockstars.repositories.AddressRepository;
import com.libertymutual.goforcode.rolodex_rockstars.repositories.CardRepository;
import com.libertymutual.goforcode.rolodex_rockstars.repositories.PhoneRepository;

@RestController
@RequestMapping("/cards")
@CrossOrigin(origins = "*")

public class RolodexController {
	private CardRepository cardRepo;
	private AddressRepository addressRepo;
	private PhoneRepository phoneRepo;

	public RolodexController(CardRepository cardRepo, AddressRepository addressRepo, PhoneRepository phoneRepo) {

		this.cardRepo = cardRepo;
		this.addressRepo = addressRepo;
		this.phoneRepo = phoneRepo;

	}

	@GetMapping("") // Get all cards
	public List<Card> getAllCards() {
		return cardRepo.findAll();
	}

	// Get one card
	@GetMapping("{id}")
	public Card getOne(@PathVariable long id) throws StuffNotFoundException {
		Card card = cardRepo.findOne(id);
		return card;
	}

	@PostMapping("")
	public Card create(@RequestBody Card card) {
		System.out.println("Printing -------------");
		System.out.println(card.getAddresses().size());
		if (card.getAddresses().size() > 0) {
			List<Address> address = addressRepo.save(card.getAddresses());
			address.get(0).addCardToAddress(card);
		}
		
		if (card.getPhoneNumbers().size() > 0) {
			List<PhoneNumber> phoneNumber = phoneRepo.save(card.getPhoneNumbers());
			phoneNumber.get(0).addCardToPhoneNumber(card);
		}
		
		return cardRepo.save(card);
	}

	// Add Phone number to Card
	@PostMapping("{id}/phone")
	public Card add_phoneNumber_ToCard(@PathVariable long id, @RequestBody PhoneNumber phoneNumber) {
		Card card = cardRepo.findOne(id);
		phoneNumber.addCardToPhoneNumber(card);
		phoneRepo.save(phoneNumber);
		return cardRepo.save(card);
	}

	// Add address to Card
	@PostMapping("{id}/address")
	public Card add_address_ToCard(@PathVariable long id, @RequestBody Address address) {
		Card card = cardRepo.findOne(id);
		address.addCardToAddress(card);
		addressRepo.save(address);
		return cardRepo.save(card);
	}

	// update name and title of a card
	@PutMapping("{id}")
	public Card update(@RequestBody Card card, @PathVariable long id) {
		card.setId(id);
		return cardRepo.save(card);

	}

	// delete a card
	@DeleteMapping("{id}")
	public Card delete(@PathVariable long id) {
		try {
			Card card = cardRepo.findOne(id);
			cardRepo.delete(id);
			return card;
		} catch (org.springframework.dao.EmptyResultDataAccessException erdae) {
			return null;
		}
	}

	// Delete phone number from card
	@DeleteMapping("{id}/phone")
	public Card delete_phone_fromCard(@PathVariable long id, PhoneNumber phone) {
		try {

			Card card = cardRepo.findOne(id);
			// cardRepo.phoneRepo.delete(phone);
			return card;

		} catch (org.springframework.dao.EmptyResultDataAccessException erdae) {

			return null;
		}
	}

	// Delete address from card
	@DeleteMapping("{id}/address")
	public Card delete_address_fromCard(@PathVariable long id, Address address) {
		try {

			Card card = cardRepo.findOne(id);
			// cardRepo.phoneRepo.delete(address);
			return card;
		} catch (org.springframework.dao.EmptyResultDataAccessException erdae) {
			return null;
		}
	}
}
