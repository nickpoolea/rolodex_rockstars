package models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.meanbean.test.BeanTester;

import com.libertymutual.goforcode.rolodex_rockstars.models.Address;
import com.libertymutual.goforcode.rolodex_rockstars.models.Card;
import com.libertymutual.goforcode.rolodex_rockstars.models.PhoneNumber;

public class PhoneNumberTest {

	 @Test
	 public void testPhoneNumber() {
	  BeanTester beanTester = new BeanTester();
	  beanTester.testBean(PhoneNumber.class);
	 }

	 @Test
	 public void test_Add_Card_ToPhone() {
			 Card card = new Card();
			 PhoneNumber phoneNumber = new PhoneNumber();
			 phoneNumber.addCardToPhoneNumber(card);
			 assertThat(phoneNumber.getCard()).isSameAs(card);
	 }
}

