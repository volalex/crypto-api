package com.skypro.cryptoapi.repository;

import com.skypro.cryptoapi.model.Price;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
  @Query("""
      SELECT p FROM Price p WHERE p.priceDate IN (SELECT MAX(p.priceDate) FROM Price p)
      """)
  List<Price> getLastPrices();
  @Query("""
      SELECT min(p.price) from Price p WHERE p.symbol=:symbol
           """)
  double getMinPrice(String symbol);
  @Query("""
      SELECT max(p.price) from Price p WHERE p.symbol=:symbol
           """)
  double getMaxPrice(String symbol);
  @Query("""
      SELECT avg(p.price) from Price p WHERE p.symbol=:symbol
           """)
  double getAveragePrice(String symbol);
}
