# Patrones creacionales

Ejemplos en Java 17 de los cinco patrones creacionales solicitados:

- **Singleton**: configuración compartida e inmutable.
- **Factory Method**: logística que crea transportes terrestres o marítimos.
- **Abstract Factory**: familias de controles gráficos para macOS y Windows.
- **Builder**: construcción paso a paso de computadoras, con y sin Director.
- **Prototype**: copia independiente de documentos con etiquetas.

## Compilar y comprobar

Desde la raíz del repositorio, con JDK 17 o superior:

```powershell
$out = "out"
$sources = Get-ChildItem -Recurse -Filter "*.java" "src/main/java"
javac --release 17 -encoding UTF-8 -d $out $sources.FullName
java -cp $out com.patronescreacionales.Main
```

La última orden ejecuta la comprobación integrada de los cinco patrones y debe mostrar:

```text
OK: los cinco patrones funcionan correctamente.
```

También se pueden ejecutar las demos individuales:

```powershell
java -cp $out com.patronescreacionales.Singleton.Singleton
java -cp $out com.patronescreacionales.AbstractFactory.Aplicacion
java -cp $out com.patronescreacionales.Builder.src.MainBuilderDemo
java -cp $out com.patronescreacionales.FactoryMethod.FactoryMethodDemo
java -cp $out com.patronescreacionales.Prototype.PrototypeDemo
```

Maven está configurado en `pom.xml` para compilar el proyecto con Java 17, aunque las comprobaciones anteriores no requieren Maven ni dependencias externas.
