package br.com.investTracker.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // Buying ou Selling
    private Integer quantity;
    private BigDecimal price;
    private LocalDateTime data;
}
