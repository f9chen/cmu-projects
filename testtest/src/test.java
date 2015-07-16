
public class test {
public static void main(String[] args){
	CellPhone nm = new CellPhone();
	Tune t1 = new Tune();
	Tune t2 = new ObnoxiousTune();
	nm.ring((ObnoxiousTune)t1);
	nm.ring((ObnoxiousTune)t2);
}
}