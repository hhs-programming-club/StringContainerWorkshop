package structures;

import java.util.ArrayList;

public class DirectImplementation implements StringContainer {
	public ArrayList<String> strings;
	public DirectImplementation() {
		strings = new ArrayList<String>(0);
	}
	public boolean insert(String s) {
		for(String t : strings)
			if(s.equals(t))
				return false;
		strings.add(s);
		return true;
	}
	public boolean erase(String s) {
		for(int i = 0;i < strings.size();++i)
			if(s.equals(strings.get(i))) {
				strings.remove(i);
				return true;
			}
		return false;
	}
	public boolean check(String s) {
		for(String t : strings)
			if(s.equals(t))
				return true;
		return false;
	}
}
