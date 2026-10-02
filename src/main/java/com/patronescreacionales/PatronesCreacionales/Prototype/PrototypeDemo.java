package com.patronescreacionales.Prototype;

import java.util.ArrayList;
import java.util.List;

/** Ejemplo del patron Prototype con una copia independiente de un documento. */
public final class PrototypeDemo {

    public interface Prototipo<T> {
        T copiar();
    }

    public static final class Documento implements Prototipo<Documento> {
        private String titulo;
        private final List<String> etiquetas;

        public Documento(String titulo, List<String> etiquetas) {
            this.titulo = titulo;
            this.etiquetas = new ArrayList<>(etiquetas);
        }

        @Override
        public Documento copiar() {
            return new Documento(titulo, etiquetas);
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public List<String> getEtiquetas() {
            return List.copyOf(etiquetas);
        }

        public void agregarEtiqueta(String etiqueta) {
            etiquetas.add(etiqueta);
        }
    }

    public static void main(String[] args) {
        Documento original = new Documento("Informe", List.of("software"));
        Documento copia = original.copiar();
        copia.setTitulo("Informe copiado");
        copia.agregarEtiqueta("patrones");

        System.out.println("Original: " + original.getTitulo() + " " + original.getEtiquetas());
        System.out.println("Copia: " + copia.getTitulo() + " " + copia.getEtiquetas());
    }

    private PrototypeDemo() { }
}
