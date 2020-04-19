class TrieNode {
	char data;
	TrieNode children[];
	boolean isTerminating;
	int childCount;
	public TrieNode(char data){
		this.data = data;
		children = new TrieNode[26];
	}
	public TrieNode getChild(char childData){
		return children[childData - 'a'];
	}
	public void addChild(char c,TrieNode child){
		children[c - 'a'] = child ;
		childCount++;
	}
}
/*https://www.youtube.com/watch?v=p4kfbNJzftQ  
https://github.com/gkcs/Competitive-Programming/blob/master/src/main/java/main/java/videos/Tries.java
*/
public class Trie{
	TrieNode root ;
	int count; //To mantain the total no of strings in the trie
	//Constructor
	Trie(){
		root = new TrieNode('\0');
	}

	public void insert(String word){
		if(insert(root,word)) 
			count++; // If the TrieNode is newly  inserted we increment total count
	}
	//Reursive Function
	private boolean insert(TrieNode root, String word ){
		//Base Case
		if(word.length() == 0){
			if(root.isTerminating) // This means that the word is already present
				return false; 	   // So no new  insertion
			else{ 
				root.isTerminating = true;
				return true;
			}
		}
		//Small Calculation
		TrieNode child = root.getChild(word.charAt(0));
		//If  the child is not present we need to make a new node
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.addChild(word.charAt(0),child);
		}
		//Recursive Case
		return insert(child,word.substring(1));
		
	} 
	public boolean search(String word){
		return search(root,word);
	}
	//Recursive Function
	private boolean search(TrieNode root, String word) {
		//Base Case
		if(word.length() == 0)
			return root.isTerminating ; 
		
		//Small Calculation
		TrieNode child = root.getChild(word.charAt(0));

		if(child == null)
			return false;
		///Recursive Case
		return search(child,word.substring(1));

	}
	public void remove(String word){
		if(remove(root,word))
			count--; //Total count will get decremented if the word is deleted
	}
	//Recursion
	private boolean remove(TrieNode root,String word ){
		//Base Case
		if(word.length() == 0){
			if(root.isTerminating){ // Present Case
				root.isTerminating = false;	
				return true;
			} 
			else //absent Case
				return false;
		}

		TrieNode child = root.getChild(word.charAt(0));
		if(child == null)//absent Case
			return false;

		//Recursive Case
		boolean ans = remove(child, word.substring(1));
		if(ans) {
			if(!child.isTerminating && child.childCount == 0) {
				root.children[word.charAt(0) - 'a'] = null;
				root.childCount--;
			}
		}
		return  ans;

	}
	public int totalWords(){
		return this.count;
	}
}
