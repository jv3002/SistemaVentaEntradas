import java.util.ArrayList;

public class Venta {
    ArrayList<Seccion> secciones;
    double precioBase;

    public Venta(double precioBase) {
        this.precioBase = precioBase; // Asegúrate de que el precio base sea 10000
        this.secciones = new ArrayList<>();
        inicializarSecciones();
    }

    private void inicializarSecciones() {
        secciones.add(new Seccion("VIP"));
        secciones.add(new Seccion("Palco"));
        secciones.add(new Seccion("Platea Baja"));
        secciones.add(new Seccion("Platea Alta"));
        secciones.add(new Seccion("Galeria"));
    }

    public void mostrarSecciones() {
        System.out.println("\nSecciones disponibles:");
        for (int i = 0; i < secciones.size(); i++) {
            System.out.println((i + 1) + ". " + secciones.get(i).nombre);
        }
    }

    public Seccion obtenerSeccion(int opcion) {
        if (opcion < 1 || opcion > secciones.size()) return null;
        return secciones.get(opcion - 1);
    }
}
