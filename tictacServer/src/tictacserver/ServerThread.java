/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacserver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Point;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerThread implements Runnable {

    int j = 0;
    int port = 6000;  // make sure you give the port number on which the server is listening.
    ServerSocket ssock;
    int clientNum;
    public static String[] XO = {"o", "x"};
    Vector<Players> playersVector;

    ServerThread() {

        playersVector = new Vector<Players>();
        setPoints();

    }

    @Override
    public void run() { //it is a thread for gui so i am using run
        try {

            ssock = new ServerSocket(port);

            System.out.println("Listening on " + ssock.getLocalPort());

            while (true) {

                Socket sock = ssock.accept();//start accepting in while for every client a new socket even if it has same name it is different

                Players client = new Players(sock, this);

                playersVector.add(client);
                System.out.println("got a client on " + sock.getInetAddress() + " " + client.name);
                sendListToAll();
                clientNum++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void request(String s, String name) {

        for (int i = 0; i < playersVector.size(); i++) {
            Players temp = playersVector.get(i);
            if (temp.name.equals(s)) {
                
                temp.send(1, name);
                break;
            }
        }
    }

    public void sendData(int x, int y, String sign, String opp, Players myPlayer) {

        String temp = x + " " + y + " " + sign;
        boolean flag = false;
        Players tempPlayer = null;
        for (int i = 0; i < playersVector.size(); i++) {
            tempPlayer = playersVector.get(i);
            if (tempPlayer.name.equals(opp)) {
                flag = true;
                tempPlayer.send(2, temp);
                break;
            }
        }
        if (!flag) {
            myPlayer.send(6, "sorry other player is disconnected");
            myPlayer.endGame(true);
        } else {
            int score = Players.checkWin(myPlayer.hmap);

            if (score != 0) {
                
                if (score > 100) {
                    if (myPlayer.sign.equals("x")) {
                        if (tempPlayer != null) {
                            tempPlayer.send(4, "lose");
                            tempPlayer.resetGame();
                        }
                        myPlayer.send(4, "win");
                        myPlayer.resetGame();
                    } else {
                        if (tempPlayer != null) {
                            tempPlayer.send(4, "win");
                            tempPlayer.resetGame();
                        }
                        myPlayer.send(4, "lose");
                        myPlayer.resetGame();
                    }
                }
                if (score < 100) {
                    if (myPlayer.sign.equals("o")) {
                        if (tempPlayer != null) {
                            tempPlayer.send(4, "lose");
                            tempPlayer.resetGame();
                        }
                        myPlayer.send(4, "win");
                        myPlayer.resetGame();
                    } else {
                        if (tempPlayer != null) {
                            tempPlayer.send(4, "win");
                            tempPlayer.resetGame();
                        }
                        myPlayer.send(4, "lose");
                        myPlayer.resetGame();
                    }
                    
                }
            } else {
                if (myPlayer.hmap.size() >= 9) {
                    
                    
                    if (tempPlayer != null) {
                        
                        tempPlayer.send(4, "Draw");
                        tempPlayer.resetGame();
                    }
                    myPlayer.send(4, "Draw");
                    myPlayer.resetGame();
                }
            }
        }

    }
    public void endRoom(Players myPlayer){
    myPlayer.playing=false;
    myPlayer.sign="";
    myPlayer.hmap.clear();
    boolean flag = false;
    Players tempPlayer = null;
    if(myPlayer.oppName!=""){
        for (int i = 0; i < playersVector.size(); i++) {
            tempPlayer = playersVector.get(i);
            if (tempPlayer.name.equals(myPlayer.oppName)) {
                flag = true;
                System.out.println(tempPlayer.name+" exit pls");
                tempPlayer.send(6, "other player exit");
                break;
            }
        }
        myPlayer.oppName="";}
    }

    public void sendEnd(String s) {
        boolean flag = false;
        
        for (int i = 0; i < playersVector.size(); i++) {
            Players tempPlayer = playersVector.get(i);
            if (tempPlayer.name.equals(s)) {
                flag = true;
                tempPlayer.send(6, "sorry other player is disconnected");
                
                break;
            }
        }
    }

    public void accept(String s, Players temp2) {

        boolean flag = false;

        for (int i = 0; i < playersVector.size(); i++) {
            Players temp = playersVector.get(i);
            if (temp.name.equals(s)) {
                flag = true;
                if (temp.playing) {
                    temp2.send(0, "sorry player is in a game");
                } else {
                    temp2.playing = true;
                    temp.playing = true;
                    temp.setOpp(temp2.name);
                    temp2.setOpp(s);
                    int random = (int) (Math.random() * 2);
                    String t;
                    if (random == 0) {
                        t = "x";
                    } else {
                        t = "o";
                    }
                    temp.sign=XO[random];
                    temp2.sign=t;
                    temp.send(3, temp2.name + " " + XO[random]);
                    temp2.send(3, s + " " + t);
                }
                break;
            }
        }
        if (!flag) {
            temp2.send(0, "sorry player is disconnected");
        }

    }

    public void cut(Players sTemp) {
        if (!sTemp.getCon()) {
            if (sTemp.playing) {
                System.out.println("playing");
                sTemp.endGame(true);
            }
            playersVector.removeElement(sTemp);
            System.out.println(sTemp.name + " disconnected");
            sTemp.close();

        }
        sendListToAll();
    }

    public void sendList(Players pTemp) {
        String str = "";
        for (int i = 0; i < playersVector.size(); i++) {
            Players tempPlayer = playersVector.get(i);
            
                if (!tempPlayer.name.equals(pTemp.name)) {
                    str += tempPlayer.name + " ";
                }
            
        }
        pTemp.send(5, str);

    }

    public void sendListToAll() {
        
        for (int i = 0; i < playersVector.size(); i++) {
            Players tempPlayer = playersVector.get(i);
            sendList(tempPlayer);
        }
        
    }

    public void setPoints() {
        Players.points = new Point[8][3];
        int line = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Players.points[line][j] = new Point(i, j);
            }
            line++;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Players.points[line][j] = new Point(j, i);
            }
            line++;
        }
        Players.points[line][0] = new Point(0, 0);
        Players.points[line][1] = new Point(1, 1);
        Players.points[line][2] = new Point(2, 2);
        line++;
        Players.points[line][0] = new Point(2, 0);
        Players.points[line][1] = new Point(1, 1);
        Players.points[line][2] = new Point(0, 2);
    }
}
