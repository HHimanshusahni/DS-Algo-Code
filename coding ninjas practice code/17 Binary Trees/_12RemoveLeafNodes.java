public class _12RemoveLeafNodes{

	//Approach 1 --> Deleting from the parent of leaf node 
	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){
		removeAllLeavesHelp(root);
		return root;
	}
	public static void removeAllLeavesHelp(BinaryTreeNode<Integer>root){
		//Base Case
		if(root == null)
			return  ;
		//Small Calculation
		if(root.left != null && root.left.left == null && root.left.right == null)
			root.left = null;
		if(root.right != null && root.right.left == null && root.right.right == null)
			root.right = null;

		//Recusive Case
		if(root.left != null)
			removeAllLeaves(root.left);
		if(root.right != null)
			removeAllLeaves(root.right);
		
	}
	
	//Approach 2
	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){
		if(root == null)
			return null;
		if(root.left == null && root.right == null) //leaf node
			return null;

		root.left = removeAllLeaves(root.left);
		root.right = removeAllLeaves(root.right);
		return root;
	}
	
	public static void main(String[]args){
		BinaryTreeUse tree = new BinaryTreeUse();
		BinaryTreeNode<Integer>root  = tree.takeInputLevelWise();
		root = 	removeAllLeaves(root);
		_08PrintLevelWise f = new _08PrintLevelWise();
		f.printLevelWise(root);

	}
}