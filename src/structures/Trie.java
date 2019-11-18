package structures;

public class Trie implements StringContainer 
{
	class TrieNode //Each node in the trie is a TrieNode
	{
		public boolean terminate;	//This represents whether the string associated with this node is actually in the trie, rather than just a temporary (but still important) node. (This is equivalent to coloring the node red instead of blue in the example)
		public TrieNode child[];	//This array (of size 128) points to all of the children of this node. These are the edges of the tree
		public TrieNode(boolean terminate)		//Initialization
		{
			this.terminate = terminate;
			child = new TrieNode[128];	//standard ASCII codes are 0..127. Array size of only 128 is necessary
			for(int i = 0;i < 128;++i)
				child[i] = null;
			/*
			 * This implementation detail (initializing all children to null) is not mentioned in the text document
			 * If you refer back to the sample trie, each node does not actually have 128 edges coming out of it
			 * This is because some nodes simply are not necessary to store words in the trie
			 * It's important that we do not create any unnecessary nodes, because if we store every possible words in the trie
			  		and not just the important ones, we would have infinite words in the trie, and that's just not practical or possible
			 * We'll simple leave these unnecessary nodes null, and create them if they are ever necessary
			 * In the beginning, however, we have not added any words so only the root node is necessary
			 */
		}
		public TrieNode()
		{
			this(false);
		}
	}
	private TrieNode root;		//Root node corresponds to the empty string
	public Trie()
	{
		root = new TrieNode();
	}
	public boolean insert(String s)
	{
		//TODO insert: Navigate to node corresponding to String s, creating new nodes when necessary
		//	If this node is already in the container (terminate == true) return false, because you didn't insert the string; it was already there. Otherwise, set terminate to true and return true, because you were able to add this string to the container
		return false;
	}
	public boolean erase(String s)
	{
		//TODO erase: Navigate to node corresponding to String s. If the node hasn't been created, return false because you cannot erase a non-existent string
		//	If you can reach the node, check if it's actually in the container. If so, remove it and return true, meaning you've sucessfully removed the string. Otherwise, return false because it was not in the container and thus could not be erased
		return false;
	}
	public boolean check(String s)		//This is pre-implemented and commented for your convenience. Use this method to check whether insert & erase behave as expected
	{
		TrieNode node = root;		//We start off at the root to search for s, the query string we are checking for. We start at the empty string, and then we append each character in the query string to the current string to get to the query string
		for(char x : s.toCharArray())		//For each character, we try append it to the end of the current string
			if(node.child[(int)x] == null)	//If we cannot append the character, then the string cannot exist
				return false;
			else
				node = node.child[(int)x];	//Set current string to the previous string with the new character appended
		return node.terminate;		//The node now corresponds to the query (input) string. We can return whether it exists in the trie.
	}
}
