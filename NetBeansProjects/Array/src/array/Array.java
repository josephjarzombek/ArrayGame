/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import java.util.Scanner;

/**
 *
 * @author josephjarzombek
 */
public class Array {
static String whichWay;
static int eY = 3;
static int eX = 10;
public static int x,y,wallx,wally;
public static int maxX = 15;
public static int maxY = 15;
static boolean bouty = true;
static boolean deblume = true;
static boolean blocked = false;
static int cooldown = 5;
static boolean isAlive = true;
    public static Character character;
    public static Trap trap;
    public static Trap tarp;
    public static void main(String[] args) {
        game();
    }
    public static void game(){
       trap = new Trap();
       tarp = new Trap();
                System.out.println("You are swashbuckling pirate in search of treasure. You must collect both 'T' treasure chest to become ");
                System.out.println("captain of the infamous black chair. Avoid the ghoul of the sea marked by the '*', and avoid rocks labled");
                System.out.println("with '+'. Use n,e,s,w to move and if the ghoul ghoul gets to close you can type 'ult' to push it away.");
                System.out.println("Type go to begin. GOD SPEED!");
                 boolean[][] wall = new boolean[maxX][maxY];
                 boolean[][] treasure = new boolean[maxX][maxY];
                 if (wall[y][x] == true) {
            x = (int) Math.floor(Math.random() * maxX);
            y = (int) Math.floor(Math.random() * maxY);
        }
        for (int t = 0; t < 15; t++) {
            int wallx = (int) Math.floor(Math.random() * maxX);
            int wally = (int) Math.floor(Math.random() * maxY);
            wall[wallx][wally] = true;
        }
        while(isAlive == true){
                Scanner movement = new Scanner(System.in);
                whichWay = movement.nextLine();
                if(whichWay.contains("ult") && cooldown >= 5){
                cooldown = 0;
                
                if(Character.Y >= eY){
                eY = eY - 2;
                }
                if(Character.Y <= eY){
                    eY = eY + 2;
                }
                if(Character.X >= eX){
                    eX = eX - 2;
                }
                if(Character.X <= eX){
                    eX = eX + 2;
                }
                }
                if(Character.Y > eY){
                    eY = eY + 1;
                }
                if(Character.Y < eY){
                    eY = eY - 1;
                }
                if(Character.X > eX){
                    eX = eX + 1;
                }
                if(Character.X < eX){
                    eX = eX - 1;
                }
                
               if(whichWay.contains("n")){
                    Character.Y = Character.Y - 1;
                    if((Character.X == maxX || Character.Y == maxY)||(Character.X == trap.x && Character.Y == trap.y)){
                        Character.Y = Character.Y + 1;
                    }

                }
                if(whichWay.contains("s")){
                    Character.Y = Character.Y + 1;
                    if(Character.X == maxX || Character.Y == maxY){
                        Character.Y = Character.Y - 1;
                    }

                }
                if(whichWay.contains("w")){
                    Character.X = Character.X - 1;
                }
                if (trap.trap[trap.y][trap.x] == true) {
            trap.x = (int) Math.floor(Math.random() * maxX);
            trap.y = (int) Math.floor(Math.random() * maxY);
        }
            if (tarp.trap[tarp.y][tarp.x] == true) {
            tarp.x = (int) Math.floor(Math.random() * maxX);
            tarp.y = (int) Math.floor(Math.random() * maxY);
        }
            trap.x = (int) Math.floor(Math.random() * maxX);
            trap.y = (int) Math.floor(Math.random() * maxY);
            trap.trap[trap.x][trap.y] = true;
            tarp.x = (int) Math.floor(Math.random() * maxX);
            tarp.y = (int) Math.floor(Math.random() * maxY);
            tarp.trap[tarp.x][tarp.y] = true;
                if(whichWay.contains("e")){
                    Character.X = Character.X + 1;
if(Character.X == maxX || Character.Y == maxY){
    Character.X = Character.X - 1;
}
                    
                }
       
                                
            char[][] map = new char[15][15];           
            map[Character.Y][Character.X] = '@';
            if(bouty == true){
            map[2][2] = 'T';
            }
            if(deblume == true){
            map[1][12] = 'T';
            }
            map[eY][eX] = '*';
            map[wally][wallx] = '+';
                    
            for (int i = 0; i <= map[0].length - 1; i++) {
                for (int j = 0; j <= map[1].length - 1; j++) {
                    if (j < map[1].length - 1) {
                        if (map[i][j] != '@' && map[i][j] != 'T' && map[i][j] != '*' && map[i][j] != '+' ) {
                            System.out.print("~");
                        } else {
                        System.out.print(map[i][j]);
                    }
                } else {
                    if (map[i][j] != '@') {
                        System.out.println("~");
                    } else {
                        System.out.println(map[i][j]);
                    }
                }
            }
               
        }
                    cooldown = cooldown + 1;
                    if(Character.X == 2 && Character.Y == 2){
                    bouty = false;
                    map[2][2] = '~';
                    if(bouty == false && deblume == false){
                    System.out.println("You Got the Treasure. Joo Wheen.");
                    isAlive = false;
                    }
                } 
                    if(Character.X == 12 && Character.Y == 1){
                    deblume = false;
                    map[1][12] = '~';
                    if(bouty == false && deblume == false){
                    System.out.println("You Got the Treasure. Joo Wheen.");
                    System.out.println("░░░░░░░░░░░░▄▄░░░░░░░░░");
                    System.out.println("░░░░░░░░░░░█░░█░░░░░░░░");
                    System.out.println("░░░░░░░░░░░█░░█░░░░░░░░");
                    System.out.println("░░░░░░░░░░█░░░█░░░░░░░░");
                    System.out.println("░░░░░░░░░█░░░░█░░░░░░░░");
                    System.out.println("███████▄▄█░░░░░██████▄░░");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█░");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█░");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█░");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█░");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█░");
                    System.out.println("▓▓▓▓▓▓█████░░░░░░░░░█░░");
                    System.out.println("██████▀░░░░▀▀██████▀░░░░");
                    isAlive = false;
                    }
                } 
                    if(eX == Character.X && eY == Character.Y){
                    System.out.println("You got caught");
                    System.out.println("███████▄▄███████████▄");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█░");
                    System.out.println("██████▀░░░░░░░██████▀");
                    System.out.println("░░░░░░░░░█░░░░█");
                    System.out.println("░░░░░░░░░░█░░░█");
                    System.out.println("░░░░░░░░░░░█░░█");
                    System.out.println("░░░░░░░░░░░█░░█");
                    System.out.println("░░░░░░░░░░░░▀▀ ");
                        isAlive = false;
                    }
                    if(Character.X == trap.x && Character.Y == trap.y){
                    System.out.println("You activated my trap card. U R DED");
                    System.out.println("███████▄▄███████████▄");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█");
                    System.out.println("▓▓▓▓▓▓█░░░░░░░░░░░░░░█░");
                    System.out.println("██████▀░░░░░░░██████▀");
                    System.out.println("░░░░░░░░░█░░░░█");
                    System.out.println("░░░░░░░░░░█░░░█");
                    System.out.println("░░░░░░░░░░░█░░█");
                    System.out.println("░░░░░░░░░░░█░░█");
                    System.out.println("░░░░░░░░░░░░▀▀ ");
                    isAlive = false;
           } 
        }
    }
}




Character:

package array;

/**
 *
 * @author josephjarzombek
 */

public class Character {
public static int Y = 13;
public static int X = 10;


}

trap:

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import static array.Array.maxX;
import static array.Array.maxY;

/**
 *
 * @author josephjarzombek
 */
public class Trap {
    public boolean[][] trap = new boolean[maxX][maxY];
    public int x;
    public int y;
    
}

