/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  tictactoegame;

import java.awt.Point;
import java.util.HashMap;

/**
 *
 * @author youssef ali
 */
public interface MainAi {
    public Point check(HashMap<Point,String> hmap);
    public int checkWin(HashMap<Point,String> hmap);
}
