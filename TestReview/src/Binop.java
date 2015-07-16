public abstract class Binop extends Node {
	Node lChild;
	Node rChild;
    public void setChild(int position, Node n)
            throws GPTreeChildPositionException {
        if (position == 1)
        	lChild = n;
        else if (position == 2)
            rChild = n;
        else
            throw new GPTreeChildPositionException();
    }
    :
}
