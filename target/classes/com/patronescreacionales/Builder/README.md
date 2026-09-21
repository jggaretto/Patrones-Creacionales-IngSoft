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

Paquete: `com.patronescreacionales.Builder`

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
javac -encoding UTF-8 -d out src/main/java/com/patronescreacionales/Builder/*.java

# 2. Ejecutar
java -cp out com.patronescreacionales.Builder.MainBuilderDemo
```

En Linux / Mac:

```bash
javac -encoding UTF-8 -d out src/main/java/com/patronescreacionales/Builder/*.java
java -cp out com.patronescreacionales.Builder.MainBuilderDemo
```

### Opcion 3: Con Maven

```powershell
mvn compile
mvn exec:java -Dexec.mainClass="com.patronescreacionales.Builder.MainBuilderDemo"
```

> Nota: si `mvn` no esta instalado, usa la Opcion 1 o 2.

## Que muestra la demo

1. **Con Director:** `construirPCGamer()` y `construirPCOficina()` (recetas fijas).
2. **Sin Director:** PC de streaming 100% personalizada paso a paso.
3. **Reutilizacion:** el mismo builder arma varias computadoras distintas.

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
