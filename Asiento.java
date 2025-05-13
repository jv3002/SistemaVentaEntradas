public class Asiento {
    int numero;
    boolean disponible;

    public Asiento(int numero) {
        this.numero = numero;
        this.disponible = true;
    }

    public boolean reservar() {
        if (disponible) {
            disponible = false;
            return true;
        }
        return false;
    }
}
