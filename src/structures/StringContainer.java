package structures;

public interface StringContainer {
	public boolean insert(String s);		//Return true is the string is inserted and did not exist previously
	public boolean erase(String s);			//Return true if the string is erased and existed previously
	public boolean check(String s);			//Return true if the string exists, false otherwise
}
