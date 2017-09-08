package models;

import org.junit.Test;
import org.meanbean.test.BeanTester;

import com.libertymutual.goforcode.rolodex_rockstars.models.Address;
import com.libertymutual.goforcode.rolodex_rockstars.models.Card;
import com.libertymutual.goforcode.rolodex_rockstars.models.PhoneNumber;

public class CardTest {
	
	 @Test
	 public void testCard() {
	  BeanTester beanTester = new BeanTester();
	  beanTester.testBean(Card.class);
	 }
}

