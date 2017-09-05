package com.libertymutual.goforcode.rolodex_rockstars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.rolodex_rockstars.models.Card;
import com.libertymutual.goforcode.rolodex_rockstars.models.PhoneNumber;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneNumber, Long> {

	
	
}
