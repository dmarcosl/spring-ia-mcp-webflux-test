package com.dmarcosl.mcptest.tools;

import com.dmarcosl.mcptest.domain.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoTools {

  private final SalesService salesService;

  @Tool(
      name = "ventas_resumen",
      description = "Dado nombre de prenda y color, devuelve nº de ventas y total facturado")
  public SalesService.SalesSummary ventasResumen(
      @ToolParam(description = "Nombre de la prenda, p.ej. 'falda'") String nombre,
      @ToolParam(description = "Color de la prenda, p.ej. 'rosa'") String color) {
    if (nombre == null || color == null) {
      throw new IllegalArgumentException("Faltan parámetros: nombre y color");
    }
    return salesService.resumen(nombre, color).block();
  }

  @Tool(name = "shout", description = "Devuelve el texto en MAYÚSCULAS")
  public String shout(String text) {
    return text == null ? "" : text.toUpperCase();
  }

  @Tool(name = "sum", description = "Suma dos enteros")
  public int sum(int a, int b) {
    return a + b;
  }
}
