package com.patronescreacionales.AbstractFactory;

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