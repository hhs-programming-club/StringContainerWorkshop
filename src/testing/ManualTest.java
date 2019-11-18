package testing;

import structures.*;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;

/*
 * For manual testing of StringContainer implementation
 * Change the definition of container to the one you implemented to manually test
 * Type "insert `string`" to insert into container
 * Type "erase `string`" to erase from container
 * Type "check `string`" to check whether the string exists in the container
 * Type "end" to terminate
 */

public class ManualTest {
	public static StringContainer container;
	public static BufferedReader input;
	public static PrintWriter output;
	public static void main(String[] argv) throws IOException {
		container = new Trie();		//Here: You can setting Trie to DirectImplementation or TrieComplete before implementing your trie to see how to manually test whether it works
	
		StringTokenizer st;
		input = new BufferedReader(new InputStreamReader(System.in));
		output = new PrintWriter(new BufferedOutputStream(System.out), true);
		
		String command;
		String action;
		while(true)
		{
			st = new StringTokenizer(input.readLine());
			command = st.nextToken();
			if(command.equalsIgnoreCase("End"))
				break;
			else if(!st.hasMoreTokens()) {
				output.println("Invalid Input!");
				continue;
			}
			action = st.nextToken("");
			
			if(command.equalsIgnoreCase("insert"))
				if(container.insert(action))
					output.println("Successfully inserted string!");
				else
					output.println("String already exists!");
			else if(command.equalsIgnoreCase("erase"))
				if(container.erase(action))
					output.println("Successfully erased string!");
				else
					output.println("String does not exist!");
			else if(command.equalsIgnoreCase("check"))
				if(container.check(action))
					output.println("String found in container!");
				else
					output.println("String not found in container!");
			else
				output.println("Invalid Input!");
		}
		input.close();
		output.close();
	}
}
