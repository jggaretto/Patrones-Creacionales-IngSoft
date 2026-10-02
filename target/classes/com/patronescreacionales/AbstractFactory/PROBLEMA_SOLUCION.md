# Abstract Factory — Problema y Solución con tu ejemplo

## El Problema (sin patrón)

Tu app tiene que dibujar 2 cosas: **Botón + Casilla**.
Y tiene que funcionar en **Windows y en Mac**, siempre combinadas.

Sin patrón harías esto en cada ventana:

```java
Boton boton;
Casilla casilla;

if (os.contains("mac")) {
  boton = new BotonMac();
  casilla = new CasillaMac();
} else {
  boton = new BotonWindows();
  casilla = new CasillaWindows();
}
```

### ¿Qué está mal? 3 problemas simples:

**1. Se puede mezclar y romper todo**
Nada te impide hacer esto por error:
```java
boton = new BotonMac();          // estilo Mac
casilla = new CasillaWindows();  // estilo Windows
```
Queda mitad Mac, mitad Windows. Se ve mal.

**2. Se repite el `if` en todos lados**
Si tenés 10 ventanas, copias ese `if` 10 veces.
Si te equivocas en una, falla solo esa.

**3. Agregar algo nuevo es complicado**
Agregar Linux Tenes que buscar los 10 `if` y agregar el caso nuevo en cada uno.

> En resumen: la Aplicación conoce demasiadas clases con `new` por todos lados.

---

## La Solución (con Abstract Factory)

**Idea simple: la Aplicación ya no hace `new`. Le pide todo a una Fábrica.**

```
ANTES: Aplicación elige → new BotonWindows, new CasillaWindows
AHORA:  Fábrica elige  → la Aplicación solo pide "dame un botón"
```

### ¿Cómo lo resuelve?

**1. Una fábrica por familia**

Se implementa la interfaz `GUIFactory.java` en las clases `WindowsFactory.java` y `MacFactory.java`

`WindowsFactory.java` — solo sabe dar familia Windows:

```java
public class WindowsFactory implements GUIFactory {
    @Override
    public Boton crearBoton() {
        return new BotonWindows();
    }

    @Override
    public Casilla crearCasilla() {
        return new CasillaWindows();
    }
}
```

`MacFactory.java` — solo sabe dar familia Mac:
```java
public class MacFactory implements GUIFactory {
    @Override
    public Boton crearBoton() {
        return new BotonMac();
    }

    @Override
    public Casilla crearCasilla() {
        return new CasillaMac();
    }
}
```

Problema 1 resuelto: imposible mezclar, cada fábrica da todo combinado.

**2. Un solo `if` en todo el programa**

`Aplicacion.java - main`:
```java
GUIFactory factory = os.contains("mac") ? new MacFactory() : new WindowsFactory();
Aplicacion app = new Aplicacion(factory);
```

Problema 2 resuelto: decides una sola vez al inicio, no en cada ventana.

**3. La Aplicación queda limpia**

`Aplicacion.java`:
```java
public Aplicacion(GUIFactory factory) {
  this.boton = factory.crearBoton();
  this.casilla = factory.crearCasilla();
}
```

No hay `new BotonWindows`, no hay `if`. Solo pide a la fábrica.
Si mañana agregas Linux, creas un `LinuxFactory` nuevo y no tocas la Aplicación.

Problema 3 resuelto.

