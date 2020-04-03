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
	//Approach  2 Without Extra Search function
	public static int lcaInBST_2(BinaryTreeNode<Integer> root , int a , int b){
		//Base Case
		if(root == null)
			return -1;
		if(root.data == a || root.data == b)
			return root.data;
		//Rec Case
		if(root.data > a && root.data > b)
			return lcaInBST_2(root.left, a, b);
		else if(root.data < a  && root.data < b)
			return lcaInBST_2(root.right, a,b);
		else{
			int leftAns = lcaInBST_2(root.left, a,b);
			int rightAns = lcaInBST_2(root.right,a,b);
			if(leftAns == -1 && rightAns == -1)
				return -1;
			else if(leftAns !=  -1  && rightAns != -1)
				return root.data;
			if(leftAns != -1 )
				return leftAns;
			else
				return rightAns;
		}		

	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		System.out.println("Enter nodes to data for finding the lca");
		System.out.println(lcaInBST_2(root,s.nextInt(),s.nextInt()));
	}
}