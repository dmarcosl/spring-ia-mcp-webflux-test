package com.dmarcosl.mcptest.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PrendaRepository extends ReactiveCrudRepository<Prenda, Long> {
  Mono<Prenda> findByNombreAndColor(String nombre, String color);
}
