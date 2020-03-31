import java.util.Scanner;
public class _16ConstructTreeFromPostorderAndInorder{

	//Approach 1 O(n^2)
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in){
		return getTreeFromPostorderAndInorder(post,in,0,post.length-1,0,in.length -1);
	}
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in,int postS,int postE,int inS,int inE){

		if(inS > inE)
			return null;
	
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(post[postE]);
		int index = 0;
		for(int i = inS ;i<=inE;i++){
			if(in[i] == root.data){
				index = i;
				break;
			}
		}
		int leftPostS = postS;
	
		int leftInS = inS;
		int leftInE = index -1;
		int leftPostE = leftInE - leftInS + leftPostS ; 

		int rightPostS = leftPostE + 1 ;
		int rightPostE = postE -1;
		int rightInS = index + 1;  
		int rightInE = inE;

		root.left  = getTreeFromPostorderAndInorder(post,in,leftPostS,leftPostE,leftInS,leftInE);
		root.right = getTreeFromPostorderAndInorder(post,in,rightPostS,rightPostE,rightInS,rightInE);
		return root;
	}
// Note  O(n) approch hashmap approch,  https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/

	//Approch2 implementaion by taking static varible

	public static int rootIndex;
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder_2(int[] post, int[] in){
		rootIndex = post.length -1;
		return getTreeFromPostorderAndInorder_2(post,in,0,in.length-1);
	}
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder_2(int[]post,int[]in , int inS,int inE){
		//Base Case
		if(inS>inE)
			return null;
		//Small Calculation
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(post[rootIndex]);
		rootIndex--;
		int i = 0;
		for( i = inS;i<=inE;i++){
			if(in[i] == root.data)
				break;
		}
		//Recursive Calls
		root.right = getTreeFromPostorderAndInorder_2(post,in,i+1,inE); 
		root.left = getTreeFromPostorderAndInorder_2(post,in,inS,i-1);
		return root;
	}

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no of nodes in a tree");
		int n = s.nextInt();
		int post[] = new int[n];
		int in[] = new int[n];
		System.out.println("Enter postorder traversal of the tree");
		for(int i = 0;i<n;i++)
			post[i] = s.nextInt();
		System.out.println("Enter indorder traversal of the tree");
		for(int i = 0;i<n;i++)
			in[i] = s.nextInt();
		
		BinaryTreeNode<Integer> root = getTreeFromPostorderAndInorder_2(post,in);
		_08PrintLevelWise obj = new _08PrintLevelWise();
		obj.printLevelWise(root);
	}
}