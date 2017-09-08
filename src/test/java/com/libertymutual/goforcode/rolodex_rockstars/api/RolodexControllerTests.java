package com.libertymutual.goforcode.rolodex_rockstars.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.rolodex_rockstars.models.Address;
import com.libertymutual.goforcode.rolodex_rockstars.models.Card;
import com.libertymutual.goforcode.rolodex_rockstars.models.PhoneNumber;
import com.libertymutual.goforcode.rolodex_rockstars.repositories.AddressRepository;
import com.libertymutual.goforcode.rolodex_rockstars.repositories.CardRepository;
import com.libertymutual.goforcode.rolodex_rockstars.repositories.PhoneRepository;

public class RolodexControllerTests {

	private CardRepository cardRepo;
	private AddressRepository addressRepo;
	private PhoneRepository phoneNumberRepo;
	private RolodexController controller;

	
	@Test
	public void test_deleteCard() {
		// Arrange
		Card card = new Card();
		when(cardRepo.findOne(3l)).thenReturn(card);

		// Act
		Card actual = controller.deleteCard(3l);

		// Assert
		assertThat(card).isSameAs(actual);
		verify(cardRepo).delete(3l);
		verify(cardRepo).findOne(3l);
	}

	
	@Test
	public void test_addAddressToCard() {
		// Arrange
		Address address = new Address();
		Card card = new Card();
		card.setId(3l);
		address.addCardToAddress(card);
		when(cardRepo.findOne(3l)).thenReturn(card);

		// Act
		controller.addAddressToCard(3l, address);

		// Assert
		verify(addressRepo).save(address);
		assertThat(address.getCard()).isSameAs(card);

	}

	
	@Test
	public void test_addPhoneNumberToCard() {
		// Arrange
		PhoneNumber phoneNumber = new PhoneNumber();
		Card card = new Card();
		card.setId(3l);
		phoneNumber.addCardToPhoneNumber(card);
		when(cardRepo.findOne(3l)).thenReturn(card);

		// Act
		controller.addPhoneNumberToCard(3l, phoneNumber);

		// Assert
		verify(phoneNumberRepo).save(phoneNumber);
		assertThat(phoneNumber.getCard()).isSameAs(card);
	}

	
	@Test
	public void test_deleteAddressFromCard() {

		// Arrange
		Address address = new Address();
		address.setId(2l);
		Card card = new Card();
		card.setId(3l);
		when(addressRepo.findOne(2l)).thenReturn(address);

		// Act
		controller.deleteAddressFromCard(3l, 2l);

		// Assert
		verify(addressRepo).findOne(2l);
		verify(addressRepo).delete(address);
		
	}
	
	
	@Test
	public void test_deletePhoneFromCard() {

		// Arrange
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setId(2l);
		Card card = new Card();
		card.setId(3l);
		when(phoneNumberRepo.findOne(2l)).thenReturn(phoneNumber);

		// Act
		controller.deletePhoneFromCard(3l, 2l);

		// Assert
		verify(phoneNumberRepo).findOne(2l);
		verify(phoneNumberRepo).delete(phoneNumber);
		
	}
	
	@Before
	public void setUp() {
		cardRepo = mock(CardRepository.class);
		phoneNumberRepo = mock(PhoneRepository.class);
		addressRepo = mock(AddressRepository.class);
		controller = new RolodexController(cardRepo, addressRepo, phoneNumberRepo);
	}

	
}
