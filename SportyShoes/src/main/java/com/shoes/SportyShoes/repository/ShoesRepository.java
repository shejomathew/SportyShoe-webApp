package com.shoes.SportyShoes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shoes.SportyShoes.model.Shoe;

@Repository
public interface ShoesRepository extends JpaRepository<Shoe, Integer>{
	
}
