package com.dmarcosl.mcptest.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("prenda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenda {
  @Id private Long id;
  private String nombre;
  private String color;
  private BigDecimal precio;
}
