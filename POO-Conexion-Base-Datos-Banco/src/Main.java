import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola xd");
        JFrame frame = new JFrame("xd");
        frame.setContentPane(new Ingreso().Inicio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);

        /*Vehiculos vehiculos =  new Vehiculos();
        System.out.println("Primer vehiculo");
        vehiculos.setNombre("Ferrari");
        vehiculos.setTipo("Carro");
        vehiculos.setCaracteristicas("Potente carro de velocidades altas");
        vehiculos.setPrecio(1555.50);
        vehiculos.setFoto("null");

        vehiculos.agregarItemBDD(vehiculos.getNombre(), vehiculos.getTipo(), vehiculos.getCaracteristicas(),
                vehiculos.getPrecio(), vehiculos.getFoto());*/
    }
}