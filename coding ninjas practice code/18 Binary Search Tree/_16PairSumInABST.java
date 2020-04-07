import java.io.*;
import java.util.*;
public class _16PairSumInABST{
/*
	Approach 1 
	Pick a node in a tree in either inorder, preorder, postorder manner and find wheather sum - node data is
	present in the tree or not this approach will take O(n^2 )time
	
	Approach2
	Convert the binary search tree into a sorted array using inorder traversals.Now take two
	pointer i from starting and j at end and use the same algorithm for finding the pair sum in sorted array

	O(n) time complexity
	O(n) space complexity
	
	 
*/
	// https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
	//Approach 3   O(n) time Complexity and O(h) space complexity
	/*
    10 
	8 21 
	4 9 13 28 
	1 6 -1 -1 12 -1 23 -1 
	-1 -1 5 7 -1 -1 -1  24 
	-1 -1 -1 -1 -1 -1
	*/
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();//Inorder stack
		Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();//Reverse Inorder stack
		int totalNodes  = countNodes(root),nodesSeen = 0;
		BinaryTreeNode<Integer> node1 , node2;
		justLarger(root,s1);
		justSmaller(root,s2);
		while(nodesSeen < totalNodes-1){
			int elem1 = s1.peek().data;
			int elem2 = s2.peek().data;
			// if(elem1 == elem2) // Important check
			// 	return;
			// System.out.print("\n"+elem1+" "+elem2+"Popped");
			if(elem1+elem2 < s){
				 node1  = s1.pop();
				 // System.out.print(elem1+" ");
				justLarger(node1.right,s1);
				nodesSeen++;
			}else if(elem1 + elem2 > s){
			     node2 = s2.pop();
			     // System.out.print(elem2+" ");
			    justSmaller(node2.left,s2);
			    nodesSeen++;
			}else{
				System.out.println(elem1+" "+elem2);
				node1 = s1.pop();
				node2 = s2.pop();

				justLarger(node1.right,s1);
				justSmaller(node2.left,s2);
				nodesSeen = nodesSeen + 2;
			}
		}
	}
	public static int countNodes(BinaryTreeNode<Integer>root){ // time: O(n) , Space : O(h)
		if(root == null)
			return 0 ;
		return  1 + countNodes(root.left)+countNodes(root.right);
	}
	public static void justLarger(BinaryTreeNode<Integer>root,Stack <BinaryTreeNode<Integer>> stack){ // time : O(h) : Spach : O(h)
		if(root == null)
			return;
		stack.push(root);
		justLarger(root.left,stack);
	}
	public static void justSmaller(BinaryTreeNode<Integer>root,Stack <BinaryTreeNode<Integer>> stack){// time : O(h) : Spach : O(h)
		if(root == null)
			return;
		stack.push(root);
		justSmaller(root.right,stack);
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		System.out.println("Enter sum");
		int sum = Integer.parseInt(br.readLine());
		printNodesSumToS(root,sum);
	}
}