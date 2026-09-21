package com.patronescreacionales.FactoryMethod;

/** Ejemplo del patron Factory Method aplicado a distintos tipos de entrega. */
public final class FactoryMethodDemo {

    public interface Transporte {
        String entregar();
    }

    public static final class Camion implements Transporte {
        @Override
        public String entregar() {
            return "Entrega por carretera en camion";
        }
    }

    public static final class Barco implements Transporte {
        @Override
        public String entregar() {
            return "Entrega por mar en barco";
        }
    }

    public abstract static class Logistica {
        public String planificarEntrega() {
            return crearTransporte().entregar();
        }

        protected abstract Transporte crearTransporte();
    }

    public static final class LogisticaTerrestre extends Logistica {
        @Override
        protected Transporte crearTransporte() {
            return new Camion();
        }
    }

    public static final class LogisticaMaritima extends Logistica {
        @Override
        protected Transporte crearTransporte() {
            return new Barco();
        }
    }

    public static void main(String[] args) {
        System.out.println(new LogisticaTerrestre().planificarEntrega());
        System.out.println(new LogisticaMaritima().planificarEntrega());
    }

    private FactoryMethodDemo() { }
}
