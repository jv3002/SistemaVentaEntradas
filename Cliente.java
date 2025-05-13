public class Cliente {
    String nombre;
    int edad;
    String tipoCliente;
    double descuento;

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoCliente = determinarTipoCliente();
        this.descuento = aplicarDescuento();
    }

    private String determinarTipoCliente() {
        if (edad < 18) return "Estudiante";
        if (edad >= 60) return "Tercera Edad";
        if (edad < 12) return "Niño";
        if (edad >= 18 && edad < 60) return "Mujer"; // Para el descuento de mujeres
        return "Ninguno";
    }

    private double aplicarDescuento() {
        switch (tipoCliente) {
            case "Estudiante": return 0.15;
            case "Tercera Edad": return 0.25;
            case "Niño": return 0.10;
            case "Mujer": return 0.20;
            default: return 0;
        }
    }
}
