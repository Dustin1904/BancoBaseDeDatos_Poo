import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ingreso {
    JPanel Inicio;
    private JTextField textField1;
    private JTextField tipo;
    private JTextField caract;
    private JTextField precio;
    private JTextField foto;
    private JButton enviarDatosButton;
    private JLabel nombre;
    private JButton visuzalizarDatosButton;

    public Ingreso() {
        enviarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectos","root","Tsuki1904")){
                    String sql = "INSERT INTO vehiculos (nombre, tipo, caracteristicas, precio, foto) VALUES (?,?,?,?,?)";
                    try(PreparedStatement statement=connection.prepareStatement(sql)) {
                        statement.setString(1, nombre.getText());
                        statement.setString(2, tipo.getText());
                        statement.setString(3, caract.getText());
                        statement.setDouble(4, Double.parseDouble(precio.getText()));
                        statement.setString(5, foto.getText());
                        int valor = statement.executeUpdate();
                        if (valor>0){
                            UIManager.put("OptionPane.minimumSize", new Dimension(200, 200));
                            JOptionPane.showMessageDialog(null,"Datos ingresados correctamente");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"ERROR al ingresar los datos");
                        }
                    } catch (Exception exception) {
                        System.out.println(exception);
                    }
                }catch (SQLException exception){
                    System.out.println(exception);
                    exception.printStackTrace();
                }
            }
        });
        visuzalizarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = new DefaultTableModel();
                JTable tabla = new JTable(model);
                try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectos","root","Tsuki1904")) {
                    String sql = "SELECT * FROM vehiculos";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnas = metaData.getColumnCount();
                    for (int i = 1 ; i<= columnas; i++){
                        model.addColumn(metaData.getColumnLabel(i));
                    }
                    while (resultSet.next()){
                        Object[] fila = new Object[columnas];
                        for (int i = 1 ; i<columnas; i++){
                            fila[i] = resultSet.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                    JScrollPane scrollPane = new JScrollPane(tabla);
                    JFrame datos = new JFrame("Datos");
                    datos.setContentPane(new JTable((TableModel) tabla));
                    datos.pack();
                    datos.setSize(500,500);
                    datos.setVisible(true);


                }catch (SQLException exception){
                    System.out.println(exception);
                }
            }
        });
    }
}
