package com.shoes.SportyShoes.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shoes.SportyShoes.model.PurchaseReport;

@Repository
public interface PurchaseReportRepository extends JpaRepository<PurchaseReport, Integer>{
	public List<PurchaseReport> findByDop(String dop);
	public List<PurchaseReport> findByCategory(String category);

}
