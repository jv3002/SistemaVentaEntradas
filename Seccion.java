import java.util.ArrayList;

public class Seccion {
    String nombre;
    ArrayList<Asiento> asientos;

    public Seccion(String nombre) {
        this.nombre = nombre;
        this.asientos = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            asientos.add(new Asiento(i));
        }
    }

    public void mostrarAsientosDisponibles() {
        System.out.println("Asientos disponibles en seccion: " + nombre);
        for (Asiento a : asientos) {
            if (a.disponible) {
                System.out.println("Asiento " + a.numero);
            }
        }
    }

    public Asiento obtenerAsiento(int numero) {
        if (numero < 1 || numero > asientos.size()) return null;
        return asientos.get(numero - 1);
    }
}
