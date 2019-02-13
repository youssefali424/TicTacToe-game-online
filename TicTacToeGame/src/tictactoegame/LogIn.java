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

/**
 *
 * @author DELL
 */
public class LogIn{
    boolean  CheckFlag = false ;
    Connection con;
    PreparedStatement pst;


    public  LogIn() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TicTac", "root", "passwd");
            pst =con.prepareStatement("select * from Name_Password where UserName = ? and Password = ? ");
         
       
       }
        catch (SQLException ex) {ex.printStackTrace();}   
    
}
    public boolean  login(String name, String password) {
        
       
            
            try {
                pst.setString(1, name);
                
                pst.setString(2, password);
                
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    CheckFlag = true;
                    
                }
            } catch (SQLException ex ) {
               // Logger.getLogger(TicTac_DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
             try {
            con.close();
            pst.close();
            
        } 
        catch (SQLException ex ) {
          //  Logger.getLogger(TicTac_DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    return CheckFlag ;
    }
    
    
}
