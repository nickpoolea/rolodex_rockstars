package com.libertymutual.goforcode.rolodex_rockstars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.rolodex_rockstars.models.Address;
import com.libertymutual.goforcode.rolodex_rockstars.models.Card;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	
	
}
