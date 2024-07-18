package br.com.investTracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "{ticker.not.blank}")
    private String ticker;
    @NotNull(message = "{quantity.not.null}")
    private Integer quantity;
    @NotNull(message = "{buyingPrice.not.null}")
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;

    public Investment(String ticker, Integer quantity, BigDecimal buyingPrice, BigDecimal sellingPrice) {
        this.ticker = ticker;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    public Investment() {
    }
}
