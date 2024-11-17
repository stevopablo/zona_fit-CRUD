package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        var baseDados = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/"+ baseDados;
        var usuario = "root";
        var password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
        }catch (Exception e){
            System.out.println("Error ao tentar conectar com base de dados = " + e);
        }
        return conexion;
    };

    public static void main(String[] args) {
        var conextion = Conexion.getConexion();
        if(conextion != null){
            System.out.println("conextion = " + conextion);
        }else{
            System.out.println("Error ao conectar");
        }
    }
}
