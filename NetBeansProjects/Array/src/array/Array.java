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
static int Y = 10;
static int X = 10;
static int eY = 3;
static int eX = 10;
static int cooldown = 5;
static boolean isAlive = true;
    public static void main(String[] args) {
   /*
	int[][] numbers=new int[10][10];       
	for(int row=0;row<numbers.length;row++){
	for(int col=0;col<numbers[row].length;col++){
	numbers[row][col]=1+col;
	}
	}
	for(int row=0;row<numbers.length;row++){
	for(int col=0;col<numbers[row].length;col++){
	System.out.print(" x");
	}
	System.out.println();
	}
	}
         */  
        System.out.println("Type go to begin");
        while(isAlive == true){
                Scanner movement = new Scanner(System.in);
                whichWay = movement.nextLine();
                                if(Y > eY){
                    eY = eY + 1;
                }
                if(Y < eY){
                    eY = eY - 1;
                }
                if(X > eX){
                    eX = eX + 1;
                }
                if(X < eX){
                    eX = eX - 1;
                }
               if(whichWay.contains("n")){
                    Y = Y - 1;
                        if(Y == 6 && X == 6){
                        Y = Y + 1;
                    }
                }
                if(whichWay.contains("s")){
                    Y = Y + 1;
                    if(Y == 6 && X==6){
                    Y = Y - 1;
                    }
                }
                if(whichWay.contains("w")){
                    X = X - 1;
                    if(X == 6 && Y == 6){
                    X = X +1;
                    }
                }
                if(whichWay.contains("e")){
                    X = X + 1;
                    if(X == 6 && Y == 6){
                    X = X -1;
                    }
                }
                if(whichWay.contains("ult") && cooldown >= 5){
                cooldown = 0;
                if(Y > eY){
                eY = eY - 2;
                }
                if(Y < eY){
                    eY = eY + 2;
                }
                if(X > eX){
                    eX = eX - 2;
                }
                if(X < eX){
                    eX = eX + 2;
                }
        }
                     
                                
            char[][] map = new char[15][15];           
            map[Y][X] = '@';
            map[2][2] = 'T';
            map[eY][eX] = 'E';
            map[6][6] = '+';
            map[5][6] = '+';
            map[4][6] = '+';
            map[3][6] = '+';
            for (int i = 0; i <= map[0].length - 1; i++) {
                for (int j = 0; j <= map[1].length - 1; j++) {
                    if (j < map[1].length - 1) {
                        if (map[i][j] != '@' && map[i][j] != 'T' && map[i][j] != 'E' && map[i][j] != '+') {
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
                    if(X == 2 && Y == 2){
                    System.out.println("You Got the Treasure. Joo Wheen.");
                    isAlive = false;
                } 
                    if(eX == X && eY == Y){
                        System.out.println("You got caught");
                        isAlive = false;
                    }
                    if(X == 4 && Y == 8){
                    System.out.println("You activated my trap card. U R DED");
                    isAlive = false;
           } 
        }
    }
}
  

