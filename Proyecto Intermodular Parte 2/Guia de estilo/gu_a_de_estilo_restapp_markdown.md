# Guía de Estilo y Sistema de Diseño — RestApp

**Versión:** 1.0.0  
**Plataforma:** PWA Responsive (Desktop / Cocina KDS y Mobile / Camarero, Administrador)  
**Tema Principal:** Golden Culinary (Dorado Gastronómico Premium & Eficiencia Operativa)

---

## 1. Identidad Visual y Filosofía de Marca

**RestApp** es una solución integral para gestión gastronómica y operativa en tiempo real que conecta Administradores (Jefe / Gerente), Camareros (Sala) y Cocineros (KDS / Pantalla de Cocina). Combina la elegancia y distinción de la restauración de alto nivel con la claridad, rapidez y contraste necesarios para el entorno exigente de servicio y cocina.

### Personalidad de Marca
- **Sofisticada & Profesional:** Detalles en tonalidades doradas sobre fondos oscuros profundos y neutros cálidos.
- **Ágil & Funcional:** Alta legibilidad visual, botones táctiles generosos y feedback de estado en tiempo real.
- **Confiable:** Control preciso de existencias, sincronización bidireccional entre stock, carta y cocina.

---

## 2. Paleta Cromática (Color Tokens)

El color primario es el **Dorado**, optimizado para accesibilidad (WCAG AA/AAA) sobre superficies oscuras y claras.

### 2.1 Colores Principales (Brand & Accent)
| Token | Código HEX | Rol y Aplicación |
| :--- | :--- | :--- |
| `--color-primary-base` | `#D4AF37` | **Dorado Principal**: Botones de acción primaria, badges activos, bordes destacados. |
| `--color-primary-light` | `#F3E5AB` | **Dorado Claro / Champagne**: Highlights, estados hover, fondos sutiles de selección. |
| `--color-primary-dark` | `#997A15` | **Dorado Oscuro / Bronce**: Bordes de contraste, texto sobre fondos muy claros, sombras. |
| `--color-primary-glow` | `rgba(212, 175, 55, 0.25)` | Efectos de brillo/foco en inputs y estados activos en pantalla KDS. |

### 2.2 Colores Neutros y Superficies (Dark & Light Canvas)
| Token | Código HEX | Rol y Aplicación |
| :--- | :--- | :--- |
| `--color-bg-kds` | `#121316` | Fondo principal para KDS / Cocina (Desktop de alto contraste). |
| `--color-surface-kds` | `#1C1E24` | Tarjetas de comandas, paneles modales de stock en cocina. |
| `--color-bg-mobile` | `#18191D` | Fondo general de vistas móviles (Admin y Camarero). |
| `--color-surface-card` | `#23262F` | Contenedores de inputs, tarjetas de ingredientes y platos. |
| `--color-border-subtle` | `#323642` | Líneas divisorias, punteados de separación (`dashed/dotted borders`). |
| `--color-text-main` | `#FFFFFF` | Títulos, cantidades críticas, llamadas a la acción. |
| `--color-text-secondary`| `#A0A5B5` | Etiquetas descriptivas, subtítulos, nombres de proveedores. |

### 2.3 Colores Semánticos y de Estado (Cocina y Stock)
| Token | Código HEX | Rol y Aplicación |
| :--- | :--- | :--- |
| `--color-status-success` | `#2ECC71` | Platos disponibles, pedidos confirmados, stock óptimo. |
| `--color-status-warning` | `#F39C12` | Stock bajo / advertencia previa a agotamiento. |
| `--color-status-danger` | `#E74C3C` | Ingrediente agotado, plato bloqueado para sala, notificación urgente. |
| `--color-status-info` | `#3498DB` | Pedidos programados con fecha y hora futura. |

---

## 3. Tipografía (Typography Scale)

Fuente sugerida: **Inter**, **Plus Jakarta Sans** o **Outfit** (moderna, geométrica, números tabulares para inventarios y tickets).

| Nivel | Tamaño / Leading | Peso | Uso |
| :--- | :--- | :--- | :--- |
| **Display / H1** | `28px` / `34px` (Mobile) <br>`36px` / `44px` (Desktop) | Bold (700) | Títulos de vista ("RestApp", "PEDIDOS DE COCINA", "Administrador"). |
| **H2 / Sección** | `20px` / `26px` | SemiBold (600) | "Stock", "Pedidos", "Platos en la carta", "Carrito". |
| **H3 / Tarjeta** | `16px` / `22px` | Medium (500) | Nombres de productos, ingredientes ("Tomates", "Pasta carbonara"). |
| **Body Base** | `14px` / `20px` | Regular (400) | Subtítulos, textos de ayuda, preguntas de pedido. |
| **Caption / Meta** | `12px` / `16px` | Regular (400) | "dd/mm/yy", stock actual de referencia, enlaces secundarios. |
| **Numbers / Data** | `16px` - `24px` Tabular | Bold (700) | Contadores de stock, cantidades en carrito y tickets KDS. |

