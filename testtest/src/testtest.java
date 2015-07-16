
public class testtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(inverse(588));
		

	}
	
	public static int inverse(int multiplier, int modulus) {
	      int f;
	      int a = multiplier;
	      int b = modulus;
	      for (int k=1 ; k < b ; k++) {
	         f = 0;
	         for (int j=0 ; j < b ; j++)
	            if (modulo(k*modulo(a*j,b), b) == j) f += 1; else break;
	         if (f == b) return k;
	      }
	      return 0;
	   }
	
	public static int modulo (int i, int j)  {  return i - (i/j)*j;  }

}
