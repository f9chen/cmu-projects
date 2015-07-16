
public class IndexCard {
	private double height;
	private double width;
	private String text;
	public IndexCard(){height = 3.0; width = 5.0;};
	public IndexCard(double inputHeight, double inputWidth, String inputText){
		height = inputHeight;
		width = inputWidth;
		text = inputText;
	}
	
	private Obligation[] obligations = new Obligation[100];
	private int index = 0;
	private int next = 0;
	public void add(Obligation obl){
		if(index >= obligations.length)
			return; //obligation obl isn't added!!bad!
		obligations[index++] = obl; //add obl to current space and and then and index
	}
}
