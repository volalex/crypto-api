package com.skypro.cryptoapi.listener;

import java.time.Instant;

public record PriceMessage(String symbol, double price, Instant instant) {}
