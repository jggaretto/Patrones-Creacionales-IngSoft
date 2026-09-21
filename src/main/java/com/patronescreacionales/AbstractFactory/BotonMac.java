package com.patronescreacionales.AbstractFactory;

public class BotonMac implements Boton {
    @Override
    public void pintar() {
        System.out.println("Renderizando botón estilo macOS");
    }
}
