package com.patronescreacionales;

import com.patronescreacionales.AbstractFactory.BotonMac;
import com.patronescreacionales.AbstractFactory.CasillaMac;
import com.patronescreacionales.AbstractFactory.MacFactory;
import com.patronescreacionales.Builder.src.Computadora;
import com.patronescreacionales.Builder.src.ComputadoraBuilder;
import com.patronescreacionales.Builder.src.ComputadoraBuilderImpl;
import com.patronescreacionales.FactoryMethod.FactoryMethodDemo.LogisticaMaritima;
import com.patronescreacionales.FactoryMethod.FactoryMethodDemo.LogisticaTerrestre;
import com.patronescreacionales.Prototype.PrototypeDemo.Documento;
import com.patronescreacionales.Singleton.Singleton.Configuracion;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        verificar(Configuracion.getInstancia() == Configuracion.getInstancia(), "Singleton");

        verificar(new LogisticaTerrestre().planificarEntrega().contains("camion"), "Factory Method terrestre");
        verificar(new LogisticaMaritima().planificarEntrega().contains("barco"), "Factory Method maritimo");

        MacFactory macFactory = new MacFactory();
        verificar(macFactory.crearBoton() instanceof BotonMac, "Abstract Factory boton");
        verificar(macFactory.crearCasilla() instanceof CasillaMac, "Abstract Factory casilla");

        ComputadoraBuilder builder = new ComputadoraBuilderImpl();
        Computadora primera = builder.setCPU("CPU 1").setRAM(16).build();
        Computadora segunda = builder.setCPU("CPU 2").setRAM(8).build();
        verificar(primera != segunda && primera.getCpu().equals("CPU 1") && segunda.getCpu().equals("CPU 2"), "Builder");

        Documento original = new Documento("Original", List.of("base"));
        Documento copia = original.copiar();
        copia.setTitulo("Copia");
        copia.agregarEtiqueta("nueva");
        verificar(original != copia && original.getTitulo().equals("Original")
                && original.getEtiquetas().equals(List.of("base")), "Prototype");

        System.out.println("OK: los cinco patrones funcionan correctamente.");
    }

    private static void verificar(boolean condicion, String patron) {
        if (!condicion) {
            throw new IllegalStateException("Fallo en " + patron);
        }
    }
}
