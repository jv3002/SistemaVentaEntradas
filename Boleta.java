import java.text.DecimalFormat;

public class Boleta {
    Cliente cliente;
    Seccion seccion;
    Asiento asiento;
    double precioOriginal;
    double precioConDescuento;

    public Boleta(Cliente cliente, Seccion seccion, Asiento asiento, double precioOriginal) {
        this.cliente = cliente;
        this.seccion = seccion;
        this.asiento = asiento;
        this.precioOriginal = precioOriginal;
        this.precioConDescuento = precioOriginal * (1 - cliente.descuento);
    }

    public void imprimirBoleta() {
        DecimalFormat formatoPrecio = new DecimalFormat("#.00"); // Formato de precio con 2 decimales
        System.out.println("\n========= BOLETA =========");
        System.out.println("Cliente: " + cliente.nombre);
        System.out.println("Edad: " + cliente.edad);
        System.out.println("Tipo Cliente: " + cliente.tipoCliente);
        System.out.println("Seccion: " + seccion.nombre);
        System.out.println("Asiento: " + asiento.numero);
        System.out.println("Precio Original: $" + formatoPrecio.format(precioOriginal));
        System.out.println("Descuento: " + (cliente.descuento * 100) + "%");
        System.out.println("Total a Pagar: $" + formatoPrecio.format(precioConDescuento));
        System.out.println("==========================\n");
    }
}
