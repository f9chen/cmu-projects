/*This program tests how fast the use can type "I type very quickly"
 * Author: Fan Chen (Andrew ID: fanc)
 */

	
	import java.util.*;


	public class TypeFaster {
	    public static void main(String[] args) {
	    	
	        Scanner keyboard = new Scanner(System.in);//set up var keyboard as scanner
	    	
	        System.out.println("Your job is to type the sentence \" I type very quickly\"  as fast as you can. \n"
	        		+ "When you are ready, press enter, type the sentence, and press enter again. \n"
                    + "Now press enter... \n");//prompt user the instructions
	        
	        String enter1 = keyboard.nextLine();  //read in first enter
	        long Time1 = System.currentTimeMillis();
	        long Time2 = System.currentTimeMillis();//init Time1 and Time2
	       
			if (enter1 == "\n"){
	        	Time1 = System.currentTimeMillis();
			}//record start time
	        
	        String text = keyboard.nextLine();
	      
	        if ("I type very quickly".equals(text)){
	        	Time2 = System.currentTimeMillis();
	            System.out.println("Congratulations! You used " + (Time2 - Time1) + " milliseconds!");
	            }
	        else
	        	System.out.println("Sorry, wrong Sentence. Go back and improve your typing...");
        
	    }

}
