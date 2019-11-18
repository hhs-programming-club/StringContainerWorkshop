package structures;

/*
 * Refer to this if you are stuck
 * It's not commented so ask an officer if you need an explanation :)
 */

public class TrieComplete implements StringContainer {
	class TrieNode {
		public boolean terminate;
		public TrieNode child[];
		public TrieNode(boolean terminate)
		{
			this.terminate = terminate;
			child = new TrieNode[128];
			for(int i = 0;i < 128;++i)
				child[i] = null;
		}
		public TrieNode()
		{
			this(false);
		}
	}
	private TrieNode root;
	public TrieComplete()
	{
		root = new TrieNode();
	}
	public boolean insert(String s)
	{
		TrieNode node = root;
		for(char x : s.toCharArray())
			if(node.child[(int)x] == null)
				node = node.child[(int)x] = new TrieNode();
			else
				node = node.child[(int)x];
		if(node.terminate)
			return false;
		node.terminate = true;
		return true;
	}
	public boolean erase(String s)
	{
		TrieNode node = root;
		for(char x : s.toCharArray())
			if(node.child[(int)x] == null)
				return false;
			else
				node = node.child[(int)x];
		if(!node.terminate)
			return false;
		node.terminate = false;
		return true;
	}
	public boolean check(String s)
	{
		TrieNode node = root;
		for(char x : s.toCharArray())
			if(node.child[(int)x] == null)
				return false;
			else
				node = node.child[(int)x];
		return node.terminate;
	}
}
