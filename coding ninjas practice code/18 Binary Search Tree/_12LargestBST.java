public class _12LargestBST{
	//Approach 1  O(n^2) approach
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		//Base Case
		if(root == null)
			return 0;
		if(isBST(root))
			return height(root);
		else
			return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right)); //Rec case
		
	}
	public static boolean isBST(BinaryTreeNode<Integer> root){
			return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	public static boolean isBST(BinaryTreeNode<Integer> root, int min,int max){  //Time Complexity : O(n)
		if(root == null)
			return true;
		if(root.data < min || root.data > max)
			return false;
		else
			return isBST(root.left,min,root.data -1) && isBST(root.right,root.data +1,max);
	}
	public static int height(BinaryTreeNode<Integer> root){
		if(root == null)
			return 0;
		return 1 + Math.max(height(root.left),height(root.right));
	}


	public static void main(String[]args){
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		System.out.println(largestBSTSubtree(root));
	}
}