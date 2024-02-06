import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Vehiculos {
    int id;
    String nombre, tipo, caracteristicas;
    double precio;
    String foto;
    public Vehiculos(int id, String nombre, String tipo, String caracteristicas, double precio, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
        this.foto=foto;
    }
    public Vehiculos(){
        //Constructor vacion
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFoto(String foto){
        this.foto=foto;
    }
    public String getFoto(){
        return foto;
    }
    public void agregarItemBDD(String nombre, String tipo, String caracteristicas, double precio, String foto){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectos","root","Tsuki1904")){
            String sql = "INSERT INTO vehiculos (nombre, tipo, caracteristicas, precio, foto) VALUES (?,?,?,?,?)";
            try(PreparedStatement statement=connection.prepareStatement(sql)) {
                statement.setString(1, nombre);
                statement.setString(2, tipo);
                statement.setString(3, caracteristicas);
                statement.setDouble(4, precio);
                statement.setString(5, foto);
                statement.executeUpdate();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }catch (SQLException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
