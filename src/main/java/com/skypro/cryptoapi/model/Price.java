package com.skypro.cryptoapi.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(updatable = false, nullable = false)
  private String symbol;
  @Column(updatable = false, nullable = false)
  private double price;
  @Column(updatable = false, nullable = false)
  private Instant priceDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Instant getPriceDate() {
    return priceDate;
  }

  public void setPriceDate(Instant priceDate) {
    this.priceDate = priceDate;
  }
}
