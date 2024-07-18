package br.com.investTracker.dto;

import br.com.investTracker.model.Investment;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class InvestmentDTO {

    @NotBlank(message = "{ticker.not.blank}")
    private String ticker;

    @NotNull(message = "{quantity.not.null}")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Buying price must not be null.")
    @Min(value = 0, message = "Buying price must be greater than or equal to 0")
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
