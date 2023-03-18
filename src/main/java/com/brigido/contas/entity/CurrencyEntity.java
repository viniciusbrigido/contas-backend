package com.brigido.contas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@Entity
@Table(name = "currency")
public class CurrencyEntity {

    public CurrencyEntity() {
        date = LocalDateTime.now();
    }

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String name;

    private BigDecimal price;

    private LocalDateTime date;

    public void update(BigDecimal price) {
        this.price = price;
        date = LocalDateTime.now();
    }
}
