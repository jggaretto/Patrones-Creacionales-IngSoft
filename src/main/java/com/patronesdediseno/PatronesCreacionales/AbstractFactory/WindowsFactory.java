package com.patronescreacionales.AbstractFactory;

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