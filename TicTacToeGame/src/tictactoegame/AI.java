/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class AI implements MainAi{
    Point[][] points;
    Point[] allPoints;
    boolean end=false;
    
    public AI(){
        
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
           int[] score=new int[8];
           int[] pointScore=new int[9];
           int winIndex=-1;
           for(int i=0;i<8;i++){
           score[i]= getLine(hmap,points[i]);
           if(score[i]>100){
               end=true;
           
           
           }
           else if(score[i]<-100){end=true;}
           if(score[i]>10){winIndex=i;break;}
           }
           if(!end){
       HashMap<Point,Integer> scoreMap=new HashMap<>();
       pointScore[0]=score[0]+score[3]+score[6];
       pointScore[1]=score[0]+score[4];
       pointScore[2]=score[0]+score[5]+score[7];
       pointScore[3]=score[1]+score[3];
       pointScore[4]=score[1]+score[4]+score[6]+score[7];
       pointScore[5]=score[1]+score[5];
       pointScore[6]=score[2]+score[3]+score[7];
       pointScore[7]=score[2]+score[4];
       pointScore[8]=score[2]+score[5]+score[6];
       if(winIndex!=-1){
           Point currPoint=new Point(10,10);
       if(winIndex==6||winIndex==7){
       currPoint=checkdiag(hmap,winIndex);
       
       }
       else{
           if(winIndex<3){  
           currPoint=checkLineY(hmap,winIndex);
       }
       else{
           currPoint=checkLineX(hmap,winIndex-3);
       }
           
       }
       System.out.println(currPoint);
       return currPoint;
       }
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
           scoreMap.put(allPoints[i], pointScore[i]);
           }
       }
       Iterator it = scoreMap.entrySet().iterator();
       int maxScore=0;
       Point currPoint=null;
       ArrayList<Point> temPoint=new ArrayList<>();
           while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        int sc=(int) pair.getValue();
            if(Math.abs(sc)==Math.abs(maxScore)){
                temPoint.add((Point) pair.getKey());
                if(sc>0||Math.abs(sc)!=maxScore){
                  
                  maxScore=sc;
            
                currPoint=(Point) pair.getKey();
                }
                
            }
            else if(Math.abs(sc)>Math.abs(maxScore)){
                maxScore=sc;
                
                currPoint=(Point) pair.getKey();
            }
                
           }
           
           
       System.out.println(currPoint);
       return currPoint;}
       
           }
           return null;
       }
    @Override
       public int checkWin(HashMap<Point,String> hmap){
           int[] score=new int[8];
       for(int i=0;i<8;i++){
           score[i]= getLine(hmap,points[i]);
           if(score[i]>=100){
           
           end=true;
           return score[i];
           }
           else if(score[i]<=-100){
           end=true;
           return score[i];
           }
           
           }
       return 0;
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
    
    public Point checkdiag(HashMap<Point,String> hmap,int x){
        
        if(x==6){
            
            Iterator it = hmap.entrySet().iterator();
            for(int i=0;i<3;i++){
                boolean flag=true;
           while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        Point temp=(Point) pair.getKey();
            
            if(new Point(i,i).equals(temp)){
            flag=false;
            break;
            }
                
           }
           if(flag){return new Point(i,i);}
            }
            
        }
        else{
        
            boolean[] flag=new boolean[3];
            flag[0]=true;
            flag[1]=true;
            flag[2]=true;
            Iterator it = hmap.entrySet().iterator();
            
           while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        Point temp=(Point) pair.getKey();
            
            if(new Point(0,2).equals(temp)){
            flag[0]=false;
            
            }
            if(new Point(1,1).equals(temp)){
            flag[1]=false;
            
            }
            if(new Point(2,0).equals(temp)){
            flag[2]=false;
            
            }
                
           }
           if(flag[0]){return new Point(0,2);}
            if(flag[1]){return new Point(1,1);}
            if(flag[2]){return new Point(2,0);}
        }
        
        return null;
        
        
    }
    public Point checkLineY(HashMap<Point,String> hmap,int x){
       
            
            
            for(int j=0;j<3;j++){
                Iterator it = hmap.entrySet().iterator();
                boolean flag=true;
           while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        Point temp=(Point) pair.getKey();
            
            if(new Point(x,j).equals(temp)){
            flag=false;
            break;
            }
                
           }
           
           if(flag){return new Point(x,j);}
        
    }
            
  
    return null;
    }
    
     public Point checkLineX(HashMap<Point,String> hmap,int x){
       
            
         for(int j=0;j<3;j++){
             boolean flag=true;
             Iterator it = hmap.entrySet().iterator();
            while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        Point temp=(Point) pair.getKey();
            
            if(new Point(j,x).equals(temp)){
            flag=false;
            
            break;
            }
                
           }
            
           if(flag){return new Point(j,x);}
               
    }
            
            
     
    return null;
    }

}
