package com.skypro.cryptoapi.controller;

import com.skypro.cryptoapi.dto.PriceDTO;
import com.skypro.cryptoapi.service.PriceService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {

  private final PriceService priceService;

  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }

  @GetMapping
  public List<PriceDTO> getLastPrices() {
    return priceService.getLastPrices();
  }

  @GetMapping("/avg/{symbol}")
  public double getAveragePrice(@PathVariable("symbol") String symbol) {
    return priceService.average(symbol);
  }

  @GetMapping("/min/{symbol}")
  public double getMinPrice(@PathVariable("symbol") String symbol) {
    return priceService.min(symbol);
  }

  @GetMapping("/max/{symbol}")
  public double getMaxPrice(@PathVariable("symbol") String symbol) {
    return priceService.max(symbol);
  }
}
