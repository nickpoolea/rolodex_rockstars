package com.libertymutual.goforcode.rolodex_rockstars.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.meanbean.test.BeanTester;

import com.libertymutual.goforcode.rolodex_rockstars.models.Address;
import com.libertymutual.goforcode.rolodex_rockstars.models.Card;

public class AddressTest {

	 @Test
	 public void testAddress() {
	  BeanTester beanTester = new BeanTester();
	  beanTester.testBean(Address.class);
	 }

	 @Test
	 public void test_Add_Card_ToAddress() {
	 Card card = new Card();
	 Address address = new Address();
	 address.addCardToAddress(card);
	 assertThat(address.getCard()).isSameAs(card);
	 
	 } 
	 
}

