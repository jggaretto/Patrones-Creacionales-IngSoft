package com.patronescreacionales.AbstractFactory;

public class CasillaWindows implements Casilla {
    @Override
    public void pintar() {
        System.out.println("Renderizando casilla estilo Windows");
    }
}