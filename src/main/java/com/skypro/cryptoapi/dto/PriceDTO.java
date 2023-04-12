package com.skypro.cryptoapi.dto;

import com.skypro.cryptoapi.model.Price;

public record PriceDTO(String symbol, double price) {

  public static PriceDTO toDTO(Price price) {
    return new PriceDTO(price.getSymbol(), price.getPrice());
  }
}
