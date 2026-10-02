package com.patronescreacionales.Builder.src;

/**
 * CONCRETE BUILDER - Implementacion unica del Builder.
 * Arma una Computadora paso a paso y permite encadenamiento fluido.
 * La diferencia entre una PC Gamer / Oficina / Economica
 * NO esta aca, la define el Director o el cliente al usarlo.
 */
public class ComputadoraBuilderImpl implements ComputadoraBuilder {

    private Computadora computadora;

    public ComputadoraBuilderImpl() {
        this.reset();
    }

    @Override
    public void reset() {
        this.computadora = new Computadora();
    }

    @Override
    public ComputadoraBuilder setCPU(String cpu) {
        computadora.setCpu(cpu);
        return this;
    }

    @Override
    public ComputadoraBuilder setRAM(int ramGB) {
        computadora.setRamGB(ramGB);
        return this;
    }

    @Override
    public ComputadoraBuilder setAlmacenamiento(int gb, String tipo) {
        computadora.setAlmacenamientoGB(gb);
        computadora.setTipoAlmacenamiento(tipo);
        return this;
    }

    @Override
    public ComputadoraBuilder setGPU(String gpu) {
        computadora.setGpu(gpu);
        return this;
    }

    @Override
    public ComputadoraBuilder setSistemaOperativo(String so) {
        computadora.setSistemaOperativo(so);
        return this;
    }

    @Override
    public ComputadoraBuilder setRefrigeracionLiquida(boolean tiene) {
        computadora.setRefrigeracionLiquida(tiene);
        return this;
    }

    @Override
    public ComputadoraBuilder setLucesRGB(boolean tiene) {
        computadora.setLucesRGB(tiene);
        return this;
    }

    @Override
    public Computadora build() {
        Computadora resultado = this.computadora;
        this.reset(); // deja el builder listo para reutilizar
        return resultado;
    }
}
