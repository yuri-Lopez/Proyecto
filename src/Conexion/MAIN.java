/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Conexion;

/**
 *
 * @author LOPEZ YURI
 */
public class MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         DB objcli =new DB();
         objcli.consultar();
         objcli.insertar();
         objcli.actualizar();
         objcli.eliminar();
    }
         
    }
    
}
