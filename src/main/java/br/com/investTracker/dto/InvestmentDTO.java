package br.com.investTracker.dto;

import br.com.investTracker.model.Investment;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class InvestmentDTO {

    private String ticker;
    private Integer quantity;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;

    @JsonCreator
    public InvestmentDTO(@JsonProperty("ticker") String ticker,
                         @JsonProperty("quantity") Integer quantity,
                         @JsonProperty("buyingPrice") BigDecimal buyingPrice,
                         @JsonProperty("sellingPrice") BigDecimal sellingPrice) {
        this.ticker = ticker;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    //Transform request into entity
    public Investment toEntity() {
        return new Investment(ticker, quantity, buyingPrice, sellingPrice);
    }

}
