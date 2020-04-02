public class _08CreateAndInsertDuplicateNode{

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		root = insertDuplicateNodeHelp(root);
	}
	public static BinaryTreeNode<Integer> insertDuplicateNodeHelp(BinaryTreeNode<Integer> root){
		//Base Case
		if(root == null)
			return null;
		//Small Calculation
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
		//Recursive Case
		newNode.left = insertDuplicateNodeHelp(root.left);
		root.left = newNode;
		root.right = insertDuplicateNodeHelp(root.right);
		return root;
	}

	public static void main(String[]args){
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		insertDuplicateNode(root);
		_00BinaryTreeUse.printLevelWise(root);

	}
}