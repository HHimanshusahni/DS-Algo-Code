public class _14NodesWithoutSibling{
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		//Base Case
		if(root == null)
			return;
		//Small Calculation
		if(root.right == null && root.left != null)
			System.out.println(root.left.data);
		if(root.right != null && root.left == null)
			System.out.println(root.right.data );
		//Recursive Call
			if(root.left != null)
				printNodesWithoutSibling(root.left);
			if(root.right != null)
				printNodesWithoutSibling(root.right);

	}
	public static void main(String[]args){
		BinaryTreeUse tree = new BinaryTreeUse();
		BinaryTreeNode<Integer> root = tree.takeInputLevelWise();
		printNodesWithoutSibling(root);
	}
}