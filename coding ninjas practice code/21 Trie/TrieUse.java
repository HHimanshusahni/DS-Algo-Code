import java.util.*;
public class TrieUse{
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		Trie  trie = new Trie();
		int choice  = s.nextInt();
		String word = new String();
		while( choice  != -1){
			switch (choice){
				case 1 : //Insert
					word = s.next();
					trie.insert(word);
					break;
				case 2 : //Search
					word = s.next();
					if(trie.search(word))
						System.out.println("String present");
					else
						System.out.println("String absent");
						break;
				case 3 : //Remove
					word = s.next();
					trie.remove(word);
						break;
				case 4 : //Total words in the trie
					System.out.println(trie.totalWords());
					break;
				default : 
						return;

			}
			choice = s.nextInt();
		}
	}
}