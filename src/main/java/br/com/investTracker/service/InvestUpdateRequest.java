package br.com.investTracker.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record InvestUpdateRequest(String ticker,
                                  Integer quantity,
                                  BigDecimal buyingPrice,
                                  BigDecimal sellingPrice) {

}
