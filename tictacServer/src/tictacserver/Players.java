/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacserver;

import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youssef ali
 */
public class Players {

    static Point[][] points;
    Socket mySocket;
    String name;
    boolean playing;
    InputStream sIn;
    DataInputStream in;
    boolean connected = false;
    OutputStream sOut;
    DataOutputStream out;
    ServerThread server;
    boolean running;
    ArrayList<String> requested;
    HashMap<Point, String> hmap;
    String oppName = "";
    String sign="";

    Players(Socket s, ServerThread thread) {
        mySocket = s;
         playing= false;
        server = thread;
        requested = new ArrayList<>();
        hmap = new HashMap<>();
        
        if (mySocket != null) {
            running = true;
            connected = true;
            try {
                sIn = mySocket.getInputStream();
                in = new DataInputStream(sIn);
                sOut = mySocket.getOutputStream();
                out = new DataOutputStream(sOut);
                name = in.readUTF();

                start();
            } catch (IOException ex) {
                Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void setOpp(String opp) {
        oppName = opp;
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        int choice = in.readInt();
                        if (choice == 0) {//recieves requestes
                            String l = in.readUTF();
                            if(!requested.contains(l)){
                            requested.add(l);
                            server.request(l, name);
                            }
                        } else if (choice == 1) {//accept answer of requests
                            String l = in.readUTF();
                            server.accept(l, Players.this);
                            System.out.println(l);
                        } else if (choice == 2) {//game start and data
                            String l = in.readUTF();
                            int x = in.readInt();
                            int y = in.readInt();
                            System.out.println(l + " " + x + " " + y);
                            hmap.put(new Point(x, y), l);
                            server.sendData(x, y, l, oppName, Players.this);
                        } else if (choice == 3) {
                            server.sendList(Players.this);

                        }
                        else if(choice == 4){
                             server.endRoom(Players.this);
                             System.out.println("end room "+Players.this.name);
                        }

                    } catch (IOException ex) {

                        connected = false;
                        server.cut(Players.this);
                        running = false;
                        Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
                }
            }
        }).start();
    }

    public void endGame(boolean flag) {
        hmap.clear();
        playing = false;
        if (flag) {
            if (oppName != "") {
                server.sendEnd(oppName);
            } else {
                oppName = "";
            }
        }
    }
    public void resetGame() {
        hmap.clear();
        
    }

    public void send(int action, String name) {
        //action = 0 server message 
        //action = 1 server send requests
        //action = 2 server send game data
        //action = 3 server send game start 
        //action = 4 resets a game room
        //action = 5 send avilable players
        //action = 6 send end room

        
            try {
                if (action == 2) {
                    String[] temp = name.split(" ");
                    out.writeInt(action);
                    int x = Integer.valueOf(temp[0]);
                    int y = Integer.valueOf(temp[1]);
                    out.writeInt(x);
                    out.writeInt(y);
                    
                    out.flush();
                    hmap.put(new Point(x,y),temp[2]);
                    System.out.println(Integer.valueOf(temp[0]) + " " + Integer.valueOf(temp[1]) + " server send " + temp[2]);
                } else if (action == 3) {
                    String[] temp = name.split(" ") ;
                    out.writeInt(action);
                    out.flush();
                    out.writeUTF(temp[0]);
                    out.writeUTF(temp[1]);
                    out.flush();
                    requested.remove(temp[0]);
                    int x=1;
                } else if (action == 1) {
                    if (requested.contains(name)) {
                        server.accept(name, this);
                        System.out.println(name);
                    } else {
                        out.writeInt(action);
                        System.out.println(name);
                        out.writeUTF(name);
                        out.flush();
                    }
                }else if(action == 6){
                        playing=false;
                        oppName="";
                        out.writeInt(action);
                        System.out.println(name);
                        out.writeUTF(name);
                        out.flush();
                }
                else {
                    out.writeInt(action);
                    System.out.println(name);
                    out.writeUTF(name);
                    out.flush();
                }

            } catch (IOException ex) {
                connected = false;
                server.cut(Players.this);
                Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    public boolean getCon() {
        return connected;
    }

    public void close() {
        try {
            sIn.close();
            in.close();
            sOut.close();
            out.close();
            mySocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public int checkWin(HashMap<Point, String> hmap) {
        int[] score = new int[8];
        for (int i = 0; i < 8; i++) {
            score[i] = getLine(hmap, points[i]);
            if (score[i] >= 100) {

                return score[i];
            } else if (score[i] <= -100) {
                return score[i];
            }

        }
        return 0;
    }

    static public int getLine(HashMap<Point, String> hmap, Point[] x) {
        int score = 0;
        int turnX = 1;
        int turnO = 1;
        for (int i = 0; i < 3; i++) {
            if (hmap.get(x[i]) != null && hmap.get(x[i]).matches("x")) {

                score += (1 * turnX);
                turnX = turnX * 10;
            } else if (hmap.get(x[i]) != null && hmap.get(x[i]).matches("o")) {
                score -= (1 * turnO);
                turnO = turnO * 10;
            }

        }
        return score;

    }

}
