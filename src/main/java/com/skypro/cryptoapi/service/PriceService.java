package com.skypro.cryptoapi.service;

import com.skypro.cryptoapi.dto.PriceDTO;
import com.skypro.cryptoapi.listener.PriceMessage;
import com.skypro.cryptoapi.model.Price;
import com.skypro.cryptoapi.repository.PriceRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

  private final PriceRepository priceRepository;


  public PriceService(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  public void savePrice(PriceMessage priceMessage) {
    Price price = new Price();
    price.setPriceDate(priceMessage.instant());
    price.setSymbol(priceMessage.symbol());
    price.setPrice(priceMessage.price());
    priceRepository.save(price);
  }

  public List<PriceDTO> getLastPrices() {
    return priceRepository.getLastPrices().stream().map(PriceDTO::toDTO).toList();
  }

  public double average(String symbol) {
    return priceRepository.getAveragePrice(symbol);
  }

  public double min(String symbol) {
    return priceRepository.getMinPrice(symbol);
  }

  public double max(String symbol) {
    return priceRepository.getMaxPrice(symbol);
  }
}
