package com.dmarcosl.mcptest.db;

import java.time.LocalDateTime;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
  @Id private Long id;

  @Column("prenda_id")
  private Long prendaId;

  private LocalDateTime ts;
}
