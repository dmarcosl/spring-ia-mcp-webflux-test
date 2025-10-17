# mcptest

Servidor **Spring Boot 3.5.6** con **Spring AI MCP (1.1.0-M3)** y **WebFlux**, conectado a una base de datos **H2 R2DBC**.  

Implementa un **servidor MCP asíncrono (protocolo *streamable-http*)**, totalmente compatible con **VS Code Copilot Agents**.

---

## 🐳 Ejecutar con Docker

### 1. Construir la imagen

```bash
docker build -t mcptest .
```

### 2. Ejecutar el contenedor

```bash
docker run --rm -p 8080:8080 mcptest
```

El servidor quedará disponible en:

```
http://localhost:8080/mcp
```

Para usar en VS Code, añade esta configuración en `settings.json`:

```json
{
  "servers": {
    "demo-mcp": {
      "type": "sse",
      "url": "http://localhost:8080/mcp"
    }
  }
}
```

---

## 🧩 Tools incluidas

| Tool                            | Descripción                                 |
|---------------------------------|---------------------------------------------|
| `shout(text)`                   | Devuelve el texto en mayúsculas             |
| `sum(a, b)`                     | Suma dos enteros                            |
| `ventas_resumen(nombre, color)` | Devuelve número de ventas y total facturado |

---

## 🗄️ Base de datos

La aplicación usa **H2 en memoria** (R2DBC).  
Se inicializa automáticamente con los scripts `schema.sql` y `data.sql`.

---

## 🪪 Licencia

MIT
