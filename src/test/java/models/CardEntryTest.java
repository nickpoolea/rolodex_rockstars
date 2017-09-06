package models;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.rolodex_rockstars.models.Address;
import com.libertymutual.goforcode.rolodex_rockstars.models.Card;
import com.libertymutual.goforcode.rolodex_rockstars.models.PhoneNumber;

public class CardEntryTest {

	private Card method;
	private ArrayList<Double> testCard;
	private List<Address> addresses;
	private List<Card> cards;

	String[] address1 = { "Home", "street1", "city", "state", "98101" };
	String[] address2 = { "Office", "street1", "city", "state", "98102" };
	String[] address3 = { "Vacation Home", "street1", "city", "state", "98103" };

	String[] phone1 = { "Home", "206-222-1234" };
	String[] phone2 = { "Mobile", "510-333-1234" };
	String[] phone3 = { "Bat Phone", "253-444-1234" };

	@Before
	public void setUP() {
		// Create Card

		ArrayList<String> addresses = new ArrayList<String>();
		// addresses = [address1, address2, address3];

//		method.setAddresses(address1, address2, address3);
//		method.setCompany("LibertyMutual");
//		method.setFirstName("FirstName");
//		method.setFirstName("LastName");
//		method.setPhoneNumbersList(phone1, phone2, phone3);
//		method.setTitle("Title");
//		method.setId((long) 5.0);
	}
	
	public void test_getCompany() {
		//Arrange
				//done in @Before
		//ACT
		
		//ASSERT
				
	}

}
