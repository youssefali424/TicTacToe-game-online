package tictactoegame;

import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;

/**
 *
 * @author youssef ali
 */
public class OnlinePlayer {
    //    static public int TURN = 0;

    int serverPort = 6000; // make sure you give the port number on which the server is listening.
    Socket sock;
    String address = "localhost";
    OutputStream sOut;
    DataOutputStream out;
    InputStream sIn;
    DataInputStream in;
    boolean connected = false;
    ArrayList<String> requests;
    LinkedHashMap<Point, String> hmap;
    LinkedHashMap<Point, String> lastGame;
    String mySign, oppSign;
    onlineBase fXml;
    ArrayList<String> availablePlayers;
    boolean playing = false;
    String oppName = "";
    String myName = "";
    int id = 0;

    OnlinePlayer(onlineBase fxml, String name) {
        fXml = fxml;
        availablePlayers = new ArrayList<>();

        try {
            sock = new Socket("localhost", serverPort);
            sOut = sock.getOutputStream();
            out = new DataOutputStream(sock.getOutputStream());
            sIn = sock.getInputStream();
            in = new DataInputStream(sIn);
            myName = name;
            out.writeUTF(myName);

            requests = new ArrayList<>();
            hmap = new LinkedHashMap<>();
            lastGame = new LinkedHashMap<>();
            connected = true;
            start();

            fXml.setRequests(requests);
        } catch (IOException ex) {
            
            close();
            fXml.returnBack();
            Logger.getLogger(OnlinePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (connected) {
                    String temp;
                    try {
                        int action = in.readInt();
                        switch (action) {
                            case 0:
                                temp = in.readUTF();
                                fXml.setLabel(temp);
                                break;
                            case 1:
                                temp = in.readUTF();
                                requests.add(temp);
                                fXml.setRequests(requests);
                                break;
                            case 2:
                                int x = in.readInt();
                                int y = in.readInt();

                                hmap.put(new Point(x, y), oppSign);
                                fXml.print(x, y, oppSign);
                                TictactoeGame.TURN -= 1;
                                fXml.setTurn();
                                break;
                            case 3:
                                temp = in.readUTF();
                                mySign = in.readUTF();
                                if (mySign.matches("o")) {
                                    TictactoeGame.TURN = 1;
                                    oppSign = "x";
                                } else {
                                    oppSign = "o";
                                }
                                playing = true;
                                fXml.gameStart(temp);
                                oppName = temp;
                                fXml.setLabel("you have " + mySign);
                                fXml.setTurn();
                                break;
                            case 4:
                                if (mySign.matches("o")) {
                                    TictactoeGame.TURN = 1;

                                } else {
                                    TictactoeGame.TURN = 0;
                                }
                                temp = in.readUTF();
                                lastGame = new LinkedHashMap<>(hmap);
                                hmap.clear();

                                fXml.reset();
                                fXml.setScoreVS(temp);
                                fXml.setTurn();
                                break;
                            case 5:
                                temp = in.readUTF();
                                String[] list = temp.split(" ");
                                if (!temp.equals("")) {
                                    availablePlayers.clear();
                                    availablePlayers.addAll(Arrays.asList(list));
                                    fXml.setList(availablePlayers);
                                }
                                else{
                                    availablePlayers.clear();
                                    fXml.setList(availablePlayers);}
                                break;
                            case 6:
                                temp = in.readUTF();
                                fXml.setLabel(temp);
                                playing = false;
                                fXml.gameEnd();
                                fXml.myScore=0;
                                fXml.oppScore=0;
                                fXml.clearTurn();
                                break;
                            default:
                                break;
                        }

                    } catch (IOException ex) {
                        connected = false;
                        close();
                        fXml.returnBack();
                        ex.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public void send(int action, String s) {
        if (s.trim().length() > 0) {
            try {
                out.writeInt(action);
                out.flush();
                switch (action) {
                    case 2:
                        String[] temp = s.split(" ");
                        System.out.println(temp[0] + " before sending " + temp[1] + " " + temp[2]);
                        out.writeUTF(temp[0]);
                        //out.flush();
                        out.writeInt(Integer.valueOf(temp[1]));
                        hmap.put(new Point(Integer.valueOf(temp[1]), Integer.valueOf(temp[2])), temp[0]);
                        out.writeInt(Integer.valueOf(temp[2]));
                        out.flush();

                        fXml.setTurn();
                        break;
                    case 1:
                        out.writeUTF(s);
                        out.flush();
                        for (String element : requests) {
                            if (element.equals(s)) {
                                requests.remove(element);
                                break;
                            }
                        }
                        fXml.setRequests(requests);
                        break;
                    case 3:
                        out.writeUTF(s);
                        out.flush();
                        System.out.println(s);
                        break;
                    case 4:
                        hmap.clear();
                        fXml.setLabel("ended room");
                        playing = false;
                        fXml.myScore=0;
                        fXml.oppScore=0;
                        fXml.gameEnd();
                        fXml.clearTurn();
                        break;
                    case 0:
                        out.writeUTF(s);
                        out.flush();
                        for (String element : requests) {
                            if (element.equals(s)) {
                                requests.remove(element);
                                break;
                            }
                        }
                        fXml.setRequests(requests);
                        break;
                }

            } catch (IOException ex) {
                connected = false;
                ex.printStackTrace();
                fXml.returnBack();
            }
        }

    }

    public void record() {

        if (!lastGame.isEmpty()) {
            System.out.println("recording");
            int GameNum = new Record().chechGameNum(id);
            System.out.println(GameNum);
            int index = 0;
            Iterator it = lastGame.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                Point temp = (Point) pair.getKey();
                String sign = (String) pair.getValue();
                new Record().record(id, GameNum + 1, index, temp.x, temp.y, sign);
                System.out.println(GameNum);
                System.out.println("index " + index);
                index++;
            }
        }
    }

    public void close() {
        if(sock!=null){
        try {
            connected = false;
            sIn.close();
            in.close();
            sOut.close();
            out.close();
            sock.close();
        } catch (IOException ex) {
            
            Logger.getLogger(OnlinePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }}

    }
    public void setId(int x){
        id=x;
    }

}
