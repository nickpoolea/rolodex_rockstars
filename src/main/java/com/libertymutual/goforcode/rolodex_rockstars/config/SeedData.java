//package com.libertymutual.goforcode.rolodex_rockstars.config;
//
//import org.springframework.context.annotation.Configuration;
//
//import com.libertymutual.goforcode.rolodex_rockstars.models.Card;
//import com.libertymutual.goforcode.rolodex_rockstars.repositories.AddressRepository;
//import com.libertymutual.goforcode.rolodex_rockstars.repositories.CardRepository;
//import com.libertymutual.goforcode.rolodex_rockstars.repositories.PhoneRepository;
//
//@Configuration
//
//public class SeedData {
//	private CardRepository cardRepo;
//	
////	public SeedData(CardRepository cardRepo, AddressRepository addressRepo, PhoneRepository phoneRepo) {
//	public SeedData(CardRepository cardRepo) {
// 		this.cardRepo = cardRepo;
//
// 		cardRepo.save(new Card("firstName1", "lastName1", "title1", "company1","",""));
// 		cardRepo.save(new Card("firstName2", "lastName2", "title2", "company2", "address2", "phoneNumber2"));
// 		cardRepo.save(new Card("firstName3", "lastName3", "title3", "company3", "address3", "phoneNumber3"));
//	}
//}