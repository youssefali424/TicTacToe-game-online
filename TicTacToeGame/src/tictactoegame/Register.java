/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Register {
    boolean  CheckFlag = false ;
    Connection con;
    PreparedStatement pst;
    //entranceBase entrance = new entranceBase();

    public Register(){
     try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TicTac", "root", "passwd");
            pst =con.prepareStatement("insert into Name_Password values (default , ?, ? , ? , 0)");
            
       }
        catch (SQLException ex) {ex.printStackTrace();}   
}
public boolean register (String name , String username , String password ){
        try {
            
                pst.setString(1, name);
                pst.setString(2, username);
                pst.setString(3, password);
                int rs = pst.executeUpdate();
                if (rs != 0)CheckFlag = true;
            } catch (SQLException ex) {
                //Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            con.close();
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CheckFlag;
        
}

    
}
