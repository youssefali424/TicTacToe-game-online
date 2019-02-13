/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author SherifAbdelmoniem
 */
public class game {
    
    Point[][] points;
    public game(){

    points=new Point[8][3];
    int line=0;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            points[line][j]=new Point(i,j);    
          }
        line++;
    }
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            points[line][j]=new Point(j,i);    
          }
        line++;
    }
    points[line][0]=new Point(0,0);
    points[line][1]=new Point(1,1);
    points[line][2]=new Point(2,2);
    line++;
    points[line][0]=new Point(2,0);
    points[line][1]=new Point(1,1);
    points[line][2]=new Point(0,2);
    }
     
    public int checkWin(HashMap<Point, String> hmap) {
     int[] score=new int[8];
       for(int i=0;i<8;i++){
           score[i]= getLine(hmap,points[i]);
           if(score[i]>=100){
           
           return score[i];
           }
           else if(score[i]<=-100){
           return score[i];
           }
           
           }
       return 0 ;
    }
    public int getLine(HashMap<Point,String> hmap,Point[] x){
        int score=0;int turnX=1;int turnO=1;
        for(int i=0;i<3;i++){
    if(hmap.get(x[i])!=null&&hmap.get(x[i]).matches("x")){
      
        score+=(1*turnX);
       turnX=turnX*10;
    }
    else if(hmap.get(x[i])!=null&&hmap.get(x[i]).matches("o")){
       score-=(1*turnO);
       turnO=turnO*10;
    }
        
        }
        return score;
    
    }
    
}
