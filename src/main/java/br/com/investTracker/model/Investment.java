package br.com.investTracker.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

}
