//koneksi
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class koneksi {

    private static Connection koneksi;

     public static Connection getConnection() {
        try {
            
            String url = "jdbc:mysql://localhost:3306/db_sistem_sembako";
            String user = "root";
            String pass = "";

            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;

        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            return null;
        }
    }
}

