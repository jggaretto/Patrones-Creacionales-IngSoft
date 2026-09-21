/** Singleton: una configuracion inmutable compartida por la aplicacion. */
public class Singleton {
    public static final class Configuracion {
        // La JVM inicializa esta instancia una sola vez al inicializar la clase.
        private static final Configuracion INSTANCIA = new Configuracion();
        private final String nombreAplicacion = "Campus virtual";

        private Configuracion() { }

        public static Configuracion getInstancia() {
            return INSTANCIA;
        }

        public String getNombreAplicacion() {
            return nombreAplicacion;
        }
    }

    public static void main(String[] args) {
        Configuracion primera = Configuracion.getInstancia();
        Configuracion segunda = Configuracion.getInstancia();
        assert primera == segunda : "Se crearon dos instancias";
        assert primera.getNombreAplicacion().equals("Campus virtual");
        System.out.println("Aplicacion: " + primera.getNombreAplicacion());
        System.out.println("Misma instancia: " + (primera == segunda));
    }
}