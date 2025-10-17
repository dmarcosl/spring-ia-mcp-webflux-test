package com.dmarcosl.mcptest.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface VentaRepository extends ReactiveCrudRepository<Venta, Long> {
  Mono<Long> countByPrendaId(Long prendaId);
}
