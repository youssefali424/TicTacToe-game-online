/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;


import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Record {
    
    

    boolean  CheckFlag = false ;
    Connection con=null;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pstSearch;
    PreparedStatement pstGameNums;
    PreparedStatement pstGetId;
    PreparedStatement pstGetScore;
    PreparedStatement pstSetScore;
    //entranceBase entrance = new entranceBase();

    public Record(){
     try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TicTac", "root", "passwd");
            pst =con.prepareStatement("insert into record values ( ?, ? , ?, ?, ?,?);");
            pst1 =con.prepareStatement("SELECT Max(GameNo) FROM record  WHERE  PlayerNo=?;");
            pstSearch =con.prepareStatement("select * from Record where PlayerNo = ? and GameNo = ? and MoveNo between 0 and 9");
            pstGameNums =con.prepareStatement("SELECT DISTINCT GameNo From record where PlayerNo = ?;");
            pstGetId = con.prepareStatement("SELECT No From Name_Password where UserName = ? ;");
            pstGetScore=con.prepareStatement("SELECT score From Name_Password where UserName = ? ;");
            pstSetScore=con.prepareStatement("update Name_Password set Score = ? where No= ?;");

     }
        catch (SQLException ex) {ex.printStackTrace();}   
}
    //PlayerNo     GameNo       MoveNo     MoveX     MoveY   X_Y
public boolean record (int PlayerNo , int GameNo , int MoveNo , int MoveX, int MoveY, String X_Y){
        try {
            
                pst.setInt(1, PlayerNo);
                pst.setInt(2, GameNo);
                pst.setInt(3, MoveNo);
                pst.setInt(4, MoveX);
                pst.setInt(5, MoveY);
                pst.setString(6, X_Y);
                
                int rs = pst.executeUpdate();
                if (rs != 0)CheckFlag = true;
            } catch (SQLException ex) {
                //Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        close();
        return CheckFlag;
        
}
    public int chechGameNum(int PlayerNo) {
        
            try {
                pst1.setInt(1, PlayerNo);
                ResultSet rs = pst1.executeQuery();
                if (rs.next()) {
                    int value = rs.getInt("Max(GameNo)");
                    if (rs.wasNull()) {
                        value = -1;
                    }
                    CheckFlag = true;
                    close();
                    return value;
                } else {
                    close();
                    return -1;
                }
            } catch (SQLException ex) {
                close();
                Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
                return -1;
            }
            
    }
    public LinkedHashMap<Point,String> getGame(int PlayerNo , int GameNo){
        LinkedHashMap<Point,String> hashTemp=new LinkedHashMap<>();
        try {
            
            pstSearch.setInt(1, PlayerNo);
            pstSearch.setInt(2, GameNo);
            
            ResultSet rs = pstSearch.executeQuery();
            
            
            while  (rs.next()) {
                
                int x=rs.getInt(4);
                int y=rs.getInt(5);
                String s=rs.getString(6);
                hashTemp.put(new Point(x,y), s);
            }
        } catch (SQLException ex) {
            hashTemp=null;
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return hashTemp;
    }
    public List getGameNum(int id){
    List<String> listTemp=new ArrayList<>();
    try {
            pstGameNums.setInt(1, id);
            ResultSet rs = pstGameNums.executeQuery();
            
            while  (rs.next()) {
                
                int x=rs.getInt("GameNo");
                if (rs.wasNull()) {
                        
                        return null;
                    }
                listTemp.add("game "+x);
            }
        } catch (SQLException ex) {
            listTemp=null;
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listTemp;
    }
    public int getScore(String name){
        try {
            pstGetScore.setString(1, name);
            ResultSet rs = pstGetScore.executeQuery();
            
            while  (rs.next()) {
                
                int x=rs.getInt("score");
                if (rs.wasNull()) {
                        
                        return -1;
                    }
                return x;
            }
        } catch (SQLException ex) {
             Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        close();
        return -1;
    
    }
    public int getId(String name){
    try {
            pstGetId.setString(1, name);
            ResultSet rs = pstGetId.executeQuery();
            
            while  (rs.next()) {
                
                int x=rs.getInt("NO");
                if (rs.wasNull()) {
                        
                        return -1;
                    }
                return x;
            }
        } catch (SQLException ex) {
             Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        close();
        return -1;
    }
    public void setScore(int id,int score){
        try {
            pstSetScore.setInt(2, id);
            pstSetScore.setInt(1, score);
            
            int rs = pstSetScore.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    private void close(){
    if(con!= null)
    {try {
            con.close();
            pst.close();
        } catch (SQLException ex) {
            
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }

    
}