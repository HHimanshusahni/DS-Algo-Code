import java.util.Scanner;
public class _11LCABST{
	//Approach 1
	public static int lcaInBST(BinaryTreeNode<Integer> root , int a , int b){
		//Base Case
		if(root == null)
			return -1;
		int data = root.data;
		if(data == a || data == b)
			return data;

		//Rec Case
		int x = Math.min(a,b), y = Math.max(a,b);
		if(data > y) //If the lca exist then it must be the left subtree
			return lcaInBST(root.left,a,b);
		else if(data < x)	//If the lca exist then it must be the right subtree
			return lcaInBST(root.right,a,b);
		else{	//Check if the root is lca or not 
			boolean leftAns = searchBST(root.left,x);
			if(leftAns)
				return data;
			boolean rightAns =  searchBST(root.right,y);
			if(rightAns)
				return data;
			return -1;
		}			
	}
	public static boolean searchBST(BinaryTreeNode<Integer> root, int element){
		if(root == null)
			return false;
		int data = root.data;
		if(data == element)
			return true;
		else if(data > element)
			return searchBST(root.left ,element);
		else
			return searchBST(root.right,element);
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		System.out.println("Enter nodes to data for finding the lca");
		System.out.println(lcaInBST(root,s.nextInt(),s.nextInt()));
	}
}