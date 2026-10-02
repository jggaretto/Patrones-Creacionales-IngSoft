# Patron Builder - Ejemplo: Armado de Computadoras

Ejemplo completo del patron creacional **Builder** en Java, listo para exponer.

## Estructura

```
Builder/
├── Computadora.java              # PRODUCTO: objeto complejo a construir
├── ComputadoraBuilder.java       # BUILDER: interfaz con los pasos de construccion
├── ComputadoraBuilderImpl.java   # CONCRETE BUILDER: implementacion unica
├── Director.java                 # DIRECTOR: recetas predefinidas (opcional)
└── MainBuilderDemo.java          # CLIENTE: demo para ejecutar y exponer
```

Paquete: `com.patronescreacionales.Builder.src`

## Requisitos

- Java 17 o superior
- (Opcional) Maven 3.x

Verifica tu version:

```powershell
java -version
```

## Como ejecutarlo

### Opcion 1: Desde el IDE (mas facil para exponer)

1. Abre el proyecto `Patrones-Creacionales-IngSoft` en IntelliJ IDEA / Eclipse / VS Code.
2. Abre el archivo `MainBuilderDemo.java`.
3. Pulsa **Run** / **Ejecutar**.

### Opcion 2: Con javac y java (sin Maven)

Desde la raiz del proyecto:

```powershell
# 1. Compilar
javac -encoding UTF-8 -d out src/main/java/com/patronescreacionales/Builder/src/*.java

# 2. Ejecutar
java -cp out com.patronescreacionales.Builder.src.MainBuilderDemo
```

En Linux / Mac:

```bash
javac -encoding UTF-8 -d out src/main/java/com/patronescreacionales/Builder/src/*.java
java -cp out com.patronescreacionales.Builder.src.MainBuilderDemo
```

### Opcion 3: Con Maven

```powershell
mvn compile
mvn exec:java -Dexec.mainClass="com.patronescreacionales.Builder.src.MainBuilderDemo"
```

> Nota: si `mvn` no esta instalado, usa la Opcion 1 o 2.

## Que muestra la demo

1. **Con Director:** `construirPCGamer()` y `construirPCOficina()` (recetas fijas).
2. **Sin Director:** PC de streaming 100% personalizada paso a paso.
3. **Reutilizacion:** el mismo builder arma varias computadoras distintas.

## Funcionamiento del codigo

### 1. Se crea el builder y se conecta al Director

`MainBuilderDemo.java`:

```java
ComputadoraBuilder builder = new ComputadoraBuilderImpl();
Director director = new Director();
director.setBuilder(builder);
```

El Director no sabe armar nada solo, solo orquesta. El que sabe es el builder.

### 2. Con Director (receta fija)

```java
Computadora gamer = director.construirPCGamer();
```

Adentro (`Director.java`) el Director ejecuta la receta paso a paso:

```java
return builder
    .setCPU("Intel Core i9-13900K")
    .setRAM(32)
    .setAlmacenamiento(2000, "SSD NVMe")
    .setGPU("NVIDIA RTX 4070 12GB")
    .setSistemaOperativo("Windows 11 Pro")
    .setRefrigeracionLiquida(true)
    .setLucesRGB(true)
    .build();
```

Cada `set` guarda un dato en el objeto `Computadora` interno
(`ComputadoraBuilderImpl.java`) y retorna `this` para encadenar.
`build()` devuelve la computadora terminada y hace `reset()`
para dejar el builder limpio y reutilizable.

Lo mismo para `construirPCOficina()`: **mismo builder, distinta
receta = distinto producto.** Ese es el punto clave del patron.

### 3. Sin Director (personalizada)

El cliente usa el builder directo, sin receta:

```java
Computadora streamer = new ComputadoraBuilderImpl()
    .setCPU("AMD Ryzen 9 7950X")
    .setRAM(64)
    .setAlmacenamiento(4000, "SSD NVMe")
    .setGPU("NVIDIA RTX 4090 24GB")
    .setSistemaOperativo("Windows 11 Pro")
    .setRefrigeracionLiquida(true)
    .setLucesRGB(true)
    .build();
```

Demuestra que el Director es opcional.

### 4. Reutilizacion

El mismo builder arma varias PCs seguidas porque `build()`
se auto-resetea. No necesitas un `new` cada vez.

> Resumen: el Producto no sabe como se arma, el Builder sabe
> armarlo paso a paso, el Director sabe que receta usar,
> y el Cliente elige si usar receta o armar a mano.

## Idea clave para exponer

Sin Builder terminarias con un constructor telescopico ilegible:

```java
new Computadora("i9", 32, 1000, "SSD", "RTX 4070", "Windows 11", true, true);
```

Con Builder es legible, paso a paso y fluido:

```java
Computadora gamer = builder
    .setCPU("Intel Core i9-13900K")
    .setRAM(32)
    .setGPU("NVIDIA RTX 4070 12GB")
    .build();
```
