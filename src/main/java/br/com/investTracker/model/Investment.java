package br.com.investTracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "investments")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private Integer quantity;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;

    public Investment(String ticker, Integer quantity, BigDecimal buyingPrice, BigDecimal sellingPrice) {
        this.ticker = ticker;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }
}
