/*
 * Description:This program examine the possibility to win in Monte Hall Paradox game, 
 * given user choose to switch choice or not.
 * Author: Fan CHEN
 * Andrew ID: fanc
 * File Name: MonteHallParadox.java; Game.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */


import java.util.Scanner;

public class MonteHallParadox {
        public static void main(String[] args) {
            Scanner keyboard = new Scanner(System.in);//set up var keyboard as scanner
            int i = 0;
            while(i == 0){
    	        System.out.println("Switch?(Y for switch, N for don't switch.)");//prompt user the instructions
    	        String input = keyboard.nextLine();  //read in user choice  
    	        if ("Y".equals(input.toUpperCase())){
    	        	i = 1;
    	        }
    	        else if ("N".equals(input.toUpperCase())){
    	        	i = 2;
    	        }
    	        else{
    	        	System.out.println("Wrong input!");
    	        }//Prompt to user again when they made invalid input
            }
            int totalWin = 0;
            for (int j = 0; j < 10000; j++){
            	 Game theGame = new Game();
                 theGame.setUpGame();
                 //theGame.printStateOfDoors();
                 theGame.contestantChooseDoor();
                 //theGame.printStateOfDoors();
    	        if (i == 1){
    	        	theGame.switchDoors();//switch door
    	        }
    	        theGame.testWin();
    	        if(theGame.win){
    	    	   totalWin += 1;
    	       }
            }
            System.out.println("The possibility to win when you choose " + 
            (i == 1 ? "to switch " : "not to switch ") + "is " + totalWin / 10000.00+".");
        }
}
	     
