/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nhi
 */
public class Connect {
    public static Connection getConnection(){
        Connection connecttion =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String DB_URL = "jdbc:mysql://localhost:3306/quanlygsneaker";
            String USER_NAME = "root";
            String PASSWORD = "ttn1101";
            connecttion = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch ( Exception ex) {
            JOptionPane.showInputDialog(null,"Ket noi CSDL thất bại","Thông báo",1);
        }
        return connecttion;

    }
    public static void closeConnection(Connection con){
        if (con!=null) {
            try {
                con.close();
            } catch (Exception ex) {
                JOptionPane.showInputDialog(null,"Dong","Thông báo",2);
            }
            
        }
    }
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