---

## 4. Retícula, Espaciado y Formato por Dispositivo

### 4.1 Pantalla Cocina KDS (Desktop / Tablet Horizontal)
- **Resolución objetivo:** 1920x1080 o 1440x900 (pantalla táctil o uso con ratón).
- **Diseño de columnas Kanban:** Tablero de comandas entrantes con tarjetas de alto impacto visual.
- **Áreas táctiles:** Mínimo de `48px` a `56px` para permitir interacción rápida en entorno con guantes o rapidez de pase.
- **Acceso a Stock:** Botón táctil directo "Stock" en cada tarjeta de comanda para abrir el modal "Stock de cocina (Cocinero)".

### 4.2 Pantallas Móviles (Admin y Camarero)
- **Formato base:** Mobile Portrait (390px - 428px ancho).
- **Navegación:** Cabecera con título de rol y botón de acción "Salir", listas con scroll vertical suave.
- **Separadores punteados:** Aplicación de bordes punteados dorados/sutiles (`border: 1.5px dashed var(--color-border-subtle)` o dorados) según boceto.
- **Controles numéricos:** Cajas cuadradas centradas para ingreso de cantidades de pedido y botones incrementales `+`.

---

## 5. Componentes Clave del Sistema

### 5.1 Botones e Interactivos
- **Botón Primario Dorado (`.btn-gold`):**  
  Fondo `#D4AF37`, texto `#121316` (negro carbón bold), esquinas redondeadas (`12px` en mobile, `8px` en desktop), sombra suave `0 4px 12px rgba(212, 175, 55, 0.3)`.
- **Botón Secundario / Outline (`.btn-outline`):**  
  Borde dorado `1.5px solid #D4AF37`, fondo transparente, texto `#F3E5AB`.
- **Botón Acción Crítica / Notificación (`.btn-notify-alert`):**  
  Pulsador para que el cocinero notifique al camarero (rombo/icono de alerta) cuando un ingrediente está por debajo del mínimo.
- **Botón Salir (`.btn-logout`):**  
  Borde discreto y tono neutro tenue para evitar pulsaciones accidentales.

### 5.2 Formularios y Controles Numéricos
- **Input de Cantidad en Cuadro:**  
  Caja cuadrada centrada (`w-14 h-14` o `w-16 h-16`), borde dorado suave, texto numérico grande y centrado.
- **Selector de Fecha y Hora (Pedido Programado):**  
  Layout dividido 50/50: a la izquierda botón/campo de calendario desplegable respetando días hábiles; a la derecha selector de `hh:mm`.

### 5.3 Separadores y Contenedores Punteados
- Característica de diseño según flujo del usuario: separador de puntos (`border-dotted` o `border-dashed`) para aislar la zona central en la pantalla de "Pedidos" y en el "Carrito".

---

## 6. Arquitectura de Pantallas y Flujos de Usuario

```
[Pantalla Inicial: Login RestApp]
   ├── Rol Administrador (Mobile)
   │     ├── Vista Admin: "Administrador" (Botones: Salir, Stock y pedidos)
   │     ├── Vista Stock: Lista con scroll + botón (+) por ingrediente
   │     ├── Vista Pedidos: Producto elegido, stock actual, opciones centrales:
   │     │     ├── A) "Hacer pedido en este momento" -> Cantidad -> "Ver carrito"
   │     │     └── B) "Hacer pedido programado" -> Calendario (Fecha) + Hora -> Cantidad -> "Ver carrito"
   │     └── Vista Carrito: Resumen de compra con separadores punteados -> "Confirmar pedido"
   │
   ├── Rol Camarero (Mobile)
   │     ├── Vista Menú Camarero: (Opciones: Salir, Stock en cocina, Ver platos en la carta)
   │     ├── Vista "Stock de cocina (camarero)": Notificación y bloqueo de platos sin ingredientes
   │     └── Vista "Platos en la carta": Selección de platos disponibles -> Botón "Mandar a cocina"
   │
   └── Rol Cocinero (Desktop / PWA Pantalla Cocina)
         ├── Vista "PEDIDOS DE COCINA": Comandas recibidas en tiempo real desde sala
         └── Subpantalla / Modal "Stock de cocina (Cocinero)":
               Desglose de receta, ingredientes, stock restante y botón de notificación a camarero
```

---

## 7. Directrices de Microinteracciones y Estados de Notificación
1. **Notificación Cocina → Camarero:** Cuando un cocinero marca un ingrediente por debajo del mínimo, se emite un evento instantáneo que en la vista del camarero deshabilita el plato en la carta y lo destaca en "Stock de cocina" en rojo/ámbar.
2. **Confirmación de Comanda:** El botón "Mandar a cocina" muestra feedback háptico/animación de enviado y limpia la selección.
3. **Consistencia de Carrito:** Los pedidos inmediatos y programados comparten la estructura de carrito persistente para una gestión ágil con proveedores.