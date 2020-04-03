import java.util.Scanner;
public class _10LCAOfBinaryTree{
	//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	public static int lcaBinaryTree(BinaryTreeNode<Integer> root,int a ,int b) {
		//Base Case
		if(root == null)
			return -1;
		
		if(root.data.intValue() == a || root.data.intValue() == b)
			return root.data.intValue();

		//Rec Case
		int a1 = lcaBinaryTree(root.left,a,b);
		int a2 = lcaBinaryTree(root.right,a,b);

		if(a1 == -1 && a2 == -1)
			return -1;
		if(a1 == a && a2 == b || a1 == b && a2 == a)
			return root.data.intValue();
		else if(a1 != -1)
			return a1;
		else 
			return a2;

	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		int a = s.nextInt(),b = s.nextInt();
		System.out.println(lcaBinaryTree(root,a,b));

	}
}