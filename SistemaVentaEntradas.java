import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class SistemaVentaEntradas {
    private JFrame frame;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JComboBox<String> cbSecciones;
    private JComboBox<Integer> cbAsientos;
    private JButton btnReservar;
    private JTextArea taBoleta;
    private Venta venta;
    private Cliente cliente;

    public SistemaVentaEntradas() {
        venta = new Venta(10000); // Establecer precio base a 10000
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Venta de Entradas");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel lblNombre = new JLabel("Nombre:");
        frame.getContentPane().add(lblNombre);
        txtNombre = new JTextField(20);
        frame.getContentPane().add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        frame.getContentPane().add(lblEdad);
        txtEdad = new JTextField(5);
        frame.getContentPane().add(txtEdad);

        JLabel lblSeccion = new JLabel("Seleccione una Sección:");
        frame.getContentPane().add(lblSeccion);

        cbSecciones = new JComboBox<>();
        for (Seccion s : venta.secciones) {
            cbSecciones.addItem(s.nombre);
        }
        frame.getContentPane().add(cbSecciones);

        JLabel lblAsiento = new JLabel("Seleccione un Asiento (1-5):");
        frame.getContentPane().add(lblAsiento);

        cbAsientos = new JComboBox<>();
        for (int i = 1; i <= 5; i++) {
            cbAsientos.addItem(i);
        }
        frame.getContentPane().add(cbAsientos);

        btnReservar = new JButton("Reservar");
        frame.getContentPane().add(btnReservar);

        taBoleta = new JTextArea(10, 30);
        taBoleta.setEditable(false);
        frame.getContentPane().add(new JScrollPane(taBoleta));

        btnReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                int seccionIndex = cbSecciones.getSelectedIndex();
                int asientoNumero = (Integer) cbAsientos.getSelectedItem();

                cliente = new Cliente(nombre, edad);
                Seccion seccion = venta.obtenerSeccion(seccionIndex + 1);
                Asiento asiento = seccion.obtenerAsiento(asientoNumero);

                if (asiento == null || !asiento.reservar()) {
                    taBoleta.setText("El asiento seleccionado ya está reservado.");
                } else {
                    Boleta boleta = new Boleta(cliente, seccion, asiento, venta.precioBase);
                    DecimalFormat formatoPrecio = new DecimalFormat("#.00"); // Formato de precio con 2 decimales
                    taBoleta.setText("");
                    taBoleta.append("Boleta generada\n");
                    taBoleta.append("Cliente: " + cliente.nombre + "\n");
                    taBoleta.append("Edad: " + cliente.edad + "\n");
                    taBoleta.append("Tipo Cliente: " + cliente.tipoCliente + "\n");
                    taBoleta.append("Sección: " + seccion.nombre + "\n");
                    taBoleta.append("Asiento: " + asiento.numero + "\n");
                    taBoleta.append("Precio Original: $" + formatoPrecio.format(venta.precioBase) + "\n");
                    taBoleta.append("Descuento: " + (cliente.descuento * 100) + "%\n");
                    taBoleta.append("Total a Pagar: $" + formatoPrecio.format(boleta.precioConDescuento) + "\n");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SistemaVentaEntradas();
    }
}
