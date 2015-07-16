import java.util.Random;

public class Game {
	
	public class Door{
	    private boolean open;
	    private boolean hasGrandPrize;
	    private boolean chosenByContestant;
	}
	
    Door door1, door2, door3;
	
	static Random r = new Random();
    static int grandPrizeDoor;
	static int contestantDoor;//set all above three var static
	
	
    void setUpGame() {
        grandPrizeDoor = r.nextInt(3);//random choose the door of prize
    	door1 = new Door();door2 = new Door();door3 = new Door();
            // initialize all the Door variables to false
        switch(grandPrizeDoor) {
        case 0:
            door1.hasGrandPrize = true; break;
        case 1: 
        	door2.hasGrandPrize = true; break;
        case 2:
        	door3.hasGrandPrize = true; break;
        }
    }
        
    void contestantChooseDoor() {
        contestantDoor = r.nextInt(3);//random choose for contestant
        switch(contestantDoor) {
        case 0:
        	door1.chosenByContestant = true; break;
        case 1:
        	door2.chosenByContestant = true; break;
        case 2:
        	door3.chosenByContestant = true; break;
    }
}
    
    void switchDoors() {     //switch door
    	if(grandPrizeDoor != contestantDoor){
    		contestantDoor = grandPrizeDoor;
    	}    //if contestant chooses wrong in round 1, he/she will switch to the correct
    	else{
    		switch(contestantDoor){
    		case 0:
    			contestantDoor = 1 + r.nextInt(2);break;//make random number from 1 and 2
    		case 1:
    			contestantDoor = 2 * r.nextInt(2);break;//make random number from 0 and 2
    		case 2:
    			contestantDoor = r.nextInt(2);break;//make random number from 0 and 1
    	}
    	}
    	door1.chosenByContestant = false;
        door2.chosenByContestant = false;
        door3.chosenByContestant = false;
    	switch(contestantDoor) {
        case 0:
        	door1.chosenByContestant = true; break;
        case 1:
        	door2.chosenByContestant = true; break;
        case 2:
        	door3.chosenByContestant = true; break;
    }
    }

    boolean win;
    boolean testWin(){       //test whether contestant wins the game
    	if(grandPrizeDoor == contestantDoor){
    		 win = true;
    	}
    	else{
    		 win = false;
    	}
    	return win;
    }
   
    void printStateOfDoors() {
        System.out.println("Door 1 is " +
            (door1.open ? "    open, " : "not open, ") +
            (door1.hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
            (door1.chosenByContestant ? "is     chosen." : "is not chosen.") );
        System.out.println("Door 2 is " +
            (door2.open ? "    open, " : "not open, ") +
            (door2.hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
            (door2.chosenByContestant ? "is     chosen." : "is not chosen.") );
        System.out.println("Door 3 is " +
            (door3.open ? "    open, " : "not open, ") +
            (door3.hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
            (door3.chosenByContestant ? "is     chosen." : "is not chosen.") );
    }//for testing purpose
 
}



