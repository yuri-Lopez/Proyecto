package Conexion; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private String url="jdbc:mysql://localhost:3306/";
    private String bd="bdd";
    private String user = "root";
    private String password="";
    private String driver ="com.mysql.cj.jdbc.Driver";
    private Connection con;
    private Statement st;
    private ResultSet rs;

public DB (){
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url+"bdd",user, password);
            st=con.createStatement();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
     public void consultar() {
    try {
        String query = "SELECT * FROM empleado";
        rs = st.executeQuery(query);
        while (rs.next()) {
            int IDempleado = rs.getInt("IDempleado");
            String Códigoempleado = rs.getString("Código empleado");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String documento = rs.getString("documento");
            String correoElectronico = rs.getString("correo_electronico");
            String cargo = rs.getString("cargo");
            
            // Imprimir cada empleado
            System.out.println("ID empleado: " + IDempleado);
            System.out.println("Código empleado: " + "Códigoempleado");
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Documento: " + documento);
            System.out.println("Correo electrónico: " + correoElectronico);
            System.out.println("Cargo: " + cargo);
            System.out.println(); // Salto de línea entre empleados
        }
        rs.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    public void insertar() {
    try {
        String query = "INSERT INTO empleado VALUES (8, '56', 'Geraldin', 'Gonzalez', 456789, 'geraf@hotmail.com', 'docente')";
        st.executeUpdate(query);
        System.out.println("El empleado se registró satisfactoriamente.\n");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    public void actualizar() {
    try {
        String query = "UPDATE empleado SET nombre = 'Camila', apellido = 'Gonzalez' WHERE IDempleado = 3";
        int filasActualizadas = st.executeUpdate(query);
        
        if (filasActualizadas > 0) {
            System.out.println("El empleado se actualizó correctamente.\n");
        } else {
            System.out.println("No se encontró empleado con ID = 3 para actualizar.\n");
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    public void eliminar() {
    try {
        String query = "DELETE FROM empleado WHERE IDempleado = 1";
        int filasEliminadas = st.executeUpdate(query);
        
        if (filasEliminadas > 0) {
            System.out.println("El empleado se eliminó correctamente.\n");
        } else {
            System.out.println("No se encontró empleado con ID = 1 para eliminar.\n");
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}



}
    

   