package com.dmarcosl.mcptest.domain;

import com.dmarcosl.mcptest.db.Prenda;
import com.dmarcosl.mcptest.db.PrendaRepository;
import com.dmarcosl.mcptest.db.VentaRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalesService {

  private final PrendaRepository prendaRepo;
  private final VentaRepository ventaRepo;

  public record SalesSummary(String nombre, String color, long ventas, BigDecimal total) {}

  public Mono<SalesSummary> resumen(String nombre, String color) {
    log.info("Buscando resumen para {} ({})", nombre, color);
    return prendaRepo
        .findByNombreAndColor(nombre, color)
        .switchIfEmpty(
            Mono.error(
                new IllegalArgumentException(
                    "Prenda no encontrada: %s (%s)".formatted(nombre, color))))
        .flatMap(
            (Prenda p) ->
                ventaRepo
                    .countByPrendaId(p.getId())
                    .map(
                        cnt ->
                            new SalesSummary(
                                p.getNombre(),
                                p.getColor(),
                                cnt,
                                p.getPrecio().multiply(BigDecimal.valueOf(cnt)))))
        .doOnError(e -> log.error("Error en resumen", e))
        .doOnSuccess(salesSummary -> log.info("Resumen encontrado: {}", salesSummary));
  }
}
