/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacserver;

/**
 *
 * @author youssef ali
 */
public class TictacServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerThread serverTh=new ServerThread();
        Thread th=new Thread(serverTh);
        th.start();
    }
    
}
