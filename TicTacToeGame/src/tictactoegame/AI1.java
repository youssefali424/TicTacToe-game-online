/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

/**
 *
 * @author youssef ali
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author youssef ali
 */
public class AI1 implements MainAi {
    Point[][] points;
    Point[] allPoints;
    boolean end=false;
     
    public AI1(){
        
        allPoints=new Point[9];
        int index=0;
         for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            allPoints[index]=new Point(i,j);
            index++;
          }
        
    }
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
    public Point check(HashMap<Point,String> hmap){
    int[] temp=minimax(hmap,"x");
    return allPoints[temp[1]];
    }
    public int[] minimax(HashMap<Point,String> hmap,String player){
        int[] scoreMap=new int[2];
        HashMap<Point,String> hash=hmap;
        ArrayList<int[]> arr=new ArrayList<>();
    int tem=checkWin(hmap);
        if(tem!=0){
            int[] i={tem,-1};
        return i;
        }    
    if(hmap.size()>=9){
        int[] i={0,-1};
        
        return i;}
    else{
        
    for(int i=0;i<9;i++){
           boolean flag=true;
           Iterator it = hmap.entrySet().iterator();
           while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        Point temp=(Point) pair.getKey();
            if(allPoints[i].equals(temp)){
            flag=false;
            break;
            }
                
           }
           if(flag){
              
              if(player.matches("x")){
                  hash.put(allPoints[i], "x");
                  scoreMap=minimax(hash,"o");
                  int y=scoreMap[0];
                  scoreMap[1]=i;
                  arr.add(scoreMap);
                  hash.remove(allPoints[i]);
                     }
              else{
                  hash.put(allPoints[i], "o");
                  scoreMap=minimax(hash,"x");
                  int y=scoreMap[0];
                  scoreMap[1]=i;
                  arr.add(scoreMap);
                  
                  hash.remove(allPoints[i]);}
           }
       }
    int index=0;
    if(player.matches("x")){
    int bestScore=-1000;
        for (int i=0;i<arr.size();i++) {
            if(arr.get(i)[0]>bestScore){
                bestScore=arr.get(i)[0];
                index=i;
            }
        }
    }
    else{int bestScore=1000;
        for (int i=0;i<arr.size();i++) {
            if(arr.get(i)[0]<bestScore){
                bestScore=arr.get(i)[0];
                index=i;
            }
        }
    }
    return arr.get(index);
    }
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
    @Override
    public int checkWin(HashMap<Point,String> hmap){
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
}

