package com.patronescreacionales.AbstractFactory;

public class BotonWindows implements Boton {
    @Override
    public void pintar() {
        System.out.println("Renderizando botón estilo Windows");
    }
}