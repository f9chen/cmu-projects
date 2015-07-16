
public class Random {

	/**
	 * @ran an instance of a Random object
	 */
	
	public static void main(String[] args) {
		Random ran = new Random(56);
		for(int i = 0; i < 10; i++){
			System.out.println(ran.nextInt());
		}
	}

	/**
	 * @param next the next number generated with a formula
	 * @param seed an argument class Random takes to initialize next
	 */
	
	public int next;
	public Random(int seed){
		next = seed;
	}
	
	public int nextInt(){
		next = (6 * next) % 511;
		return next;
	}
}
