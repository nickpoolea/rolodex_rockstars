package com.libertymutual.goforcode.rolodex_rockstars.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
	private PhoneRepository phoneRepo;
	private RolodexController controller;

	@Before
	public void setUp() {
		cardRepo = mock(CardRepository.class);
		addressRepo = mock(AddressRepository.class);
		phoneRepo = mock(PhoneRepository.class);
		controller = new RolodexController(cardRepo, addressRepo, phoneRepo);
	}

	@Test
	public void test_that_get_all_returns_a_list_of_all_card_objects() {
		// arrange
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card());
		cards.add(new Card());
		cards.add(new Card());
		when(cardRepo.findAll()).thenReturn(cards);

		// act
		List<Card> actual = controller.getAllCards();

		// assert
		assertThat(actual.size()).isEqualTo(3);
		assertThat(actual).isSameAs(cards);
		verify(cardRepo).findAll();
	}

	@Test
	public void test_getOne_returns_card_returned_from_rep() {
		// Arrange
		Card card = new Card();
		when(cardRepo.findOne(8l)).thenReturn(card);

		// Act
		Card actual = controller.getOneCard(8l);

		// Assert
		assertThat(card).isSameAs(actual);
		verify(cardRepo).findOne(8l);
	}

	@Test
	public void test_that_create_runs_and_returns_card_from_the_repo() {
		// Arrange
		Card card = new Card();
		when(cardRepo.save(card)).thenReturn(card);

		// Act
		Card actual = controller.create(card);

		// Assert
		assertThat(actual).isSameAs(card);
		verify(cardRepo).save(card);
	}

	@Test
	public void test_that_create_run_and_returns_a_card_with_an_address() {
		// arrange
		Card card = new Card();
		List<Address> addresses = new ArrayList<Address>();
		Address address = new Address();
		addresses.add(address);
		card.setAddresses(addresses);
		when(cardRepo.save(card)).thenReturn(card);

		// act
		Card actual = controller.create(card);

		// assert
		assertThat(actual.getAddresses()).isSameAs(addresses);
		verify(addressRepo).save(addresses);
	}

	@Test
	public void test_that_create_run_and_returns_a_card_with_a_phone() {
		// arrange
		Card card = new Card();
		List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumbers.add(phoneNumber);
		card.setPhoneNumbers(phoneNumbers);
		when(cardRepo.save(card)).thenReturn(card);

		// act
		Card actual = controller.create(card);

		// assert
		assertThat(actual.getPhoneNumbers()).isSameAs(phoneNumbers);
		verify(phoneRepo).save(phoneNumbers);
	}

	@Test
	public void test_that_addPhone_adds_a_number_save_a_number_and_returns_a_card() {
		// arrange
		Card card = new Card();
		PhoneNumber phoneNumber = new PhoneNumber();
		when(cardRepo.findOne(57l)).thenReturn(card);
		when(phoneRepo.save(phoneNumber)).thenReturn(phoneNumber);

		// act
		Card actual = controller.addPhoneNumberToCard(57l, phoneNumber);

		// assert
		assertThat(actual).isSameAs(card);
		verify(phoneRepo).save(phoneNumber);
		verify(cardRepo).findOne(57l);

	}

	@Test
	public void test_that_addAddress_adds_a_number_save_a_number_and_returns_a_card() {
		// arrange
		Card card = new Card();
		Address address = new Address();
		when(cardRepo.findOne(22l)).thenReturn(card);

		// act
		Card actual = controller.addAddressToCard(22l, address);

		// assert
		assertThat(actual).isSameAs(card);
		verify(addressRepo).save(address);
		verify(cardRepo).findOne(22l);

	}

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
	public void test_that_deleteCard_runs_delete_and_returns_a_card() {
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
	public void test_that_deleteAddress_deletes_address_and_returns_card() {

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
	public void test_that_deletePhone_deletes_address_and_returns_card() {

		// Arrange
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setId(2l);
		Card card = new Card();
		card.setId(3l);
		when(phoneRepo.findOne(2l)).thenReturn(phoneNumber);

		// Act
		controller.deletePhoneFromCard(3l, 2l);

		// Assert
		verify(phoneRepo).findOne(2l);
		verify(phoneRepo).delete(phoneNumber);
		
	}
	
}
