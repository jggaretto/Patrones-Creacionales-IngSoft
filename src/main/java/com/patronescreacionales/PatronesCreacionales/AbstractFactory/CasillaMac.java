package com.patronescreacionales.AbstractFactory;

public class CasillaMac implements Casilla {
    @Override
    public void pintar() {
        System.out.println("Renderizando casilla estilo macOS");
    }
}
